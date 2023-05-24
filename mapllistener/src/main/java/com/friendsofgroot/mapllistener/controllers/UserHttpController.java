package com.friendsofgroot.mapllistener.controllers;

import com.friendsofgroot.mapllistener.models.User;
<<<<<<< HEAD
import com.friendsofgroot.mapllistener.services.UserJDBCService;
=======
//import com.friendsofgroot.mapllistener.services.UserJDBCService;
import com.friendsofgroot.mapllistener.services.UserJDBCService;
import com.friendsofgroot.mapllistener.services.UsersService;
>>>>>>> f5c72078f1133a85e50481cd6bc488ced892ac20
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
@ResponseBody
public class UserHttpController {

    private final UserJDBCService userJDBCService;
    private final ObservationRegistry registry;

    public UserHttpController(UserJDBCService userJDBCService, ObservationRegistry registry) {
        this.userJDBCService = userJDBCService;
        this.registry = registry;
    }

    @GetMapping("")
    Collection<User> all() {
        return Observation
                .createNotStarted("all", this.registry)  // starts a span , from one node to another
                .observe(userJDBCService::all // each hop is a span that joins up with existing trace or creates new one
                );
    }

    @GetMapping({"/{email}", "/email/{email}/"})
   User Userbyemail(@PathVariable("email") String email) {
        Assert.state(Character.isLowerCase(email.charAt(0)), "Email must be lowercase: ");
        return Observation
                .createNotStarted("byemail", this.registry)  // starts a span , from one node to another
                .observe(() -> userJDBCService.byemail(email) // each hop is a span that joins up with existing trace or creates new one
                );
    }

    //	http://localhost:8080/actuator/metrics/byemail
//	http://localhost:8080/actuator/metrics/byemail?tag=exception:IllegalStateException
    @GetMapping("/id/{userid}")
    // http://localhost:8080/id/1
    User byuserid(@PathVariable("userid") String userid) {
        Assert.state(Character.isLowerCase(userid.charAt(0)), "byuserid  : ");
        return Observation
                .createNotStarted("byuserid", this.registry)  // starts a span , from one node to another
                .observe(() -> userJDBCService.byid(Long.valueOf(userid)) // each hop is a span that joins up with existing trace or creates new one
                );
    }
}
