package com.friendsofgroot.app.bootstrap;

import com.friendsofgroot.app.dataLoader.BootstrapData;
import com.friendsofgroot.app.repositories.ChainsRepository;
import com.friendsofgroot.app.repositories.UserRepository;
import com.friendsofgroot.app.service.ChainCsvService;
import com.friendsofgroot.app.service.ChainCsvServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@Import(ChainCsvServiceImpl.class)
class BootstrapDataTest {

    @Autowired
    ChainsRepository chainRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChainCsvService csvService;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(chainRepository, userRepository, csvService);
    }

    @Test
    void Testrun() throws Exception {
        bootstrapData.run(null);

        assertThat(chainRepository.count()).isEqualTo(2413);
        assertThat(userRepository.count()).isEqualTo(3);
    }
}
