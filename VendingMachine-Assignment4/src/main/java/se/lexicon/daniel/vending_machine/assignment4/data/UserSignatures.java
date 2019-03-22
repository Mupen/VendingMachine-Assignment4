package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.List;
import java.util.Optional;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface UserSignatures {

	// Product
	public void addProduct(Product product) throws IllegalArgumentException;
	public void useProduct(Product product) throws IllegalArgumentException;
	public void examineProduct(Product product) throws IllegalArgumentException;
	public void removeProduct(Optional<Product> product) throws IllegalArgumentException;
	public Optional<Product> findProductById(int id);
	public List<Product> findByNameLike(String name);
	public List<Product> findAllProducts();
	
	// Coins
	public List<Denomination> getUserCoins();
	public int addCoinsTogether();
	public void addCoinsCollection(List<Denomination> coins);
	public void removeCoinsCollection(List<Denomination> coins);
	
	
}
