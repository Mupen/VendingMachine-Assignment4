package se.lexicon.daniel.vending_machine.assignment4.service;

import java.util.List;

import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineServiceSignatures {
	
	// User coins
	public List<ObjectEnum> getAllUsersCoins();
	public int getUsersCoinsValue();
	public void addCoinsToUser(ObjectEnum type, int amount);
	public void removeCoinsFromUser(ObjectEnum type, int amount);
	
	// Vending Machine coins
	public List<ObjectEnum> getAllVendingMachinenCoins();
	public int getVendingMachinensCoinsValue();
	public void addCoinsToVendingMachinen(ObjectEnum type, int amount);
	public void removeCoinsFromVendingMachinen(ObjectEnum type, int amount);
	
	// Transnational Balance coins
	public List<ObjectEnum> getAllTransnationalBalanceCoins();
	public int getTransnationalBalanceCoinsValue();
	public void addCoinsToTransnationalBalance(ObjectEnum type, int amount);
	public void removeCoinsFromTransnationalBalance(ObjectEnum type, int amount);
	
	// User Product
	public String examineUserProduct(Product product);
	public List<Product> examineUserInventory();
	public Product userPurchaseProduct(int code);
	public void userUseProduct(Product product);
	
	// VendingMachine Product
	public String examineVendingMachineProduct(Product product);
	public List<Product> examineVendingMachineInventory();
	
}
