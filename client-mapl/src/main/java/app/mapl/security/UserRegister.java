package app.mapl.security;

import app.mapl.dto.UserDto;
import app.mapl.service.UsersServiceImpl;
import app.mapl.util.constants.Cmds;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class UserRegister {

	UsersServiceImpl usersService;

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
//		User newUserser = new User(un, pw, ln, fn, 4, 2, un+"@cryptomaven.xyz", "999-999-9999" ,"http://www.dailytech.net",
//				"photoPath",
//				"userGroup",
//				0,
//				1,
//				"id" );
		UserDto newUser =  new UserDto();
//		newUser.setUserid((int) Math.round(Math.random()*100));
		newUser.setUsername(un);
		newUser.setPassword(pw);
		newUser.setLastName(ln);
		newUser.setFirstName(fn);
		newUser.setUserType(2);	// 2 = customer
		newUser.setEmail(un); //  email == username
		newUser.setPhone("999-999-9999");
		newUser.setCusUrl("http://www.dailytech.net");
		newUser.setPhotoPath("photoPath");
		newUser.setIsActive(0);
		newUser.setContactType(1);
		UserRegister userRegister = new UserRegister();
		userRegister.registerThis(un, pw, fn, ln);


		System.out.println("\nThank you, *" + fn + " "+ ln);
		System.out.println(" Continue to dashboard?  'yes'/'no':");
		String response = scan.next();

		UserLogin.decideDashboard(response, un);
		scan.close();


	}
	UserDto registerThis(String un, String pw,  String fn, String ln ) {
		UserDto newUserDto =  new UserDto();
		newUserDto.setUserId((int) Math.round(Math.random()*100));//not saved
		newUserDto.setUsername(un);
		newUserDto.setPassword(pw);
		newUserDto.setLastName(ln);
		newUserDto.setFirstName(fn);
		newUserDto.setUserType(2);	// 2 = customer
		newUserDto.setEmail(un);
		newUserDto.setPhone("999-999-9999");
		newUserDto.setCusUrl("http://www.dailytech.net");
		newUserDto.setPhotoPath("photoPath");
		newUserDto.setIsActive(0);
		newUserDto.setContactType(1);
		UsersServiceImpl.createUser(newUserDto);

		return newUserDto;
	}

}
