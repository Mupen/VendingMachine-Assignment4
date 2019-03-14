package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineSignatures {
	
	public Integer getCashAmount();
	public void setCashAmount(Integer userCash);
	public void addCashAmount(Integer userCash);
	
	public String getInventory();
	
	public void addToInventory(Product product);
	public void removeProduct(Product productObject);
	
	public Optional<Product> findProductById(Integer productId);
	public Optional<Product> findProductByCode(Integer code);
	public List<Product> findAllProducts();
	
}
