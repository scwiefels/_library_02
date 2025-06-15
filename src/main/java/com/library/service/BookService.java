package com.library.service;
import com.library.model.Book;

import java.util.List;
import java.util.function.ToDoubleBiFunction;


public interface BookService {

    Book save(Book book);
    List<Book> findAll();
    Book findById(Long bookId);


//    Todo
//    Book update(Long bookId, Book book);
//    void delete (Long bookId);
//    List<Book> findByTitle(String title);
//    Book updateByTitle(Long id, String newTitle);
}
