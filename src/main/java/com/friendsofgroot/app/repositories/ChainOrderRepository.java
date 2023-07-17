package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.ChainOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
*
 */
public interface ChainOrderRepository extends JpaRepository<ChainOrder, UUID> {
}
