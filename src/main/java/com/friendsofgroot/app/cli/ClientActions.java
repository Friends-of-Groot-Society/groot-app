package com.friendsofgroot.app.cli;

import com.friendsofgroot.app.controllers.BookmarkController;
import com.friendsofgroot.app.dataLoader.TestDataStore;
import com.friendsofgroot.app.models.Bookmark;
import com.friendsofgroot.app.models.Coin;
import com.friendsofgroot.app.models.User;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class
ClientActions {

	public static List<Bookmark> browse(User user, List<List<Bookmark>> bookmarks) throws FileNotFoundException, UnsupportedEncodingException {
		List<Bookmark> subset = new ArrayList<>();
		System.out.println("\n" + user.getEmail() + " is bookmarking");
		int count = 0;
		for (int i = 0; i < TestDataStore.USER_BOOKMARK_LIMIT; i++) {
			// BOOKMARK_TYPES_COUNT 0= webLink, 1=book, 2=movie
			int typeOffset = (int) (Math.random() * TestDataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset = (int) (Math.random() * TestDataStore.BOOKMARK_COUNT_PER_TYPE);
			Bookmark bookmark = bookmarks.get(typeOffset).get(bookmarkOffset);
			boolean isBookmarked = getBookmarkDecision(bookmark); //bookmark ~ 4 of 10
			if(isBookmarked) {
				count++;
				System.out.println(count+ "[Bookmarke]"+bookmark);
				BookmarkController.getInstance().saveUserBookmark(user, bookmark);
				subset.add(bookmark);
			}
		}
		return subset;
	}

	static boolean getBookmarkDecision(Bookmark bookmark) {
		return (Math.random() <.4);
	}

	// user shares subset of browsed bookmarks:
	public static void shareBookmark(User user, List<List<Bookmark>> bookmarks) {
		System.out.println("\n" + user.getEmail() + " is sharing two instance: (0)link or (1) book; Not (2) movie");
		for(int x = 0;x<=1;x++) {
			int bookmarkOffset = (int) (Math.random() * TestDataStore.BOOKMARK_COUNT_PER_TYPE);
			Bookmark bookmark = bookmarks.get(x).get(bookmarkOffset);
			BookmarkController.getInstance().shareBookmark(user, bookmark);
			System.out.println("User: " + user.getEmail() + "inside View; bookmark: " + bookmark.getTitle()+ bookmark.getClass());
		}
	}
	public static void buyCoin(User user, List<Coin> coins) {
		System.out.println("\n" + user.getEmail() + " is coinbuying");
		for (int i = 0; i < 2; i++) {  // buy 2 randomly among inventory
			int coinOffset = (int) (Math.random() * TestDataStore.getCoinInventory());
			Coin coin = coins.get(coinOffset);
			ViewUserCommand.UserController.getInstance().saveUserCoin(user, coin);
			System.out.println(coin);
		}
	}
	}
