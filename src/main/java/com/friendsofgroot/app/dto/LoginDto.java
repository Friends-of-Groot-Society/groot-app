package com.friendsofgroot.app.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDto {
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
