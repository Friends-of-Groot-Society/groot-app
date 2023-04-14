package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Address;
import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.Role;
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
    private int userId; // userId;
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
    private String idToken; // id
    // parent of many
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    private List<Chain> chains;
    private Set<Role> roles;


}
