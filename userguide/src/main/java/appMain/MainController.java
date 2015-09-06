package appMain;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	private BookService service;
	private AdminService adminService;
	private AccountService accountService;
	private ArrayList<Book> kosnicka = new ArrayList<>();

	@Autowired
	public MainController(BookService service, AccountService acccountService, AdminService adminService) {
		super();
		this.service = service;
		this.accountService = acccountService;
		this.adminService = adminService;
	}

	@RequestMapping(value = "/index1", method = RequestMethod.GET)
	String index1(Model model) {
		model.addAttribute("books", service.listBooks());
		return "index";
	}

	@RequestMapping(value = "kosnicka/{title}", method = RequestMethod.GET)
	public String addToBucket(@PathVariable("title") String title, Model model,
			HttpSession session) {
		final Book produkt = service.findProduct(title);
		String ime = produkt.getTitle();
		int cena = produkt.getPrice();
		model.addAttribute("cena", cena);
		model.addAttribute("kosnicka", ime);
		session.setAttribute("izbranProdukt", produkt);
		Book p = (Book) session.getAttribute("izbranProdukt");
		kosnicka.add(p);
		return "redirect:/index1#services";
	}

	@RequestMapping(value = "/kosnicka", method = RequestMethod.GET)
	String listBucket(Model model, HttpSession session) {
		int suma = 0;
		for (Book produkt : kosnicka) {
			suma += produkt.getPrice();

		}

		model.addAttribute("backet", kosnicka);
		model.addAttribute("suma", suma);
		session.setAttribute("suma", suma);

		return "kosnicka";

	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	String payment(Model model, HttpSession session) {
		int suma = (int) session.getAttribute("suma");
		Account account = new Account();
		model.addAttribute("account", account);
		model.addAttribute("suma", suma);
		return "plakjanje";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(value = "account") Account account,
			final BindingResult bindingResult) {
		Account returnAccount = accountService.returnAccount(
				account.getEmail(), account.getPassword());
		if (returnAccount == null) {
			return "redirect:/account1";
		}

		return "redirect:/index1#services";
	}

	@RequestMapping(value = "/account1", method = RequestMethod.GET)
	public String createAccount(Model model) {
		CreditCard card = new CreditCard();
		model.addAttribute("card", card);

		return "account1";

	}

	@RequestMapping(value = "/creditcard", method = RequestMethod.POST)
	public String login(@ModelAttribute(value = "card") CreditCard card,
			final BindingResult bindingResult, HttpSession session) {
		accountService.saveCreditCard(card);
		session.setAttribute("card", card);

		return "redirect:/account2";
	}

	@RequestMapping(value = "/account2", method = RequestMethod.GET)
	public String account(@ModelAttribute(value = "account") Account account,
			final BindingResult bindingResult, Model model) {
		model.addAttribute("account", account);

		return "account2";
	}

	@RequestMapping(value = "/accountInput", method = RequestMethod.POST)
	public String accountInput(
			@ModelAttribute(value = "account") Account account,
			final BindingResult bindingResult, HttpSession session) {
		CreditCard card = (CreditCard) session.getAttribute("card");
		account.setCreditCard(card);
		accountService.createAccount(account);

		return "redirect:/index1#services";
	}

	// ------Adding Books-------

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	String index3(Model model) {
		model.addAttribute("books", service.listBooks());
		Book book = new Book();
		model.addAttribute("book", book);
		return "Angular";
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String createOrUpdateBook(@ModelAttribute("book") Book book) {

		service.addBook(book);
		;

		return "redirect:/books";
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	String index4(Model model) {
		model.addAttribute("books", service.listBooks());
		Book book = new Book();
		model.addAttribute("book", book);
		return "EditBook";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String createOrUpdateBook4(@ModelAttribute("book") Book book) {

		service.addBook(book);
		;

		return "redirect:/books";
	}
	
	

	@RequestMapping(value = "books/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		
		final Book book = service.editBook(id);
		model.addAttribute("book", book);
		return "EditBook";
	}
//	@RequestMapping(value = "books/{title}", method = RequestMethod.GET)
//	public String editBook1(@PathVariable("title") String title, Model model) {
//		Book bb = service.findProduct(title);
//		final Book book = service.editBook(bb);
//		model.addAttribute("book", book);
//		return "EditBook";
//	}
//	@RequestMapping(value = "books/{title}", method = RequestMethod.PUT)
//	public Book updateBookRegistration1(@RequestBody Book book,
//			@PathVariable("title") String title ) {
//	//	book.setId(id);
//		service.addBook(book);
//		return book;
//	}


	@RequestMapping(value = "books/{id}", method = RequestMethod.PUT)
	public Book updateBookRegistration(@RequestBody Book book,
			@PathVariable("id") Long id) {
	//	book.setId(id);
		service.addBook(book);
		return book;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id, Model model) {
		this.deleteBook(id);
		return "redirect:/books";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteBook(@RequestParam("id") Long id) {
		service.unregisterBookById(id);
		return "redirect:/books";
	}

	// ---------Admin Login------------
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	String adminLogin(Model model) {

		Admin admin = new Admin();
		model.addAttribute("admin", admin);

		return "AdminLogin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String login(@ModelAttribute(value = "admin") Admin admin,
			final BindingResult bindingResult,Model model) {
		Admin returnAdmin = adminService.returnAdmin(admin.getUsername(), admin.getPassword());
		model.addAttribute("books", service.listBooks());
		if (returnAdmin == null) {
			return "redirect:/admin";
		}

		return "Angular";
	}

}
