package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Metadata;
import com.friendsofgroot.app.models.Nft;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.friendsofgroot.app.models.Nft} entity
 */
@Data
public class NftDto implements Serializable {
    private final int id;
    private final int name;
    private final int amount;
    private final Metadata metadata;
    private final int nft_address_id;
}