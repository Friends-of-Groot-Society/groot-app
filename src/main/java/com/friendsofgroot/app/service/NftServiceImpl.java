package com.friendsofgroot.app.service;

import com.friendsofgroot.app.dto.NftDto;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.mapper.NftMapper;
import com.friendsofgroot.app.models.Address;
import com.friendsofgroot.app.models.Nft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.friendsofgroot.app.repositories.NftRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NftServiceImpl implements NftService {
    @Autowired
    private NftRepository nftRepository;
    @Autowired
    private NftMapper nftMapper;

    public boolean createNft(NftDto nftDto) {
        Nft nft = nftMapper.toEntity(nftDto);

//    if (nft != null && (nft.getChainId() == 0)) {
//        nft.setChainId(nftDto.getChainId());
//    }

        Nft newNft = nftRepository.save(nft);
        NftDto newNftDto = nftMapper.toDto(newNft);
        return true;
    }

    public NftDto getNft(int id) {
        Nft nft = nftRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", Integer.toString(id)));
        return nftMapper.toDto(nft);
    }

    public List<NftDto> getAllNftsIOwn(String username) {
        List<Nft> nfts = nftRepository.findAll();
        List<NftDto> content = nfts.stream().map(nftMapper::toDto).collect(Collectors.toList());
    return content;

    }

    public List<NftDto> getAllNfts() {


        List<Nft> adds = nftRepository.findAll();
        List<NftDto> nftDtos = adds.stream().map(nftMapper::toDto).collect(Collectors.toList());
        return nftDtos;
    }
 

    public boolean updateNft(NftDto change) {
        try {
            Nft nft = nftMapper.toEntity(change);
            Nft newNft = nftRepository.save(nft);
            NftDto newNftDto = nftMapper.toDto(newNft);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteNft(int id) {
  try {
            nftRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
  }

    public void nftlotViewAll() {
    }
}
