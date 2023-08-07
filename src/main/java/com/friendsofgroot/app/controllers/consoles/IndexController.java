package com.friendsofgroot.app.controllers.consoles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.models.dto.LoginDto;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.service.ChainsService;
import com.friendsofgroot.app.service.UsersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Profile("mysql")
public class IndexController {

    @Value("${version}")
    private String ver;


    ChainsService chainsService;


    UsersService usersService;


    IndexController( ChainsService chainsService, UsersService usersService ) {

        this.chainsService = chainsService;
        this.usersService = usersService;
    }

    @GetMapping(value = {"/v1", "/v1/"})
    public String consoleHome(Model model ) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        model.addAttribute("versionNumber",ver);

        // Query database for chain-links
        List<ChainDto> chains = chainsService.getAllChains();
        model.addAttribute("chains", chains);

        List<UserDto> users =  usersService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("map", map);

        List<ChainDto> dataCat= chainsService.findByName("ethereum");

        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto",loginDto);
        // convert chain data object into json
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(dataCat);
//        String json = objectMapper.writeValueAsString(data);
        model.addAttribute("dataCat", jsonString);

            // query for users
//        List<ChainUsers> userChainCnt = usersService.getUserChains();
//        model.addAttribute("userChainCnt", userChainCnt);
        // query for users
//        List<UserChain> userChainCnt = usersService.getUserChains();
//        model.addAttribute("userChainCnt", userChainCnt);

        // i.e. src/main/resources/templates/index.html
        return "index";
    }
}

//
//		model.addAttribute("projectStatusCnt", jsonString);
//
//                // we are querying the database for employees
//                List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
//        model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
