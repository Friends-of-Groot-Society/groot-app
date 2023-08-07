package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    void testSaveUser() {
        User user = usersRepository.save(User.builder()
                        .username("New Name")
                .build());

    System.out.println("user: " + user);
    }
}
