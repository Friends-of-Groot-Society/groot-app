package com.friendsofgroot.app;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.friendsofgroot.app.consoles.MainDashboard;
import com.friendsofgroot.app.logger.LogCustom;
@ServletComponentScan("com.friendsofgroot.app")
@EnableJpaRepositories("com.friendsofgroot.app.repositories")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@ComponentScan("com.friendsofgroot.app")
@EntityScan("com.friendsofgroot.app.models")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CliApplication {


	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		System.out.println("INSIDE ____________CliApplication.main()");
		ApplicationContext ctx = SpringApplication.run(CliApplication.class, args);

//		for (String name : ctx.getBeanDefinitionNames()){
//			System.out.println(name);
//		}
		System.out.println("******* Bean Count *******");
		System.out.println(ctx.getBeanDefinitionCount());
		System.out.println("******* Class Loader *******");
		System.out.println(ctx.getClassLoader());
		System.out.println("******* Environment *******");
		System.out.println(ctx.getEnvironment());


		LogCustom.logger();


		// USER MAIN
		MainDashboard.mainConsole(args);
	}




}
