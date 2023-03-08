package com.friendsofgroot.app.consoles;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.friendsofgroot.app.commands.IMaPL;
import com.friendsofgroot.app.commands.MaPL;
import com.friendsofgroot.app.commands.MaPLInvoker;
import com.friendsofgroot.app.commands.MaPLwriter;
import com.friendsofgroot.app.models.Coin;
import com.friendsofgroot.app.service.CoinsServiceImpl;

import com.friendsofgroot.app.service.UsersServiceImpl;
import com.friendsofgroot.app.security.UserProfile;
import com.friendsofgroot.app.util.constants.Cmds;
import org.springframework.stereotype.Component;

import static com.friendsofgroot.app.util.constants.Cmds.*;


@Component
public class UserDashboard implements IMaPL {


    private static final int MENU_FIRST = 0;
    public static final int MENU_LAST = 7;


    @Override
    public void openMaPLControl() throws SQLException {
        System.out.println(Cmds.WELCOME_TO_MY_PERSONAL_LIBRARIAN_MY_NAME_IS_MA_PL);
        MaPLInvoker mc = new MaPLInvoker();
        mc.getMapleState();

        sessionMaPL(mc);
    }

    private static void sessionMaPL(MaPLInvoker mapleInvokerSession) throws SQLException {
        // LOAD UP THE COMMANDS FROM THE DB ADMIN TABLE
        System.out.println(mapleInvokerSession.getMaplCommands());
        while (true) {
            try (Scanner scan = new Scanner(System.in)) {
                System.out.println("______________Session MaPL: AdminDashboard______________");
                System.out.println("What next? - enter number; 0 to quit()");
                int nextCommand = scan.nextInt();
                if (nextCommand == 0)
                    console("UserDashboard");

                mapleInvokerSession.execute(nextCommand);
                System.out.println("Invoked command executed.\n");
                sessionMaPL(mapleInvokerSession);
            }
        }
    }
    // RECURSIVE LOOP, breaks out at option 0

    private static void frontConsoleMenu() {
        System.out.println("\n Welcome to your Dashboard! *b*, ");
        System.out.println(WHAT_TO_DO);
        System.out.println("2: " + VIEW_ALL_COINS);
        System.out.println("3: " + VIEW_COIN_DETAILS);
        System.out.println("4: " + MAKE_AN_OFFER);
        System.out.println("5: " + MAKE_INQUIRY_MY_OFFERS);
        System.out.println("6: " + EDIT_MY_PROFILE);
        System.out.println("0: " + LEAVE_MENU);
    }

    /**
     * @param username
     */
    public static void console(String username) {


        System.out.println("Now Loading frontConsoleMenu()");
        frontConsoleMenu();
        try (Scanner scan = new Scanner(System.in)) {
            int val = scan.nextInt();
            if (val < MENU_FIRST || val > MENU_LAST) {
                System.out.println(OOPS_OPTIONS);
                val = scan.nextInt();
                scan.nextLine();
            } else {
                switch (val) {
                    case 1: {
                        try {
                            CoinsServiceImpl coinService = new CoinsServiceImpl();

                            List<Coin> coinList = coinService.getAllCoinsCustCLI();
                            System.out.println(COINMARKET_TITLE);
                            System.out.println(coinList);
                            System.out.println("4: " + PRESS_DIGIT);
                            System.out.println();
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 2: {
                        CoinsServiceImpl coinService = new CoinsServiceImpl();
                        try {
                            List<Coin> coinList = coinService.getAllCoinsCustCLI();
                            System.out.println(COINMARKET_TITLE);
                            System.out.println(coinList);
                            System.out.println("4: " + PRESS_DIGIT);
                            System.out.println();
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 3: {
                        CoinsServiceImpl coinService = new CoinsServiceImpl();
                        try {
                            List<Coin> coinList = coinService.getAllCoinsCustCLI();
                            System.out.println(coinList);
                            scan.nextLine();
                            System.out.println("Which coin #?");
                            int id = scan.nextInt();
                            scan.nextLine();
                            Coin newest = coinService.getCoinCLI(id);
                            System.out.println(newest);
                            System.out.println("\n Coin #" + id +
                                    NICE + PRESS_DIGIT + FOUR);
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 4: {
                        CoinsServiceImpl coinService = new CoinsServiceImpl();
                        try {
                            List<Coin> coinList = coinService.getAllCoinsCustCLI();
                            System.out.println("e-Coins Lot:");
                            System.out.println(coinList);
                            System.out.println("\nOk, type in the Coin ID to begin.\n"
                                    + " ...change your mind? press 'no' (or any letter)");
                            val = scan.nextInt();

                            Coin newest = coinService.getCoinCLI(val);
                            System.out.println("Voila, coin id #" + val + "\n");
                            System.out.println(newest);

                            scan.nextLine();
                            System.out.println("\nHow much, $xxxx.xx can you put down?  ");
                            double down = scan.nextDouble();
                            while (down > newest.getPriceTotal()) {
                                System.out.println("Oops, that's more than the coin price!");
                                down = scan.nextDouble();
                            }
                            scan.nextLine();
                            System.out.println(HOW_MANY_MONTHS);
                            int mos = scan.nextInt();
//				Offer offering = new Offer(777, username, val, down, mos, "PENDING");
//				 /////////////////////////////////////////////////////////////////
//				System.out.println(OfferService.createOffer(offering));
                            System.out.println(NICE + " $" + down + " down, over *" + mos + "* months\n"
                                    + "We'll let you know in less than 24 hours!!\n");
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 5: {
                        try {
//				List<Offer> offerList = OfferService.getAllOffersCust(username);
// 				for (Offer offer : offerList) {
//					System.out.println(offer);
//				}
                            System.out.println("Pressed 5");
//				 /////////////////////////////////////////////////////////////////
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 6: {
                        UsersServiceImpl usersService = new UsersServiceImpl();
                        try {
                            UserProfile.editProfile(usersService.getUser(username));

                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case MENU_LAST: {
                        System.out.println("Opening MaPLControl...");
                        MaPLInvoker newMaPLInvokerl = new MaPLInvoker(); // create new MaPLInvoker

                        NavigateRunner open = new NavigateRunner( ); // open MaPLControl
                        open.runNavigate(newMaPLInvokerl);
                        console("UserDashboard");
                        break;
                    }
                    case 0: {
                        System.out.println(GOOD_BYE);
                        MainDashboard.console();
                        break;
                    }
                }
            }
            console(username);
        }

    }

    ;


    /**
     * @return
     */
    @Override
    public String[] getCmds() {
        return new String[0];
    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPL cmd) {

    }

    /**
     *
     */
    @Override
    public void getMapleState() {

    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(String cmdName, MaPLwriter cmd) {

    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPLwriter cmd) {

    }

    /**
     * @param cmdId
     */
    @Override
    public void execute(int cmdId) {

    }

    /**
     *
     */
    @Override
    public void execute() {

    }

    /**
     *
     */
    @Override
    public void up() {

    }

    /**
     *
     */
    @Override
    public void down() {

    }

    /**
     *
     */
    @Override
    public void left() {

    }

    /**
     *
     */
    @Override
    public void right() {

    }

    /**
     * @param o
     */
    @Override
    public void up(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void down(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void left(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void right(Object o) {

    }
}
