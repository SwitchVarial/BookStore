package project.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;

@Controller
public class BookRestController {
	@Autowired
	private BookRepository repository;
	
	//REST kaikki kirjat
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public @ResponseBody List<Book> booklistRest() {
		return (List<Book>) repository.findAll();
	}
	
	//REST hakee kirjan id:n perusteella
	@RequestMapping(value = "/booklist/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findbookRest(@PathVariable("id") Long studentId) {
		return repository.findById(studentId);
	}
	
}
