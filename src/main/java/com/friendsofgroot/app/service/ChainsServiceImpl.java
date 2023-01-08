package com.friendsofgroot.app.service;


import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.repositories.ChainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChainsServiceImpl implements ChainsService {

@Autowired
private ChainsRepository chainsRepository;
    @Override
    public Chain createChain(Chain c) {
         return  chainsRepository.save(c);
    }
    @Override
    public Chain getChain(int id) {
    try {
            return chainsRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }
//    @Autowired
//    public List<Chain> getAllChainsIOwn(String username) {
//        return null; //(List<Chain>)  chainsRepository.findByUsername(username);
//    }
    @Override
    public List<Chain> getAllChains() {
        return (List<Chain>) chainsRepository.findAll();
    }

    /**
     * @return
     */


    @Override
    public  Chain  getChainByName(String name) {
        return chainsRepository.findByName(name);
    }
    @Override
    public Chain updateChain(Chain change) {
         return   chainsRepository.save(change);
    }
    @Override
    public boolean deleteChain(int chainId) {

        try {
            Chain c = chainsRepository.findById(chainId).get();
            chainsRepository.delete(c);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
