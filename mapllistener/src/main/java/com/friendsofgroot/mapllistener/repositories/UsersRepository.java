package com.friendsofgroot.mapllistener.repositories;

import com.friendsofgroot.mapllistener.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    User findByUsername(String username);

    Optional<Object> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);


    User findByUsernameAndPassword(String username, String password);

}