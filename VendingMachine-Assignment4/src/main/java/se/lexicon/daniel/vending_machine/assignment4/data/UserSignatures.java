package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface UserSignatures {
	
	public int getCashAmount();
	public void setCashAmount(int userCash);
	public void addCashAmount(int userCash);
	
	public void useProduct(Product product);
	
	public Product addToInventory(Product product);
	
	public Optional<Product> findProductById(int productId);
	
	public void removeProduct(Optional<Product> product);
	
	public List<Product> findAllProducts();
	

}
