package com.friendsofgroot.mapllistener.services;

//import com.friendsofgroot.mapllistener.dto.RegisterDto;
import com.friendsofgroot.mapllistener.dto.UserDto;
import com.friendsofgroot.mapllistener.exception.ResourceNotFoundException;
import com.friendsofgroot.mapllistener.mappers.UserMapper;
import com.friendsofgroot.mapllistener.models.User;
import com.friendsofgroot.mapllistener.repositories.UsersRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    private   UserMapper userMapper;
//    private   UserAccountRepository userAccountRepository;

    public UsersServiceImpl(UsersRepository usersRepository, UserMapper userMapper
//            , UserAccountRepository userAccountRepository
            ) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
//        this.userAccountRepository = userAccountRepository;
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

    @Override
    public UserDto getUser(int id) {
        return null;
    }
    /**
     * @param registerDto
     * @return  UserDto
     */
//    @Override
//    public UserDto registerUser(RegisterDto registerDto) {
//
//        UserDto newUser = new UserDto();
//        newUser.setUsername(registerDto.getUsername());
//        newUser.setPassword(registerDto.getPassword());
//        newUser.setLastName(registerDto.getLastName());
//        newUser.setFirstName(registerDto.getFirstName());
//        /// TODO: MOVE LOGIC TO REGISTERDTO
//        newUser.setUserType(2);
//        newUser.setEmail(registerDto.getEmail());
//        newUser.setAddresses(List.of(new Address()));
//        newUser.setPhone("1234567890");
////        newUser.setRole(registerDto.getRole()); //  registerDto.setRole("USER");
//
//        User u = usersRepository.save(userMapper.toEntity(newUser));
//        return userMapper.toDto(u);
//    }

    /**
     * @param usernameOrEmail
     * @param password
     * @return
     */
    @Override
    public UserDto loginUser(String usernameOrEmail, String password) {
         Optional<User> u = (Optional<User>) usersRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", usernameOrEmail));

        if ( u.get().getPassword().equals(password)) {

            return userMapper.toDto(u.get());
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
    public UserDto getUser(long id) {
        try {
            User u = usersRepository.findById( id).get();
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
           List<User> users = usersRepository.findAll();
           if (users != null) {
               userDtos = users.stream().map(userMapper::toDto).collect(Collectors.toList());
           }   else {
               throw new ResourceNotFoundException("not found", "not found", "not found");
           }
        return userDtos;
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



    /**
     * @param username
     * @param password
     * @return
     */
    @Override
    public UserDto getUserByPassword(String username, String password) {
        return userMapper.toDto(usersRepository.findByUsernameAndPassword(username, password));
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