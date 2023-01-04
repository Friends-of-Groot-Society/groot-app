package com.friendsofgroot.app.dto;

import lombok.*;
import javax.persistence.*;

@Getter @Setter @ToString
public class UserDto {

    @Id
    private int id;
    private String userName; // entity email

    private String lastName;
    private String firstName;
    private String photoPath;
}
