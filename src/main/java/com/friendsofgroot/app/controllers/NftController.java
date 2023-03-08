package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.dto.NftDto;
import com.friendsofgroot.app.service.NftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/nfts")
@RestController
public class NftController {
    @Autowired
    private NftService nftService;


    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Boolean> createNft(@RequestBody NftDto n) {

        return new ResponseEntity<>(nftService.createNft(n), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<NftDto>  getNft(@PathVariable("id") int id) {

        return new ResponseEntity<>(nftService.getNft(id), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<NftDto>> getAllNfts() {
        return  new ResponseEntity<>(nftService.getAllNfts(), HttpStatus.OK);
    }

    @PutMapping(value = "", consumes = "application/json")
    public ResponseEntity<Boolean> updateNft(@RequestBody NftDto change) {
        return new ResponseEntity<>(nftService.updateNft(change), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> deleteNft(@PathVariable("id") int addressId) {
        return new ResponseEntity<>(nftService.deleteNft(addressId), HttpStatus.OK);
    }


}
