package com.friendsofgroot.app.serviceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.friendsofgroot.app.dto.CoinDto;
import com.friendsofgroot.app.dto.UserDto;
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
public class UserServiceMockTest {

    public static final String USER_4_CRYPTOMAVEN_XYZ = "user4@cryptomaven.xyz";
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
        UserDto u = new UserDto( );
        when(userServiceMock.createUser(u)).thenReturn(assertInstanceOf(UserDto.class, u));
        assertEquals(userServiceMock.createUser(u), u);
     }


    @Test
    public void get_user() {
        UserDto user = new UserDto( );
        user.setEmail(USER_4_CRYPTOMAVEN_XYZ);
//        when(userServiceMock.getUser(user.getEmail())).thenReturn( assertInstanceOf(UserDto.class, user));
        assertEquals(USER_4_CRYPTOMAVEN_XYZ, user.getEmail());
    }

    @Test
    public void get_users() {
        List<UserDto> users =   userServiceMock.getUsers();
        when(userServiceMock.getUsers()).thenReturn((List<UserDto>) assertInstanceOf(List.class, users));
        assertEquals(userServiceMock.getUsers(), users);

    }
    @Test
    public void update_user() {
            UserDto uUpdated = new UserDto( );   // PASSES
        when(userServiceMock.updateUser(uUpdated)).thenReturn(assertInstanceOf(UserDto.class, uUpdated));
        assertEquals(userServiceMock.updateUser(uUpdated), uUpdated);
    };

    @Test
    public void delete_user() {
        UserDto u = new UserDto( );    // PASSES
        u.setEmail("email@email.com");
        when(userServiceMock.createUser(u)).thenReturn(assertInstanceOf(UserDto.class, u));
        when(userServiceMock.deleteUser(u.getEmail())).thenReturn( assertInstanceOf(Boolean.class, true));

        assertTrue(userServiceMock.deleteUser(u.getEmail()));
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