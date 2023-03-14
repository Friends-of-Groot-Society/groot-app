package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.NftRef;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link NftRef} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NftRefDto implements Serializable {
    private String name;
    private String owner;
    private String email;
    private String address;
    private String chain;
    private NftDto  nft;
}