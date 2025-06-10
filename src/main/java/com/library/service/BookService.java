package com.library.service;
import com.library.model.Book;

import java.util.List;


public interface BookService {Book save(Book book);

    List<Book> getAll();

    Book getById(int id);

    List<Book> getByTitle(String title);

    Book updateByTitle(int id, String newTitle);

    void delete (int id);

    Book update(int id, Book book);

    Book findByISBN(String isbn);
}
