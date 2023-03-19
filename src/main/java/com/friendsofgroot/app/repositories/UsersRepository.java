package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.dto.UserChain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.friendsofgroot.app.models.User;

import java.util.List;
import java.util.Optional;


@Repository

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    User findByUsername(String username);

    Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail1);


    User findByUsernameAndPassword(String username, String password);

    @Query(nativeQuery=true, value="SELECT e.first_name as firstName, u.last_name as lastName, COUNT(cu.user_id) as chainCount " +
            "FROM user u left join chain_user cu ON cu.user_id = u.user_id " +
            "GROUP BY u.first_name, u.last_name ORDER BY 3 DESC")
    List<UserChain> getUserChains();
}