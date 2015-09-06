package appMain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.dao.BookWarehouse;

@Service
public class BookService implements BookWarehouse {

	private HibernateWarehouse bookRepo;

	@Autowired
	public BookService(HibernateWarehouse bookRepo) {
		super();
		this.bookRepo = bookRepo;

	}

	@Override
	public void addBook(Book book) {
		bookRepo.addBook(book);

	}

	public Book editBook(Long id) {
		return bookRepo.findBookId(id);
	}

	@Override
	public ArrayList<Book> listBooks() {
		ArrayList<Book> lista = bookRepo.listBooks();
		return lista;
	}

	public Book findProduct(String name) {
		Book book = bookRepo.findProduct(name);
		return book;
	}

	public void unregisterBookById(Long id) {
		bookRepo.deleteBook(id);
		
	}

}
