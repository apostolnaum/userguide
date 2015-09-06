package appMain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;
	@Column(name = "price")
	private int price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="category")
	private String category;
	@Column(name = "quantity")
	private int quantity;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Produkt [isbn=" + isbn + ", title=" + title + ", author="
				+ author + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	



}
