package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.dao.CoinDAOimpl;
import com.friendsofgroot.app.dao.OfferDAOimpl;
import com.friendsofgroot.app.models.Coin;
import com.friendsofgroot.app.models.Offer;

import java.util.List;

public class CoinManager {

	private static CoinManager instance = new CoinManager(); 
	private static CoinDAOimpl carDaoImpl = new CoinDAOimpl();

	private static OfferDAOimpl offerDaoImpl= new OfferDAOimpl();
	private CoinManager() {
	}

	public static CoinManager getInstance() {

		return instance;
	}

	public Coin createCoin(int carId, String carToken, String carSymbol, double priceTotal, int purchased) {

		Coin car = new Coin(); 
		car.setCoinId(carId);
		car.setCoinToken(carToken);
		car.setCoinSymbol(carSymbol);
		car.setPriceTotal(priceTotal); 
		car.setPurchased(purchased);  
		
		return car; 
	}
	public List<Coin> getCoins() {
		return carDaoImpl.getCoins(); 
}


	public Offer createOffer(int offerID, String userName, int carId, double offerAmt, int offerMos, String offerStatus) {
		Offer offer = new Offer();
		offer.setOfferID(offerID);
		offer.setUserName(userName);
		offer.setCoinId(carId);
		offer.setOfferAmt(offerAmt);
		offer.setOfferMos(offerMos);
		offer.setOfferStatus(offerStatus);
		return offer;
	}

	public List<Offer> getOffers() {
		return offerDaoImpl.getOffers();
	}
}
