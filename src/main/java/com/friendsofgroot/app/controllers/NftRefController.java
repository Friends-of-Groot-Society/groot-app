package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.dto.NftRefDto;
import com.friendsofgroot.app.service.NftRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/nftRefs")
@RestController
public class NftRefController {
    @Autowired
    private NftRefService nftRefService;


    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<NftRefDto> createNftRef(@RequestBody NftRefDto n) {

        return new ResponseEntity<>(nftRefService.createNftRef(n), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<NftRefDto>  getNftRef(@PathVariable("id") int id) {

        return new ResponseEntity<>(nftRefService.getNftRef(id), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<NftRefDto>> getAllNftRefs() {
        return  new ResponseEntity<>(nftRefService.getAllNftRefs(), HttpStatus.OK);
    }

    @PutMapping(value = "", consumes = "application/json")
    public ResponseEntity<Boolean> updateNftRef(@RequestBody NftRefDto change) {
        return new ResponseEntity<>(nftRefService.updateNftRef(change), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteNftRef(@PathVariable("id") int addressId) {
        return new ResponseEntity<>(nftRefService.deleteNftRef(addressId), HttpStatus.OK);
    }


}
