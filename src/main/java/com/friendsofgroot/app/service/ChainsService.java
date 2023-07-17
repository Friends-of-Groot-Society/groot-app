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

    public ChainDto getChain(int chainId);

//    public List<Chain> getAllChainsIOwn(String username);

    List<ChainDto> getAllChains( );


    Page<ChainDto> getAllChainsPageable(Pageable page);

    Optional<ChainDto> getChainByChainId(UUID chainId);

//    Page<ChainDto> listChains(Pageable page);

    ChainDto  getChainByName(String name);

    public ChainDto updateChain(ChainDto change);
    Optional<ChainDto>  updateChainById(UUID chainId, ChainDto chain);

    Optional<ChainDto> patchChainById(UUID chainId, ChainDto chain);
    boolean deleteById(UUID chainId);

    ChainDto getChain(UUID chainId);

//    List<ChainDto> findByCategory(String cat);

    List<ChainDto> findByName(String ethereum);

    Page<ChainDto> listChains(String name, Symbol symbol, Integer pageNumber, Integer pageSize);
}
