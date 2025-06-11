package com.library.service;
import com.library.model.Book;

import java.util.List;


public interface BookService {

    Book save(Book book);
    List<Book> findAll();
    Book findById(Long id);
    Book update(Long id, Book book);
    void delete (Long id);

    List<Book> findByTitle(String title);
    Book updateByTitle(Long id, String newTitle);
    Book findByISBN(String isbn);
}
