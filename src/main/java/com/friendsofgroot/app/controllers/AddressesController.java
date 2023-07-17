package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.models.dto.AddressDto;
import com.friendsofgroot.app.service.AddressesService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/addresses")
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class AddressesController {
@Autowired
    AddressesService addressesService;




    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto c) {

        return new ResponseEntity<>(addressesService.createAddress(c), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto>  getAddress(@PathVariable("id") int id) {

        return new ResponseEntity<>(addressesService.getAddress(id), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return  new ResponseEntity<>(addressesService.getAllAddresses(), HttpStatus.OK);
    }

    @PutMapping(value = "", consumes = "application/json")
    public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto change) {
        return new ResponseEntity<>(addressesService.updateAddress(change), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{addressId}")
    public ResponseEntity<Boolean> deleteAddress(@PathVariable("addressId") int addressId) {
        return new ResponseEntity<>(addressesService.deleteAddress(addressId), HttpStatus.OK);
    }

}
