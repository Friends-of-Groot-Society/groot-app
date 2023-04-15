package com.friendsofgroot.app.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterDto implements Serializable {
    private static long serialVersionUID = 1L;
    private String username;
    private String lastName;
    private String firstName;
    private String email;
    private String password;

    public RegisterDto(String lastName, String firstName, String email, String password) {
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;

        this.username = makeUsername(email);
    }

    String makeUsername(String email) {
        	String[] parts = email.split("@");
        	return parts[0];
    }

}
