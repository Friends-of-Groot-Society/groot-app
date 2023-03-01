package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Weblink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeblinksRepository extends JpaRepository<Weblink, Long> {
}