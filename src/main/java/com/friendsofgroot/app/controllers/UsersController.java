package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.models.dto.LoginDto;
import com.friendsofgroot.app.models.dto.RegisterDto;
import com.friendsofgroot.app.models.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.friendsofgroot.app.service.UsersService;

import java.util.List;


import com.friendsofgroot.app.models.dto.JWTAuthResponse;
import com.friendsofgroot.app.config.security.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@SessionAttributes("name")
//@Api(tags={"Users"})
public class UsersController {

    private PasswordEncoder bcrypt;

    private UsersService usersService;
    private AuthService authService;
    public static final String USER_PATH = "/api/users";
    public static final String USER_PATH_ID = USER_PATH + "/{userId}";


    public UsersController(AuthService authService,UsersService usersService, PasswordEncoder bcrypt) {
        this.bcrypt = bcrypt;
                this.authService = authService;
        this.usersService=usersService;
    }

    @PostMapping(value={"/auth/login","/auth/signin"}, consumes = "application/x-www-form-urlencoded; charset=utf-8")
    public ResponseEntity< JWTAuthResponse > loginUser(@RequestParam String usernameOrEmail, @RequestParam String password
    ) {
        LoginDto ldto = new LoginDto();
        ldto.setUsernameOrEmail(usernameOrEmail);
        ldto.setPassword(bcrypt.encode(password));
        String token = authService.login(ldto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
//
//        return new ResponseEntity<>(
//                usersService.loginUser(lDto.getUsernameOrEmail(), lDto.getPassword()),
//                HttpStatus.OK);
    }
    //// API for user registration and login   ////

    @PostMapping(value = {"/auth/register", "/auth/signup"}, consumes = "application/x-www-form-urlencoded; charset=utf-8")
    public ResponseEntity<String> registerUser(@RequestParam String email, @RequestParam String password,
                                               @RequestParam String firstName,@RequestParam String lastName) {
        RegisterDto rdto = new RegisterDto();
        rdto.setEmail(email);
        rdto.setPassword(bcrypt.encode(password));
        rdto.setFirstName(firstName);
        rdto.setLastName(lastName);
        String response = authService.register(rdto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
//        return new ResponseEntity<>(
//                usersService.registerUser(rDto),
//                HttpStatus.CREATED);
    }
//////////////////////////////////////////////////////////////
     //// GENERAL API for user management ////
    /////////////////////////////////////////////////////////
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                usersService.createUser( userDto) ,
                 HttpStatus.CREATED);
    }

    @PostMapping(USER_PATH)
    public ResponseEntity handlePost(@RequestBody UserDto user){
        UserDto savedUser = usersService.createUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", USER_PATH + "/" + savedUser.getUserId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @GetMapping(value=USER_PATH_ID)
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(  usersService.getUser(userId), HttpStatus.OK);
    }
    @GetMapping(value="/users/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(
                        usersService.getUser(email),
                HttpStatus.OK);
    }

    @GetMapping(USER_PATH)
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(
                        usersService.getUsers(),
                HttpStatus.OK);
    }

    @PutMapping(value=USER_PATH, consumes="application/json")  // userId in body
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") int userId, @RequestBody UserDto userDto) {
        if (usersService.updateUserById(userId, userDto).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(
                usersService.createUser(userDto),
                HttpStatus.CREATED);
    }


    @PatchMapping(USER_PATH_ID)
    public ResponseEntity patchUserById(@PathVariable("userId") Integer userId,
                                        @RequestBody UserDto user){

        usersService.patchUserById(userId, user);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value=USER_PATH_ID)
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") int userId) {
        try {
            usersService.deleteUser(usersService.getUser(userId));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


//    public List<String> getUsersByCoins();

//    public User getUserByPassword(String username, String password) {
//        return null;
//    }ResponseEntity

}
