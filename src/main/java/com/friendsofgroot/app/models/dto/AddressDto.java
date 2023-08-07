package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.NftAddressDto;
import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDto implements Serializable {
    static long serialVersionUID = 1L;
    private int id;

    private String description;

    private String email;

    private String address;

    private String chain;


    private String iconUrl;

    private String blockExplorerUrl;

    private UserDto user;

    private int chainId;

    private NftAddressDto nftAddressDto;

}
