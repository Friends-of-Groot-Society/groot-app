package com.friendsofgroot.app.consoles;





import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.dto.ChainDto;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.mapper.ChainMapper;
import com.friendsofgroot.app.mapper.UserMapper;
import com.friendsofgroot.app.service.ChainsService;
import com.friendsofgroot.app.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class ChainsDashController {
    private static final Logger log =
            LoggerFactory.getLogger(ChainsDashController.class);
    @Value("${version}")
    private String ver;
    final
    ChainsService chainsService;

    final
    UsersService usersService;

    final
    UserMapper userMapper;
    final
    ChainMapper chainMapper;

    public ChainsDashController(ChainsService chainsService, UsersService usersService, UserMapper userMapper, ChainMapper chainMapper) {
        this.chainsService = chainsService;
        this.usersService = usersService;
        this.userMapper = userMapper;
        this.chainMapper = chainMapper;
    }

    @GetMapping(value = {"/v1/chains", "/v1/chains/"})
    public String consoleHome(Model model ) throws JsonProcessingException {
        HashMap<String, Object> map = new HashMap<>();
        model.addAttribute("versionNumber",ver);

        // Query database for chain-links
        List<ChainDto> chains = chainsService.getAllChains();
        map.put("chains",chains);// Add to scope
        model.addAttribute("chains", chains);

        List<UserDto> users =  usersService.getUsers();
        map.put("users",users);// Add to scope
        model.addAttribute("users", users);

        model.addAttribute("map", map); // DUPLICATION FOR TESTING
        List<ChainDto> dataCat= chainsService.findByName("ethereum");


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
        return "chains";
    }
}

//
//		model.addAttribute("projectStatusCnt", jsonString);
//
//                // we are querying the database for employees
//                List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
//        model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);