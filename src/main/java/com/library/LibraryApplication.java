package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryApplication.class, args);
	}

	//erzeugt ein CommandLineRunner-Objekt -kann man benutzen, um Methoden zu testen
	@Bean    // hiermit hängen wir uns in das gestartete Programm rein
	public CommandLineRunner run(BookRepository repository) {

		return args -> {
			repository.save(new Book("Java ist auch eine Insel", "Max Meier"));
			repository.save(new Book("Infinite Jest", "David Wallace"));
			repository.save(new Book("Murderbot Diaries", "Martha Wells"));
		};
	}
}

//
//			1.alle Bücher anzeigen
//			2.Buch per Id suchen
//			3.Bücher per Titel suchen
//				- hier muss noch mehr getan werden
//			 *//*
//
//			List<Book> books = repository.findAll();
//			System.out.println(books);
//
//			System.out.println(repository.findById(2));
//			*//* alternativ
//			Optional<Book> o = repository.findById(2)
//			System.out.println(o.get());
//			 *//*
//			System.out.println(repository.findByTitle("Murderbot Diaries"));

