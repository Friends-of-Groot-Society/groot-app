package com.friendsofgroot.app.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.controllers.ChainsController;
import com.friendsofgroot.app.controllers.UsersController;
import com.friendsofgroot.app.mapper.UserMapper;
import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.repositories.UserRepository;
import com.friendsofgroot.app.service.ChainsService;
import com.friendsofgroot.app.service.ChainsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.http.RequestEntity.delete;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class UserControllerIT {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserController userController;

    @Autowired
    UserMapper userMapper;

    @Rollback
    @Transactional
    @Test
    void deleteByIdFound() {
        User user = userRepository.findAll().get(0);

        ResponseEntity responseEntity = userController.deleteUserById(user.getId());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        assertThat(userRepository.findById(user.getId()).isEmpty());
    }

    @Test
    void testDeleteNotFound() {
        assertThrows(NotFoundException.class, () -> {
            userController.deleteUserById(UUID.randomUUID());
        });
    }

    @Test
    void testUpdateNotFound() {
        assertThrows(NotFoundException.class, () -> {
            userController.updateUserByID(UUID.randomUUID(), UserDto.builder().build());
        });
    }

    @Rollback
    @Transactional
    @Test
    void updateExistingChain() {
        User user = userRepository.findAll().get(0);
        UserDto userDto = userMapper.toDto(user);
        userDto.setId(null);
        userDto.setVersion(null);
        final String userName = "UPDATED";
        userDto.setName(userName);

        ResponseEntity responseEntity = userController.updateUserByID(user.getId(), userDto);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        User updatedUser = userRepository.findById(user.getId()).get();
        assertThat(updatedUser.getName()).isEqualTo(userName);
    }

    @Rollback
    @Transactional
    @Test
    void saveNewChainTest() {
       UserDto userDto = UserDto.builder()
               .name("TEST")
               .build();

        ResponseEntity responseEntity = userController.handlePost(userDto);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationUUID = responseEntity.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID = UUID.fromString(locationUUID[4]);

        User user = userRepository.findById(savedUUID).get();
        assertThat(user).isNotNull();
    }

    @Rollback
    @Transactional
    @Test
    void testListAllEmptyList() {
        userRepository.deleteAll();
        List<UserDto> dtos = userController.listAllUsers();

        assertThat(dtos.size()).isEqualTo(0);
    }

    @Test
    void testListAll() {
        List<UserDto> dtos = userController.listAllUsers();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Test
    void testGetByIdNotFound() {
        assertThrows(NotFoundException.class, () -> {
            userController.getUserById(UUID.randomUUID());
        });
    }

    @Test
    void testGetById() {
        User user = userRepository.findAll().get(0);
        UserDto userDto = userController.getUserById(user.getId());
        assertThat(userDto).isNotNull();
    }

    @WebMvcTest(ChainsController.class)
    static
    class ChainsControllerTest {

        @Autowired
        MockMvc mockMvc;

        @Autowired
        ObjectMapper objectMapper;

        @MockBean
        ChainService chainService;

        ChainServiceImpl chainServiceImpl;

        @Captor
        ArgumentCaptor<UUID> uuidArgumentCaptor;

        @Captor
        ArgumentCaptor<ChainDto> chainArgumentCaptor;

        @BeforeEach
        void setUp() {
            chainServiceImpl = new ChainServiceImpl();
        }

        @Test
        void testPatchChain() throws Exception {
            ChainDto chain = chainServiceImpl.listChains(null, null,   1, 25).getContent().get(0);

            Map<String, Object> chainMap = new HashMap<>();
            chainMap.put("chainName", "New Name");

            mockMvc.perform(patch(ChainsController.CHAIN_PATH_ID, chain.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(chainMap)))
                    .andExpect(status().isNoContent());

            verify(chainService).patchChainById(uuidArgumentCaptor.capture(), chainArgumentCaptor.capture());

            assertThat(chain.getId()).isEqualTo(uuidArgumentCaptor.getValue());
            assertThat(chainMap.get("chainName")).isEqualTo(chainArgumentCaptor.getValue().getName());
        }

        @Test
        void testDeleteChain() throws Exception {
            ChainDto chain = chainServiceImpl.listChains(null, null, false, 1, 25).getContent().get(0);

            given(chainService.deleteChain(any())).willReturn(Optional.of(chain));

            mockMvc.perform((RequestBuilder) delete(ChainsController.CHAIN_PATH_ID, chain.getId())
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNoContent());

            verify(chainService).delete(uuidArgumentCaptor.capture());

            assertThat(chain.getId()).isEqualTo(uuidArgumentCaptor.getValue());
        }

        @Test
        void testUpdateChain() throws Exception {
            ChainDto chain = chainServiceImpl.listChains(null, null,  1, 25).getContent().get(0);

            given(chainService.updateChainById(any(), any())).willReturn(Optional.of(chain));

            mockMvc.perform(put(ChainsController.CHAIN_PATH_ID, chain.getId())
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(chain)))
                    .andExpect(status().isNoContent());

            verify(chainService).updateChainById(any(UUID.class), any(ChainDto.class));
        }

        @Test
        void testUpdateChainBlankName() throws Exception {
            ChainDto chain = chainServiceImpl.listChains(null, null,  1, 25).getContent().get(0);
            chain.setChainName("");
            given(chainService.updateChainById(any(), any())).willReturn(Optional.of(chain));

            mockMvc.perform(put(ChainsController.CHAIN_PATH_ID, chain.getId())
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(chain)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.length()", is(1)));

        }

        @Test
        void testCreateNewChain() throws Exception {
            ChainDto chain = chainServiceImpl.listChains(null, null,  1, 25).getContent().get(0);
            chain.setVersion(null);
            chain.setId(null);

            given(chainService.saveNewChain(any(ChainDto.class))).willReturn(chainServiceImpl.listChains(null, null,  1, 25).getContent().get(1));

            mockMvc.perform(post(ChainsController.CHAIN_PATH)
                    .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(chain)))
                    .andExpect(status().isCreated())
                    .andExpect(header().exists("Location"));
        }

        @Test
        void testCreateChainNullChainName() throws Exception {

            ChainDto chainDto = ChainDto.builder().build();

            given(chainService.saveNewChain(any(ChainDto.class))).willReturn(chainServiceImpl.listChains(null, null,  1, 25).getContent().get(1));

            MvcResult mvcResult = mockMvc.perform(post(ChainsController.CHAIN_PATH)
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(chainDto)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.length()", is(6)))
                    .andReturn();

            System.out.println(mvcResult.getResponse().getContentAsString());
        }

        @Test
        void testListChains() throws Exception {
            given(chainService.listChains(any(), any() , any(), any()))
                    .willReturn(chainServiceImpl.listChains(null, null,  null, null));

            mockMvc.perform(get(ChainsController.CHAIN_PATH)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.content.length()", is(3)));
        }

        @Test
        void getChainByIdNotFound() throws Exception {

            given(chainService.getChainById(any(UUID.class))).willReturn(Optional.empty());

            mockMvc.perform(get(ChainsController.CHAIN_PATH_ID, UUID.randomUUID()))
                    .andExpect(status().isNotFound());
        }

        @Test
        void getChainById() throws Exception {
            ChainDto testChain = chainServiceImpl.listChains(null, null,  1, 25).getContent().get(0);

            given(chainService.getChainByChainId(testChain.getId())).willReturn(Optional.of(testChain));

            mockMvc.perform(get(ChainsController.CHAIN_PATH_ID, testChain.getId())
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id", is(testChain.getId().toString())))
                    .andExpect(jsonPath("$.chainName", is(testChain.getName())));
        }
    }
}
