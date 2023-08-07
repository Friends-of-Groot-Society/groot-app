package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Created by jt on 5/21/22.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ChainOrderWallet extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chain_order_wallet_generator")
    @SequenceGenerator(name="chain_order_wallet_generator", sequenceName = "chain_order_wallet_seq", allocationSize=1)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "order_header_id")
    private ChainOrderHeader chainOrderHeader;
    private String loggedInWallet;

}
