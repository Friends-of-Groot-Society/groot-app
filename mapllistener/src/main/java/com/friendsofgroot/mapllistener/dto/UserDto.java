package com.friendsofgroot.mapllistener.dto;

import com.friendsofgroot.mapllistener.models.Role;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto  implements Serializable {
    static final long serialVersionUID = 1L;
    private long userId; // userId;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private int userType;
    private String phone;
    private String email;
    private String cusUrl;

    private String photoPath;
    private int isActive;
    private int contactType;

    private Set<Role> roles;


}