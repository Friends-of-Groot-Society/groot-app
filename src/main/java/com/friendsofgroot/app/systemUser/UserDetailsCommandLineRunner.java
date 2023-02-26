package com.friendsofgroot.app.systemUser;

import com.friendsofgroot.app.dataLoader.BookmarkManager;
import com.friendsofgroot.app.dataLoader.CoinManager;
import com.friendsofgroot.app.dataLoader.TestDataStore;
import com.friendsofgroot.app.dataLoader.UserManager;
import com.friendsofgroot.app.models.Bookmark;
import com.friendsofgroot.app.models.Coin;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.service.BookmarkServlet;
import com.friendsofgroot.app.service.CoinLocalService;
import com.friendsofgroot.app.util.InputOutput;
import com.friendsofgroot.app.util.constants.Datum;
import com.friendsofgroot.app.util.utilConcurrency.DownloadThreadTask;
import org.springframework.boot.CommandLineRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsCommandLineRunner   implements CommandLineRunner {

        private static List<User> users;
        private static List<List<Bookmark>> bookmarks;
        private static List<Coin> coins;

        /**
         * launch methods
         * @param args
         * @throws Exception
         */
        @Override
        public void run(String... args) throws IOException {

            users = UserManager.getInstance().getUsers();
            bookmarks = BookmarkManager.getInstance().getBookmarksArray();
            coins = CoinManager.getInstance().getCoins();


            System.out.println(Datum.ANSI_CYAN+  "1. ANSI_CYAN LOADING BOOKMARK DATA");
            TestDataStore.loadData();

            System.out.println(Datum.ANSI_PURPLE+ "ANSI_PURPLE printing user data: ");

            System.out.println(Datum.ANSI_GREEN+  "ANSI_GREEN printing user data: ");
            printUserData();
            System.out.println(Datum.ANSI_BLUE+   "ANSI_BLUE printing bookmark data: ***Paused until AWS DB PS/SQL UPDATED");
            printBookmarks();
            System.out.println(Datum.ANSI_RED+ "ANSI_RED printing startBrowsingBuying: ");
            startBrowsingBuying();

            System.out.println(Datum.ANSI_RESET+ "ANSI_RESET runDownloaderJob ");
            runDownloaderJob();

        }



    static void printUserData() throws IOException {
        for (User u : users) {
            System.out.println(u);
            InputOutput.writeUser(u);
            InputOutput.writeUsers(users);
        }
    }
    static void printBookmarks() {
        for (List<Bookmark> i : bookmarks) {
            for (Bookmark j : i) {
                System.out.println(j);
            }
        }
    }

    public static void startBrowsingBuying() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("\n2. Start Bookmarking");
        for (User user: users) {
            autoCollectBookmarks(user,bookmarks);
            autoShareBookmarks(user, bookmarks);
            automatedBuyCoins(user, coins);

        }
    }
    // Multi-Threaded Background offline html loader
    public static void runDownloaderJob() {
        DownloadThreadTask task = new DownloadThreadTask(true);
        (new Thread((Runnable) task)).start();
    }
    public static List<Bookmark> autoCollectBookmarks(User user, List<List<Bookmark>> bookmarks) throws FileNotFoundException, UnsupportedEncodingException {
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
                BookmarkServlet.getInstance().saveLocalUserBookmark(user, bookmark);
                subset.add(bookmark);
            }
        }
        return subset;
    }

    static boolean getBookmarkDecision(Bookmark bookmark) {
        return (Math.random() <.4);
    }

    // user shares subset of browsed bookmarks:
    public static void autoShareBookmarks(User user, List<List<Bookmark>> bookmarks) {
        System.out.println("\n" + user.getEmail() + " is sharing two instance: (0)link or (1) book; Not (2) movie");
        for(int x = 0;x<=1;x++) {
            int bookmarkOffset = (int) (Math.random() * TestDataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark = bookmarks.get(x).get(bookmarkOffset);
            BookmarkServlet.getInstance().shareBookmark(user, bookmark);
            System.out.println("User: " + user.getEmail() + "inside View; bookmark: " + bookmark.getTitle()+ bookmark.getClass());
        }
    }

    public static void automatedBuyCoins(User user, List<Coin> coins) {
        System.out.println("\n" + user.getEmail() + " is coinbuying");
        for (int i = 0; i < 5; i++) {  // buy 5 randomly among inventory
            int coinOffset = (int) (Math.random() * TestDataStore.getCoinInventory());
            Coin coin = coins.get(coinOffset);
            CoinLocalService.getInstance().saveLocalUserCoin(user, coin);
            System.out.println(coin.getCoinSymbol());
        }
    }


    }

