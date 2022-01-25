package project.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@GetMapping("/index")
	@ResponseBody
	public String bookShelf() {
		return "This is a Bookshelf";
	}
}
