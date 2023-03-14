
package com.friendsofgroot.app.consoles;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.friendsofgroot.app.commands.*;
import com.friendsofgroot.app.service.UsersServiceImpl;
import com.friendsofgroot.app.util.constants.Cmds;
import com.friendsofgroot.app.models.Coin;

import com.friendsofgroot.app.service.CoinsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class AdminDashboard  {


    public static final int OPTION_COUNT_MAX = 7;
    private static final int MIN_OPTIONS = 0;




    private static void frontConsoleMenu() {
        System.out.println("*--------- -------*\n" +
                "Welcome to your Admin dashboard\n " + " ... What's Next? \n"
                + Cmds.ONE + "View Financials and Payments\n"
                + Cmds.TWO + "View Coin Lot\n"
                + Cmds.THREE + "Add Coin\n"
                + Cmds.FOUR + "Remove Unpurchased Coin\n"
                + Cmds.FIVE + "View and/or Accept Offers\n"
                + Cmds.SIX + "get Users With Coins\n"
                + OPTION_COUNT_MAX + ".) open MaPL Control(); \n"
                + Cmds.ZERO + "Logout");
    }

    // RECURSIVE LOOP, breaks out at option 0
    public static void console() throws SQLException {

        frontConsoleMenu();
        try (Scanner scan = new Scanner(System.in)) {
            int val = scan.nextInt();
            if (val < MIN_OPTIONS && val > OPTION_COUNT_MAX) {
                System.out.println("Please enter digits " + MIN_OPTIONS + "-" + OPTION_COUNT_MAX);
                console();
            } else {
                switch (val) {
                    case 0: {
                        System.out.println("At your service, back to MainDashboard ...\n");
                        MainDashboard.console();
                        break;
                    }
                    case 1: {
                        CoinsServiceImpl coinsService = new CoinsServiceImpl();

                        System.out.println("Entering Financials View...");
                        System.out.println(coinsService.getAllCoins());
                        System.out.println(Cmds.ADMIN_PERKS);
                        console();
                        break;
                    }
                    case 2: {
                        CoinsServiceImpl coinsService = new CoinsServiceImpl();

                        System.out.println("Entering CoinLot View...");
                        System.out.println(coinsService.getAllCoins());
                        System.out.println(Cmds.ADMIN_PERKS);
                        console();
                        break;
                    }
                    case 3: {
                        CoinsServiceImpl coinsService = new CoinsServiceImpl();

                        scan.nextLine();
                        System.out.println("Adding a coin? Let me get my notepad ...");
                        System.out.println("Coin ID?");
                        while (true) {
                            try {
                                scan.nextInt();
                                scan.nextLine();
                                System.out.println("Coin TOKEN?");
                                String coinToken = scan.nextLine();
                                System.out.println("Coin Symbol?");
                                String coinSymbol = scan.nextLine();
                                System.out.println("Coin Price?");
                                double price = scan.nextDouble();
                                scan.nextLine();
                                if (price > 999999.99) {
                                    System.out.println("price must be less than $1 million, please.");
                                    System.out.println("Coin Price?");
                                    price = scan.nextDouble();
                                    scan.nextLine();
                                }
                                System.out.println("Umkay,coin's coinToken is *" + coinToken + "*,\n coinSymbol is *" + coinSymbol
                                        + "*,\n and price at *$" + price + "*\n");
                                System.out.println("   Everything look right? (y) or (no)\n");
                                while (true) {
                                    String decide = scan.next();
                                    if (decide.contentEquals("y")) {
                                        Coin createdCoin = new Coin(999, coinToken, coinSymbol, price, 0); //CoinId overwritten later

                                        coinsService.createCoinCLI(createdCoin);
                                        System.out.println(
                                                "This " + createdCoin.getCoinToken() + " has been Successfully added!!\n");
                                        console();
                                    } else {
                                        console();
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println(Cmds.OOPS_TRY_AGAIN);
                            }
                            console();
                        }
                    }
                    case 4: {
                        CoinsServiceImpl coinsService = new CoinsServiceImpl();

                        System.out.println(coinsService.getAllCoins());
                        scan.nextLine();
                        System.out.println("Removing a coin? \nLet me get my notepad ...");
                        System.out.println("\nCoin ID to be removed?");
                        while (true) {
                            try {
                                val = scan.nextInt();
                                Coin uCoin = coinsService.getCoinCLI(val);
                                scan.nextLine();
                                System.out.println("1.) Remove coin #" + uCoin.getCoinId() + "? Type \"y\" or \"yes\"."
                                        + "\n\n2.)To permanently delete from records?\n" + "If so, type \"delete\" \n");

                                String decide = scan.next();
                                if ((decide.contentEquals("y")) | (decide.contentEquals("yes"))) {
                                    Coin removeCoin = new Coin(uCoin.getCoinId(), uCoin.getCoinToken(), uCoin.getCoinSymbol(),
                                            uCoin.getPriceTotal(), 2); // 2 = remove unpurchased
                                    try {
                                        coinsService.updateCoinCLI(removeCoin);
                                        System.out.println(removeCoin.toString() + "\n" + " ...\n..#" + uCoin.getCoinId()
                                                + " Successfully removed!!\n");

                                    } catch (Exception e) {
                                        System.out.println("Oops, something went wrong, try again please\n");
                                    }
                                } else if (decide.contentEquals("delete")) {// delete & unpurchased
                                    try {
                                        int deleted = uCoin.getCoinId();
                                        coinsService.deleteCoin(deleted);
                                        System.out.println("\n" + "\n...#" + deleted + " Permanently deleted!\n");

                                    } catch (Exception e) {
                                        System.out.println("Oops, something went wrong, try again please\n");
                                    }
                                } else {
                                    System.out.println("Not implemented, returning to dashboard");
                                    console();
                                }
                            } catch (Exception e) {
                                System.out.println("I could not find that coin ...\nTry again. Here's the current lot:");
                                List<Coin> coinList = coinsService.getAllCoinsCLI();
                                System.out.println(coinList);
                                console();
                            }
                            console();
                        }
                    }
                    case 5: {
                        System.out.println("OfferService.getAllOffers()");
                        console();
                        break;
                    }
                    case 6: {
                        UsersServiceImpl u = new UsersServiceImpl();

                        System.out.println(u.getUsersWithCoins());
                        console();
                        break;
                    }
                    case OPTION_COUNT_MAX: {
                        System.out.println("Opening MaPLControl...");
                        MaPLAdminInvoker newMaPLInvokerl = new MaPLAdminInvoker(""); // create new MaPLInvoker

                        NavigateRunner open = new NavigateRunner(newMaPLInvokerl ); // open MaPLControl

                        open.runNavigate();
                        console();
                        break;
                    }
                } // end switch
            }
        } catch (InputMismatchException e) {
            // go round again. Read past the end of line in the input first
            System.out.println("Please enter digits 0 to 5");
            console();
        }
    }

}
