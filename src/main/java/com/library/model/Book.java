package com.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
/*
Die Klasse Book wird als Entity konfiguriert und kann von JPA (Java Persistence API)
verwendet werden, um Objekte in der Datenbank zu speichern
 */

@Builder
@NoArgsConstructor  //lombok
@AllArgsConstructor //lombok
@Data   // get/set/equals/toString
@Entity

// Objekte in Datenbank speichern(JPA) - nur Entities
public class Book {

    // Aufbau des Programms: Book, BookService, BookRepository, BookService Impl
    // Annotationen (zB @Id) beziehen sich immer auf das darunter stehende Feld

    @Id // legt Primärschlüssel fest
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // legt auto Increment fest
    private long bookId;

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Loan> loans = new ArrayList<>();

    @Column(length = 20, unique = true)    //field
    private String isbn;

    @Column(length = 100)
    private String title;

    @Column(length = 100)
    private String author;

    @Column(name = "publishing_year") // da 'year' in Datenbanken ein Schlüsselwort ist, müssen wir es für die Spalte ändern
    private int year;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String isbn, String title, String author, Integer year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}