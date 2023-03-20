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
    private int localId; // userId;
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
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;


    public UserDto(String user1, String password1, String smith, String tom, int i, int i1, String s, String s1, String s2, String photoPath, String userGroup, int i2, int i3, String id) {


    }
}
