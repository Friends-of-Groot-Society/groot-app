package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.dto.AddressResponse;
import com.friendsofgroot.app.dto.ChartData;
import com.friendsofgroot.app.models.Address;
import com.friendsofgroot.app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressesRepository extends JpaRepository<Address, Integer> {
    List<Address> getAddressesByEmail(String email);

    // JOINS
    @Query(value="SELECT  address.email, users.firstname,users.lastname, address.address, address.chain, address.chain_id, address.icon_url\n" +
            "FROM users\n" +
            "JOIN address\n" +
            "ON users.email = address.email\n" +
            "ORDER BY email DESC;", nativeQuery = true)
    List<AddressResponse> getAddressesByUser(String email);

//    @Query(value="SELECT new com.friendsofgroot.app.dto.AddressResponse(u.LASTNAME,u.FIRSTNAME, a.email, a.CHAIN, a.ICON_URL) FROM THOMAS.ADDRESS a, USERS u where a.email = u.email and a.email = ?1", nativeQuery = false)
    @Query(nativeQuery=true, value="SELECT a.email,u.FIRSTNAME,  u.LASTNAME, a.ADDRESS, a.CHAIN, a.ICON_URL from ADDRESS a, USERS u where a.email = u.email and a.email = ?1")
    AddressResponse getAddressByUser(String email); //ChartData is a custom class
//    public AddressResponse getAddressByUser(String email); //ChartData is a custom class
    // SEARCH BY EMAIL
    @Query(value = "SELECT * FROM ADDRESS WHERE EMAIL LIKE '%?1'", nativeQuery = true)
    List<Address> getAddressesByEmailStartsWith(String email);


    @Query(value = "SELECT * FROM ADDRESS a WHERE a.chain LIKE '%?1%'", nativeQuery = true)
    List<Address> search(String keyword);


    @Query(value = "SELECT * FROM ADDRESS a WHERE a.address LIKE '%?1'", nativeQuery = true)
    List<Address> getAddressStartsBy(String keyword);


    @Query(value = "SELECT * FROM ADDRESS a WHERE a.address LIKE '?1%'", nativeQuery = true)
    List<Address> getAddressEndsBy(String keyword);

}
