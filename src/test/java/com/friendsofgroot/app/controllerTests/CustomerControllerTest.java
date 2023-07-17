package com.friendsofgroot.app.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.service.UserService;
import com.friendsofgroot.app.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
 class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        userServiceImpl = new UserServiceImpl();
    }

    @Captor
    ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Captor
    ArgumentCaptor<UserDto> userArgumentCaptor;

    @Test
    void testPatchUser() throws Exception {
        UserDto user = userServiceImpl.getAllUsers().get(0);

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "New Name");

        mockMvc.perform(patch( UserController.CUSTOMER_PATH_ID, user.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMap)))
                .andExpect(status().isNoContent());

        verify(userService).patchUserById(uuidArgumentCaptor.capture(),
                userArgumentCaptor.capture());

        assertThat(uuidArgumentCaptor.getValue()).isEqualTo(user.getId());
        assertThat(userArgumentCaptor.getValue().getName())
                .isEqualTo(userMap.get("name"));
    }

    @Test
    void testDeleteUser() throws Exception {
        UserDto user = userServiceImpl.getAllUsers().get(0);

        given(userService.deleteUserById(any())).willReturn(true);

        mockMvc.perform(delete(UserController.CUSTOMER_PATH_ID, user.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(userService).deleteUserById(uuidArgumentCaptor.capture());

        assertThat(user.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testUpdateUser() throws Exception {
        UserDto user = userServiceImpl.getAllUsers().get(0);

        given(userService.updateUserById(any(), any())).willReturn(Optional.of(UserDto.builder()
                .build()));

        mockMvc.perform(put(UserController.CUSTOMER_PATH_ID, user.getId())
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(userService).updateUserById(uuidArgumentCaptor.capture(), any(UserDto.class));

        assertThat(user.getId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testCreateUser() throws Exception {
        UserDto user = userServiceImpl.getAllUsers().get(0);
        user.setId(null);
        user.setVersion(null);

        given(userService.saveNewUser(any(UserDto.class)))
                .willReturn(userServiceImpl.getAllUsers().get(1));

        mockMvc.perform(post(UserController.CUSTOMER_PATH).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @Test
    void listAllUsers() throws Exception {
        given(userService.getAllUsers()).willReturn(userServiceImpl.getAllUsers());

        mockMvc.perform(get(UserController.CUSTOMER_PATH)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));
    }

    @Test
    void getUserByIdNotFound() throws Exception {

        given(userService.getUserById(any(UUID.class))).willReturn(Optional.empty());

        mockMvc.perform(get(UserController.CUSTOMER_PATH_ID, UUID.randomUUID()))
                .andExpect(status().isNotFound());
    }

    @Test
    void getUserById() throws Exception {
        UserDto user = userServiceImpl.getAllUsers().get(0);

        given(userService.getUserById(user.getId())).willReturn(Optional.of(user));

        mockMvc.perform(get(UserController.CUSTOMER_PATH_ID, user.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(user.getName())));
    }
}
