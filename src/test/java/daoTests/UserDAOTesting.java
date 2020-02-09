package daoTests;

//import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.User;
import service.UserService;

public class UserDAOTesting {
	@Test
	public void add_User() {

		User u = new User("x1username", "passWordX", "NEW FULL NAME", 0, 0);
		assertTrue(UserService.createUser(u));
		assertTrue(UserService.deleteUser(UserService.getUser("x1username").getUsername()));
	}
}
