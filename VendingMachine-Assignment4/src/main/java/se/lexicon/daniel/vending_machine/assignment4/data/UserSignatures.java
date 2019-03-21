package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface UserSignatures {

	public Product addProduct(Product product) throws IllegalArgumentException;

	public List<Denomination> getUserCoins();

	public int addCoinsTogether();

	public Stream<Denomination> addCoinsCollection(List<Denomination> coins);
	
	public void addCoin(Denomination coin) throws IllegalArgumentException;

	public void removesCoin(Denomination coins);

	public void useProduct(Product product) throws IllegalArgumentException;

	public void examineProduct(Product product) throws IllegalArgumentException;

	public void removeProduct(Optional<Product> product) throws IllegalArgumentException;

	public Optional<Product> findProductById(int id);

	public List<Product> findByNameLike(String name);

	public List<Product> findAllProducts();

	public List<Denomination> removeCoinsCollection(List<Denomination> coins);

}
