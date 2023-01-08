package com.friendsofgroot.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.friendsofgroot.app.models.User;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    User findByUserName(String username);

}