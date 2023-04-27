package com.friendsofgroot.app.service;

import com.friendsofgroot.app.dto.ChainUsers;
import com.friendsofgroot.app.dto.LoginDto;
import com.friendsofgroot.app.dto.RegisterDto;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.models.User;

import java.util.List;
import java.util.Optional;


public interface UsersService {

	UserDto registerUser(RegisterDto rDto);

	UserDto loginUser(String username, String password);
	public UserDto createUser(UserDto user);

	User createUserCLI(User user);

	public UserDto getUser(int id);
	public UserDto getUser(String username );
	public List<UserDto> getUsers();

	public UserDto updateUser(UserDto change);

	UserDto getUserByEmailAndPassword(String email, String pw);

	public List<User> getUsersWithCoins();
	public UserDto getUserByPassword(String username, String password);
	public boolean deleteUser(String username);

	boolean deleteUser(UserDto user);

}
