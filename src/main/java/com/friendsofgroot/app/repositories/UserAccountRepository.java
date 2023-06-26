package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.dto.ChainUsers;
import com.friendsofgroot.app.models.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel="user_account", path = "user_account")
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long>{

    @Query(nativeQuery=true, value="SELECT u.firstname as firstName, u.lastname as lastname, COUNT(cu.userid) as chainCount " +
            "FROM USERS u left join CHAIN_USERS cu ON cu.userid = u.userid;")
          //  "GROUP BY  u.lastname ORDER BY  chainCount")
    List<ChainUsers> getUserChains();

    @Query(nativeQuery=true, value="SELECT u.firstname as firstName, u.lastname as lastName, COUNT(cu.userid) as chainCount " +
            "FROM USERS u left join CHAIN_USERS cu ON cu.userid = u.userid " +
            "GROUP BY  u.lastname ORDER BY  chainCount")
    List<ChainUsers> getUserChainsCount();
}
