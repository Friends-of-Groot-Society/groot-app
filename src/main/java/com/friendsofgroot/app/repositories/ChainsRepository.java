package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Chain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChainsRepository extends JpaRepository<Chain, Integer> {
    Chain findByName(String name);
}