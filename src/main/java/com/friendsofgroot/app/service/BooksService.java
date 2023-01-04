package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.Book;

import java.util.List;

public interface BooksService {
    public Book createBooks(Book bkmk);

    public Book getBooks(long id);


    public List<Book> getAllBooks();

    public Book updateBooks(Book change);

    public boolean deleteBooks(long id);

}
