package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Nft;
import com.friendsofgroot.app.models.NftAddress;
import com.friendsofgroot.app.models.User;
import lombok.*;

import jakarta.persistence.*;

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

    private User user;

    private int chainId;


}
