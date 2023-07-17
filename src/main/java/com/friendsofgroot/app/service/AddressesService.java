package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.dto.AddressDto;

import java.util.List;

public interface AddressesService {
    public AddressDto createAddress(AddressDto addr);

    public AddressDto getAddress(int id);

    public List<AddressDto> getAllAddresses();

    public AddressDto updateAddress(AddressDto change);

    public boolean deleteAddress(int id);

    List<AddressDto> getAddressesByEmail(String email);
}
