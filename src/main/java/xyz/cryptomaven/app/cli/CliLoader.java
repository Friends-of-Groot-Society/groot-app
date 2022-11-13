package xyz.cryptomaven.app.cli;

import xyz.cryptomaven.app.dataLoader.TestDataStore;
import xyz.cryptomaven.app.logger.CliLogger;
import xyz.cryptomaven.app.models.Bookmark;
import xyz.cryptomaven.app.models.Coin;
import xyz.cryptomaven.app.models.Offer;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.dataLoader.BookmarkManager;
import xyz.cryptomaven.app.dataLoader.CoinManager;
import xyz.cryptomaven.app.dataLoader.UserManager;
import xyz.cryptomaven.app.util.InputOutput;
import xyz.cryptomaven.app.utilConcurrency.DownloadThreadTask;

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
        System.out.println("1. LOADING BOOKMARK DATA");
        TestDataStore.loadData();
        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarksArray();
        coins = CoinManager.getInstance().getCoins();
        offers = CoinManager.getInstance().getOffers();

        System.out.println("printing user data: ");
        printUserData();
        System.out.println("printing bookmark data: ***Paused until AWS DB PS/SQL UPDATED");
        printBookmarks();
        System.out.println("printing coin data: ");
        printCoins();
        System.out.println("printing offer data: ");
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
            ClientActions.shareBookmark(user, bookmarks);
            ClientActions.buyCoin(user, coins);

        }
    }
    // random loader


    // Multi-Threaded Background offline html loader
    public static void runDownloaderJob() {
        DownloadThreadTask task = new DownloadThreadTask(true);
        (new Thread((Runnable) task)).start();
    }
}
