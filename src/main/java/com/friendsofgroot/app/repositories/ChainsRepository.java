package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChainsRepository extends JpaRepository<Chain, Integer> {
    Chain findByName(String name);


    List<Chain> findByCategory(String category);
}