package com.friendsofgroot.app.cli;

import com.friendsofgroot.app.dataLoader.TestDataStore;
import com.friendsofgroot.app.models.Bookmark;
import com.friendsofgroot.app.models.Coin;
import com.friendsofgroot.app.models.Offer;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.dataLoader.BookmarkManager;
import com.friendsofgroot.app.dataLoader.CoinManager;
import com.friendsofgroot.app.dataLoader.UserManager;
import com.friendsofgroot.app.util.InputOutput;
import com.friendsofgroot.app.util.constants.Datum;
import com.friendsofgroot.app.util.utilConcurrency.DownloadThreadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class CliLoader {
    // app-wide vars
    private static List<User> users;
    private static List<List<Bookmark>> bookmarks;
    private static List<Coin> coins;
    private static List<Offer> offers;

    // launch methods
    public static void cliDataLoader() throws IOException {
        System.out.println(Datum.ANSI_CYAN+  "1. ANSI_CYAN LOADING BOOKMARK DATA");
        TestDataStore.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarksArray();
        coins = CoinManager.getInstance().getCoins();
        offers = CoinManager.getInstance().getOffers();

        System.out.println(Datum.ANSI_GREEN+  "ANSI_GREEN printing user data: ");
        printUserData();
        System.out.println(Datum.ANSI_BLUE+   "ANSI_BLUE printing bookmark data: ***Paused until AWS DB PS/SQL UPDATED");
        printBookmarks();
        System.out.println(Datum.ANSI_RED+ "ANSI_RED printing coin data: ");
        printCoins();

        System.out.println(Datum.ANSI_RESET+ "ANSI_RESET printing offer data: ");
        printCoins();

    }
    private static void printCoins() {
        for (Coin c: coins) {
            System.out.println(c);
            for (Offer o : offers) {
                if (c.getCoinId() ==o.getCoinId()) {
                    System.out.println("Coin #"+ c.getCoinId()+": matched Offer: "+o.getCoinId());
                }
            }
        }
    }
    private static void printUserData() throws IOException {
        for (User u : users) {
            System.out.println(u);
            InputOutput.writeUser(u);
            InputOutput.writeUsers(users);
        }
    }
    private static void printBookmarks() {
        for (List<Bookmark> i : bookmarks) {
            for (Bookmark j : i) {
                System.out.println(j);
            }
        }
    }

    public static void startBrowsingBuying() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("\n2. Start Bookmarking");
        for (User user: users) {
            ClientActions.browse(user,bookmarks);
            ClientActions.automatedShareBookmarks(user, bookmarks);
            ClientActions.automatedBuyCoins(user, coins);

        }
    }



    // Multi-Threaded Background offline html loader
    public static void runDownloaderJob() {
        DownloadThreadTask task = new DownloadThreadTask(true);
        (new Thread((Runnable) task)).start();
    }
}
