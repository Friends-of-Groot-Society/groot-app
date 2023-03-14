package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.models.*;
import com.friendsofgroot.app.repositories.CoinsRepository;
import com.friendsofgroot.app.repositories.UsersRepository;
import com.friendsofgroot.app.repositories.WeblinksRepository;
import com.friendsofgroot.app.service.BookmarkServlet;
import com.friendsofgroot.app.util.ReadWriteFile;
import com.friendsofgroot.app.util.constants.Datum;
import com.friendsofgroot.app.util.logger.CliLogger;
import com.friendsofgroot.app.util.utilConcurrency.DownloadThreadTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDetailsCLR implements CommandLineRunner {

//    import org.slf4j.Logger;
    private static final Logger log =
            LoggerFactory.getLogger(UserDetailsCLR.class);

    @Autowired
    private UsersRepository usersRepository;
    private List<User> users;
    private static List<User> usersStatic;
    private List<Weblink> bookmarks;
    private static List<Weblink> bookmarksStatic;
    private List<Coin> coins;
    private static List<Coin> coinsStatic;

    @Autowired
    private WeblinksRepository weblinksRepository;
    @Autowired
    private CoinsRepository coinsRepository;

    /**
     * launch methods
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws IOException {
    if (System.getenv("ENV") != null && System.getenv("ENV").equals("dev")) {

        System.out.println("ENV: " + System.getenv("ENV"));
        CliLogger.getInstance().info("UserDetailsCommandLineRunner.run()");

        System.out.println(Datum.ANSI_CYAN + "1. ANSI_CYAN LOADING BOOKMARK DATA");
//        FileDataStore.loadData();

        System.out.println(Datum.ANSI_CYAN + "1. ANSI_CYAN LOADING USERS");// USERS
        usersStatic = FileDataStore.loadUsers();
        users = usersStatic;
        users.stream().map(user -> {
            user.setUsername(user.getEmail());
            user.setAddresses(new ArrayList<>(List.of(new Address ( 0, "description", "owner", "address", "chain", "iconUrl", "blockExplorerUrl", new User(),1  ))));
            return user;
        });

        usersRepository.saveAll(users);
        usersRepository.save(new User("thomas.maestas@gmail.com", "password", "lastName", "firstName",
                1, 1, "phone", "thomas.maestas@gmail.com", "cusUrl", "photoPath", "userGroup", 1, 3, "1"));
        usersRepository.save(new User("admin", "password", "lastName", "firstName",
                0, 0, "phone", "admin@gmail.com", "cusUrl", "photoPath", "userGroup", 1, 3, "0"));


        Optional<User> userWithIdOne = usersRepository.findById(1);
        log.info("User is retrieved : " + userWithIdOne);

        List<User> users = usersRepository.findAll();
        log.info("All Users : " + users);

        // WEBLINKS
        try {
            bookmarksStatic = FileDataStore.loadWeblinks();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        bookmarks = bookmarksStatic;
        weblinksRepository.saveAll(bookmarks);
        weblinksRepository.save(new Weblink(0, "https://www.google.com", "Google", "<html><head></head><body>Hello!!!!!!!</body></html>", Weblink.DownloadStatus.SUCCESS));

        // COINS
        System.out.println(Datum.ANSI_RED + "ANSI_RED printing user data: ");
        coinsStatic = FileDataStore.loadCoins();
        coins = coinsStatic;
        coinsRepository.saveAll(coins);
        coinsRepository.save(new Coin(0, "Ethereum", "ETH", 1455.1111, 0));
        coinsRepository.save(new Coin(1, "Bitcoin", "BTC", 23455.5455, 1));


        System.out.println(Datum.ANSI_GREEN + "ANSI_GREEN printing user data: ");
        printUserData();
        System.out.println(Datum.ANSI_BLUE + "ANSI_BLUE printing bookmark data: ***Paused until AWS DB PS/SQL UPDATED");
        printBookmarks();
        System.out.println(Datum.ANSI_PURPLE + "ANSI_PURPLE printing startBrowsingBuying: ");
        startBrowsingBuying();

//        runDownloaderJob();
        System.out.println(Datum.ANSI_RESET + "ANSI_RESET without runDownloaderJob ");

    } else {
        System.out.println("MAVEN_HOME: NOT SET");
    }
    }


    static void printBookmarks() {
        for (Bookmark i : bookmarksStatic) {
            if (i instanceof Weblink) {
                System.out.println("WEBLINK" + i);
            } else {
                System.out.println("NON-WEBLINK" + i);
            }
        }
    }

    void writeUserData() throws IOException {
        for (User u : users) {
            System.out.println("|__________|  WRITING USER  TO FILE |_______|  /n" + u);
            ReadWriteFile.writeUser(u);
            ReadWriteFile.writeUsers(users);
        }
    }

    void printUserData() throws IOException {
        for (User u : users) {
            System.out.println(u);
        }
    }

    public static void startBrowsingBuying() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("\n2. Start Bookmarking");
        for (User user : usersStatic) {
            autoCollectBookmarks(user, bookmarksStatic);
            autoShareBookmarks(user, bookmarksStatic);
            automatedBuyCoins(user, coinsStatic);

        }
    }

    // Multi-Threaded Background offline html loader
    public static void runDownloaderJob() {
        DownloadThreadTask task = new DownloadThreadTask(true);
        (new Thread((Runnable) task)).start();
    }

    public static List<Bookmark> autoCollectBookmarks(User user, List<Weblink> bookmarks) throws IllegalStateException, FileNotFoundException, UnsupportedEncodingException {
        List<Bookmark> subset = new ArrayList<>();
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        int count = 0;
        for (int i = 0; i < FileDataStore.USER_BOOKMARK_LIMIT; i++) {
            // BOOKMARK_TYPES_COUNT 0= webLink, 1=book, 2=movie
//            int typeOffset = (int) (Math.random() * FileDataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffset = (int) (Math.random() * FileDataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark = bookmarks.get(bookmarkOffset);
            boolean isBookmarked = getBookmarkDecision(bookmark); //bookmark ~ 4 of 10
            if (isBookmarked) {
                count++;
                System.out.println(count + "[Bookmarke]" + bookmark);
                BookmarkServlet.getInstance().saveLocalUserBookmark(user, bookmark);
                subset.add(bookmark);
            }
        }
        return subset;
    }

    static boolean getBookmarkDecision(Bookmark bookmark) {
        return (Math.random() < .4);
    }

    // user shares subset of browsed bookmarks:
    public static void autoShareBookmarks(User user, List<Weblink> bookmarks) {
        System.out.println("\n" + user.getEmail() + " is sharing two instance: (0)link or (1) book; Not (2) movie");
        for (int x = 0; x <= 1; x++) {
            int bookmarkOffset = (int) (Math.random() * FileDataStore.BOOKMARK_COUNT_PER_TYPE);
            Bookmark bookmark = bookmarks.get(bookmarkOffset);
            BookmarkServlet.getInstance().shareBookmark(user, bookmark);
            System.out.println("User: " + user.getEmail() + "inside View; bookmark: " + bookmark.getTitle() + bookmark.getClass());
        }
    }

    public static void makeCoins() throws FileNotFoundException, UnsupportedEncodingException {
        coinsStatic = FileDataStore.loadCoins();
    }

    public static void automatedBuyCoins(User user, List<Coin> coins) {
        System.out.println("\n" + user.getEmail() + " is coinbuying");
        for (int i = 0; i < coins.size(); i++) {  // buy 5 randomly among inventory
            int coinOffset = (int) (Math.random() * FileDataStore.getCoinInventory());
            Coin coin = coins.get(coinOffset);
            CoinManager.getInstance().saveLocalUserCoin(user, coin);
            System.out.println(coin.getCoinSymbol());
        }
    }


}

