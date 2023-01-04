package com.friendsofgroot.app.models;



import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter @ToString
@Table(name = "cointable")
public class Coin implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@Column(name = "coinid", nullable = false)
	int coinId;
	@Column(name = "cointoken")
	String coinToken;
	@Column(name = "coinsymbol")
	String coinSymbol;
	@Column(name = "pricetotal")
	double priceTotal;

	int purchased;

	/*
	 * Java Object representation of a table in DB.
	 * Tables: User, Payments, Offers,
	 * *purchased = 1 ; (not) purchased = 0
	 */

//	public int getCoinId() {
//		return coinId;
//	}
//
//	public void setCoinId(int coinId) {
//		this.coinId = coinId;
//	}
//
//	public String getCoinToken() {
//		return coinToken;
//	}
//
//	public void setCoinToken(String coinToken) {
//		this.coinToken = coinToken;
//	}
//
//	public String getCoinSymbol() {
//		return coinSymbol;
//	}
//
//	public void setCoinSymbol(String coinSymbol) {
//		this.coinSymbol = coinSymbol;
//	}
//
//	public double getPriceTotal() {
//		return priceTotal;
//	}
//
//	public void setPriceTotal(double priceTotal) {
//		this.priceTotal = priceTotal;
//	}
//
//	public int getPurchased() {
//		return purchased;
//	}
//
//	public void setPurchased(int purchased) {
//		this.purchased = purchased;
//	}
//
	public int isPurchased() {
		return 0;
	}

}
