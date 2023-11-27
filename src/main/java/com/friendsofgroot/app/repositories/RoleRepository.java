package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="role", path = "role")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(@RequestParam String name);
}
