package com.friendsofgroot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.service.UsersService;

import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
//@Api(tags={"Users"})
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return usersService.createUser(user);
    }
    @GetMapping(value="/users/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        return usersService.getUser(userId);
    }
    @GetMapping(value="/users/email/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return usersService.getUser(email);
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return usersService.getUsers();
    }

    @PutMapping(value="/users", consumes="application/json")  // userId in body
    public User updateUser(@RequestBody User change) {
        return usersService.updateUser(change);
    }
    @DeleteMapping(value="/users/{id}")
    public boolean deleteUser(@PathVariable("id") int id) {
        try {
            usersService.deleteUser(usersService.getUser(id));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


//    public List<String> getUsersByCoins();

//    public User getUserByPassword(String username, String password) {
//        return null;
//    }


}
