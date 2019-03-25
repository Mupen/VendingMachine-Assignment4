package se.lexicon.daniel.vending_machine.assignment4.service;

import java.util.List;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineServiceSignatures {
	
	public String examineUserProduct(Product product);
	public String examineVendingMachineProduct(Product product);
	
	public Product userPurchaseProduct(int code);
	public void userUseProduct(Product product);

	public List<Product> examineUserInventory();
	public List<Product> examineVendingMachineInventory();

	public int getUsersCoinsValue();
	public int getVendingMachinensCoinsValue();
	public int getInBetweenCoinsStorageCoinsValue();
	
	public List<Denomination> getAllVendingMachinenCoins();
	public List<Denomination> getAllUsersCoins();
	public List<Denomination> getInBetweenCoinsStorageCoins();
	
	public void addCoinsToUser(List<Denomination> coins);
	public void addCoinsToVendingMachinen(List<Denomination> coins);
	public void addCoinsToInBetweenStorage(List<Denomination> coins);
	
	public void removeCoinsFromUser(List<Denomination> coins);
	public void removeCoinsFromVendingMachinen(List<Denomination> coins);
	public void removeCoinsFromInBetweenStorage(List<Denomination> coins);
	
	
}
