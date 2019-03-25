package se.lexicon.daniel.vending_machine.assignment4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import se.lexicon.daniel.vending_machine.assignment4.data.User;
import se.lexicon.daniel.vending_machine.assignment4.data.UserSignatures;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachine;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;
import se.lexicon.daniel.vending_machine.assignment4.models.ChewingGum;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Drink;
import se.lexicon.daniel.vending_machine.assignment4.models.Food;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;
import se.lexicon.daniel.vending_machine.assignment4.utils.KeyboardInput;

public class VendingMachineService implements VendingMachineServiceSignatures {

	private static final VendingMachineServiceSignatures vendingMachineServiceInstance = new VendingMachineService();
	public static VendingMachineServiceSignatures getVendingMachineService() {return vendingMachineServiceInstance;}

	private List<Denomination> inBetweenCoinsStorage;
	private UserSignatures userInstance;
	private VendingMachineSignatures vendingMachineInstance;

	VendingMachineService() {
		userInstance = User.getUserInstance();
		vendingMachineInstance = VendingMachine.getVendingMachineInstance();
		inBetweenCoinsStorage = new ArrayList<Denomination>();
	}
	
	@Override
	public List<Product> examineUserInventory() {return userInstance.findAllProducts();}

	@Override
	public List<Product> examineVendingMachineInventory() {return vendingMachineInstance.findAllProducts();}

	@Override
	public String examineUserProduct(Product product) {return product.toString();}

	@Override
	public String examineVendingMachineProduct(Product product) {return product.toString();}
	
	@Override
	public void userUseProduct(Product product) {this.userInstance.useProduct(product);}

	@Override
	public Product userPurchaseProduct(int code) {
		Product tempProduct = vendingMachineInstance.findProductByCode(code).get();
		userInstance.addProduct(tempProduct);
		vendingMachineInstance.removeProduct(tempProduct);
		return tempProduct;
	}
	
	@Override
	public int getUsersCoinsValue() {return userInstance.addCoinsTogether();}
	
	@Override
	public int getVendingMachinensCoinsValue() {return vendingMachineInstance.addCoinsTogether();}	

	@Override
	public int getInBetweenCoinsStorageCoinsValue() {
		int coinsToValue = 0;
		for(Denomination denomination : inBetweenCoinsStorage) {
			coinsToValue += denomination.getValue();
		}
		return coinsToValue;	
	}

	
	
	@Override
	public List<Denomination> getAllVendingMachinenCoins() {return vendingMachineInstance.getVendingMachineCoins();}
	
	@Override
	public List<Denomination> getAllUsersCoins() {return userInstance.getUserCoins();}
	
	@Override
	public List<Denomination> getInBetweenCoinsStorageCoins() {return this.inBetweenCoinsStorage;}
	
	
	
	
	@Override
	public void addCoinsToUser(List<Denomination> coins) {userInstance.addCoinsCollection(coins);}
	
	@Override
	public void addCoinsToVendingMachinen(List<Denomination> coins) {vendingMachineInstance.addCoinsCollection(coins);}
	
	@Override
	public void addCoinsToInBetweenStorage(List<Denomination> coins) throws IllegalArgumentException {
		for(Denomination denomination : coins) {
			if(denomination == null) {throw new IllegalArgumentException("one of the coins is null");}
			else {inBetweenCoinsStorage.add(denomination);}
		}
	}
	
	
	@Override
	public void removeCoinsFromUser(List<Denomination> coins) {userInstance.removeCoinsCollection(coins);}

	@Override
	public void removeCoinsFromVendingMachinen(List<Denomination> coins) {vendingMachineInstance.removeCoinsCollection(coins);}
	
	@Override
	public void removeCoinsFromInBetweenStorage(List<Denomination> coins) {
		for(Denomination denomination : coins) {
			if(denomination == null) {throw new IllegalArgumentException("one of the coins is null");}
			else {
				this.inBetweenCoinsStorage.removeIf(c->c.equals(denomination));
			}
		}
	}
	




}
