package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {

}