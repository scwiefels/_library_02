package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*wenn wir ein Interface benutzen, müssen alle Methoden (hier aus BookService) implementiert(=überschrieben) werden
syntaktisch reichen dafür die geschweiften Klammern
 */

@Service    /* wir können und wollen kein Objekt von einem Interface erzeugen;
um eine nullpointer-exception zu vermeiden, brauchen wir aber eins -
das übernimmt die annotation (das framework) für uns -
@Autowired BookService*/

public class BookServiceImpl implements BookService{

    @Autowired  // holt Implementierung, wenn es eine gibt/ Objekt wird erzeugt - design pattern: dependency injection
    private BookRepository repository;

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Book getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getByTitle(String title) {
        return repository.findByTitleContaining(title);
    }

    @Override
    public Book updateByTitle(int id, String newTitle) {
        Optional<Book> o = repository.findById(id);
        if(o.isPresent()) {
            Book b = o.get();
            b.setTitle(newTitle);
            repository.save(b);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        // Optional<Book> o = repository.findById(id);
        // if (o.isPresent()){
        // repository.delete(o.get());
        // }
        // else System.out.println("Id not found.");
        repository.deleteById(id);

    }

    /*Die Methode ist noch nicht perfekt, mit "fix me" und "to do" kann man
    solche Stellen markieren - per View, Tool Windows, "to do" lassen sie sich anzeigen*/
    @Override
    public Book update(int id, Book book) {
        Book b = getById(id);
        if (b!=null){   //FIXME Fields prüfen!
            b.setIsbn(book.getIsbn());
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
            b.setYear(book.getYear());
            return repository.save(book); //save wirkt wie update
        }
        return null;
    }

    @Override
    public Book findByISBN(String isbn) {
        return repository.findByIsbnIgnoreCase(isbn);
    }
}