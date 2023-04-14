package com.friendsofgroot.app.consoles;





import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.dto.AddressDto;
import com.friendsofgroot.app.dto.ChainDto;
import com.friendsofgroot.app.dto.RegisterDto;
import com.friendsofgroot.app.dto.UserDto;
import com.friendsofgroot.app.mapper.ChainMapper;
import com.friendsofgroot.app.mapper.UserMapper;
import com.friendsofgroot.app.service.AddressesService;
import com.friendsofgroot.app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserDashController {

    @Value("${version}")
    private String ver;
    @Autowired
    AddressesService addressesService;

    @Autowired
    UsersService usersService;

//    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

//    @Autowired
    UserMapper userMapper;
//    @Autowired
    ChainMapper chainMapper;


    @GetMapping("/v1/register")
    public String register(Model model) {
        RegisterDto userAccount = new RegisterDto();
        model.addAttribute("registerDto", userAccount);

        return "security/register";
    }

    @PostMapping("/v1/register/save")
    public String saveUser(Model model, RegisterDto user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
      try {
          usersService.registerUser(user);
          return "redirect:/v1/";
      } catch (Exception e) {
          String errorMessage = "Error: " + e.getMessage();
          model.addAttribute("errorMessage", errorMessage);
          return "security/register";
      }
    }
    @GetMapping(value = {"/v1/users", "/v1/users/"})
    public String consoleHome(Model model ) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        model.addAttribute("versionNumber",ver);

        // Query database for chain-links
        List<AddressDto> addresses = addressesService.getAllAddresses();
        model.addAttribute("addresses", addresses);

        List<UserDto> users =  usersService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("map", map);

        String email = "thomasm1.maestas@gmail.com";
        List<AddressDto> dataAddressesByEmail= addressesService.getAddressesByEmail(email);

        // convert chain data object into json
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(dataAddressesByEmail);
        //////////////////////////dataAddressesByEmail
          model.addAttribute("dataAddressesByEmail", jsonString);

            // query for users
//        List<ChainUsers> userChainCnt = usersService.getUserAddresses();
//        model.addAttribute("userChainCnt", userChainCnt);
        // query for users
//        List<UserChain> userChainCnt = usersService.getUserAddresses();
//        model.addAttribute("userChainCnt", userChainCnt);

        // i.e. src/main/resources/templates/index.html
        return "users";
    }
}

//
//		model.addAttribute("projectStatusCnt", jsonString);
//
//                // we are querying the database for employees
//                List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
//        model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);