package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.dto.RegisterDto;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.repositories.UsersRepository;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserMapper userMapper;


    public UsersServiceImpl() {
        UserDto user1 = UserDto.builder()
//                .userId(UUID.randomUUID()
//                .name("User 1")
//                .version(1)
//                .createdDate(LocalDateTime.now())
//                .updateDate(LocalDateTime.now())
                .build();

        UserDto user2 = UserDto.builder()
//                .id(UUID.randomUUID())
//                .name("User 2")
//                .version(1)
//                .createdDate(LocalDateTime.now())
//                .updateDate(LocalDateTime.now())
                .build();

        UserDto user3 = UserDto.builder()
//                .id(UUID.randomUUID())
//                .name("User 3")
//                .version(1)
//                .createdDate(LocalDateTime.now())
//                .updateDate(LocalDateTime.now())
                .build();

        usersRepository.save(userMapper.toEntity(user1));
        usersRepository.save(userMapper.toEntity(user2));
        usersRepository.save(userMapper.toEntity(user3));
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User createUserCLI(User user) {
        User u = usersRepository.save(user);
        return u;
    }
    /**
     * @param registerDto
     * @return  UserDto
     */
    @Override
    public UserDto registerUser(RegisterDto registerDto) {

        UserDto newUser = UserDto.builder()
                .lastName(registerDto.getLastName())
                .username(registerDto.getUsername())
                .password(registerDto.getPassword())
//                .dateCreated(registerDto.getDateCreated())
//                .lastUpdated(LocalDateTime.now())
                .build();
        User u = usersRepository.save(userMapper.toEntity(newUser));
        return userMapper.toDto(u);
    }

    /**
     * @param usernameOrEmail
     * @param password
     * @return
     */
    @Override
    public UserDto loginUser(String usernameOrEmail, String password) {
         User  u = usersRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", usernameOrEmail));

        if ( u.getPassword().equals(password)) {
            return userMapper.toDto(u) ;
        } else {
            return null;
        }
    }
    /**
     * @param user
     * @return
     */
    @Override
    public UserDto createUser(UserDto user) {
        User u = usersRepository.save(userMapper.toEntity(user));
        return userMapper.toDto(u);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UserDto getUser(int id) {
        try {
            User u = usersRepository.findById(id).get();
            return userMapper.toDto(u);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param email
     * @return
     */
    @Override
    public UserDto getUser(String email) {
        try {
            User u = usersRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
            return userMapper.toDto(u);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> getUsers() {
        List<UserDto> userDtos = new ArrayList<>();
       try {
           List<User> users = usersRepository.findAll();
           if (users == null) {
               throw new ResourceNotFoundException("not found", "not found", "not found");
           }   else {
               return users.stream().map(userMapper::toDto).collect(Collectors.toList());
           }
       } catch (NullPointerException e) {
           e.printStackTrace();
           return new ArrayList<>();
       }

    }

    @Override
    public UserDto getUserByEmailAndPassword(String email, String pw) {
        User u;
        try {
            u = usersRepository.findByEmailAndPassword(email,pw).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
//                return usersRepository.findByEmailAndPassword(email, pw).get();
        } catch (Exception e) {
            return null;
        }
        return userMapper.toDto(u);
    }

    public UserDto getUserByEmail(String email) {
        User u;
        try {

            u = usersRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
        } catch (Exception e) {
            return null;
        }
        return userMapper.toDto(u);
    }

    public List<User> getUsersWithCoins() {
        if (usersRepository.findAll().size() == 0) return null;
        return usersRepository.findAll()
                .stream()
                .filter(u ->
                        u.getAddresses().size() > 0 && u.getIsActive() != 0
                )
                .collect(Collectors.toList());
    }


    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserDto getUserByPassword(String username, String password) {
        return null;
    }

    /**
     * @param change
     * @return
     */
    @Override
    public UserDto updateUser(UserDto change) {
        try {
            User uEntity = userMapper.toEntity(change);
            User uDone = usersRepository.save(uEntity);

            return userMapper.toDto(uDone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return change;
    }

    @Override
    public Optional<UserDto> patchUserById(Integer userId, UserDto user) {
        User existing = usersRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", userId.toString()));

        if (!StringUtils.hasText(existing.getEmail())) {
            existing.setEmail(user.getEmail() != null ? user.getEmail() : existing.getEmail());
        }

        return Optional.of(userMapper.toDto(usersRepository.save(existing)));
    }
    /**
     * @param email
     * @return
     */
    @Override
    public boolean deleteUser(String email) {
        try {
            User u = usersRepository.findByEmail(email).get();
            usersRepository.delete(u);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public boolean deleteUser(UserDto user) {

        try {
            User u = usersRepository.findByEmail(user.getEmail()).get();
            usersRepository.delete(u);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
