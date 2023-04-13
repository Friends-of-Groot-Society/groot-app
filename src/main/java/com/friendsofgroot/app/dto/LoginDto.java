package com.friendsofgroot.app.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDto  implements Serializable {
    static long serialVersionUID = 1L;
    private String usernameOrEmail;
    private String username;
    private String email;
    private String password;

    public LoginDto(String usernameOrEmail, String password ) {
        this.email = usernameOrEmail;
        this.username = usernameOrEmail;
        this.password = password;
    }


}
