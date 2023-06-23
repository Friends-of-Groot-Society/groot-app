package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "raw_token")
public class RawToken implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column(name = "raw_token")
    private String rawToken;

    @ManyToOne
    @JoinColumn(name = "nft_address_id")
    private NftAddress nftAddress;


}