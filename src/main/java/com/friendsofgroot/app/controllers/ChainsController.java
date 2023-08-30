package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.models.dto.Symbol;
import com.friendsofgroot.app.service.ChainsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
public class ChainsController {
    public static final String CHAIN_PATH = "/api/chains";
    public static final String CHAIN_PATH_ID = CHAIN_PATH + "/{chainId}";

    private final ChainsService chainService;


    //    @RequestMapping(value = CHAIN_PATH, method = RequestMethod.POST, consumes = "application/json")
//    public ResponseEntity<ChainDto> createChain(@RequestBody ChainDto cd) {
//        return new ResponseEntity<>(chainService.createChain(cd), HttpStatus.CREATED);//    }
    @PostMapping(CHAIN_PATH)
    public ResponseEntity handlePost(@Validated @RequestBody ChainDto chain) {
        ChainDto savedChain = chainService.saveNewChain(chain);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", CHAIN_PATH + "/" + savedChain.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

/////////////////////////////// GET

//    @GetMapping(value = CHAIN_PATH)
//    public Page<ChainDto> listChains(@RequestParam(required = false, defaultValue = "Ethereum") String name,
//                                     @RequestParam(required = false) Symbol symbol,
//                                     @RequestParam(required = false) Integer pageNumber,
//                                     @RequestParam(required = false) Integer pageSize) {
//        return chainService.listChains(name, symbol, pageNumber, pageSize);
//    }

    @GetMapping(value = CHAIN_PATH)
    public ResponseEntity<List<ChainDto>> getAllChains() {
        return new ResponseEntity<>(chainService.getAllChains(), HttpStatus.OK);
    }

    @GetMapping(value = CHAIN_PATH + "/page")
    public ResponseEntity<Page<ChainDto>> getAllChainsPageable(Pageable page) {

        return new ResponseEntity<>(chainService.getAllChainsPageable(page), HttpStatus.OK);
    }

    @GetMapping(value = CHAIN_PATH_ID)
    public ChainDto getChainByChainId(@PathVariable("chainId") UUID chainId) {


        log.debug("Get Chain by Id - in controller");

        return chainService.getChainByChainId(chainId).orElseThrow(ResourceNotFoundException::new);
    }

    //    @GetMapping(value = "/chains/{username}")
//    public Lis t<Chain> getAllChainsIOwn(@PathVariable("username") String username) {
    //        return null; // chainService.getAllChainsIOwn(username);
//    }
    @GetMapping(value = CHAIN_PATH + "/name/{name}")
    public ResponseEntity<ChainDto> getChainByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(chainService.getChainByName(name), HttpStatus.OK);
    }


    /////////////////////////////// PUT
    @PutMapping(CHAIN_PATH_ID)
    public ResponseEntity updateById(@PathVariable("chainId") UUID chainId, @Validated @RequestBody ChainDto chain) {
        if (chainService.updateChainByChainId(chainId, chain).isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /////////////////////////////// PATCH
    @PatchMapping(CHAIN_PATH_ID)
    public ResponseEntity updateChainPatchById(@PathVariable("chainId") UUID chainId, @RequestBody ChainDto chain) {
        chainService.patchChainById(chainId, chain);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    /////////////////////////////// DELETE
    @DeleteMapping(value = CHAIN_PATH_ID)
    public ResponseEntity<Boolean> deleteChain(@PathVariable("chainId") UUID chainId) {
        Boolean response = false;

        if(! chainService.deleteById(chainId)){
//            response = false;
//            return new ResponseEntity(response, HttpStatus.NO_CONTENT);
            throw new ResourceNotFoundException();
        }
        response = true;
        return new ResponseEntity(response, HttpStatus.NO_CONTENT);
    }


}
