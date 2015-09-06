package appMain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import warehouse.dao.Warehouse;

@Service
public class ProductService implements Warehouse {

	private HibernateWarehouse productRepo;

	@Autowired
	public ProductService(HibernateWarehouse productRepo) {
		super();
		this.productRepo = productRepo;

	}

	@Override
	public void addProduct(Produkt produkt) {
		productRepo.addProduct(produkt);

	}

	@Override
	public ArrayList<Produkt> listProducts() {
		ArrayList<Produkt> lista = productRepo.listProducts();
		return lista;
	}

	public Produkt findProduct(String name) {
		//Produkt product = productRepo.findProduct(name);
		return null;
	}

}
