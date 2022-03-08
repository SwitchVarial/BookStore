package project.bookstore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.bookstore.web.BookController;
import project.bookstore.web.BookRestController;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;

	@Test
	@DisplayName("BookController should Not be null")
	void contextLoadsBook() {
		assertThat(bookController, notNullValue());
	}
	
	@Autowired
	private BookRestController bookRestController;
	
	@Test
	@DisplayName("BookRestController should not be null")
	void contextLoadsBookRest() {
		assertThat(bookRestController, notNullValue());
	}
}
