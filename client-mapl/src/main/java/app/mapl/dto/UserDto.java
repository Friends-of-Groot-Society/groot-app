package app.mapl.dto;

import app.mapl.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    // parent of many
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<Role> roles;


}
