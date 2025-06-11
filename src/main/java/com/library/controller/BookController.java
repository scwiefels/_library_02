package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }
    //Syntax: localhost:8080/api/books/isbn/13246796347846
    @GetMapping("/isbn/{isbn}")
    public Book findByISBN(@PathVariable("isbn")String isbn){
        return bookService.findByISBN(isbn);

    }

    //Syntax alternativ: localhost:8080/api/books?isbn=13246796347846
    @GetMapping(params = "isbn")
    public Book findByISBN2(@RequestParam("isbn")String isbn){
        return bookService.findByISBN(isbn);

    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        System.out.println("SaveBook");
        return bookService.save(book);
    }
}

