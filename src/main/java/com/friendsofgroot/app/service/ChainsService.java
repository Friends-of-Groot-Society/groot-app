package com.friendsofgroot.app.service;


import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.models.dto.Symbol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ChainsService {


    ChainDto saveNewChain(ChainDto cd);


//    public List<Chain> getAllChainsIOwn(String username);

    List<ChainDto> getAllChains( );


    Page<ChainDto> getAllChainsPageable(Pageable page);

    Optional<ChainDto> getChainByChainId(Integer chainId);

//    Page<ChainDto> listChains(Pageable page);

    ChainDto  getChainByName(String name);

    public ChainDto updateChain(ChainDto change);

    Optional<ChainDto> updateChainByChainId(Integer chainId, ChainDto change);

    Optional<ChainDto> patchChainById(Integer chainId, ChainDto chain);
    boolean deleteById(Integer chainId);


//    List<ChainDto> findByCategory(String cat);

    List<ChainDto> findByName(String ethereum);

    Page<ChainDto> listChains(String name, String symbol, Integer pageNumber, Integer pageSize);
}
