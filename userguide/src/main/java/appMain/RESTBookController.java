package appMain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/com")
public class RESTBookController {

	private BookService bookService;

	@Autowired
	public RESTBookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public ArrayList<Book> listProducts() {
		return bookService.listBooks();

	}

	@RequestMapping(value = "/restAdd" ,method = RequestMethod.POST)
	public @ResponseBody Book registerBook(@RequestBody Book book) {
		bookService.addBook(book);
		return book;
	}
}
