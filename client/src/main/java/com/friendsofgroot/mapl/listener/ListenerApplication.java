package com.friendsofgroot.mapl.listener;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.function.Supplier;

@SpringBootApplication
public class ListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(UserService us) {
        return event -> {
            System.out.println("ApplicationReadyEvent userService.all()");
            us.all().forEach(System.out::println);
        };
    }

}

@Controller
@ResponseBody
class UserHttpController {

    private final UserService userService;
    private final ObservationRegistry registry;

    UserHttpController(UserService userService, ObservationRegistry registry) {
        this.userService = userService;
        this.registry = registry;
    }

    @GetMapping("/api/users")
    Collection<User> all() {
        return Observation
                .createNotStarted("all", this.registry)  // starts a span , from one node to another
                .observe(() -> userService.all() // each hop is a span that joins up with existing trace or creates new one
                );
    }

    @GetMapping({"/api/users/{email}", "/api/users/email/{email}/"})
    User byemail(@PathVariable("email") String email) {
        Assert.state(Character.isLowerCase(email.charAt(0)), "Email must be lowercase: ");
        return Observation
                .createNotStarted("byemail", this.registry)  // starts a span , from one node to another
                .observe(() -> userService.byemail(email) // each hop is a span that joins up with existing trace or creates new one
                );
    }

    //	http://localhost:8080/actuator/metrics/byemail
//	http://localhost:8080/actuator/metrics/byemail?tag=exception:IllegalStateException
    @GetMapping("/api/users/id/{userid}")
    // http://localhost:8080/api/users/id/1
    User byuserid(@PathVariable("userid") String userid) {
        Assert.state(Character.isLowerCase(userid.charAt(0)), "byuserid  : ");
        return Observation
                .createNotStarted("byuserid", this.registry)  // starts a span , from one node to another
                .observe(() -> userService.byid(Integer.valueOf(userid)) // each hop is a span that joins up with existing trace or creates new one
                );
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

@Service
class UserService {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("username"), rs.getString("email"), rs.getString("password"));

    UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    User byemail(String email) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", userRowMapper, email);
    }

    User byid(Integer userid) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE userid = ?", userRowMapper, userid);
    }

    Collection<User> all() {
//		return this.jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("email"), rs.getString("password"), rs.getS
        return this.jdbcTemplate.query("SELECT * FROM users", userRowMapper);

    }
}


record User(Integer userid, String username, String email, String password) {
}