package com.friendsofgroot.app.service;


import com.friendsofgroot.app.dataLoader.CoinManager;
import com.friendsofgroot.app.dataLoader.UserManager;
import com.friendsofgroot.app.models.Coin;
import com.friendsofgroot.app.models.User;

import java.util.List;


// Like Singleton Managers, This Service is a Controllers return singletons


public class CoinLocalService {

    private static CoinLocalService instance = new CoinLocalService();
    private CoinLocalService() {}
    public static CoinLocalService getInstance() {
        return instance;
    }

    public void saveLocalUserCoin(User user, Coin bookmark) {
        UserManager.getInstance().saveLocalUserCoin(user, bookmark);
    }
    public List<Coin> getLocalUserCoinsByUser(User user) {
        List<Coin> coinList = UserManager.getInstance().getLocalUserCoinsByUser(user);
        System.out.println(coinList);
        return coinList;
    }

}
