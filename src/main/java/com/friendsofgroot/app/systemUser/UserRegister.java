package com.friendsofgroot.app.systemUser;

import java.sql.SQLException;
import java.util.Scanner;

import com.friendsofgroot.app.util.constants.Cmds;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.service.UserService;

public class UserRegister {

	public static void register() throws SQLException {
	
		System.out.print(Cmds.WELCOME_REGISTER);
		System.out.print(Cmds.REGISTER_UNAME);
		Scanner scan = new Scanner(System.in);
		String un = scan.next();

		System.out.println(Cmds.REGISTER_PW); 
		String pw = scan.next();

		System.out.println(Cmds.REGISTER_FNAME); 
		String fn = scan.next();   

		System.out.println(Cmds.REGISTER_LNAME); 
		String ln = scan.next();  
		//  "ADD_NEW_USERS" 
//(username VARCHAR2, password VARCHAR2, lastName varchar2, firstName varchar2,  groups NUMBER,  usertype NUMBER,email VARCHAR2, phone VARCHAR2, cusURl VARCHAR2)
		User newUser = new User(un, pw, ln, fn, 4, 2, un+"@cryptomaven.xyz", "999-999-9999" ,"http://www.dailytech.net",
				"photoPath",
				"userGroup",
				0,
				1,
				"id" );

		System.out.println("Successfully registered: "+ UserService.createUser(newUser));
		System.out.println("New User: "+newUser);

		System.out.println("\nThank you, *" + fn + " "+ ln);
		System.out.println(" Continue to dashboard?  'yes'/'no':");
		String response = scan.next();

		UserLogin.decideDashboard(response, un);
		scan.close();

		
	}


}
