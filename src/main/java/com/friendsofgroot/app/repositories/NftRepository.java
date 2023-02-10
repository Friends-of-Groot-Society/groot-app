package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Nft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NftRepository extends JpaRepository<Nft, Integer> {
}