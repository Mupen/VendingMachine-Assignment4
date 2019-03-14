package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface UserSignatures {
	
	public int getCashAmount();
	public void setCashAmount(Integer userCash);
	public void addCashAmount(Integer userCash);
	
	public void useProduct(Product product);
	
	public Product addToInventory(Product product);
	
	public Optional<Product> findProductById(Integer productId);
	
	public void removeProduct(Optional<Product> product);
	
	public List<Product> findAllProducts();
	

}
