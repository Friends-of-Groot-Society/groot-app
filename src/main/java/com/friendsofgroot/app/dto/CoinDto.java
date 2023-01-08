package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Weblink;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.friendsofgroot.app.models.Coin} entity
 */
@Data
public class CoinDto implements Serializable {
    private final int coinId;
    private final String coinToken;
    private final String coinSymbol;
    private final double priceTotal;
    private final int purchased;

    /**
     * A DTO for the {@link Weblink} entity
     */

}