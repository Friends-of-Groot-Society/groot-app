package com.friendsofgroot.app;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.friendsofgroot.app.consoles.MainDashboard;
import com.friendsofgroot.app.logger.LogCustom;


@EnableJpaRepositories("com.friendsofgroot.app.repositories")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@ComponentScan("com.friendsofgroot.app")
@EntityScan("com.friendsofgroot.app.models")
@SpringBootApplication
public class CliApplication {


	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		SpringApplication.run(CliApplication.class, args);
		System.out.println("INSIDE ____________CliApplication.main()");

		LogCustom.logger();


		// USER MAIN
		MainDashboard.mainUser(args);
	}




}
