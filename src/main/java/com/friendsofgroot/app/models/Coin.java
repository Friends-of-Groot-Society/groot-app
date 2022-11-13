package com.friendsofgroot.app.models;

public class Coin {

	int coinId;
	String coinToken;
	String coinSymbol;
	double priceTotal;
	int purchased;

	/*
	 * Java Object representation of a table in DB.
	 * Tables: User, Payments, Offers,
	 * *purchased = 1 ; (not) purchased = 0
	 */
	public Coin() {
		super();
	}

	public Coin(int coinId, String coinToken, String coinSymbol, double priceTotal, int purchased) {
		super();


	}

	public int getCoinId() {
		return coinId;
	}

	public void setCoinId(int coinId) {
		this.coinId = coinId;
	}

	public String getCoinToken() {
		return coinToken;
	}

	public void setCoinToken(String coinToken) {
		this.coinToken = coinToken;
	}

	public String getCoinSymbol() {
		return coinSymbol;
	}

	public void setCoinSymbol(String coinSymbol) {
		this.coinSymbol = coinSymbol;
	}

	public double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public int getPurchased() {
		return purchased;
	}

	public void setPurchased(int purchased) {
		this.purchased = purchased;
	}

	public int isPurchased() {
		return 0;
	}
}
