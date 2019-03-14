package se.lexicon.daniel.vending_machine.assignment4.service;

import se.lexicon.daniel.vending_machine.assignment4.data.User;
import se.lexicon.daniel.vending_machine.assignment4.data.UserSignatures;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachine;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;
import se.lexicon.daniel.vending_machine.assignment4.models.ChewingGum;
import se.lexicon.daniel.vending_machine.assignment4.models.Drink;
import se.lexicon.daniel.vending_machine.assignment4.models.Food;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class VendingMachineService implements VendingMachineServiceSignatures {
	
	private static final VendingMachineServiceSignatures vendingMachineServiceInstance = new VendingMachineService();
	public static VendingMachineServiceSignatures getVendingMachineService() {return vendingMachineServiceInstance;}
	
	private UserSignatures userInstance;
	private VendingMachineSignatures vendingMachineInstance;
	
	VendingMachineService() {
		userInstance = User.getUserInstance();
		vendingMachineInstance = VendingMachine.getVendingMachineInstance();
	}
	
	public void VendingMachineDefaultLoadStart() {
		this.vendingMachineInstance.setCashAmount(200); // 100k
		
		/**
		 * @param productId is an Integer sequencer
		 * @param productName is an String
		 * @param productCode is an Integer
		 * @param productPrice is an Integer
		 * @param volume is an Integer
		 * @param carbonated is an boolean
		 * @param taste is an String
		 * @param productPackaging is an String
		 * @param productWeight is an Integer
		 */
		
		// String productName, Integer productCode, Integer productPrice, String productPackaging, Integer productWeight, Integer volume, 
		// boolean carbonated, String taste, String packaging, Integer weight
		
		this.vendingMachineInstance.addToInventory(new Drink("Coca Cola Zero", 01, 12, 33, true, "Sodium citrate", "Can", 360));
		this.vendingMachineInstance.addToInventory(new Drink("Coca Cola Zero", 01, 12, 33, true, "Sodium citrate", "Can", 360));
		this.vendingMachineInstance.addToInventory(new Drink("Coca Cola Zero", 01, 12, 33, true, "Sodium citrate", "Can", 360));
		
		this.vendingMachineInstance.addToInventory(new Drink("Coca cola light", 02, 12, 33, true, "Citric acid", "Can", 360));
		this.vendingMachineInstance.addToInventory(new Drink("Coca cola light", 02, 12, 33, true, "Citric acid", "Can", 360));
		this.vendingMachineInstance.addToInventory(new Drink("Coca cola light", 02, 12, 33, true, "Citric acid", "Can", 360));
		
		this.vendingMachineInstance.addToInventory(new Drink("Fanta Orange", 03, 12, 33, true, "Orange", "Can", 360));
		this.vendingMachineInstance.addToInventory(new Drink("Fanta Orange", 03, 12, 33, true, "Orange", "Can", 360));
		this.vendingMachineInstance.addToInventory(new Drink("Fanta Orange", 03, 12, 33, true, "Orange", "Can", 360));
		
		/**
		 * Food have the following values
		 * @param productId is an Integer sequencer
		 * @param productName is an String
		 * @param productCode is an Integer
		 * @param productPrice is an Integer
		 * @param foodtype is an String
		 * @param taste is an string
		 * @param productPackaging is an String
		 * @param weight is an Integer
		 */

		this.vendingMachineInstance.addToInventory(new Food("Pizza Mozzarella", 04, 32, "Frozen", "Chesey with bread", "Cartons", 450));
		this.vendingMachineInstance.addToInventory(new Food("Pizza Mozzarella", 04, 32, "Frozen", "Chesey with bread", "Cartons", 450));
		this.vendingMachineInstance.addToInventory(new Food("Pizza Mozzarella", 04, 32, "Frozen", "Chesey with bread", "Cartons", 450));

		this.vendingMachineInstance.addToInventory(new Food("Ost hamburgare", 05, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));
		this.vendingMachineInstance.addToInventory(new Food("Ost hamburgare", 05, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));
		this.vendingMachineInstance.addToInventory(new Food("Ost hamburgare", 05, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));
		
		this.vendingMachineInstance.addToInventory(new Food("Beer sausage", 06, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		this.vendingMachineInstance.addToInventory(new Food("Beer sausage", 06, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		this.vendingMachineInstance.addToInventory(new Food("Beer sausage", 06, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		/**
		 * Chewing Gum have the following values
		 * @param productId is an Integer sequencer
		 * @param productName is an String
		 * @param productCode is an Integer
		 * @param productPrice is an Integer
		 * @param amount is an Integer
		 * @param taste is an String
		 * @param packaging is an String
		 */

		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
		
		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
		
		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
		this.vendingMachineInstance.addToInventory(new ChewingGum(null, null, null, null, null, null, null, null));
	}
	
	public void UserDefaultLoadStart() {
		this.userInstance.addCashAmount(100);
	}
	
	public void userUseProduct(Product product) {
		this.userInstance.useProduct(product);
	}

	public void userExamineInventory() {
		userInstance.findAllProducts().toString();
	}

	public void userPurchaseProduct(Integer code) {
		Product tempProduct = vendingMachineInstance.findProductByCode(code).get();
		userInstance.addToInventory(tempProduct);
		vendingMachineInstance.removeProduct(tempProduct);
	}

	public void userInsertCoin() {
		// TODO Auto-generated method stub
		
	}

	public void userExamineProduct() {
		// TODO Auto-generated method stub
		
	}

}
