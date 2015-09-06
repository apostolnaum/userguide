package warehouse.dao;

import java.util.ArrayList;

import appMain.Book;

public interface BookWarehouse {

	public void addBook(Book book);

	public ArrayList<Book> listBooks();

}
