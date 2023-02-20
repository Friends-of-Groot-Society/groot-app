package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.models.*;
import com.friendsofgroot.app.util.InputOutput;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.friendsofgroot.app.util.constants.Datum.*;

import static com.friendsofgroot.app.util.constants.Datum.*;


public class TestDataStore extends InputOutput{

	public static int USER_BOOKMARK_LIMIT = 5; // Non-member User
//	public   int USER_BOOKMARK_LIMIT = Integer.MAX_VALUE; //Premium -member
	// DATA SOURCES
	private static int COIN_INVENTORY;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;

	public List<Groups> groups = new ArrayList<>();
	public static List<Coin> coins = new ArrayList<>();
	public static List<Nft> nfts = new ArrayList<>();

	public static int getCoinInventory() {
		return COIN_INVENTORY;
	}

	private static int TEST_USERS;
	public static List<UserCoinbuy> userCoinbuys = new ArrayList<>();
	public static List<UserNftbuy> userNftbuys = new ArrayList<>();
	private static List<User> users = new ArrayList<>();
	public static List<User> getUsers() {
		return users;
	}

	protected static List<List<Bookmark>> bookmarks= new ArrayList<>();
	public static List<List<Bookmark>> getBookmarksArray() {
		return bookmarks;
	}
	public static List<UserBookmark> userBookmarks = new ArrayList<>();

	public int bookmarkIndex; // initialized to zero
	public static void loadData() throws FileNotFoundException, UnsupportedEncodingException {
		loadUsers();
		loadWeblinks();

		loadCoins();
		loadGroups();
	}


		private static void loadUsers() throws FileNotFoundException, UnsupportedEncodingException {
//		users[0] = UserManager.getInstance().createUser(500,  "user0", "password", "Smith", "Tom", Group.MALE,  UserType.USER, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net", "1000");
 	List<String> data = new ArrayList<>();
			InputOutput.readFromFilename(data,  FILE_IN_USERS);
			System.out.println("TEST_USERS::::::: "+FILE_IN_USERS+data.toString());
			for (String row : data) {
				String[] values = row.split(",");
				User user = UserManager.getInstance().createUser(Integer.parseInt(values[0]), values[1], values[2], values[3], values[4], Integer.parseInt(values[5]), Integer.parseInt(values[6]), values[7], values[8], values[9],  values[10],values[11],Integer.parseInt(values[12]),Integer.parseInt((values[13])),values[14]);
				users.add(user);
				TEST_USERS = users.size();
			}
		}

		private static void loadWeblinks() throws FileNotFoundException, UnsupportedEncodingException {
//			bookmarks[0][0] = BookmarkManager.getInstance().createWeblink(2000,  "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com" );
			List<String>  data = new ArrayList<>();
			InputOutput.readFromFilename(data, FILE_IN_WEBLINKS);
			List<Bookmark> WeblinkList = new ArrayList<>();
			for (String row : data) {
				String[] values = row.split(",");
				Bookmark weblink = BookmarkManager.getInstance().createWeblink(Long.parseLong(values[0]), values[1],  values[2]);
				WeblinkList.add(weblink);
			}
			bookmarks.add(WeblinkList);   // First of Three
		}

		public static void loadCoins() throws FileNotFoundException, UnsupportedEncodingException {
//		Coin coin1 = CoinManager.getInstance().createCoin(5000, CoinMake.TESLA, "Cyber-Truck", 37000.99, 0);
			List<String> data =new ArrayList<>();
			InputOutput.readFromFilename(data, FILE_IN_COINS);
			for (String row: data) {
				String[] values = row.split(",");
				Coin coin = CoinManager.getInstance().createCoin(Integer.parseInt(values[0]), values[1], values[2], Double.parseDouble(values[3]), Integer.parseInt(values[4]));
				coins.add(coin);
				COIN_INVENTORY = coins.size();
			}
		};
	public static void loadGroups() throws FileNotFoundException, UnsupportedEncodingException {
//		Group group1 = UserManager.getInstance().createGroup( 7004,24,"Business Group");
		List<String> data =new ArrayList<>();
		InputOutput.readFromFilename(data, FILE_IN_GROUPS);
		for (String row: data) {
			String[] values = row.split(",");
			Groups groups = UserManager.getInstance().createGroups(Integer.parseInt(values[0]), Integer.parseInt(values[1]), values[2] );
			groups.add(groups);
		}
	};
// TABLE JOIN
	public static void add(UserBookmark userBookmark) {
		userBookmarks.add(userBookmark);
	}

	public static void add(Groups groups) {
		groups.add(groups);
	}

	public static void add(UserCoinbuy userCoinbuy) {
		userCoinbuys.add(  userCoinbuy);
	}
	public static void add(UserNftbuy userNftbuy) {
		userNftbuys.add( userNftbuy);
	}


	public static List<Coin> getCoins() {
		return coins;
	}

	public static List<Nft> getNfts() {
		return nfts;
	}

	public static void saveLocalUserCoinbuy(User user, Coin coin) {
		UserCoinbuy userCoinbuy = new UserCoinbuy();
		userCoinbuy.setUser(user);
		userCoinbuy.setCoin(coin);
	}

	public List<Coin> getLocalCoinsByUser(User user) {
		List<Coin> coinsOwnedByUser = new ArrayList<>();
		for(UserCoinbuy userCoinbuy : userCoinbuys) {
			if(userCoinbuy.getUser() == user) {
				coinsOwnedByUser.add(userCoinbuy.getCoin());
			}
		}
		return coinsOwnedByUser;
	}

	public static List<Bookmark> getLocalUserBookmarksByUser(User user) {
		List<Bookmark> bookmarksOwnedByUser = new ArrayList<>();
		for(UserBookmark userbookmark: userBookmarks) {
			if(userbookmark.getUser()==user) {
				bookmarksOwnedByUser.add(userbookmark.getBookmark());
			}
		}
		return bookmarksOwnedByUser;
	}

}










