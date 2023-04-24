package com.friendsofgroot.mapllistener.services;

//import com.friendsofgroot.mapllistener.dto.RegisterDto;
import com.friendsofgroot.mapllistener.dto.UserDto;
import com.friendsofgroot.mapllistener.models.User;

import java.util.List;


public interface UsersService {
//
//	UserDto registerUser(RegisterDto rDto);

	UserDto loginUser(String username, String password);
	public UserDto createUser(UserDto user);

	User createUserCLI(User user);

	public UserDto getUser(int id);

	UserDto getUser(long id);

	public UserDto getUser(String username );
	public List<UserDto> getUsers();

	public UserDto updateUser(UserDto change);

	UserDto getUserByEmailAndPassword(String email, String pw);

	public List<User> getUsersWithCoins();
	public UserDto getUserByPassword(String username, String password);
	public boolean deleteUser(String username);

	boolean deleteUser(UserDto user);


}
