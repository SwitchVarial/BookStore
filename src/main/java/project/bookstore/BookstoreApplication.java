package project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.bookstore.domain.BookRepository;
import project.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository) {
		return (args) -> {
			
			repository.save(new Book("Sinusta, minusta, ihmisistä ja jazz-bandista", "Viljo Kajava", "951-1-16939-4", 2000, 19.90));
			repository.save(new Book("Uppo-Nalle", "Elina Karjalainen", "951-0-17989-2", 1977, 12.50));
			repository.save(new Book("Eminem", "Anthony Bozza", "951-0-29666-x", 2003, 14.90));
			
			System.out.println("Haetaan kaikki kirjat tietokannasta");
			for (Book book : repository.findAll()) {
				System.out.println("Kirja:" + book.toString());
			}

		};
	}

}
