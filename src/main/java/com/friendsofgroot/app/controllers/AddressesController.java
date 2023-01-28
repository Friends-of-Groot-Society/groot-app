package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.dto.AddressDto;
import com.friendsofgroot.app.dto.NftDto;
import com.friendsofgroot.app.models.Address;
import com.friendsofgroot.app.service.AddressesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/addresses")
@RestController
public class AddressesController {
    @Autowired
    private AddressesService addressesService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto c) {

        return new ResponseEntity<>(addressesService.createAddress(c), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public AddressDto getAddress(@PathVariable("id") int id) {

        return addressesService.getAddress(id);
    }

    @GetMapping(value = "")
    public List<AddressDto> getAllAddresses() {
        return addressesService.getAllAddresses();
    }


    @PutMapping(value = "", consumes = "application/json")
    public AddressDto updateAddress(@RequestBody AddressDto change) {
        return addressesService.updateAddress(change);
    }
    @DeleteMapping(value = "/{addressId}")
    public boolean deleteAddress(@PathVariable("addressId") int addressId) {
        return addressesService.deleteAddress(addressId);
    }

    /////////

    @RequestMapping(value = "/nfts", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<NftDto> createNft(@RequestBody NftDto n) {

        return new ResponseEntity<>(addressesService.createNft(n), HttpStatus.CREATED);
    }
    @GetMapping(value = "/nfts")
    public ResponseEntity<List<NftDto>> getAllNFTs() {
        return new ResponseEntity<>(addressesService.getAllNFTs(), HttpStatus.OK);
    }
}
