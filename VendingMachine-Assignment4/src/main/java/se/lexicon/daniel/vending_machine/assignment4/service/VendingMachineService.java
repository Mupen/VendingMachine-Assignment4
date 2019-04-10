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
	
	/**
	 * User Coins
	 * @param type = Denomination
	 * @param amount = number 
	 */
	
	@Override
	public List<ObjectEnum> getAllUsersCoins() {return userInstance.getUserCoins();}
	
	@Override
	public int getUsersCoinsValue() {return userInstance.addCoinsTogether();}
	
	@Override
	public void addCoinsToUser(ObjectEnum type, int amount) {userInstance.addCoins(type, amount);}
	
	@Override
	public void removeCoinsFromUser(ObjectEnum type, int amount) {userInstance.removeCoins(type, amount);}
	
	
	/**
	 * Vending Machine Coins
	 * @param type = Denomination
	 * @param amount = number 
	 */
	
	@Override
	public List<ObjectEnum> getAllVendingMachinenCoins() {return vendingMachineInstance.getVendingMachineCoins();}
	
	@Override
	public int getVendingMachinensCoinsValue() {return vendingMachineInstance.addVendingMachineCoinsTogether();}
	
	@Override
	public void addCoinsToVendingMachinen(ObjectEnum type, int amount) {vendingMachineInstance.addCoinsToVendingMachine(type, amount);}
	
	@Override
	public void removeCoinsFromVendingMachinen(ObjectEnum type, int amount) {vendingMachineInstance.removeCoinsFromVendingMachine(type, amount);}
	
	
	/**
	 * Transnational Balance Coins
	 * @param type = Denomination
	 * @param amount = number 
	 */
	
	
	@Override
	public List<ObjectEnum> getAllTransnationalBalanceCoins() {
		return inBetweenCoinsStorage;}
	
	@Override
	public int getTransnationalBalanceCoinsValue() {return vendingMachineInstance.addTransnationalBalanceTogether();}	
	
	@Override
	public void addCoinsToTransnationalBalance(ObjectEnum type, int amount) {vendingMachineInstance.addCoinsToTransnationalBalance(type, amount);}
	
	@Override
	public void removeCoinsFromTransnationalBalance(ObjectEnum type, int amount) {vendingMachineInstance.removeCoinsFromTransnationalBalance(type, amount);}
	
	/**
	 * User Product
	 * @param product = object
	 * @param List<Product> = list of objects
	 */
	
	@Override
	public String examineUserProduct(Product product) {return product.toString();}
	
	@Override
	public List<Product> examineUserInventory() {return userInstance.findAllProducts();}
	
	@Override
	public Product userPurchaseProduct(int code) {
		Product tempProduct = vendingMachineInstance.findProductByCode(code).get();
		userInstance.addProduct(tempProduct);
		vendingMachineInstance.removeProduct(tempProduct);
		return tempProduct;
	}
	
	@Override
	public void userUseProduct(Product product) {this.userInstance.useProduct(product);}
	
	
	/**
	 * Vending Machine Product
	 * @param product = object
	 * @param List<Product> = list of objects
	 */
	
	@Override
	public String examineVendingMachineProduct(Product product) {return product.toString();}
	
	@Override
	public List<Product> examineVendingMachineInventory() {return vendingMachineInstance.findAllProducts();}

}
