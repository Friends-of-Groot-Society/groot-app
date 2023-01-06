package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.Address;

import java.util.List;

public interface AddressesService {
    public Address createAddress(Address addr);

    public Address getAddress(int id);

    public List<Address> getAllAddresses();

    public Address updateAddress(Address change);

    public boolean deleteAddress(int id);
}
