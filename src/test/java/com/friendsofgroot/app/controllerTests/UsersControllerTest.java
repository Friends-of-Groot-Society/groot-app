package com.friendsofgroot.app.controllerTests;

import com.friendsofgroot.app.controllers.UsersController;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.mapper.UserMapper;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.service.UsersService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UsersControllerTest {


    @Mock
    private UsersService uService;

    @InjectMocks
    private UsersController urController;
//    @InjectMocks
//    private UserMapper userMapper;

    private MockMvc mockMvc;


    @BeforeAll
    public void setup(){
        MockitoAnnotations.initMocks(this);

        ResponseEntity<UserDto> u = urController.createUser(new UserDto());
        urController.createUser(new UserDto());

        mockMvc = MockMvcBuilders.standaloneSetup(urController).build();
    }

    @Test
    public void testGet() throws Exception {
        Integer id = 1;

        when(uService.getUser(id)).thenReturn(new UserDto());

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk()); // 200  OK      // .andExpect(view().name("user/show"));
//                .andExpect(view().name("/api/users"))
//                .andExpect(model().attribute("user", instanceOf(UserDto.class)));
    }

    @Test
    public void testUpdate() throws Exception {
        Integer id = 0;

//        User user = new User();
        UserDto userDto = new UserDto();
        userDto.setUserId(id);
//        userDto = userMapper.toDto(user);

        when(uService.getUser(id)).thenReturn(userDto);

        mockMvc.perform(post("/api/users"))
                .andExpect(status().isOk())  ; // 200  OK      // .andExpect(view().name("user/show"));
//                .andExpect(view().name("user/userform"))
//                .andExpect(model().attribute("userForm", instanceOf(UserForm.class)));
    }


    @Test
    public void testSaveOrUpdate() throws Exception {
        Integer id = 0;
        User returnUser = new User();
        String firstName = "Thomas";
        String lastName = "Maestas";
        String email = "thomasm1.maestas@gmail.com";
        String phone = "305.333.0101";
        String username = "mweston";
        String password = "password";

//        returnUser.setId(id);
//        returnUser.setFirstName(firstName);
//        returnUser.setLastName(lastName);
//        returnUser.setAddress(new Address());
//        returnUser.getAddress().setAddressLine1(addressLine1);
//
//        returnUser.setEmail(email);
//        returnUser.setPhoneNumber(phoneNumber);
//        returnUser.setUser(new User());
//        returnUser.getUser().setUsername(username);
//        returnUser.getUser().setPassword(password);
//
//        when(userService.saveOrUpdateUserForm(Matchers.<UserForm>any())).thenReturn(returnUser);
//        when(userService.getById(Matchers.<Integer>any())).thenReturn(returnUser);
//
//        mockMvc.perform(post("/user")
//                        .param("userId", "1")
//                        .param("firstName", firstName)
//                        .param("lastName", lastName)
//                        .param("userName", username)
//                        .param("passwordText", password)
//                        .param("email", email)
//                        .param("phone", phoner))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:user/show/1"));
//
//        ArgumentCaptor<UserForm> userCaptor = ArgumentCaptor.forClass(UserForm.class);
//        verify(userService).saveOrUpdateUserForm(userCaptor.capture());
//
//        UserForm boundUser = userCaptor.getValue();
//
//        assertEquals(id, boundUser.getUserId());
//        assertEquals(firstName, boundUser.getFirstName());
//        assertEquals(lastName, boundUser.getLastName());
//        assertEquals(email, boundUser.getEmail());
//        assertEquals(phoneNumber, boundUser.getPhoneNumber());

    }
}
