package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.service.ChainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class ChainsController {
    @Autowired
    ChainsService chainsService;

    @RequestMapping(value = "/chains", method = RequestMethod.POST, consumes = "application/json")
    public Chain createChain(@RequestBody Chain c) {
        return chainsService.createChain(c);
    }


    @GetMapping(value = "/chains")
    public List<Chain> getAllChains() {
        return chainsService.getAllChains();
    }
    @GetMapping(value = "/chains/{id}")
    public Chain getChain(@PathVariable("id") int id) {

        return chainsService.getChain(id);
    }

//    @GetMapping(value = "/chains/{username}")
//    public List<Chain> getAllChainsIOwn(@PathVariable("username") String username) {
//        return null; // chainsService.getAllChainsIOwn(username);
//    }
    @GetMapping(value = "/chains/name/{name}")
    public Chain getChainByName(@PathVariable("name") String name) {
        return chainsService.getChainByName(name);
    }
   @PutMapping(value = "/chains", consumes = "application/json")
    public Chain updateChain(@RequestBody Chain change) {
        return chainsService.updateChain(change);
    }
    @DeleteMapping(value = "/chains/{chainId}")
    public boolean deleteChain(@PathVariable("chainId") int chainId) {
        return chainsService.deleteChain(chainId);
    }


}
