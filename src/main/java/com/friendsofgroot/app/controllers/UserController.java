package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
*
 */

@RequiredArgsConstructor
@RestController
public class UserController {
    public static final String CUSTOMER_PATH = "/api/v1/user";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{userId}";

    private final UserService userService;

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity patchUserById(@PathVariable("userId") UUID userId,
                                                @RequestBody UserDto user){

        userService.patchUserById(userId, user);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity deleteUserById(@PathVariable("userId") UUID userId){

        if (!userService.deleteUserById(userId)){
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateUserByID(@PathVariable("userId") UUID userId,
                                             @RequestBody UserDto user){

        if (userService.updateUserById(userId, user).isEmpty()){
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity handlePost(@RequestBody UserDto user){
        UserDto savedUser = userService.saveNewUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", CUSTOMER_PATH + "/" + savedUser.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping(CUSTOMER_PATH)
    public List<UserDto> listAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = CUSTOMER_PATH_ID)
    public UserDto getUserById(@PathVariable("userId") UUID id){
        return userService.getUserById(id).orElseThrow(NotFoundException::new);
    }

}
