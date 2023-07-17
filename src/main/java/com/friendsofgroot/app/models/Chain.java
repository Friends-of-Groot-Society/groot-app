package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.friendsofgroot.app.models.dto.Symbol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CHAIN")
public class Chain  extends BaseModel implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, name = "CHAIN_ID", nullable = false, unique = true)
    private UUID chainId;
//    @GeneratedValue(strategy = GenerationType.AUTO) //IDENTITY, generator = "chain_seq")

    @Version
    private Integer version;

    @NotNull
    @NotBlank
    @Size(max = 250)
    @Column(length = 250)
    private String name;

    @Column(name="symbol")
    private Symbol symbol;

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

    @Column(name = "block_explorer_url")
    private String blockExplorerUrl;



    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name="CHAIN_USERS",
            joinColumns=@JoinColumn(name="CHAIN_ID"),
            inverseJoinColumns= @JoinColumn(name="userid")
    )
    @JsonIgnore
    private List<User> users;


    @OneToMany(mappedBy = "chain")
    private Set<ChainOrderLine> chainOrderLines;

    @ManyToMany
    @JoinTable(name = "chain_category",
            joinColumns = @JoinColumn(name = "chain_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
}
