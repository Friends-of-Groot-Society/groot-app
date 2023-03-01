package com.friendsofgroot.app.security;

import com.friendsofgroot.app.dataLoader.UserDetailsCommandLineRunner;
import com.friendsofgroot.app.service.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    private static final Logger log =
            LoggerFactory.getLogger(UserDetailsCommandLineRunner.class);
// DISABLE WHEN CONNECTED TO LDAP or DB
    @Bean
    InMemoryUserDetailsManager createUserDetailsManager() {
        log.info("createUserDetailsManager");

        UserDetails userDetails1 = createNewUser("admin", "password");

        UserDetails userDetails2 = User.builder()
                .username("thomas")
                .password(passwordEncoder2().encode("password"))
                .authorities(new SimpleGrantedAuthority("ROLE_USER"))
                .build();
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        log.info("createNewUser");

        Function<String, String> passwordEncoding
                = input -> passwordMaplEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoding)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    PasswordEncoder passwordMaplEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    PasswordEncoder passwordEncoder2() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("filterChain");

        //All URLs are protected
        //A login form is shown for unauthorized requests
        //CSRF disable
        //Frames disable [h2 uses]

//		http.authorizeHttpRequests(
//				auth -> auth.anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.authorizeRequests().anyRequest().permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }


//////////////////// CUSTOM

    static final String ADMIN = "admin";
    static final String ADMIN_PASSWORD = "pass";

    static String getAuthenticatedUserName() {
        log.info("getAuthenticatedUserName");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        currentUserName = authentication.getName();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = "SETUP FOR: *" + currentUserName + "* now complete.\n  " +
                    "  ... now preparing your Dashboard";
            return currentUserName ;
        }
        currentUserName = "SETUP FOR AnonymousAuthenticationToken:" + currentUserName + "* now complete.\n  " +
                "  ... now preparing your Dashboard";
        return currentUserName;
    }

    static boolean checkDbUsernameAndPassword(String un, String pw) {
        log.info("checkDbUsernameAndPassword");

        UsersServiceImpl usersService = new UsersServiceImpl();
        com.friendsofgroot.app.models.User login = usersService.getUser(un); // returns null if not in DB
//	    VALIDATION #2 - Check targeted DB User against logged-in Username & password
        if (login != null && (un.contentEquals(
                login.getUserName()) && pw.contentEquals(
                login.getPassword()
        ))) {
            ;
            System.out.println(
                    "...grreat, password checks out! *" + un + "* #1, now logging you into your Dashboard");
            String name = (login.getFirstName() != null) ? login.getFirstName() : un;
            return true;
        }
        return false;
    }

    static boolean hardCodedAdminNameAndPassword(String un, String pw) {
        log.info("hardCodedAdminNameAndPassword");

        if (un.contentEquals(ADMIN) && pw.contentEquals(ADMIN_PASSWORD)) {
            System.out.println("Welcome Internal Administrator, *" + un + "*\n  " +
                    "  ... now preparing your Dashboard");
            return true;
        } else {
            return false;
        }
    }
}
