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
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;
import se.lexicon.daniel.vending_machine.assignment4.utils.KeyboardInput;

public class VendingMachineService implements VendingMachineServiceSignatures {

	private static final VendingMachineServiceSignatures vendingMachineServiceInstance = new VendingMachineService();
	public static VendingMachineServiceSignatures getVendingMachineService() {return vendingMachineServiceInstance;}

	private List<ObjectEnum> inBetweenCoinsStorage;
	private UserSignatures userInstance;
	private VendingMachineSignatures vendingMachineInstance;

	VendingMachineService() {
		userInstance = User.getUserInstance();
		vendingMachineInstance = VendingMachine.getVendingMachineInstance();
		inBetweenCoinsStorage = new ArrayList<ObjectEnum>();
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
		for(ObjectEnum denomination : inBetweenCoinsStorage) {
			coinsToValue += denomination.getDenomination().getValue();
		}
		return coinsToValue;	
	}

	
	
	@Override
	public List<ObjectEnum> getAllVendingMachinenCoins() {return vendingMachineInstance.getVendingMachineCoins();}
	
	@Override
	public List<ObjectEnum> getAllUsersCoins() {return userInstance.getUserCoins();}
	
	@Override
	public List<ObjectEnum> getInBetweenCoinsStorageCoins() {return this.inBetweenCoinsStorage;}
	
	
	
	
	@Override
	public void addCoinsToUser(List<ObjectEnum> coins) {userInstance.addCoinsCollection(coins);}
	
	@Override
	public void addCoinsToVendingMachinen(List<ObjectEnum> coins) {vendingMachineInstance.addCoinsCollection(coins);}
	
	@Override
	public void addCoinsToInBetweenStorage(List<ObjectEnum> coins) throws IllegalArgumentException {
		for(ObjectEnum denomination : coins) {
			if(denomination == null) {throw new IllegalArgumentException("one of the coins is null");}
			else {inBetweenCoinsStorage.add(denomination);}
		}
	}
	
	
	@Override
	public void removeCoinsFromUser(List<ObjectEnum> coins) {userInstance.removeCoinsCollection(coins);}

	@Override
	public void removeCoinsFromVendingMachinen(List<ObjectEnum> coins) {vendingMachineInstance.removeCoinsCollection(coins);}
	
	@Override
	public void removeCoinsFromInBetweenStorage(List<ObjectEnum> coins) {
		for(ObjectEnum denomination : coins) {
			if(denomination == null) {throw new IllegalArgumentException("one of the coins is null");}
			else {
				this.inBetweenCoinsStorage.removeIf(c->c.equals(denomination));
			}
		}
	}
	




}
