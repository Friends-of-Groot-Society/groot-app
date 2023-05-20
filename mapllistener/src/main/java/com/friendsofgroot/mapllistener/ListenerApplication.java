package com.friendsofgroot.mapllistener;

//import com.friendsofgroot.DailyTechService;
import com.friendsofgroot.mapllistener.services.PostJDBCService;
import com.friendsofgroot.mapllistener.services.UserJDBCService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class ListenerApplication {
//    Static final log = LogFactory.getLog(ListenerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }


    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(UserJDBCService us) {
        return event -> {
            System.out.println("ApplicationReadyEvent userService.all()");
            us.all().forEach(System.out::println);
        };
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener2(PostJDBCService ps) {
        return event -> {
            System.out.println("ApplicationReadyEvent userService.all()");
            ps.all().forEach(System.out::println);
        };
    }

}


@ControllerAdvice
class ErrorHandlingControllerAdvice {

    @ExceptionHandler
    public ProblemDetail handleIllegalStateException(IllegalStateException e) {
        var pdh = ProblemDetail.forStatus(HttpStatusCode.valueOf(404));
        pdh.setDetail("IllegalStateException" + e.getMessage());
        return pdh;
    }
}


record Admin(Long userid, String username, String email, String password) {
}
