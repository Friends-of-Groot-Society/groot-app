package com.friendsofgroot.app.service;


import com.friendsofgroot.app.models.Chain;

import java.util.List;


public interface ChainsService {


    public Chain createChain(Chain c);

    public Chain getChain(int chainId);

//    public List<Chain> getAllChainsIOwn(String username);

    public List<Chain> getAllChains();

    Chain  getChainByName(String name);

    public Chain updateChain(Chain change);

    public boolean deleteChain(int id);



}
