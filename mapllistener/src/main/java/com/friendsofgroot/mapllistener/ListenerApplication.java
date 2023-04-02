package com.friendsofgroot.mapllistener;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
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

@SpringBootApplication
public class ListenerApplication {


    public static void main(String[] args) {
        SpringApplication.run(ListenerApplication.class, args);
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(UserService us) {
        return event -> {
            System.out.println("ApplicationReadyEvent userService.all()");
            us.all().forEach(System.out::println);
        };
    }
    @Bean
    public ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener2(PostService ps) {
        return event -> {
            System.out.println("ApplicationReadyEvent userService.all()");
            ps.all().forEach(System.out::println);
        };
    }

}

@Controller
@ResponseBody
  class UserHttpController {

    private final UserService userService;
    private final ObservationRegistry registry;

    public UserHttpController(UserService userService, ObservationRegistry registry) {
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


@Controller
@ResponseBody
class PostEntityHttpController {

    private final PostService postService;
    private final ObservationRegistry registry;


    PostEntityHttpController(PostService postService, ObservationRegistry registry) {
        this.postService = postService;
        this.registry = registry;
    }

    @GetMapping("/api/posts")
    Collection<PostEntity> all() {
        return Observation
                .createNotStarted("all", this.registry)  // starts a span , from one node to another
                .observe(() -> postService.all() // each hop is a span that joins up with existing trace or creates new one
                );
    }

    @GetMapping({"/api/posts/{email}", "/api/users/email/{email}/"})
    PostEntity byemail(@PathVariable("email") String email) {
        Assert.state(Character.isLowerCase(email.charAt(0)), "Email must be lowercase: ");
        return Observation
                .createNotStarted("byemail", this.registry)  // starts a span , from one node to another
                .observe(() -> postService.byusername(email) // each hop is a span that joins up with existing trace or creates new one
                );
    }

    //	http://localhost:8080/actuator/metrics/byemail
//	http://localhost:8080/actuator/metrics/byemail?tag=exception:IllegalStateException
    @GetMapping("/api/posts/id/{userid}")
    // http://localhost:8080/api/users/id/1
    PostEntity byuserid(@PathVariable("userid") String userid) {
        Assert.state(Character.isLowerCase(userid.charAt(0)), "byuserid  : ");
        return Observation
                .createNotStarted("byuserid", this.registry)  // starts a span , from one node to another
                .observe(() -> postService.byid(Integer.valueOf(userid)) // each hop is a span that joins up with existing trace or creates new one
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

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("lastName"), rs.getString("firstName"),rs.getString("password"), rs.getString("email"),  rs.getString("cusUrl"), rs.getString("photoPath"), rs.getString("userGroup"), rs.getInt("isActive"));

    UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User byemail(String email) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", userRowMapper, email);
    }

    public User byid(Integer userid) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE userid = ?", userRowMapper, userid);
    }

    public Collection<User> all() {
//		return this.jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("email"), rs.getString("password"), rs.getS
        return this.jdbcTemplate.query("SELECT * FROM users", userRowMapper);

    }
}
record User(Integer userid,  String lastName, String firstName, String password, String email,String cusUrl, String photoPath, String userGroup, int isActive) implements IUser {
}

record Admin(Integer userid, String username, String email, String password) implements IUser {
}
@Service
class PostService {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<PostEntity> postRowMapper = (rs, rowNum) -> new PostEntity(rs.getInt("ID"), rs.getString("DID"), rs.getString("DATE_"),rs.getString("CATEGORY_ID"), rs.getString("TITLE"),  rs.getString("POST"), rs.getString("BLOGCITE"), rs.getString("USERNAME"), rs.getInt("CATEGORY"));

    PostService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PostEntity bycat3(String cat3) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM post_entity WHERE cat3 = ?", postRowMapper, cat3);
    }

    public PostEntity byid(Integer userid) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM post_entity WHERE userid = ?", postRowMapper, userid);
    }

    public Collection<PostEntity> all() {
//		return this.jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("email"), rs.getString("password"), rs.getS
        return this.jdbcTemplate.query("SELECT * FROM post_entity", postRowMapper);

    }

    public PostEntity byusername(String username) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM post_entity WHERE username = ?", postRowMapper, username);
    }

}