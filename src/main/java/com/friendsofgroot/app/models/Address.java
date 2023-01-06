package com.friendsofgroot.app.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String description;

    private String owner;

    private String address;

    private String chain;


    @Column(name="icon_url")
    private String iconUrl;

    @Column(name="block_explorer_url")
    private String blockExplorerUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="owner_id",foreignKey = @ForeignKey(name = "users_fk"))
    private User user;

    @Column(name="chain_id")
    private int chainId;
}
