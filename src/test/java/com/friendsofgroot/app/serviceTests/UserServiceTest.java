package com.friendsofgroot.app.serviceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.friendsofgroot.app.service.UsersServiceImpl;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.service.UsersService;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB

//    @InjectMocks
//	private UsersService userServiceTester;
    @Mock
    private UsersServiceImpl usersServiceImpl = mock(UsersServiceImpl.class);

//    @BeforeAll
//    public final static void setup() {
//
//        MockitoAnnotations.openMocks(UsersServiceImpl.class);
//    }
    //TODO mockito Service INJECTION
    @Test
    public void add_new_user() {
        User u = new User(
                "user0", "passwordX",
                "Smith", "Tom", 3, 1,
                "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                "photoPath",
                "userGroup",
                0,
                1,
                "id");
        when(usersServiceImpl.createUser(u)).thenReturn(assertInstanceOf(User.class, u));
        assertEquals(usersServiceImpl.createUser(u), u);
     }

    @Test
    public void get_users() {

        when(usersServiceImpl.getUsers()).thenReturn(Arrays.asList(
                new User(
                        "user1", "password1",
                        "Smith", "Tom", 3, 1,
                        "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                        "photoPath",
                        "userGroup",
                        0,
                        1,
                        "id"),
                new User(
                        "user2", "password2",
                        "Smith", "Tom", 3, 1,
                        "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                        "photoPath",
                        "userGroup",
                        0,
                        1,
                        "id")));
        List<User> users = usersServiceImpl.getUsers();
        assertEquals("user1", users.get(0).getUserName());
        assertEquals("password2", users.get(1).getPassword());
    }

    @Test
    public void get_user() {
        User u = new User(
                "user1", "password1",
                "Smith", "Tom", 3, 1,
                "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                "photoPath",
                "userGroup",
                0,
                1,
                "id");
        when(usersServiceImpl.getUser("user1")).thenReturn(
                    new User(
                        "user1", "password1",
                        "Smith", "Tom", 3, 1,
                        "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                        "photoPath",
                        "userGroup",
                        0,
                        1,
                        "id"));
        User user = usersServiceImpl.getUser("user1");
        assertEquals("user1", user.getUserName());
    }

    @Test
    public void update_user() {
		User uUpdated = new User("password", "Smith", "Tom", 3, 1, "5055087707" , "user4@cryptomaven.xyz", "http://www.dailytech.net","photoPath", 	"userGroup",
				0,
				1,
				"id");   // PASSES
        when(usersServiceImpl.updateUser(uUpdated)).thenReturn(assertInstanceOf(User.class, uUpdated));
        assertEquals(usersServiceImpl.updateUser(uUpdated), uUpdated);
    }

    @Test
    public void delete_user() {
//		User u = new User("user4"+rand, "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net",
//				"photoPath",
//				"userGroup",
//				0,
//				1,
//				"id");    // PASSES
//		String x = u.getUserName()+rand;
//		System.out.println("about to delete just  ..."+x);
//		assertTrue(UserService.deleteUser(x));
//		System.out.println("deleteed just now ..."+ x);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After Class executing ...");
    }

    @AfterAll  // static! (not needed with TestNG @BeforeClass
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}