package com.friendsofgroot.app.dataLoader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.dto.ChainDto;
import com.friendsofgroot.app.dto.UserChain;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.mapper.ChainMapper;
import com.friendsofgroot.app.mapper.UserMapper;
import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.repositories.ChainsRepository;
import com.friendsofgroot.app.repositories.UsersRepository;
import com.friendsofgroot.app.service.ChainsService;
import com.friendsofgroot.app.service.UsersService;
import groovy.transform.AutoImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Value("${version}")
    private String ver;
    @Autowired
    ChainsService chainsService;

    @Autowired
    UsersService usersService;

    @Autowired
    UserMapper userMapper;
    @Autowired
    ChainMapper chainMapper;

    @GetMapping("/")
    public String consoleHome(Model model ) throws JsonProcessingException {
    Map<String, Object> map = new HashMap<>();
    model.addAttribute("versionNumber",ver);

    // Query database for chain-links
        List<ChainDto> chains = chainMapper.toListDto(chainsService.getAllChains());
        model.addAttribute("chains", chains);

        List<UserDto> users = userMapper.toListDto(usersService.getUsers());
        model.addAttribute("users", users);

        model.addAttribute("map", map);

        List<ChainDto> dataCat= chainsService.findByCategory("ethereum");

        // convert chain data object into json
         ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(dataCat);

            // query for users
        List<UserChain> userChainCnt = usersService.getUserChains();
        model.addAttribute("userChainCnt", userChainCnt);

        return "main/home";
    }

}
