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
    private final int id;
    private final String address;
    private final Double nativeToken;
    private final HashMap<String, Double> tokens;
    private final List<NftDto> nfts;
}