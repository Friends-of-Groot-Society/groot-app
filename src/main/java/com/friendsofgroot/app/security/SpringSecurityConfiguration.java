package com.friendsofgroot.app.security;

import com.friendsofgroot.app.dataLoader.UserDetailsCLR;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.service.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;



//@Configzuration
//@EnableWebSecurity
public class SpringSecurityConfiguration {

    private static final Logger log =
            LoggerFactory.getLogger(UserDetailsCLR.class);

    // DISABLE WHEN CONNECTED TO LDAP or DB
//    @Bean
//    InMemoryUserDetailsManager createUserDetailsManager() {
//        log.info("createUserDetailsManager");
//
//        UserDetails userDetails1 = createNewUser("admin", "password");
//
//        UserDetails userDetails2 = User.builder()
//                .username("thomas")
//                .password(passwordEncoder2().encode("password"))
//                .authorities(new SimpleGrantedAuthority("ROLE_USER"))
//                .build();
//        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
//    }

//    private UserDetails createNewUser(String username, String password) {
//        log.info("createNewUser");
//
//        Function<String, String> passwordEncoding
//                = input -> passwordMaplEncoder().encode(input);
//
//        UserDetails userDetails = User.builder()
//                .passwordEncoder(passwordEncoding)
//                .username(username)
//                .password(password)
//                .roles("USER", "ADMIN")
//                .build();
//        return userDetails;
//    }

//    @Bean
//    PasswordEncoder passwordMaplEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder2() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        log.info("filterChain");
//
//        //All URLs are protected A login form is shown for unauthorized requests
//
////		http.authorizeHttpRequests(
////				auth -> auth.anyRequest().authenticated());
//
//        // UNPROTECTED
//        http.formLogin(withDefaults());
//        http.authorizeRequests().anyRequest().permitAll();
//        http.csrf().disable();         //CSRF disable
//        http.headers().frameOptions().disable();   //Frames disable [h2 uses]
//        http.headers().frameOptions().sameOrigin();
//        return http.build();
//    }


//////////////////// CUSTOM

    static final String ADMIN = "admin";
    static final String ADMIN_PASSWORD = "pass";

//    static String getAuthenticatedUsername() {
//        System.out.println("getAuthenticatedUsername");
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUsername = null;
//        currentUsername = authentication.getName();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            currentUsername = "SETUP FOR: *" + currentUsername + "* now complete.\n  " +
//                    "  ... now preparing your Dashboard";
//            return currentUsername;
//        }
//        currentUsername = "SETUP FOR AnonymousAuthenticationToken:" + currentUsername + "* now complete.\n  " +
//                "  ... now preparing your Dashboard";
//        return currentUsername;
//    }

    static boolean checkDbUsernameAndPassword(String un, String pw) {

        UsersServiceImpl usersService = new UsersServiceImpl();
        System.out.println("checkDbUsernameAndPassword"+usersService.getUsers());
       // returns null if not in DB params: EMAIL
        UserDto login = new UserDto();
        try {
              login = usersService.getUserByEmail(un);
        } catch (Exception e) {
            e.printStackTrace();
        }
      //	    VALIDATION #2 - Check targeted DB User against logged-in Username & password
        if (login != null && (un.contentEquals(
                login.getEmail())
                && pw.contentEquals(  login.getPassword()  )
        )) {
            System.out.println(
                    "...grreat, password checks out! *" + un + "* #1, now logging you into your Dashboard");
            String name = (login.getFirstName() != null) ? login.getFirstName() : un;
            System.out.println("Welcome, *" + name + "*\n  " +
                    "  ... now preparing your Dashboard");
            return true;
        } else {
            System.out.println("...sorry, password does not match our records for *" + un + "* #1");
        }
        return false;
    }

    static boolean hardCodedAdminNameAndPassword(String un, String pw) {
        log.info("hardCodedAdminNameAndPassword"+" un: "+un+" pw: "+pw+" ADMIN: "+ADMIN+" ADMIN_PASSWORD: "+ADMIN_PASSWORD);

        if (un.contentEquals(ADMIN) && pw.contentEquals(ADMIN_PASSWORD)) {
            System.out.println("Welcome Internal Administrator, *" + un + "*\n  " +
                    "  ... now preparing your Dashboard");
            return true;
        } else {
            return false;
        }
    }
}
