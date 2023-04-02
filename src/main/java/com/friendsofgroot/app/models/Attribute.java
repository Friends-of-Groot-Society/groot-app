package com.friendsofgroot.app.models;


import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ATTRIBUTE")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attrid", nullable = false)
    private int attrid;
    private String valu;
    private String trait_type;
    @ManyToOne
    private Metadata metadata;
//    @Column(name = "metaids")
//    private int metadataMetaid;

}