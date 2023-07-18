package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.Chain;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * A Dto for the {@link Chain} entity
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChainDto implements Serializable {
    static long serialVersionUID = 1L;
    private UUID chainId;
    private Integer version;

    @NotBlank
    @NotNull
    private String name;
    @NotNull
    private Symbol symbol;
    private String description;
    private String longDescription;
    private String iconUrl;
    private String category;
    private String chainListIcon;
    private String rpcUrl;
    private Integer id;
    private String blockExplorerUrl;


    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime createdDate;


    @UpdateTimestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    //    private String nativeCurrency;
//    private String nativeCurrencySymbol;
//    private String nativeCurrencyDecimals;
//    private String chainType;
//    private String chainTypeShort;
//    private String chainTypeLong;
//    private String chainTypeIcon;
//    private String chainTypeIconUrl;
//    private String chainTypeIconUrlSvg;
//    private String chainTypeIconUrlPng;
//    private String chainTypeIconUrlJpg;
//    private String chainTypeIconUrlGif;
//    private String chainTypeIconUrlWebp;

}
