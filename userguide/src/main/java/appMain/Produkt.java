package appMain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "product")
public class Produkt {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "key")
	private String key;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private int price;
	@Column(name = "quantity")
	private int quantity;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Price: " + price + "\n" + " Name: " + name + "\t";
	}

}
