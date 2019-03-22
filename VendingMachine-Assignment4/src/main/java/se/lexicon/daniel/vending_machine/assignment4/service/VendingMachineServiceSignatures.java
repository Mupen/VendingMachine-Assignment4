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
	
	public void addCoinToUser(Denomination coin);
	public void addCoinToVendingMachinen(Denomination coin);
	public void addCoinToInBetweenStorage(Denomination coin) throws IllegalArgumentException;
	
	public void addCoinsCollectionToUser(List<Denomination> removeCoinsFromInBetweenStorage);
	public void addCoinsCollectionToVendingMachinen(List<Denomination> removeCoinsFromInBetweenStorage);
	public void addCoinsCollectionToInBetweenStorage(List<Denomination> removeCoinsFromInBetweenStorage);
	
	public Denomination removeCoinFromUser(Denomination coin);
	public Denomination removeCoinFromVendingMachinen(Denomination coin);
	public Denomination removeCoinFromInBetweenStorage(Denomination coins);

	public void removeCoinsCollectionFromInBetweenStorage(List<Denomination> coins);
	public void removeCoinsCollectionFromUser(List<Denomination> coins);
	public void removeCoinsCollectionFromVendingMachinen(List<Denomination> coins);
	
}
