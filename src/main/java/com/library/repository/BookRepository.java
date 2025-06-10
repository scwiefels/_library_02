package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//zunächst muss das interface von einem anderen Interface erben(Jpa) und erwartet zwei Parameter
public interface BookRepository extends JpaRepository<Book,Integer> {

    /**
     *findByTitleIgnoreCase - Namenskonvention: findByField
     *@param title
     * @return
     * SELEVT * FROM book WHERE title = ....
     */
    List<Book> findByTitleIgnoreCase(String title);

    Book findByIsbnIgnoreCase(String isbn);


    /**
     *
     * @param title
     * @return all books
     */

    List<Book> findByTitleContaining(String title);


}