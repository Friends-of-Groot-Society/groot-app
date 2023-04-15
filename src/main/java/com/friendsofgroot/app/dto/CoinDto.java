package com.friendsofgroot.app.dto;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link com.friendsofgroot.app.models.Coin} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class CoinDto implements Serializable {
    static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coin_id", nullable = false)
    private   int coinId;
    private   String coinToken;
    private   String coinSymbol;
    private   double priceTotal;
    private   int purchased;


}