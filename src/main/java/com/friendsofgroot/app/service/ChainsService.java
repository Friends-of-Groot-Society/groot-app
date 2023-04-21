package com.friendsofgroot.app.service;


import com.friendsofgroot.app.dto.ChainDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ChainsService {


    ChainDto createChain(ChainDto cd);

    public ChainDto getChain(int chainId);

//    public List<Chain> getAllChainsIOwn(String username);

    public List<ChainDto> getAllChains( );


    Page<ChainDto> getAllChainsPageable(Pageable page);

    ChainDto  getChainByName(String name);

    public ChainDto updateChain(ChainDto change);

    public boolean deleteChain(int id);



    List<ChainDto> findByCategory(String cat);

    List<ChainDto> findByName(String ethereum);
}
