package com.friendsofgroot.app.consoles;





import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.dto.ChainDto;
import com.friendsofgroot.app.dto.ChainUsers;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.mapper.ChainMapper;
import com.friendsofgroot.app.mapper.UserMapper;
import com.friendsofgroot.app.service.ChainsService;
import com.friendsofgroot.app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Value("${version}")
    private String ver;
    @Autowired
    ChainsService chainsService;

    @Autowired
    UsersService usersService;

//    @Autowired
    UserMapper userMapper;
//    @Autowired
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
        String jsonString = objectMapper.writeValueAsString(dataCat);
//        String json = objectMapper.writeValueAsString(data);
        model.addAttribute("dataCat", jsonString);
//
//<<<<<<< HEAD:src/main/java/com/friendsofgroot/app/dataLoader/HomeController.java
            // query for users
        List<ChainUsers> userChainCnt = usersService.getUserChains();
        model.addAttribute("userChainCnt", userChainCnt);
        // query for users
//        List<UserChain> userChainCnt = usersService.getUserChains();
//        model.addAttribute("userChainCnt", userChainCnt);
//>>>>>>> bd4d26e454c27ad7110c3930eb2d1fd4ba7030e7:src/main/java/com/friendsofgroot/app/consoles/MainController.java

        // i.e. src/main/resources/templates/main.html
        return "main";
    }
}

//
//		model.addAttribute("projectStatusCnt", jsonString);
//
//                // we are querying the database for employees
//                List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
//        model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);