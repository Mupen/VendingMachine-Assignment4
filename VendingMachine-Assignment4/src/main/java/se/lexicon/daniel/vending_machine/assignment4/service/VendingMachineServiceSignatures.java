package se.lexicon.daniel.vending_machine.assignment4.service;

import java.util.List;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
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
	
	public List<ObjectEnum> getAllVendingMachinenCoins();
	public List<ObjectEnum> getAllUsersCoins();
	public List<ObjectEnum> getInBetweenCoinsStorageCoins();
	
	public void addCoinsToUser(List<ObjectEnum> coins);
	public void addCoinsToVendingMachinen(List<ObjectEnum> coins);
	public void givenCoinsToVendingMachinen(List<ObjectEnum> coins);
	
	public void removeCoinsFromUser(List<ObjectEnum> coins);
	public void removeCoinsFromVendingMachinen(List<ObjectEnum> coins);
	public void returnCoinsFromVendingMachinen();
	
	
}
