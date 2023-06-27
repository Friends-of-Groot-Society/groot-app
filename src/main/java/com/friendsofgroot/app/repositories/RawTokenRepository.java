package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.RawToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="raw_token", path="raw_token")
public interface RawTokenRepository extends JpaRepository<RawToken, Integer> {
}