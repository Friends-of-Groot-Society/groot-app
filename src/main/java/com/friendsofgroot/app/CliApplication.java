package com.friendsofgroot.app;

import java.io.IOException;
import java.sql.SQLException;

import com.friendsofgroot.app.util.logger.LoggerImpl;
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
@ServletComponentScan("com.friendsofgroot.app")
@EnableJpaRepositories("com.friendsofgroot.app.repositories")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@ComponentScan("com.friendsofgroot.app")
@EntityScan("com.friendsofgroot.app.models")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CliApplication {


	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		System.out.println("INSIDE ____________CliApplication.main()");
		ApplicationContext ctx = SpringApplication.run(CliApplication.class, args);

//		for (String name : ctx.getBeanDefinitionNames()){
//			System.out.println(name);
//		}
		System.out.println("******* Bean Count *******");
		System.out.println(ctx.getBeanDefinitionCount());
		System.out.println("******* Class Loader *******");
		System.out.println(ctx.getClassLoader().toString());
		System.out.println("******* Environment *******");
//		System.out.println(ctx.getEnvironment());
		System.out.println("******* Application Name *******");
		System.out.println(ctx.getApplicationName());

		LoggerImpl.loggerInstance(new String[] { "CliApplication.main()" });


		// USER MAIN
		MainDashboard.mainConsole(args);
	}




}
