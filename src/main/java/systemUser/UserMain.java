package systemUser;

import logger.LogGround;
import models.Car;
import models.Offer;
import models.User;
import service.CarService;
import service.OfferService;
import service.UserService;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import systemUser.UserLogin;

public class UserMain {

	public static void main(String[] args) throws SQLException {

		LogGround.logger();

		try {
			System.out.println("...Logging by Log4j2.\n");
			System.out.println(Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("... JDBC Drive successfully connected.");
		} catch (ClassNotFoundException e) {
			System.out.println("oops, Driver not found :-O");
		}
		try {
			frontpage();
		} catch (Exception e) {
			UserMain.main(args);
		}
	}

	public static void carlotView() {
		List<Car> carList = CarService.getAllCarsCust(); // Customer view of carlot.
		System.out.println("\nWelcome to All-Star e-Cars!\n  " + ">>>> Now featuring 2020 e-Cars!! <<<<");

		System.out.println(carList);
		frontpage();
	}

	public static void frontpage() {

		String fileName = "C:/w/www/git/java-dev/project0/src/main/java/systemUser/scannertext.txt";

		try {
			File textFile = new File(fileName);
			Scanner scanText = new Scanner(textFile);
			int value = scanText.nextInt();
			System.out.println("\n    #=============#");
			System.out.println("    Welcome VIP # " + value);
			System.out.println("    #=============#");
			System.out.println("\n#====All-Star_E-Cars===#");
			System.out.println(
					"\n1.) Log in press '1'.\n" + "2.) Register (get great deals and make offers), press '2'"
							+ "\n3.) Browse the lot,  press '3'." + "\n\nExit, press '0'.");

			scanText.close();
		} catch (FileNotFoundException e) {
			System.out.println("Welcome script file not found: " + fileName.toString());
		}

		try {
			Scanner newScan = new Scanner(System.in);
			boolean hasNextInt = newScan.hasNextInt();
			int val = newScan.nextInt();
			try {
				if (val < 0 | val > 3 | !hasNextInt) {
					System.out.println("Please enter valid choices: 0-3");
					UserMain.frontpage();
				} else {
					switch (val) {
					case 1: {
						UserLogin.login();
						carlotView();
						break;
					}
					case 2: {
						UserRegister.register();
						carlotView();
					}
					case 3: {
						System.out.println("\n Ok, please enjoy your browsing....");
						carlotView();
						break;
					}
					case 0: {
						System.out.println("\n   Come Back *Soon* !\n");
						frontpage();
					}
					}
					newScan.close();
				}
			} catch (SQLException e) {
				System.out.println("Input digits from 0 - 4" + e);
				frontpage();
			}
			frontpage();

		} catch (InputMismatchException e) {
			System.out.println("Oops, Inputs! must choose 1,2,3,4... " + e);
			frontpage();
		}

	}

}
