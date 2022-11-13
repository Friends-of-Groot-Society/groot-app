package com.friendsofgroot.app.cli;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.friendsofgroot.app.consoles.MainDashboard;
import com.friendsofgroot.app.logger.LogCustom;

@SpringBootApplication
public class CliApplication {


	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//		SpringApplication.run(CliApplication.class, args);
		LogCustom.logger();


		// USER MAIN
		MainDashboard.mainUser(args);
	}




}
