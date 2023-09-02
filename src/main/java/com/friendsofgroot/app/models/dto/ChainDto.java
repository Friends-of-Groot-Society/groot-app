package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.BaseModel;
import com.friendsofgroot.app.models.Chain;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
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
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChainDto implements Serializable {
    static long serialVersionUID = 1L;
    private Integer chainId;
    private Integer version;

    @NotBlank
    @NotNull
    private String name;
    private Symbol symbol;
    private String description;
    private String longDescription;
    private String iconUrl;
    private String category;
    private String chainListIcon;
    private String rpcUrl;
    @NotNull
    private Integer id;
    private String blockExplorerUrl;


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
