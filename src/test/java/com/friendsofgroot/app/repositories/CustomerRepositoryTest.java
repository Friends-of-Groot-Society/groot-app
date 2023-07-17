package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void testSaveUser() {
        User user = userRepository.save(User.builder()
                        .name("New Name")
                .build());

        assertThat(user.getId()).isNotNull();

    }
}
