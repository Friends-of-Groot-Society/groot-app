package com.friendsofgroot.mapllistener.controllers;

//import com.friendsofgroot.mapllistener.dto.JWTAuthResponse;
//import com.friendsofgroot.mapllistener.dto.LoginDto;
//import com.friendsofgroot.mapllistener.dto.RegisterDto;
import com.friendsofgroot.mapllistener.dto.UserDto;
//import com.friendsofgroot.mapllistener.security.AuthService;
import com.friendsofgroot.mapllistener.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
@RestController
//@Api(tags={"Users"})
public class UsersController {

//    private PasswordEncoder bcrypt;

    private UsersService usersService;
//    private AuthService authService;

    public UsersController( UsersService usersService ) {
//        this.bcrypt = bcrypt;
//                this.authService = authService;
        this.usersService=usersService;
    }

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                usersService.createUser( userDto) ,
                 HttpStatus.CREATED);
    }

    @GetMapping(value="/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(
                        usersService.getUser(userId),
                HttpStatus.OK);
    }
    @GetMapping(value="/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(
                        usersService.getUser(email),
                HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(
                        usersService.getUsers(),
                HttpStatus.OK);
    }

    @PutMapping(value="", consumes="application/json")  // userId in body
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                usersService.createUser(userDto),
                HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") int userId) {
        try {
            usersService.deleteUser(usersService.getUser(userId));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

//    @PostMapping(value={"/auth/login","/auth/signin"}, consumes = "application/x-www-form-urlencoded; charset=utf-8")
//    public ResponseEntity< JWTAuthResponse > loginUser(@RequestParam String usernameOrEmail, @RequestParam String password
//    ) {
//        LoginDto ldto = new LoginDto();
//        ldto.setUsernameOrEmail(usernameOrEmail);
//        ldto.setPassword(bcrypt.encode(password));
//        String token = authService.login(ldto);
//
//        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
//        jwtAuthResponse.setAccessToken(token);
//
//        return ResponseEntity.ok(jwtAuthResponse);
////
////        return new ResponseEntity<>(
////                usersService.loginUser(lDto.getUsernameOrEmail(), lDto.getPassword()),
////                HttpStatus.OK);
//    }
    //// API for user registration and login   ////

//    @PostMapping(value = {"/auth/register", "/auth/signup"}, consumes = "application/x-www-form-urlencoded; charset=utf-8")
//    public ResponseEntity<String> registerUser(@RequestParam String email, @RequestParam String password,
//                                               @RequestParam String firstName,@RequestParam String lastName) {
//        RegisterDto rdto = new RegisterDto();
//        rdto.setEmail(email);
//        rdto.setPassword(bcrypt.encode(password));
//        rdto.setFirstName(firstName);
//        rdto.setLastName(lastName);
//        String response = authService.register(rdto);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
////        return new ResponseEntity<>(
////                usersService.registerUser(rDto),
////                HttpStatus.CREATED);
//    }
//////////////////////////////////////////////////////////////
    //// GENERAL API for user management ////
    /////////////////////////////////////////////////////////

//    public List<String> getUsersByCoins();

//    public User getUserByPassword(String username, String password) {
//        return null;
//    }ResponseEntity

}
