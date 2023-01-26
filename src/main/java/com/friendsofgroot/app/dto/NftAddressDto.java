package com.friendsofgroot.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * A DTO for the {@link com.friendsofgroot.app.models.NftAddress} entity
 */
@Data
public class NftAddressDto implements Serializable {
    private  int id;
    private  String address;
    private  Double nativeToken;
    private  HashMap<String, Double> tokens;
    private  List<NftDto> nfts;
}