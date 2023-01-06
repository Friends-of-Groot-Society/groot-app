package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.models.Address;
import com.friendsofgroot.app.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class AddressesController {
    @Autowired
    private AddressesService addressesService;

    @RequestMapping(value = "/addresses", method = RequestMethod.POST, consumes = "application/json")
    public Address createAddress(@RequestBody Address c) {
        return addressesService.createAddress(c);
    }
    @GetMapping(value = "/addresses/{id}")
    public Address getAddress(@PathVariable("id") int id) {

        return addressesService.getAddress(id);
    }

    @GetMapping(value = "/addresses")
    public List<Address> getAllAddresses() {
        return addressesService.getAllAddresses();
    }

    @PutMapping(value = "/addresses", consumes = "application/json")
    public Address updateAddress(@RequestBody Address change) {
        return addressesService.updateAddress(change);
    }
    @DeleteMapping(value = "/addresses/{addressId}")
    public boolean deleteAddress(@PathVariable("addressId") int addressId) {
        return addressesService.deleteAddress(addressId);
    }
}
