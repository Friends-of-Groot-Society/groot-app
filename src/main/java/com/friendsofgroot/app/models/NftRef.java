package com.friendsofgroot.app.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "NFT_REF")
public class NftRef   {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String owner;
    private String email;
    private String address;
    private String chain;

//    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    private Nft nft;

}