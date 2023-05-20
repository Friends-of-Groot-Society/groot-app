package com.friendsofgroot.mapllistener.controllers;

import com.friendsofgroot.mapllistener.models.PostEntity;
import com.friendsofgroot.mapllistener.services.PostJDBCService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/api/posts")
@ResponseBody
public class PostEntityHttpController {

    private final PostJDBCService postService;
    private final ObservationRegistry registry;


    public PostEntityHttpController(PostJDBCService postService, ObservationRegistry registry) {
        this.postService = postService;
        this.registry = registry;
    }

    @GetMapping("")
    Collection<PostEntity> all() {
        return Observation
                .createNotStarted("all", this.registry)  // starts a span , from one node to another
                .observe(() -> postService.all() // each hop is a span that joins up with existing trace or creates new one
                );
    }

    @GetMapping({"/{email}", "/users/email/{email}/"})
    PostEntity byemail(@PathVariable("email") String email) {
        Assert.state(Character.isLowerCase(email.charAt(0)), "Email must be lowercase: ");
        return Observation
                .createNotStarted("byemail", this.registry)  // starts a span , from one node to another
                .observe(() -> postService.byusername(email) // each hop is a span that joins up with existing trace or creates new one
                );
    }

    //	http://localhost:8080/actuator/metrics/byemail
//	http://localhost:8080/actuator/metrics/byemail?tag=exception:IllegalStateException
    @GetMapping("/id/{userid}")
    // http://localhost:8080/users/id/1
    PostEntity byuserid(@PathVariable("userid") String userid) {
        Assert.state(Character.isLowerCase(userid.charAt(0)), "byuserid  : ");
        return Observation
                .createNotStarted("byuserid", this.registry)  // starts a span , from one node to another
                .observe(() -> postService.byid(Long.valueOf(userid)) // each hop is a span that joins up with existing trace or creates new one
                );
    }
}
