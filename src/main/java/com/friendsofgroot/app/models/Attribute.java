package com.friendsofgroot.app.models;


import lombok.*;

import jakarta.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ATTRIBUTE")
public class Attribute extends BaseModel {
    private static final long serialVersionUID = 1L;
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