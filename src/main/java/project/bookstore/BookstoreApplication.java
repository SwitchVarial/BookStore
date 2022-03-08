package project.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.bookstore.domain.BookRepository;
import project.bookstore.domain.Category;
import project.bookstore.domain.CategoryRepository;
import project.bookstore.domain.User;
import project.bookstore.domain.UserRepository;
import project.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstore(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			// H2 DB add New categories
			crepository.save(new Category("Runot"));
			crepository.save(new Category("Tietokirjat"));
			crepository.save(new Category("Lasten kirjat"));
			
			// H2 DB add new books
			repository.save(new Book("Sinusta, minusta, ihmisistä ja jazz-bandista", "Viljo Kajava", "951-1-16939-4", 2000, 19.90, crepository.findByName("Runot").get(0)));
			repository.save(new Book("Uppo-Nalle", "Elina Karjalainen", "951-0-17989-2", 1977, 12.50, crepository.findByName("Lasten kirjat").get(0)));
			repository.save(new Book("Eminem", "Anthony Bozza", "951-0-29666-x", 2003, 14.90, crepository.findByName("Tietokirjat").get(0)));
			
			// Show booklist in console log
			System.out.println("Haetaan kaikki kirjat tietokannasta");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
				
			// H2 DB Add users admin/qwerty user/asdfg
			User admin = new User("admin", "$2a$10$436p2H2MD/P4eN077xZd8Oww5Ajg8XWb5ez4cWxxcuMfGFqB5qb1K", "ADMIN");
			User user = new User("user", "$2a$10$pJTPGPzrntDLBVVXKrOtA.Zy4BQvW2UsMOpPE7xcLhsRZfjmyI9.q", "USER");
			urepository.save(admin);
			urepository.save(user);
			}

		};
	}

}