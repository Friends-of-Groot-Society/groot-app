package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
public class AddressDto  implements Serializable {
    private int id;

    private String description;

    private String owner;

    private String address;

    private String chain;


    private String iconUrl;

    private String blockExplorerUrl;

    private User user;

    private int chainId;

}
