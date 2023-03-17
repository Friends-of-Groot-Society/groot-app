package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Weblink;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.friendsofgroot.app.models.Coin} entity
 */
@Data
@Getter
@Setter
public class CoinDto implements Serializable {
    private static long serialVersionUID = 1L;
    private final int coinId;
    private final String coinToken;
    private final String coinSymbol;
    private final double priceTotal;
    private final int purchased;


    public CoinDto() {
        this.coinId = 0;
        this.coinToken = "";
        this.coinSymbol = "";
        this.priceTotal = 0;
        this.purchased = 0;
    }
    /**
     * A DTO for the {@link Weblink} entity
     */
    public CoinDto(int coinId, String coinToken, String coinSymbol, double priceTotal, int purchased) {
        this.coinId = coinId;
        this.coinToken = coinToken;
        this.coinSymbol = coinSymbol;
        this.priceTotal = priceTotal;
        this.purchased = purchased;
    }
}