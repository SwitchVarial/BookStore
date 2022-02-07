package project.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.bookstore.domain.Book;
import project.bookstore.domain.BookRepository;
import project.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	// Endpointit / ja /books
	@RequestMapping(value = {"/","/books"})
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	// Endpointti add, joka ohjataan addbook.html ja sinne viedään uusi tyhjä kirja ja kategoriat
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	
	// Endpoint save, joka tallenta lomakeen tiedot POST-metodin avulla. 
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:books";
	}
	
	// Endpoint, joka poistaa kirjaan id:n perusteella - käytetään GET metodia oikean id:n hakuun
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../books";
	}
	
	// Enpoint, joka muokkaa kirjaa, joka haetaan id:n perusteella - käytetään GET metodia oikean id:n hakuun.
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}
	

}
