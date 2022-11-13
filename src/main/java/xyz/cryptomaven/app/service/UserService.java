package xyz.cryptomaven.app.service;

import java.util.List;

import xyz.cryptomaven.app.dao.UserDAO;
import xyz.cryptomaven.app.dao.UserDAOimpl;
//import db.DB;
import xyz.cryptomaven.app.models.User;

public class UserService {
	// DB.users.put(c.getUserID(), c);
	public static UserDAO userdaoImpl = new UserDAOimpl(); // Interface Dao Ref-type, & userImpl is object

	public static boolean createUser(User user) {
		System.out.println("Passing User Service userdao.createUser(u); ...");
		return userdaoImpl.createUser(user);
	};

	public static User getUser(int id) {
		System.out.println("Passing User Service getUser(String id) {...");
		return userdaoImpl.getUser(id);
	};
	public static User getUser(String username ) {
		System.out.println("Passing User Service getUser(SString username) {...");
		return userdaoImpl.getUser(username);
	};
	public static List<User> getUsers() {
		System.out.println("Passing User Service userdao.getAllUsers() { ...");
		return userdaoImpl.getUsers();
	};

	public static boolean updateUser(User change) {
		System.out.println("Passing User Service userdao.updateUser(User change) {..");
		return userdaoImpl.updateUser(change);
	}

	public static UserDAO getUserdao() {
		System.out.println("Passing User Service userdao.getUserdao() {..");
		return userdaoImpl;
	}

	public static List<String> getUsersWithCoins() {
		System.out.println("Passing User Service userdao.getUsersWithCoins() {...");
		return userdaoImpl.getUsersWithCoins();
	}

	public static User getUserByPassword(String username, String password) {
		System.out.println("Passing User Service userdao.getUserByPassword(String username, String password)...");
		return userdaoImpl.getUserByPassword(username, password);
	}
	public static boolean deleteUser(String username) {
		System.out.println("Passing User Service userdao.deleteUser(String username) { ...");
		return userdaoImpl.deleteUser(username);
	}

}
