package se.lexicon.daniel.vending_machine.assignment4.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;
import se.lexicon.daniel.vending_machine.assignment4.service.VendingMachineService;
import se.lexicon.daniel.vending_machine.assignment4.service.VendingMachineServiceSignatures;
import se.lexicon.daniel.vending_machine.assignment4.utils.KeyboardInput;

public class ConsoleMenuController {
	private boolean running;
	private VendingMachineServiceSignatures vendingMachineServiceInstance;
	private int userSwitchInput;
	private List<Denomination> tempCoinPool;
	
	public ConsoleMenuController() {
		vendingMachineServiceInstance = VendingMachineService.getVendingMachineService();
		running = true;

		System.out.println("");
		System.out.println("|------------------------------------|");
		System.out.println("|    Vending Machine Assignment 4    |");
		System.out.println("|------------------------------------|");
		System.out.println("");
		
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void run() {
		startingUserInterface(); // What action do you want to take?
	}

	public void startingUserInterface() {
		boolean stopLoop = false;
		while(!stopLoop) {
			System.out.println("\n You stand in front of a vending machine \n" +
					" \n [Value Inserted] " + vendingMachineServiceInstance.getInBetweenCoinsStorageCoinsValue() + " kr " +
					" \n [Vending Machine] " + vendingMachineServiceInstance.getVendingMachinensCoinsValue() + " kr " +
					" \n [Wallet] " + vendingMachineServiceInstance.getUsersCoinsValue() + " kr " + "\n" +
					" \n [1] Examine the product in the machine. \n" +
					" [2] Insert coin in to the machin. \n" +
					" [3] Purchase a product. \n" +
					" [4] Examine your inventory for coins and products. \n" +
					" [5] Use product. \n" +
					" [6] leave the machine. \n");
			
			userSwitchInput = KeyboardInput.getInt();
			switch (userSwitchInput) {
			case 1:
				
				System.out.println("");
				System.out.println("|---------------------|");
				System.out.println("| Examine Products... |");
				System.out.println("|---------------------|");
				System.out.println("");
				examineProducts();
				break;
			case 2:
				System.out.println("");
				System.out.println("|----------------|");
				System.out.println("| Insert Coin... |");
				System.out.println("|----------------|");
				System.out.println("");
				insertCoin();
				break; 
			case 3:
				System.out.println("");
				System.out.println("|---------------------|");
				System.out.println("| Purchase Product... |");
				System.out.println("|---------------------|");
				System.out.println("");
				purchaseProduct();
				break;
			case 4:
				System.out.println("");
				System.out.println("|-------------------------------------------|");
				System.out.println("| Eamine inventory for product and coins... |");
				System.out.println("|-------------------------------------------|");
				System.out.println("");
				// examineInventoryController();
				break;
			case 5:
				System.out.println("");
				System.out.println("|-----------------------------|");
				System.out.println("| Use product in inventory... |");
				System.out.println("|-----------------------------|");
				System.out.println("");
				// useProductController();
				break;
			case 6:
				System.out.println("");
				System.out.println("|-----------------------|");
				System.out.println("| Ask for the change... |");
				System.out.println("|-----------------------|");
				System.out.println("");
				returnChange();
				break;
			case 7:
				System.out.println("");
				System.out.println("|------------------------------|");
				System.out.println("| leave the vending machine... |");
				System.out.println("|------------------------------|");
				System.out.println("");
				stopLoop = true;
				break;
			default:
				System.out.println("");
				System.out.println("|-------------------|");
				System.out.println("| No such choice... |");
				System.out.println("|-------------------|");
				System.out.println("");
			}
		}
	}

	private void returnChange() {
		vendingMachineServiceInstance.addCoinsCollectionToUser(
				vendingMachineServiceInstance.removeCoinsCollectionFromInBetweenStorage(
						vendingMachineServiceInstance.getInBetweenCoinsStorageCoins()));
	}

	private void purchaseProduct() {
		// TODO Auto-generated method stub
		System.out.println("\n Standing in front of the vending machine \n"
				+ "\n What product do you want to purchase \n"
				+ "Product code... ");
		int userInputCode = KeyboardInput.getInt();
		Product tempProduct = vendingMachineServiceInstance.userPurchaseProduct(userInputCode);
		// tempCoinPool -= tempProduct.getProductPrice();
	}

	private void insertCoin() {
		boolean stopLoop = false;
		while(!stopLoop) {
			System.out.println("\n Standing in front of the vending machine you start inserting coins \n"
					+ "\n [1]" + Denomination._1KR.toString()
					+ "\n [2]" + Denomination._5KR.toString()
					+ "\n [3]" + Denomination._10KR.toString()
					+ "\n [4]" + Denomination._20KR.toString()
					+ "\n [5]" + Denomination._50KR.toString()
					+ "\n [6]" + Denomination._100KR.toString()
					+ "\n [7]" + Denomination._500KR.toString()
					+ "\n [8]" + Denomination._1000KR.toString()
					+ "\n [9] Stop inserting coins");
			
			userSwitchInput = KeyboardInput.getInt();
			switch (userSwitchInput) {
				case 1: 
					vendingMachineServiceInstance.removeCoinFromUser(Denomination._1KR);
					vendingMachineServiceInstance.addCoinToInBetweenStorage(Denomination._1KR);
					;break;
				case 2: 
					vendingMachineServiceInstance.removeCoinFromUser(Denomination._5KR);
					vendingMachineServiceInstance.addCoinToInBetweenStorage(Denomination._5KR);
					;break;
				case 3: 
					vendingMachineServiceInstance.removeCoinFromUser(Denomination._10KR);
					vendingMachineServiceInstance.addCoinToInBetweenStorage(Denomination._10KR);
					break; 
				case 4: 
					vendingMachineServiceInstance.removeCoinFromUser(Denomination._20KR);
					vendingMachineServiceInstance.addCoinToInBetweenStorage(Denomination._20KR);
					break; 
				case 5: 
					vendingMachineServiceInstance.removeCoinFromUser(Denomination._50KR);
					vendingMachineServiceInstance.addCoinToInBetweenStorage(Denomination._50KR);
					break;  
				case 6: 
					vendingMachineServiceInstance.removeCoinFromUser(Denomination._100KR);
					vendingMachineServiceInstance.addCoinToInBetweenStorage(Denomination._100KR);
					break;   
				case 7: 
					vendingMachineServiceInstance.removeCoinFromUser(Denomination._500KR);
					vendingMachineServiceInstance.addCoinToInBetweenStorage(Denomination._500KR);
					break;   
				case 8: 
					vendingMachineServiceInstance.removeCoinFromUser(Denomination._1000KR);
					vendingMachineServiceInstance.addCoinToInBetweenStorage(Denomination._1000KR);
					break;   
				case 9: stopLoop = true; break;
				default: System.out.println("Wrong input");
			}
		}
	}

	private void examineProducts() {
		System.out.println("\n Examining the vending machines products \n");
		
        // Get element stream them and filter them with distinctByKey
        List<Product> distinctElements = vendingMachineServiceInstance.examineVendingMachineInventory().stream()
                                            .filter(KeyboardInput.distinctByKey(p -> p.getProductCode()) )
                                            .collect( Collectors.toList());
        
        // Let's verify distinct elements
        distinctElements.forEach(p->System.out.print(p.StringBuilder()));
        
	}
}
