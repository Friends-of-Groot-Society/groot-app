package com.friendsofgroot.app.service;


import com.friendsofgroot.app.dto.ChainDto;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.mapper.ChainMapper;
import com.friendsofgroot.app.repositories.ChainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChainsServiceImpl implements ChainsService {

private final ChainsRepository chainsRepository;

private final ChainMapper chainMapper;

    public ChainsServiceImpl(ChainsRepository chainsRepository, ChainMapper chainMapper) {
        this.chainsRepository = chainsRepository;
        this.chainMapper = chainMapper;
    }

    /**
     * @param c
     * @return
     */

    @Override
    public ChainDto createChain(ChainDto cd) {
        Chain chain = chainMapper.toEntity(cd);
        Chain newChain = chainsRepository.save(chain);

        ChainDto newChainDto = chainMapper.toOneDto(newChain);
         return newChainDto;
    }
    @Override
    public ChainDto getChain(int id) {
        Chain chain = chainsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", Integer.toString(id)));
            return chainMapper.toOneDto(chain);
    }
//    @Autowired
//    public List<Chain> getAllChainsIOwn(String username) {
//        return null; //(List<Chain>)  chainsRepository.findByUsername(username);
//    }
    @Override
    public List<ChainDto> getAllChains() {
        List<Chain> chains = chainsRepository.findAll();
        List<ChainDto> content = chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());

        return content;
    }

    /**
     * @return
     */


    @Override
    public ChainDto getChainByName(String name) {

        List<Chain> c = chainsRepository.findByName(name);
        return (ChainDto) chainMapper.toListDto(c);
    }

    @Override
    public ChainDto updateChain(ChainDto change) {
        try {
            Chain chainUpdate = chainMapper.toEntity(change);

            chainUpdate = chainsRepository.findById(change.getId()).get();
            chainUpdate.setName(change.getName());
            chainUpdate.setSymbol(change.getSymbol());
            chainUpdate.setDescription(change.getDescription());
            chainUpdate.setLongDescription(change.getLongDescription());
            chainUpdate.setChainListIcon(change.getChainListIcon());
            chainUpdate.setChainId(change.getChainId());
            chainUpdate.setCategory(change.getCategory());
            chainUpdate.setRpcUrl(change.getRpcUrl());
            chainUpdate.setIconUrl(change.getIconUrl());
            chainUpdate.setBlockExplorerUrl(change.getBlockExplorerUrl());

            Chain chainDone = chainsRepository.save(chainUpdate);

            return chainMapper.toOneDto(chainDone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @Override
    public boolean deleteChain(int id) {
        try {
            chainsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @return
     */
    @Override
    public List<ChainDto> findByCategory(String cat) {
        List<Chain> chains = chainsRepository.findByCategory(cat);
        List<ChainDto> content = chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());
        return content;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<ChainDto> findByName(String name) {
        List<Chain> chains = chainsRepository.findByName(name);
        List<ChainDto> content = chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());
        return content;
    }
}
