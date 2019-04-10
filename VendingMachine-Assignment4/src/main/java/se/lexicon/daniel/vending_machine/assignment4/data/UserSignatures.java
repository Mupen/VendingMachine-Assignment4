package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.List;
import java.util.Optional;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface UserSignatures {

	/**
	 * User Product
	 * @param product = object
	 * @param List<Product> = list of objects
	 */
	public void addProduct(Product product) throws IllegalArgumentException;
	public void useProduct(Product product) throws IllegalArgumentException;
	public void examineProduct(Product product) throws IllegalArgumentException;
	public void removeProduct(Optional<Product> product) throws IllegalArgumentException;
	public Optional<Product> findProductById(int id);
	public List<Product> findByNameLike(String name);
	public List<Product> findAllProducts();
	

	/**
	 * User Coins
	 * @param product = object
	 * @param List<Product> = list of objects
	 */
	public int addCoinsTogether();
	public List<ObjectEnum> getUserCoins();
	public void removeCoins(ObjectEnum type, int amount);
	public void addCoins(ObjectEnum type, int amount) throws IllegalArgumentException;
	
	
}
