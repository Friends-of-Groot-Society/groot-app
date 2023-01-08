package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Address, Integer> {
}
