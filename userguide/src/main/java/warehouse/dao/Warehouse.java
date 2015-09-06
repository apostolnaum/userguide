package warehouse.dao;

import java.util.ArrayList;

import appMain.Produkt;

public interface Warehouse {

	public void addProduct(Produkt produkt);

	public ArrayList<Produkt> listProducts();

}
