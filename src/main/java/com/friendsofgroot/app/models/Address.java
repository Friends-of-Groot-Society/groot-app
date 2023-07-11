package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String description;

    private String email;

    private String address;

    private String chain;


    @Column(name="icon_url")
    private String iconUrl;

    @Column(name="block_explorer_url")
    private String blockExplorerUrl;

    @ManyToOne( fetch = FetchType.EAGER,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name="users_userid")
    private User user;
    @Column(name="chain_id")
    private int chainId;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name="NFTADDRESS_id")
    private NftAddress nftAddress;
}
