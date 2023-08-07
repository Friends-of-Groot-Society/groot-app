package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.ChainOrderWallet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 5/21/22.
 */
public interface OrderApprovalRepository extends JpaRepository<ChainOrderWallet, Long> {
}
