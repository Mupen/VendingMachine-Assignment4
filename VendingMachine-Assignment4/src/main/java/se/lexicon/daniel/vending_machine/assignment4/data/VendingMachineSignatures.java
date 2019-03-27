package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineSignatures {
	
	// Product
	public void addProduct(Product product) throws IllegalArgumentException;
	public void removeProduct(Product product) throws IllegalArgumentException;
	public String getInventory();
	public Optional<Product> findProductById(int productId);
	public Optional<Product> findProductByCode(int code);
	public List<Product> findAllProducts();
	
	// Coins
	public List<ObjectEnum> getVendingMachineCoins();
	public int addCoinsTogether();
	public void addCoinsCollection(List<ObjectEnum> coins) throws IllegalArgumentException;
	public void removeCoinsCollection(List<ObjectEnum> coins) throws IllegalArgumentException;
	public List<ObjectEnum> findCoinByName(Denomination denomination);

}
