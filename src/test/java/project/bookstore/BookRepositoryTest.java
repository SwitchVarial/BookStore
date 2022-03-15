package project.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;
import project.bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	// Find book by author name
	@Test
	public void findByAuthorReturnAuthor() {
		List<Book> books = bookRepository.findByAuthor("Elina Karjalainen");
		Assertions.assertThat(books.get(0).getAuthor()).isEqualTo("Elina Karjalainen");
	}
	
	// Find book by author name and check if right amount exists
	@Test
	public void findByAuthorReturnSize() {
		List<Book> books = bookRepository.findByAuthor("Elina Karjalainen");
		Assertions.assertThat(books).hasSize(1);
	}
	
	// Insert new book
	@Test
	public void insertNewBook() {
		Book book = new Book("Yhden illan käsityöt", "Elisa Lampela", "978-951-23-5564-8", 2012, 24.90, new Category("Käsityökirjat"));
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
		Assertions.assertThat(book.getAuthor()).isEqualTo("Elisa Lampela");
	}
	
	// Delete book
	@Test 
	public void deleteBook() { 
		List<Book> books = bookRepository.findByTitle("Eminem");
		bookRepository.deleteById(books.get(0).getId());
		books= bookRepository.findByTitle("Eminem");
		Assertions.assertThat(books).hasSize(0);
	}
	
	// Find book by title
	@Test
	public void findByTitleReturnTitle() {
		List<Book> books = bookRepository.findByTitle("Eminem");
		Assertions.assertThat(books.get(0).getTitle()).isEqualTo("Eminem");
	}
	
	// Find book by title and check if right amount exists
	@Test
	public void findByTitleReturnSize() {
		List<Book> books = bookRepository.findByTitle("Eminem");
		Assertions.assertThat(books).hasSize(1);	
	}

}
