package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.User;
import lombok.Data;

import javax.persistence.*;


@Data
public class AddressDto {
    private int id;

    private String description;

    private String owner;

    private String address;

    private String chain;


    private String iconUrl;

    private String blockExplorerUrl;

    private UserDto userDto;

    private int chainIdDto;

}
