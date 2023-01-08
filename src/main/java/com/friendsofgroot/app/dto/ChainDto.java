package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Chain;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Chain} entity
 */
@Data
public class ChainDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String symbol;
    private final String description;
    private final String longDescription;
    private final String iconUrl;
    private final String category;
    private final String chainListIcon;
    private final String rpcUrl;
    private final Integer addressesCount;
}