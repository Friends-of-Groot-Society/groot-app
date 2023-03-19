package com.friendsofgroot.app.service;

import com.friendsofgroot.app.dto.UserChain;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.models.User;

import java.util.List;


public interface UsersService {

	public UserDto createUser(UserDto user);

	User createUserCLI(User user);

	public UserDto getUser(int id);
	public UserDto getUser(String username );
	public List<UserDto> getUsers();

	public UserDto updateUser(UserDto change);

 	public List<User> getUsersWithCoins();
	public UserDto getUserByPassword(String username, String password);
	public boolean deleteUser(String username);

	boolean deleteUser(UserDto user);

	List<UserChain> getUserChains();
}
