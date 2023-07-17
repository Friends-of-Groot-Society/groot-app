package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.dto.NftRefDto;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.mapper.NftRefMapper;
import com.friendsofgroot.app.models.NftRef;
import com.friendsofgroot.app.repositories.NftRefRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NftRefServiceImpl implements NftRefService {
    private final NftRefRepository nftRefRepository;
    private final NftRefMapper nftRefMapper;

    public NftRefServiceImpl(NftRefRepository nftRefRepository, NftRefMapper nftRefMapper) {
        this.nftRefRepository = nftRefRepository;
        this.nftRefMapper = nftRefMapper;
    }

    public NftRefDto createNftRef(NftRefDto nftRefDto) {
        NftRef nftRef = nftRefMapper.toEntity(nftRefDto);

//    if (nftRef != null && (nftRef.getChainId() == 0)) {
//        nftRef.setChainId(nftRefDto.getChainId());
//    }

        NftRef newNftRef = nftRefRepository.save(nftRef);
        NftRefDto newNftRefDto = nftRefMapper.toDto(newNftRef);
        return newNftRefDto;
    }

    public NftRefDto getNftRef(int id) {
        NftRef nftRef = nftRefRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", Integer.toString(id)));
        return nftRefMapper.toDto(nftRef);
    }

    public List<NftRefDto> getAllNftRefsIOwn(String username) {
        List<NftRef> nftRefs = nftRefRepository.findAll();
        List<NftRefDto> content = nftRefs.stream().map(nftRefMapper::toDto).collect(Collectors.toList());
    return content;
    }

    public List<NftRefDto> getAllNftRefs() {
        List<NftRef> adds = nftRefRepository.findAll();
        List<NftRefDto> nftRefDtos = adds.stream().map(nftRefMapper::toDto).collect(Collectors.toList());
        return nftRefDtos;
    }


    public boolean updateNftRef(NftRefDto change) {
        try {
            NftRef nftRef = nftRefMapper.toEntity(change);
            NftRef newNftRef = nftRefRepository.save(nftRef);
            NftRefDto newNftRefDto = nftRefMapper.toDto(newNftRef);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteNftRef(int id) {
  try {
            nftRefRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
  }

}
