package com.friendsofgroot.app.security;


import com.friendsofgroot.app.consoles.AdminDashboard;
import com.friendsofgroot.app.consoles.MainDashboard;
import com.friendsofgroot.app.consoles.UserDashboard;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.InputMismatchException;


import static com.friendsofgroot.app.security.SpringSecurityConfiguration.checkDbUsernameAndPassword;
import static com.friendsofgroot.app.security.SpringSecurityConfiguration.hardCodedAdminNameAndPassword;
import static com.friendsofgroot.app.util.Utilities._earlyQuit; //RETURNS TO MainConsole

public class UserLogin {


    public static void login() throws SQLException {

        try {
            System.out.println("Welcome, please enter your username: [admin: admin; default: joshallen]");
            System.out.println(" 'quit' to go back");
            Scanner scanner = new Scanner(System.in);
            String un = scanner.next();
            _earlyQuit(new String[]{un});
            System.out.println("and your password: [admin: pass; default: allen");
            String pw = scanner.next();
            _earlyQuit(new String[]{pw});

            //  admin   hardcoded backdoor
            if (hardCodedAdminNameAndPassword(un, pw)) {
                AdminDashboard.adminConsole(); //
            }

            // VALIDATION #1 - LOOK UP AND GET Targeted DB USER
            if (checkDbUsernameAndPassword(un, pw)) {
                decideDashboard("yes", un);
            } else {
                System.out.println("Oops, typo time, please try again");
                try {
                    login(); // login input clears for next attempt
                } catch (InputMismatchException e) {
                    e.getMessage();
                    MainDashboard.mainConsole();
                }
            }
            scanner.close();
        } catch (

                InputMismatchException e) {
            System.out.println("Oops, must choose 1 or 2... ");
        }
    }

    static void decideDashboard(String resp, String userName) {
		if (resp.matches("y|yes|true")) {
            try {
                System.out.println("...sounds good, *" + userName + "*, now logging you into your Dashboard");
                UserDashboard.dashboardChoice(userName);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                MainDashboard.mainConsole();
            }
        } else {
            MainDashboard.mainConsole();
        }
    }



}
