package app.mapl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import app.mapl.models.User;
import app.mapl.util.methods.restTemplate.LoanRepository;
import app.mapl.webControllers.ForEntityMethod;
import app.mapl.webControllers.ForObjectMethod;
import jakarta.ws.rs.BeanParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import app.mapl.consoles.MainDashboard;
import app.mapl.util.logger.LoggerImpl;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@ServletComponentScan("app.mapl.app")
@EnableJpaRepositories("app.mapl.repositories")
@EntityScan("app.mapl.models")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CliApplication {

	@Bean
	public LoggerImpl loggerImpl() {
		return new LoggerImpl();
	}

	static RestTemplate restTemplate = new RestTemplate();
	static String baseUrl = "http://localhost:8080/api/";


	@Autowired
	private static ForEntityMethod ForEntityMethod;
	private static final Logger log;

	static {
		log = LoggerFactory.getLogger(CliApplication.class);
	}

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		log.info("INSIDE ____log.info________CliApplication.main()");
		ApplicationContext ctx = SpringApplication.run(CliApplication.class, args);

		logBeans(ctx);

		//SpringApplication.run(UserManagementClient.class, args);
		useExchangeMethodsOfRestTemplate();

//		ForEntityMethod ForEntityMethod = new ForEntityMethod();
//		ForEntityMethod.driverMethod();
//		ForObjectMethod ForObjectMethod = new ForObjectMethod();
//		ForObjectMethod.driverMethod();
		// USER MAIN
		MainDashboard.console(args);
	}

	@Profile(value={"dev"})
	private static void logBeans(ApplicationContext ctx) {
		log.info("logbeans ____dev____XXXXXX");
		log.info("****log.info*** Bean Count *******");
		log.info(String.valueOf(ctx.getBeanDefinitionCount()));
		log.info("***log.info**** Class Loader *******");
		log.info(ctx.getClassLoader().toString());
		log.info("***log.info**** Environment *******");
//		log.info(ctx.getEnvironment());
		System.out.println("******* Application Name *******");
		log.info(ctx.getApplicationName());
		LoggerImpl.loggerInstance(new String[] { "CliApplication.main()" });
//		for (String name : ctx.getBeanDefinitionNames()){
//			log.info(name);
//		}
	}


	private static void useExchangeMethodsOfRestTemplate() {

		HttpHeaders headers;
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Object> requestEntity = new HttpEntity<>(headers);

		getSingleUserByExchangeMethod(requestEntity);
		getListUserByExchangeMethod(requestEntity);

		User sysUser = new User();
		sysUser.setFirstName("thomas");
		sysUser.setLastName("Milton");
		//requestEntity = new HttpEntity<>(sysUser, headers);

		//addUserByExchangeMethod(requestEntity);

		//updateUserByExchangeMethod(requestEntity);

		//deleteUserByExchangeMethod(requestEntity);
	}

	private static void deleteUserByExchangeMethod(HttpEntity<User> requestEntity) {
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "users/21",
				HttpMethod.DELETE,
				requestEntity,
				String.class);
		statusCode(responseEntity);
	}


	private static void updateUserByExchangeMethod(HttpEntity<User> requestEntity) {
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "users/21",
				HttpMethod.PUT,
				requestEntity,
				String.class);
		statusCode(responseEntity);
	}

	private static void addUserByExchangeMethod(HttpEntity<User> requestEntity) {
		ResponseEntity<User> responseEntity = restTemplate.exchange(baseUrl + "users",
				HttpMethod.POST,
				requestEntity,
				User.class);

		HttpStatusCode statusCode = responseEntity.getStatusCode();
		System.out.println("status code - " + statusCode);
		User userDetails = responseEntity.getBody();
		System.out.println("response body - " + userDetails);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("response Headers - " + responseHeaders);
	}


	private static void getListUserByExchangeMethod(HttpEntity<Object> requestEntity) {
		ResponseEntity<List> responseEntity = restTemplate.exchange(baseUrl + "users",
				HttpMethod.GET,
				requestEntity,
				List.class);
		HttpStatusCode statusCode = responseEntity.getStatusCode();
		System.out.println("status code - " + statusCode);
		List user = responseEntity.getBody();
		System.out.println("response body - " + user);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("response Headers - " + responseHeaders);
/*
        ResponseEntity<User> responseUser = restTemplate.exchange(baseUrl + "user/5",
                HttpMethod.GET,
                requestEntity,
                User.class);
        User userBody = responseUser.getBody();
        System.out.println("user object - " + userBody);*/
	}

	private static void getSingleUserByExchangeMethod(HttpEntity<Object> requestEntity) {
		ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl + "users/5",
				HttpMethod.GET,
				requestEntity,
				String.class);
		statusCode(responseEntity);

		ResponseEntity<User> responseUser = restTemplate.exchange(baseUrl + "users/5",
				HttpMethod.GET,
				requestEntity,
				User.class);
		User userBody = responseUser.getBody();
		System.out.println("user object - " + userBody);
	}

	public static void statusCode(ResponseEntity<String> responseEntity) {
		HttpStatusCode statusCode = responseEntity.getStatusCode();
		System.out.println("status code - " + statusCode);
		String user = responseEntity.getBody();
		System.out.println("response body - " + user);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("response Headers - " + responseHeaders);
	}



}
