package app.mapl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.mapl.dao.UserDAO;
import app.mapl.dao.UserDAOimpl;
//import db.DB;
import app.mapl.dto.UserDto;
import app.mapl.mapper.UserMapper;
import app.mapl.models.User;

public class UsersServiceImpl {
	// DB.users.put(c.getUserID(), c);

	private   static UserMapper userMapper;
	public static UserDAO userdaoImpl = new UserDAOimpl(); // Interface Dao Ref-type, & userImpl is object

	public static boolean createUser(UserDto user) {
		System.out.println("Passing User Service userdao.createUser(u); ...");
		return userdaoImpl.createUser(user);
	};

	public static Optional<UserDto> getUser(int id) {
		System.out.println("Passing User Service getUser(String id) {...");

		return Optional.ofNullable(userMapper.toDto(userdaoImpl.getUser(id)));
	};

	public Optional<UserDto> getUserByEmail(String un) {
		System.out.println("Passing User Service getUser(SString username) {...");
		return Optional.ofNullable(userMapper.toDto(userdaoImpl.getUserbyEmail(un)));

	}
	public static Optional<UserDto> getUser(String username ) {
		System.out.println("Passing User Service getUser(SString username) {...");
		return Optional.ofNullable(userMapper.toDto(userdaoImpl.getUser(username)));
	};
	public static List<UserDto> getUsers() {
		System.out.println("Passing User Service userdao.getAllUsers() { ...");
		List<User> a = new ArrayList<>(userdaoImpl.getUsers());
		return a.stream().map(x -> userMapper.toDto(x)).toList();

	};

	public static boolean updateUser(UserDto change) {
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

	public static Optional<UserDto> getUserByPassword(String username, String password) {
		System.out.println("Passing User Service userdao.getUserByPassword(String username, String password)...");
		return Optional.ofNullable(userMapper.toDto(userdaoImpl.getUserByPassword(username, password)));
	}
	public static boolean deleteUser(String username) {
		System.out.println("Passing User Service userdao.deleteUser(String username) { ...");
		return userdaoImpl.deleteUser(username);
	}

}
