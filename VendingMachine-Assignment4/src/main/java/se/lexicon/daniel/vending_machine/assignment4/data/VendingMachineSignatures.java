package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineSignatures {
	
	/**
	 * User Product
	 * @param product = object
	 * @param List<Product> = list of objects
	 */
	
	public void addProduct(Product product) throws IllegalArgumentException;
	public void removeProduct(Product product) throws IllegalArgumentException;
	public String getInventory();
	public Optional<Product> findProductById(int productId);
	public Optional<Product> findProductByCode(int code);
	public List<Product> findAllProducts();
	

	/**
	 * Vending Machine Coins
	 * @param product = object
	 * @param List<Product> = list of objects
	 */
	
	public int addVendingMachineCoinsTogether();
	public List<ObjectEnum> getVendingMachineCoins();
	public void addCoinsToVendingMachine(ObjectEnum type, int amount) throws IllegalArgumentException;
	public void removeCoinsFromVendingMachine(ObjectEnum type, int amount) throws IllegalArgumentException;
	
	/**
	 * Translational Balance Coins
	 * @param product = object
	 * @param List<Product> = list of objects
	 */
	
	public int addTransnationalBalanceTogether();
	public List<ObjectEnum> getTransnationalBalanceCoins();
	public void addCoinsToTransnationalBalance(ObjectEnum type, int amount) throws IllegalArgumentException;
	public void removeCoinsFromTransnationalBalance(ObjectEnum type, int amount) throws IllegalArgumentException;
	
}
