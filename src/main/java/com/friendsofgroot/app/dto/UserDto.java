package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Address;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto  implements Serializable {

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
