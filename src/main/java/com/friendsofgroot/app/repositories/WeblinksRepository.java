package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Book;
import com.friendsofgroot.app.models.Weblink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeblinksRepository extends JpaRepository<Weblink, Long> {
}