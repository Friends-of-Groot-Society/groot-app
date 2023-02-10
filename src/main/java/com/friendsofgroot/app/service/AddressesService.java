package com.friendsofgroot.app.service;

import com.friendsofgroot.app.dto.AddressDto;
import com.friendsofgroot.app.dto.NftDto;
import com.friendsofgroot.app.models.Address;

import java.util.List;

public interface AddressesService {
    public AddressDto createAddress(AddressDto addr);

    public AddressDto getAddress(int id);

    public List<AddressDto> getAllAddresses();

    public AddressDto updateAddress(AddressDto change);

    public boolean deleteAddress(int id);

    /////////////////////////
    NftDto createNft(NftDto nftDto);

    List<NftDto> getAllNFTs();
}
