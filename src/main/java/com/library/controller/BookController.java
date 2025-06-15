package com.library.controller;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Rest-HTTP Methoden
 * -get  -> zum lesen (z.B. über Browser testen/aufrufen)
 * -post -> zum speichern
 * -put  -> für Update
 * -delete -> löschen*/

@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("{/bookId}")
    public Book findById(@PathVariable("bookId") Long bookId){
        return bookService.findById(bookId);
    }
    @PostMapping
    public Book save(@RequestBody Book book) {
        System.out.println("Save book: " + book);
        return bookService.save(book);
    }


    //Syntax: localhost:8080/api/books/isbn/13246796347846
    ////    @GetMapping("/isbn/{isbn}")
    ////    public Book findByISBN(@PathVariable("isbn")String isbn){
    ////        return bookService.findByISBN(isbn);
    ////    }
    ////    Syntax alternativ: localhost:8080/api/books?isbn=13246796347846
    ////    @GetMapping(params = "isbn")
    ////    public Book findByISBN2(@RequestParam("isbn")String isbn){
    ////        return bookService.findByISBN(isbn);
    ////    }
}

