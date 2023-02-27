package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.dao.CoinDAOimpl;
import com.friendsofgroot.app.dao.UserDAOimpl;
import com.friendsofgroot.app.models.*;

import java.util.List;

public class UsersData {
	private static UsersData instance = new UsersData();

	private static CoinDAOimpl coinDAOimpl = new CoinDAOimpl();
	private static UserDAOimpl userDAOimpl = new UserDAOimpl();

	private UsersData() {
	}

	public static UsersData getInstance() {

		return instance;
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

	public void saveLocalUserCoin(User user, Coin coin) {

		userDAOimpl.saveLocalUserCoinbuy(user, coin);

	}

	public List<Coin> getLocalUserCoinsByUser(User user) {
		return userDAOimpl.getLocalUserCoinbuysByUser(user);
	}

	public void saveLocalUserCoinbuy(UserCoinbuy userCoinbuy) {
		userDAOimpl.saveLocalUserCoinbuy(userCoinbuy);
	}

	public List<Coin> getLocalUserCoinbuysByUser(User user) {
		return 	userDAOimpl.getLocalUserCoinbuysByUser(user);
	}

//	public User createUser(int parseInt, String value, String value1, String value2, String value3, int parseInt1, int parseInt2, String value4, String value5, String value6, String value7, String value8, int parseInt3, int parseInt4, String value9) {
//	 User u = new User(  value, value1, value2, value3, parseInt1, parseInt2, value4, value5, value6, value7, value8, parseInt3, parseInt4, value9);
//		userDAOimpl.createUser(u);
//		return u;
//	}
}