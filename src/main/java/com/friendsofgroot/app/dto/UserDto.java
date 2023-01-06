package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Address;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter @Setter @ToString
public class UserDto {

    @Id
    private int id; // userId
    private String userName;
    private String LName; // lastName
    private String FName; // firstName
    private String photoPath;

    private String groupType; // usergroup

    private String email;

    private String userId; // id

    private List<Address> addresses ;

}
