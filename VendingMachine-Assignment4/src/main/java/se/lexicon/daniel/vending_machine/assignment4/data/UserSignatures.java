package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface UserSignatures {
	
	public void useProduct(Product product);
	
	public Product addProduct(Product product);
	
	public Optional<Product> findProductById(int productId);
	
	public void removeProduct(Optional<Product> product);
	
	public List<Product> findAllProducts();
	
	public int addCoinsTogether();
	public void addCoins(List<Denomination> coins);
	public void removesCoins(List<Denomination> coins);

	public List<Denomination> getUserCoins();
	

}
