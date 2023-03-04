package com.friendsofgroot.app.serviceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.friendsofgroot.app.service.UsersServiceImpl;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.service.UsersService;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {      // *NOTE: change PK usernames before sending to DB

//    @InjectMocks
//	private UsersService userServiceTester;
    @Mock
    private UsersService userServiceMock;
    // Impl usersServiceImpl = mock(UsersServiceImpl.class);
    @InjectMocks
    private UsersServiceImpl usersServiceImpl;

    @BeforeAll
    public final static void setup() {
//        MockitoAnnotations.openMocks(UsersServiceImpl.class);
    }
//    TODO mockito Service INJECTION
    @Test
    public void add_new_user() {
        User u = new User( );
        when(userServiceMock.createUser(u)).thenReturn(assertInstanceOf(User.class, u));
        assertEquals(userServiceMock.createUser(u), u);
     }

    @Test
    public void get_users() {

        when(userServiceMock.getUsers()).thenReturn(Arrays.asList(
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
        List<User> users = userServiceMock.getUsers();
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
        when(userServiceMock.getUser("user1")).thenReturn(
                    new User(
                        "user1", "password1",
                        "Smith", "Tom", 3, 1,
                        "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                        "photoPath",
                        "userGroup",
                        0,
                        1,
                        "id"));
        User user = userServiceMock.getUser("user1");
        assertEquals("user1", user.getUserName());
    }

    @Test
    public void update_user() {
		User uUpdated = new User("password", "Smith", "Tom", 3, 1, "5055087707" , "user4@cryptomaven.xyz", "http://www.dailytech.net","photoPath", 	"userGroup",
				0,
				1,
				"id");   // PASSES
        when(userServiceMock.updateUser(uUpdated)).thenReturn(assertInstanceOf(User.class, uUpdated));
        assertEquals(userServiceMock.updateUser(uUpdated), uUpdated);
    }

    @Test
    public void delete_user() {
		User u = new User("user4", "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net",
				"photoPath",
				"userGroup",
				0,
				1,
				"id");    // PASSES
		String x = u.getEmail();
		System.out.println("about to delete just  ..."+x);
        when(userServiceMock.deleteUser(u)).thenReturn( assertInstanceOf(Boolean.class, true));

        assertTrue(userServiceMock.deleteUser(u));
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