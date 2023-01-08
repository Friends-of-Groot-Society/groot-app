package com.friendsofgroot.app.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
    @SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
    @Column(name="userid")
    private int userId;

    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="lastname")
    private String lastName;

    @Column(name="firstname")
    private String firstName;
    @Column(name="groups")
    private int groups;
    @Column(name="usertype")
    private int userType;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;

    @Column(name="cusurl")
    private String cusUrl;

    @Column(name="photopath")
    private String photoPath;

    @Column(name="usergroup")
    private String userGroup;
    @Column(name="isactive")
    private int isActive;

    @Column(name="contacttype")
    private int contactType; // ContactType contactType
    @Column(name="id")
    private String id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses ;

    // overloaded for getUsersByCArs() call to DB
    public User(int userId, String userName) {
        super();
        this.userId = userId;
        this.userName = userName;
    }

    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    // overloaded for OFFER/ Groups must be multi-purpose
    public User(int userId, String userName, String password, int groups, int userType) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.groups = groups;
    }

    // overloaded For REGISTER userId is AutoIncrement, lastname, firstname, email, phone, cusurl
//    public User(String userName, String password, String lastName, String firstName, int groups, int userType, String email, String phone, String cusUrl) {
//        super();
//        this.userName = userName;
//        this.password = password;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.userType = userType;
//        this.groups = groups;
//        this.email = email;
//        this.phone = phone;
//        this.cusUrl = cusUrl;
//    }

    //	 overloaded WITHOUT userId  FOR Creating TO ORACLE DB  FOR ORACLE DB INSERTION/RETRIEVAL
    public User(String userName, String password, String lastName, String firstName,
                int groups, int userType, String phone,String email,  String cusUrl, String photoPath,
                String userGroup,
                int isActive,
                int contactType,
                String id) {
        super();
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.groups = groups;
        this.userType = userType;
        this.phone = phone;
        this.email = email;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
        this.userGroup = userGroup;
        this.isActive = isActive;
        this.contactType = contactType;
        this.id = id;
    }

    public User(int userId, String userName, String password) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

//     Contstructor for EDIT PROFILE (options available for user)
public User(  String password, String lastName, String firstName,
            int groups, int userType, String phone,String email,  String cusUrl, String photoPath,
            String userGroup,
            int isActive,
            int contactType, // ContactType contactType
            String id) {
    super();

    this.password = password;
    this.lastName = lastName;
    this.firstName = firstName;
    this.userType = userType;
    this.groups = groups;
    this.email = email;
    this.phone = phone;
    this.cusUrl = cusUrl;
    this.photoPath = photoPath;
    this.userGroup = userGroup;
    this.isActive = isActive;
    this.contactType = contactType;
    this.id = id;
}



}