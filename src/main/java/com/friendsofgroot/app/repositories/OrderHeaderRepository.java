package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.ChainOrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 *
 */
public interface OrderHeaderRepository extends JpaRepository<ChainOrderHeader, Long> {
    ChainOrderHeader getById(UUID id);

    void deleteById(UUID id);
}
