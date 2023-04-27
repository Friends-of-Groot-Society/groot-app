package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chain")
public class Chain  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //IDENTITY, generator = "chain_seq")
    @Column(name = "chain_id", nullable = false, unique = true)
    private int chainId;

    private String name;
    private String symbol;
    private String description;
    @Column(name = "long_description")
    private String longDescription;
    @Column(name= "icon_url")
    private String iconUrl;

    private String category;
    @Column(name = "chain_list_icon")
    private String chainListIcon;
    @Column(name = "rpc_url")
    private String rpcUrl;

    private int id; // chain id
    @Column(name = "block_explorer_url")
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