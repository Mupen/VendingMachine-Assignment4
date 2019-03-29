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
	public List<ObjectEnum> findCoinByName(Denomination denomination);
	
	public void confirmPurchase(int cost) throws IllegalArgumentException;
	public void addCoins(ObjectEnum type, int amount) throws IllegalArgumentException;
	public void removeCoins(ObjectEnum type, int amount) throws IllegalArgumentException;
	

}
