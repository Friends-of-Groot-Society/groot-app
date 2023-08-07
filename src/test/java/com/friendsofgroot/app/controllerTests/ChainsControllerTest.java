package com.friendsofgroot.app.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.controllers.ChainsController;
import com.friendsofgroot.app.mapper.ChainMapper;
import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.models.dto.Symbol;
import com.friendsofgroot.app.repositories.ChainsRepository;
import com.friendsofgroot.app.service.ChainsService;
import com.friendsofgroot.app.service.ChainsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.web.servlet.function.RequestPredicates.accept;


@WebMvcTest(ChainsController.class)
   public    class ChainsControllerTest {

        @Autowired
        MockMvc mockMvc;

        @Autowired
        ObjectMapper objectMapper;

        @MockBean
        ChainsService chainService;

        @MockBean
        ChainsServiceImpl chainServiceImpl;
        @MockBean
        ChainsRepository chainsRepository;
        @MockBean
        ChainMapper chainMapper;

        @Captor
        ArgumentCaptor<UUID> uuidArgumentCaptor;

        @Captor
        ArgumentCaptor<ChainDto> chainArgumentCaptor;



        @BeforeEach
        void setUp() {
            chainsRepository = mock(ChainsRepository.class);
            chainMapper = mock(ChainMapper.class);
        }


        @Test
        void testPatchChain() throws Exception {
            ChainDto chain = chainServiceImpl.listChains("Ethereum", Symbol.valueOf("ETH"),   1, 25).getContent().get(0);

            Map<String, Object> chainMap = new HashMap<>();
            chainMap.put("name", "New Name");

            mockMvc.perform(patch(ChainsController.CHAIN_PATH_ID, chain.getName())
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(chainMap)))
                    .andExpect(status().isNoContent());

            verify(chainService.patchChainById(uuidArgumentCaptor.capture(), chainArgumentCaptor.capture()));

            assertThat(chain.getChainId()).isEqualTo(uuidArgumentCaptor.getValue());
            assertThat(chainMap.get("name")).isEqualTo(chainArgumentCaptor.getValue().getName());
        }

//        @Test
//        void testDeleteChain() throws Exception {
//            ChainDto chain = chainServiceImpl.listChains(null, null,  1, 25).getContent().get(0);
//
//            given(chainService.deleteById(any())).willReturn(Optional.of(chain));
//
//            mockMvc.perform((RequestBuilder) delete(ChainsController.CHAIN_PATH_ID, chain.getUserId())
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isNoContent());
//
//            verify(chainService).delete(uuidArgumentCaptor.capture());
//
//            assertThat(chain.getUserId()).isEqualTo(uuidArgumentCaptor.getValue());
//        }

        @Test
        void testUpdateChain() throws Exception {
            ChainDto chain = chainServiceImpl.listChains(null, null,  1, 25).getContent().get(0);

            given(chainService.updateChainByChainId(any(), any())).willReturn(Optional.of(chain));

            mockMvc.perform(put(ChainsController.CHAIN_PATH_ID, chain.getChainId())
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(chain)))
                    .andExpect(status().isNoContent());

            verify(chainService).updateChainByChainId(chain.getChainId(), any(ChainDto.class));
        }

        @Test
        void testUpdateChainBlankName() throws Exception {
            ChainDto chain = chainService.listChains(null, null,  1, 25).getContent().get(0);
            chain.setName("");
            given(chainService.updateChainByChainId(any(), any())).willReturn(Optional.of(chain));

            mockMvc.perform(put(ChainsController.CHAIN_PATH_ID, chain.getChainId())
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

            mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(ChainsController.CHAIN_PATH)
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(chain)))
                    .andExpect(status().isCreated())
                    .andExpect(header().exists("Location"));
        }

        @Test
        void testCreateChainNullName() throws Exception {

            ChainDto chainDto = ChainDto.builder().build();

            given(chainService.saveNewChain(any(ChainDto.class))).willReturn(chainServiceImpl.listChains(null, null,  1, 25).getContent().get(1));

            MvcResult mvcResult = mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post(ChainsController.CHAIN_PATH)
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

            given(chainService.getChainByChainId(any(UUID.class))).willReturn(Optional.empty());

            mockMvc.perform(get(ChainsController.CHAIN_PATH_ID, UUID.randomUUID()))
                    .andExpect(status().isNotFound());
        }

        @Test
        void getChainById() throws Exception {
            ChainDto testChain = chainServiceImpl.listChains(null, null,  1, 25).getContent().get(0);

            given(chainService.getChainByChainId(testChain.getChainId())).willReturn(Optional.of(testChain));

            mockMvc.perform(get(ChainsController.CHAIN_PATH_ID, testChain.getChainId())
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.id", is(testChain.getChainId().toString())))
                    .andExpect(jsonPath("$.name", is(testChain.getName())));
        }
    }
