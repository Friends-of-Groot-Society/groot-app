package com.friendsofgroot.app.dao;

import java.util.List;
 
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.models.UserCoinbuy;

public interface UserDAO {
	public boolean createUser(User u);

	public User getUser(int id);

	public User getUser(String username);

	public List<User> getUsers();

	public List<User> getLocalUsers();

	public boolean updateUser(User change);

	public boolean deleteUser(String username);

	public List<String> getUsersWithCoins();

	public User getUserByPassword(String username, String password);


	// PRE-POP
	public boolean createUserPrePop(User u);


	public void saveUserCoinbuy(UserCoinbuy userCoinbuy);

}


