package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinsRepository extends JpaRepository<Coin, Integer> {
//    Object findByUsername(String username); // logic needed
}