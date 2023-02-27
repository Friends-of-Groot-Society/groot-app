package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.User;

import java.util.List;


public interface UsersService {

	public User createUser(User user);

	public User getUser(int id);
	public User getUser(String username );
	public List<User> getUsers();

	public User updateUser(User change);

 	public List<User> getUsersWithCoins();
	public User getUserByPassword(String username, String password);
	public boolean deleteUser(String username);

	boolean deleteUser(User user);
}
