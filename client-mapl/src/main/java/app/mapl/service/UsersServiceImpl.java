package app.mapl.service;

import app.mapl.dto.RegisterDto;
import app.mapl.dto.UserDto;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.mapper.UserMapper;
import app.mapl.models.User;
import app.mapl.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {


    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserMapper userMapper;


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

        UserDto newUser = new UserDto();
        newUser.setUsername(registerDto.getUsername());
        newUser.setPassword(registerDto.getPassword());
        newUser.setLastName(registerDto.getLastName());
        newUser.setFirstName(registerDto.getFirstName());
        /// TODO: MOVE LOGIC TO REGISTERDTO
        newUser.setUserType(2);
        newUser.setEmail(registerDto.getEmail());
        newUser.setPhone("1234567890");
//        newUser.setRole(registerDto.getRole()); //  registerDto.setRole("USER");

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
