package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressesRepository extends JpaRepository<Address, Integer> {
    List<Address> getAddressesByEmail(String email);
}
