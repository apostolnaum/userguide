//package appMain;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class ProductAccountController {
//
//	private ProductService service;
//	private BookService bookService;
//	private AccountService accountService;
//	private ArrayList<Produkt> kosnicka = new ArrayList<>();
//
//	@Autowired
//	public ProductAccountController(ProductService service,
//			AccountService acccountService) {
//		super();
//		this.service = service;
//		this.accountService = acccountService;
//	}
//
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	String index(Model model) {
//		model.addAttribute("products", service.listProducts());
//		System.out.println(service.listProducts());
//		return "ListProducts";
//	}
//	@RequestMapping(value = "/index1", method = RequestMethod.GET)
//	String index1(Model model) {
//		model.addAttribute("books", bookService.listBooks());
//		return "index";
//	}
//
//	@RequestMapping(value = "kosnicka/{name}", method = RequestMethod.GET)
//	public String addToBucket(@PathVariable("name") String name, Model model,
//			HttpSession session) {
//		final Produkt produkt = service.findProduct(name);
//		String ime = produkt.getName();
//		int cena = produkt.getPrice();
//		model.addAttribute("cena", cena);
//		model.addAttribute("kosnicka", ime);
//		session.setAttribute("izbranProdukt", produkt);
//		Produkt p = (Produkt) session.getAttribute("izbranProdukt");
//		kosnicka.add(p);
//		return "redirect:/index";
//	}
//
//	@RequestMapping(value = "/kosnicka", method = RequestMethod.GET)
//	String listBucket(Model model, HttpSession session) {
//		int suma = 0;
//		for (Produkt produkt : kosnicka) {
//			suma += produkt.getPrice();
//
//		}
//
//		model.addAttribute("backet", kosnicka);
//		model.addAttribute("suma", suma);
//		session.setAttribute("suma", suma);
//
//		return "Bucket";
//
//	}
//
//	@RequestMapping(value = "/payment", method = RequestMethod.GET)
//	String payment(Model model, HttpSession session) {
//		int suma = (int) session.getAttribute("suma");
//		Account account = new Account();
//		model.addAttribute("account", account);
//		model.addAttribute("suma", suma);
//		return "Payment";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@ModelAttribute(value = "account") Account account,
//			final BindingResult bindingResult) {
//		Account returnAccount = accountService.returnAccount(
//				account.getEmail(), account.getPassword());
//		if (returnAccount == null) {
//			return "redirect:/createAccountPart1";
//		}
//
//		return "redirect:/index";
//	}
//
//	@RequestMapping(value = "/createAccountPart1", method = RequestMethod.GET)
//	public String createAccount(Model model) {
//		CreditCard card = new CreditCard();
//		model.addAttribute("card", card);
//
//		return "CreateAccountPartOne";
//
//	}
//
//	@RequestMapping(value = "/creditcard", method = RequestMethod.POST)
//	public String login(@ModelAttribute(value = "card") CreditCard card,
//			final BindingResult bindingResult, HttpSession session) {
//		accountService.saveCreditCard(card);
//		session.setAttribute("card", card);
//
//		return "redirect:/createAccountPart2";
//	}
//
//	@RequestMapping(value = "/createAccountPart2", method = RequestMethod.GET)
//	public String account(@ModelAttribute(value = "account") Account account,
//			final BindingResult bindingResult, Model model) {
//		model.addAttribute("account", account);
//
//		return "CreateAccountPartTwo";
//	}
//
//	@RequestMapping(value = "/accountInput", method = RequestMethod.POST)
//	public String accountInput(
//			@ModelAttribute(value = "account") Account account,
//			final BindingResult bindingResult, HttpSession session) {
//		CreditCard card = (CreditCard) session.getAttribute("card");
//		account.setCreditCard(card);
//		accountService.createAccount(account);
//
//		return "redirect:/index";
//	}
//
//}
