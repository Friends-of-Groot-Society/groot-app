package com.friendsofgroot.app.security;

import com.friendsofgroot.app.dto.LoginDto;
import com.friendsofgroot.app.dto.RegisterDto;
import com.friendsofgroot.app.exception.PostApiException;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.models.Role;
import com.friendsofgroot.app.repositories.RoleRepository;
import com.friendsofgroot.app.repositories.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl  implements AuthService {
    private AuthenticationManager authenticationManager;
    private UsersRepository usersRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UsersRepository usersRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    /**
     * @param loginDto
     * @return
     */
    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    /**
     * @param registerDto
     * @return
     */
    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if(usersRepository.existsByUsername(registerDto.getUsername())){
            throw new PostApiException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(usersRepository.existsByEmail(registerDto.getEmail())){
            throw new PostApiException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        usersRepository.save(user);

        return "User registered successfully!.";
    }
}
