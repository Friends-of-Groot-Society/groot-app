package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.Address;
import com.friendsofgroot.app.repositories.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressesServiceImpl implements AddressesService {

    @Autowired
    private AddressesRepository addressesRepository;

    @Override
    public Address createAddress(Address addr) {
        return addressesRepository.save(addr);
    }

    @Override
    public Address getAddress(int id) {
       try {
           return addressesRepository.findById(id).get();
       } catch (Exception e) {
           return null;
       }
    }

    @Override
    public List<Address> getAllAddresses() {
        return (List<Address>) addressesRepository.findAll();
    }

    @Override
    public Address updateAddress(Address change) {
     try {
         return addressesRepository.save(change);
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
}
