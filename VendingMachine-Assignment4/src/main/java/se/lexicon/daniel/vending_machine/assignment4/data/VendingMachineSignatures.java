package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineSignatures {
	
	// Product
	public void addProduct(Product product);
	public void removeProduct(Product product);
	public String getInventory();
	public Optional<Product> findProductById(int productId);
	public Optional<Product> findProductByCode(int code);
	public List<Product> findAllProducts();
	
	// Coins
	public List<Denomination> getVendingMachineCoins();
	public int addCoinsTogether();
	public void addCoinsCollection(List<Denomination> coins);
	public void removeCoinsCollection(List<Denomination> coins);

}
