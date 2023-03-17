package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name = "chain")
public class Chain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chain_id", nullable = false, unique = true)
    private int chainId;

    private String name;
    private String symbol;
    private String description;
    private String longDescription;
    private String iconUrl;

    private String category;

    private String chainListIcon;

    private String rpcUrl;

    private int id;


    private String blockExplorerUrl;


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name="chain_users",
            joinColumns=@JoinColumn(name="chain_id"),
            inverseJoinColumns= @JoinColumn(name="userid")
    )
    @JsonIgnore
    private List<User> users;
}