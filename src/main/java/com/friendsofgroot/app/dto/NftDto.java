package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Metadata;
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
    private int name;
    private int amount;
    private Metadata metadata;
    private int nft_address_id;
}