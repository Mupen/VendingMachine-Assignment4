package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineSignatures {
	
	public int addCoinsTogether();
	public void addCoin(Denomination coin);
	public void addCoinsCollection(List<Denomination> coins);
	public void removesCoin(Denomination coin);
	
	public String getInventory();
	
	public void addProduct(Product product);
	public void removeProduct(Product product);
	
	public Optional<Product> findProductById(int productId);
	public Optional<Product> findProductByCode(int code);
	
	public List<Product> findAllProducts();
	public List<Denomination> getVendingMachineCoins();
	public List<Denomination> removeCoinsCollection(List<Denomination> coins);
	
}
