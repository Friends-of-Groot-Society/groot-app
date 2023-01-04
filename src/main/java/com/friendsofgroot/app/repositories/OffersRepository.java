package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersRepository extends JpaRepository<Offer, Integer> {
}
