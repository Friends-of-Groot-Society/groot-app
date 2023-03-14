package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Nft;
import com.friendsofgroot.app.models.NftRef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NftRefRepository extends JpaRepository<NftRef, Integer> {
    NftRef findByName(String name);


}