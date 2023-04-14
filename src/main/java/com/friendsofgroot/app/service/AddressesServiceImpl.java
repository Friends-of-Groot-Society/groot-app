package com.friendsofgroot.app.service;

import com.friendsofgroot.app.dto.AddressDto;
import com.friendsofgroot.app.mapper.AddressMapper;
import com.friendsofgroot.app.models.Address;

import com.friendsofgroot.app.repositories.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressesServiceImpl implements AddressesService {

    @Autowired
    private AddressesRepository addressesRepository;
    @Autowired
    private AddressMapper addressMapper;


    @Override
    public AddressDto createAddress(AddressDto addrDto) {
        Address address = addressMapper.addressDtoToAddress(addrDto);

        if (address != null && (address.getChainId() == 0)) {
            address.setChainId(addrDto.getChainId());
        }
        if (address != null && (address.getEmail() == null || address.getEmail() == "")) {
            address.setEmail(addrDto.getEmail());
        }
        Address newAddress = addressesRepository.save(address);
        AddressDto newAddressDto = addressMapper.addressToAddressDto(newAddress);
        return newAddressDto;
    }

    @Override
    public AddressDto getAddress(int id) {
        try {
            Address address = addressesRepository.findById(id).get();
            return addressMapper.addressToAddressDto(address);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<AddressDto> getAllAddresses() {

        List<Address> adds = addressesRepository.findAll();
        List<AddressDto> addressDtos = adds.stream().map(addressMapper::addressToAddressDto).collect(Collectors.toList());
        return addressDtos;
    }

    @Override
    public AddressDto updateAddress(AddressDto change) {

        try {
//             addUpdate = addressMapper.addressDtoToAddress(change);
            Address existingUpdate = addressesRepository.findById(change.getId()).get();
            existingUpdate.setDescription(change.getDescription() != null ? change.getDescription() : existingUpdate.getDescription());
            existingUpdate.setIconUrl(change.getIconUrl() != null ? change.getIconUrl() : existingUpdate.getIconUrl());
            existingUpdate.setUser(change.getUser() != null ? change.getUser() : existingUpdate.getUser());
            existingUpdate.setChain(change.getChain() != null ? change.getChain() : existingUpdate.getChain());
            existingUpdate.setEmail(change.getEmail()   != null ? change.getEmail() : existingUpdate.getEmail());
            existingUpdate.setBlockExplorerUrl(change.getBlockExplorerUrl()     != null ? change.getBlockExplorerUrl() : existingUpdate.getBlockExplorerUrl());
            existingUpdate.setChainId(change.getChainId() != 0 ? change.getChainId() : existingUpdate.getChainId());
//            addUpdate.setNftAddress(change.getNftAddress());

            Address newAddress = addressesRepository.save(existingUpdate);

            return addressMapper.addressToAddressDto(newAddress);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteAddress(int id) {
        try {
            addressesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param email
     * @return
     */
    @Override
    public List<AddressDto> getAddressesByEmail(String email) {

        List<Address> adds = addressesRepository.getAddressesByEmail(email);
        List<AddressDto> addressDtos = adds.stream().map(addressMapper::addressToAddressDto).collect(Collectors.toList());
        return addressDtos;
    }
}

