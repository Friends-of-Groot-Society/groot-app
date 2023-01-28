package com.friendsofgroot.app.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "METADATA")
public class Metadata {

    @Id
    int metaid;
    String name;
    String description;
    String image;
    @OneToOne(mappedBy = "metadata")
    @JoinColumn(name = "nft_id")
    Nft nft;
//    @OneToMany
//    List<Attribute> attributes;


}
