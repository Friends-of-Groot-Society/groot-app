package com.friendsofgroot.mapl.client;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.math.RoundingMode;
import java.util.Collection;

@SpringBootApplication

public class ClientApplication {


    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(UserClient userClient) {
        return event -> {
            System.out.println("ApplicationReadyEvent userClient.all()");
            userClient.all().forEach(System.out::println);
        };
    }

    // auto-generated client from interface
    @Bean
    UserClient userClient(WebClient.Builder builder) {
       return HttpServiceProxyFactory
               .builder(WebClientAdapter.forClient(builder.baseUrl("http://localhost:8889").build()))
               .build()
               .createClient(UserClient.class);
    }


}

record User(Integer userid, String email, String password) {
}
interface UserClient {
    @GetExchange("/users")
    Collection<User> all();

    @GetExchange("/users/{email}")
    Collection<User> byEmail(@PathVariable String email);
}

//class UserClient {
//    private final UserClientProperties properties;
//    private final UserClientRestTemplate restTemplate;
//    UserClient(UserClientProperties properties, UserClientRestTemplate restTemplate) {
//        this.properties = properties;
//        this.restTemplate = restTemplate;
//    }
//    Collection<User> all() {
//        return restTemplate.getForEntity(properties.getUsersUrl(), User[].class).getBody();
//    }
//}