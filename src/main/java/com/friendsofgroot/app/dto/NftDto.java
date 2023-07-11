package com.friendsofgroot.app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.friendsofgroot.app.models.Nft} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NftDto implements Serializable {
    private static long serialVersionUID = 1L;
    private int id;
    private String name;
    private int amount;
    private MetadataDto metadataDto;
    private int NFTADDRESS_id;
}
