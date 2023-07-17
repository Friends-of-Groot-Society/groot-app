package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.Role;
import lombok.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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
    // parent of many
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressDto> addresses;

    private List<ChainDto> chains;
    private Set<Role> roles;


}
