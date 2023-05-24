package app.mapl.service;


import app.mapl.dataLoader.BookmarkManager;
import app.mapl.models.Coin;
import app.mapl.models.User;

import java.util.List;


// Like Singleton Managers, This Service is a Controllers return singletons


public class CoinLocalService {

    private static CoinLocalService instance = new CoinLocalService();
    private CoinLocalService() {}
    public static CoinLocalService getInstance() {
        return instance;
    }

}
