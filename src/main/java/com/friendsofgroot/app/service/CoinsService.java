package com.friendsofgroot.app.service;


import com.friendsofgroot.app.dto.CoinDto;
import com.friendsofgroot.app.models.Coin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CoinsService {


    public CoinDto createCoin(CoinDto c);

    public CoinDto getCoin(int coinId);

    public List<CoinDto> getAllCoins();

    public List<CoinDto> getAllCoinsCust();

    public CoinDto updateCoin(CoinDto change);

    public boolean deleteCoin(int id);

    public void coinMarketViewAll();

    List<CoinDto> getAllCoinsIOwn(String username);

    // CLI
    public Coin getCoinCLI(int coinId);
    public List<Coin> getAllCoinsCustCLI();
}
