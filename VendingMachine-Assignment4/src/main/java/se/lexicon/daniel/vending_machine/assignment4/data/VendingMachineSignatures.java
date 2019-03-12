package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.List;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineSignatures {
	public int getCashAmount();
	public void setCashAmount(int userCash);
	public void addCashAmount(int userCash);
	
	public String getInventory();
	public List<Product> addToInventory(Product product);
	public Product findProductById(int productId);
	public void removeProduct(Product productObject);
	public List<Product> findAllProducts();
}
