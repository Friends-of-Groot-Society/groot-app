package xyz.cryptomaven.app.dataLoader;

import xyz.cryptomaven.app.dao.UserDAOimpl;
import xyz.cryptomaven.app.models.*;

import java.util.List;

public class UserManager {

	private static UserManager instance = new UserManager();
	private static UserDAOimpl userDAOimpl = new UserDAOimpl();
	private UserManager() {
	}

	public static UserManager getInstance() {

		return instance;
	}

	public User createUser(int userId, String userName, String password,  String lastName, String firstName,
						   int groups, int userType,   String phone, String email, String cusUrl, String photoPath, String userGroup, int isActive, int contactType, String id ) {
		
		User user = new User();
		user.setUserId(userId);
		user.setId(id);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setGroups(groups);
		user.setUserType(userType);
		user.setEmail(email);
		user.setPhone(phone);
		user.setCusUrl(cusUrl);
		user.setPhotoPath(photoPath);
		user.setUserGroup(userGroup);
		user.setIsActive(isActive);
		user.setContactType(contactType);
		user.setId(id);
		
		return user;

	}
	public List<User>  getUsers() {// THis is just relaying the call to the DaoImpl
			return userDAOimpl.getLocalUsers();
	}


	public void saveUserCoin(User user, Coin coin) {
		UserCoinbuy userCoinbuy = new UserCoinbuy();
		userCoinbuy.setUser(user);
		userCoinbuy.setCoin(coin);
		userDAOimpl.saveUserCoinbuy(userCoinbuy);
	}

    public Groups createGroups(int id, int id2, String name_groups) {
		Groups groups = new Groups();
		groups.setGroupsId(id);
		groups.setGroupsHeadId(id2);
		groups.setGroupsName(name_groups);
		userDAOimpl.createLocalGroups(groups);
		return groups;
	}

}
