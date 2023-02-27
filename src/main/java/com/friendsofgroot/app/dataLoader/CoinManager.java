package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.dao.CoinDAOimpl;
import com.friendsofgroot.app.dao.UserDAOimpl;
import com.friendsofgroot.app.models.Coin;
import com.friendsofgroot.app.models.User;

import java.util.List;

public class CoinManager {

	private static CoinManager instance = new CoinManager(); 
	private static CoinDAOimpl coinDaoImpl = new CoinDAOimpl();

	private static UserDAOimpl userDAOimpl = new UserDAOimpl();
	private CoinManager() {
	}

	public static CoinManager getInstance() {

		return instance;
	}
	public void saveLocalUserCoin(User user, Coin bookmark) {
		UsersData.getInstance().saveLocalUserCoin(user, bookmark);
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
		return coinDaoImpl.getCoins(); 
}



}
