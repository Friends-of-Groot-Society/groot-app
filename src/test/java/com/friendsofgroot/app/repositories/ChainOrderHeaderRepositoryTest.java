package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.*;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChainOrderHeaderRepositoryTest {

    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    ChainsRepository productRepository;

    Chain product;

    @BeforeEach
    void setUp() {
        Chain newChain = new Chain();
//        newChain.setChainStatus(ChainStatus.NEW);
        newChain.setDescription("test product");
        product = productRepository.saveAndFlush(newChain);
    }

    @Test
    void testSaveOrderWithLine() {
        ChainOrderHeader chainOrderHeader = new ChainOrderHeader();
        User user = new User();
        user.setUsername("New User");
        User savedUser = usersRepository.save(user);

        chainOrderHeader.setUser(savedUser);

        ChainOrderLine chainOrderLine = new ChainOrderLine();
        chainOrderLine.setChain(product);

        chainOrderHeader.addOrderLine(chainOrderLine);

        ChainOrderWallet approval = new ChainOrderWallet();
        approval.setLoggedInWallet("asdfatq45qewrgfasdrg45wyhgsdfgrw");

        chainOrderHeader.setOrderApproval(approval);

        ChainOrderHeader savedOrder = orderHeaderRepository.save(chainOrderHeader);

        orderHeaderRepository.flush();

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertNotNull(savedOrder.getOrderLines());
        assertEquals(savedOrder.getOrderLines().size(), 1);

       ChainOrderHeader fetchedOrder = orderHeaderRepository.getById(savedOrder.getId());

        assertNotNull(fetchedOrder);
    }

    @Test
    void testSaveOrder() {
        ChainOrderHeader chainOrderHeader = new ChainOrderHeader();
        User user = new User();
        user.setUsername("New User");
        User savedUser = usersRepository.save(user);

        chainOrderHeader.setUser(savedUser);
        ChainOrderHeader savedOrder = orderHeaderRepository.save(chainOrderHeader);

        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getOrderStatus());

        ChainOrderHeader fetchedOrder = orderHeaderRepository.getById(savedOrder.getId());

        assertNotNull(fetchedOrder);
        assertNotNull(fetchedOrder.getId());
        assertNotNull(fetchedOrder.getOrderStatus());
        assertNotNull(fetchedOrder.getOrderApproval());
    }

    @Test
    void testDeleteCascade() {

        ChainOrderHeader chainOrderHeader = new ChainOrderHeader();
        User user = new User();
        user.setUsername("new User");
        chainOrderHeader.setUser(usersRepository.save(user));

        ChainOrderLine chainOrderLine = new ChainOrderLine();
        chainOrderLine.setChain(product);

        ChainOrderWallet chainOrderWallet = new ChainOrderWallet();
        chainOrderWallet.setLoggedInWallet("me");
        chainOrderHeader.setOrderApproval(chainOrderWallet);

        chainOrderHeader.addOrderLine(chainOrderLine);
        ChainOrderHeader savedOrder = orderHeaderRepository.saveAndFlush(chainOrderHeader);

        System.out.println("order saved and flushed");

        orderHeaderRepository.deleteById(savedOrder.getId());
        orderHeaderRepository.flush();

        assertThrows(EntityNotFoundException.class, () -> {
            ChainOrderHeader fetchedOrder = orderHeaderRepository.getById(savedOrder.getId());

            assertNull(fetchedOrder);
        });
    }

}
