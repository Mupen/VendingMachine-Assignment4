package se.lexicon.daniel.vending_machine.assignment4.service;

import java.util.List;
import se.lexicon.daniel.vending_machine.assignment4.data.User;
import se.lexicon.daniel.vending_machine.assignment4.data.UserSignatures;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachine;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;
import se.lexicon.daniel.vending_machine.assignment4.models.ChewingGum;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Drink;
import se.lexicon.daniel.vending_machine.assignment4.models.Food;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class VendingMachineService implements VendingMachineServiceSignatures {

	private static final VendingMachineServiceSignatures vendingMachineServiceInstance = new VendingMachineService();
	public static VendingMachineServiceSignatures getVendingMachineService() {return vendingMachineServiceInstance;}

	private List<Denomination> inBetweenCoinsStorage;
	private UserSignatures userInstance;
	private VendingMachineSignatures vendingMachineInstance;

	VendingMachineService() {
		userInstance = User.getUserInstance();
		vendingMachineInstance = VendingMachine.getVendingMachineInstance();
	}

	@Override
	public void VendingMachineDefaultLoadStart() {

		/**
		 * @param productId is an int sequencer
		 * @param productName is an String
		 * @param productCode is an int
		 * @param productPrice is an int
		 * @param volume is an int
		 * @param carbonated is an boolean
		 * @param taste is an String
		 * @param productPackaging is an String
		 * @param productWeight is an int
		 */

		// String productName, int productCode, int productPrice, String productPackaging, int productWeight, int volume, 
		// boolean carbonated, String taste, String packaging, int weight

		this.vendingMachineInstance.addProduct(new Drink("Coca Cola Zero", 1, 12, 33, true, "Sodium citrate", "Can", 360));
		this.vendingMachineInstance.addProduct(new Drink("Coca Cola Zero", 1, 12, 33, true, "Sodium citrate", "Can", 360));
		this.vendingMachineInstance.addProduct(new Drink("Coca Cola Zero", 1, 12, 33, true, "Sodium citrate", "Can", 360));

		this.vendingMachineInstance.addProduct(new Drink("Coca cola light", 2, 12, 33, true, "Citric acid", "Can", 360));
		this.vendingMachineInstance.addProduct(new Drink("Coca cola light", 2, 12, 33, true, "Citric acid", "Can", 360));
		this.vendingMachineInstance.addProduct(new Drink("Coca cola light", 2, 12, 33, true, "Citric acid", "Can", 360));

		this.vendingMachineInstance.addProduct(new Drink("Fanta Orange", 3, 12, 33, true, "Orange", "Can", 360));
		this.vendingMachineInstance.addProduct(new Drink("Fanta Orange", 3, 12, 33, true, "Orange", "Can", 360));
		this.vendingMachineInstance.addProduct(new Drink("Fanta Orange", 3, 12, 33, true, "Orange", "Can", 360));

		/**
		 * Food have the following values
		 * @param productId is an int sequencer
		 * @param productName is an String
		 * @param productCode is an int
		 * @param productPrice is an int
		 * @param foodtype is an String
		 * @param taste is an string
		 * @param productPackaging is an String
		 * @param weight is an int
		 */

		this.vendingMachineInstance.addProduct(new Food("Pizza Mozzarella", 4, 32, "Frozen", "Chesey with bread", "Cartons", 450));
		this.vendingMachineInstance.addProduct(new Food("Pizza Mozzarella", 4, 32, "Frozen", "Chesey with bread", "Cartons", 450));
		this.vendingMachineInstance.addProduct(new Food("Pizza Mozzarella", 4, 32, "Frozen", "Chesey with bread", "Cartons", 450));

		this.vendingMachineInstance.addProduct(new Food("Ost hamburgare", 5, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));
		this.vendingMachineInstance.addProduct(new Food("Ost hamburgare", 5, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));
		this.vendingMachineInstance.addProduct(new Food("Ost hamburgare", 5, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));

		this.vendingMachineInstance.addProduct(new Food("Beer sausage", 6, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		this.vendingMachineInstance.addProduct(new Food("Beer sausage", 6, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		this.vendingMachineInstance.addProduct(new Food("Beer sausage", 6, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		/**
		 * Chewing Gum have the following values
		 * @param productId is an int sequencer
		 * @param productName is an String
		 * @param productCode is an int
		 * @param productPrice is an int
		 * @param amount is an int
		 * @param taste is an String
		 * @param packaging is an String
		 * @param Weight is an String
		 */

		this.vendingMachineInstance.addProduct(new ChewingGum("Doublemint", 7, 30, 20, "Mint", "Bottle 150ml", 72));
		this.vendingMachineInstance.addProduct(new ChewingGum("Doublemint", 7, 30, 20, "Mint", "Bottle 150ml", 72));
		this.vendingMachineInstance.addProduct(new ChewingGum("Doublemint", 7, 30, 20, "Mint", "Bottle 150ml", 72));

		this.vendingMachineInstance.addProduct(new ChewingGum("Juicy Fruit", 8, 20, 25, "Banana", "Plastic bag", 42));
		this.vendingMachineInstance.addProduct(new ChewingGum("Juicy Fruit", 8, 20, 25, "Banana", "Plastic bag", 42));
		this.vendingMachineInstance.addProduct(new ChewingGum("Juicy Fruit", 8, 20, 25, "Banana", "Plastic bag", 42));

		this.vendingMachineInstance.addProduct(new ChewingGum("Dubble Bubble", 9, 10, 10, "Lemonade", "paper", 36));
		this.vendingMachineInstance.addProduct(new ChewingGum("Dubble Bubble", 9, 10, 10, "Lemonade", "paper", 36));
		this.vendingMachineInstance.addProduct(new ChewingGum("Dubble Bubble", 9, 10, 10, "Lemonade", "paper", 36));
	}
	
	@Override
	public void UserDefaultLoadStart() {this.userInstance.addProduct(new Drink("Coca Cola Zero", 1, 12, 33, true, "Sodium citrate", "Can", 360));}

	@Override
	public List<Denomination> getAllVendingMachinenCoins() {return vendingMachineInstance.getVendingMachineCoins();}
	
	@Override
	public List<Denomination> getAllUsersCoins() {return userInstance.getUserCoins();}
	
	@Override
	public int getUsersCoinsValue() {return userInstance.addCoinsTogether();}
	
	@Override
	public int getVendingMachinensCoinsValue() {return vendingMachineInstance.addCoinsTogether();}	

	@Override
	public void removeCoinsFromUser(List<Denomination> coins) {userInstance.removesCoins(coins);}
	
	@Override
	public void removeCoinsFromVendingMachinen(List<Denomination> coins) {vendingMachineInstance.removesCoins(coins);}	
	
	@Override
	public void addCoinsToUser(List<Denomination> coins) {userInstance.addCoins(coins);}
	
	@Override
	public void addCoinsToVendingMachinen(List<Denomination> coins) {vendingMachineInstance.addCoins(coins);}
	
	@Override
	public void userUseProduct(Product product) {this.userInstance.useProduct(product);}

	@Override
	public List<Product> examineUserInventory() {return userInstance.findAllProducts();}

	@Override
	public List<Product> examineVendingMachineInventory() {return vendingMachineInstance.findAllProducts();}

	@Override
	public String examineUserProduct(Product product) {return product.toString();}

	@Override
	public String examineVendingMachineProduct(Product product) {return product.toString();}

	@Override
	public Product userPurchaseProduct(int code) {
		Product tempProduct = vendingMachineInstance.findProductByCode(code).get();
		userInstance.addProduct(tempProduct);
		vendingMachineInstance.removeProduct(tempProduct);
		return tempProduct;
	}

















}
