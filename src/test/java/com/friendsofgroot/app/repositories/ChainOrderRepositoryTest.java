package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.models.ChainOrder;
import com.friendsofgroot.app.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ChainOrderRepositoryTest {

    @Autowired
    ChainOrderRepository chainOrderRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ChainsRepository chainRepository;

    User testUser;
    Chain testChain;

    @BeforeEach
    void setUp() {
        testUser = usersRepository.findAll().get(0);
        testChain = chainRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void testChainOrders() {
        ChainOrder chainOrder = ChainOrder.builder()
                .userRef("Test order")
                .user(testUser)
                .build();

        ChainOrder savedChainOrder = chainOrderRepository.save(chainOrder);


        System.out.println(savedChainOrder.getUserRef());
    }
}
