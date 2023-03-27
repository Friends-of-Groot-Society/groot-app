package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Address;
import lombok.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userId; // userId;
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private int groups;
    private int userType;
    private String email;
    private String phone;
    private String cusUrl;

    private String photoPath;
    private String userGroup;
    private int isActive;
    private int contactType;
    private String idToken; // id

    // parent of many
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;


}
