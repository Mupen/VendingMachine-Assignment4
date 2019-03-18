package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineSignatures {
	
	public int getCashAmount();
	public void setCashAmount(int cash);
	public void addCashAmount(int cash);
	
	public String getInventory();
	
	public void addToInventory(Product product);
	public void removeProduct(Product productObject);
	
	public Optional<Product> findProductById(int productId);
	public Optional<Product> findProductByCode(int code);
	public List<Product> findAllProducts();
	
}
