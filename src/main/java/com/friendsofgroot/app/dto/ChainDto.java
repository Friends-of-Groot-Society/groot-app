package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Chain;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Chain} entity
 */
@Data
public class ChainDto implements Serializable {
    private Integer id;
    private String name;
    private String symbol;
    private String description;
    private String longDescription;
    private String iconUrl;
    private String category;
    private String chainListIcon;
    private String rpcUrl;
    private Integer addressesCount;
}