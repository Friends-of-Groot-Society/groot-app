package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends AbstractDomainClass  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
private String name;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "USERS_ROLE", joinColumns = @JoinColumn(name = "role_id"),    inverseJoinColumns = @JoinColumn(name = "userid"))
//    private List<User> users = new ArrayList<>();
}
