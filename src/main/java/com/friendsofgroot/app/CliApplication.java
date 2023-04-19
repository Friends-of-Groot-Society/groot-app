package com.friendsofgroot.app;

import java.io.IOException;
import java.sql.SQLException;

import com.friendsofgroot.app.util.PasswordGeneratorEncoder;
import com.friendsofgroot.app.util.logger.LoggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@EntityScan("com.friendsofgroot.app.models")
 @SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CliApplication {
	private static final Logger log =
			LoggerFactory.getLogger(PasswordGeneratorEncoder.class);

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, InterruptedException {
		log.info("INSIDE ____log.info________CliApplication.main()");
		ApplicationContext ctx = SpringApplication.run(CliApplication.class, args);

//		for (String name : ctx.getBeanDefinitionNames()){
//			log.info(name);
//		}
		log.info("****log.info*** Bean Count *******");
		log.info(String.valueOf(ctx.getBeanDefinitionCount()));
		log.info("***log.info**** Class Loader *******");
		log.info(ctx.getClassLoader().toString());
		log.info("***log.info**** Environment *******");
//		log.info(ctx.getEnvironment());
		System.out.println("******* Application Name *******");
		log.info(ctx.getApplicationName());

		LoggerImpl.loggerInstance(new String[] { "CliApplication.main()" });


		// USER MAIN
		MainDashboard.console(args);
	}




}
