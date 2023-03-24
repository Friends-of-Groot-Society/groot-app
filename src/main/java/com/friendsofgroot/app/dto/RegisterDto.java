package com.friendsofgroot.app.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterDto {
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
