package com.friendsofgroot.app.models;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "METADATA")
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "metadata_id", nullable = false)
    private int metadataId;
    private String name;
    private String description;
    private String image;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Nft nft;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metadata", orphanRemoval = true)
    private List<Attribute> attributes;


}
