package com.friendsofgroot.mapllistener.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.friendsofgroot.mapllistener.models.BaseModel;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@RequiredArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "users")
public class
User implements Serializable  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
    @SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
    @Column(name="userid", nullable = false, unique = true)
    private Long userId;

    @Column(name="username" , unique = true )
    private String username;

//    @NotBlank(message="*Must give password")
//    @Size(min=2, max=120)
    @Column(name="password" )
    private String password;
    @Column(name="lastname")
    private String lastName;

    @Column(name="firstname")
    private String firstName;

    @Column(name="usertype") /// 0 = admin, 1 = user
    private int userType;
    @Column(name="phone")
    private String phone;

//    @NotBlank
//    @Email(message="*Must be a valid email address")
    @Column(name="email"  , unique = true)
    private String email;
    @Column(name="cusurl")
    private String cusUrl;

    @Column(name="photopath")
    private String photoPath;

    @Column(name="isactive")
    private int isActive;

    @Column(name="contacttype")
    private int contactType; // ContactType contactType

    @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(long userid, String username, String password, String lastName, String firstName, int userType, String phone, String email, String cusUrl, String photoPath, int isActive, int contactType) {

        this.userId = userid;
        this.username = username;
        this.password = password;
        this.lastName = lastname;
        this.firstName = firstName;
        this.userType = userType;
        this.phone = phone;
        this.email = email;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
        this.isActive = isActive;
        this.contactType = contactType;
    }

    public User(Long userId, String username, String password, String lastName, String firstName, int userType, String phone, String email, String cusUrl, String photoPath, int isActive) {

    }

    ////////////////////

    public boolean setRole(String admin) {
        this.userType = 9;
        return true;
    }
    public void addRole(Role role){
        if(!this.roles.contains(role)){
            this.roles.add(role);
        }

        if(!role.getUsers().contains(this)){
            role.getUsers().add(this);
        }
    }

    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
}