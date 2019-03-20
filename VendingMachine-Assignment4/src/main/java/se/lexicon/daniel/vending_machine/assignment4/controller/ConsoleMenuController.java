package se.lexicon.daniel.vending_machine.assignment4.controller;
import java.util.Arrays;
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
	private int tempCoinPool;
	
	public ConsoleMenuController() {
		
		vendingMachineServiceInstance = VendingMachineService.getVendingMachineService();
		vendingMachineServiceInstance.UserDefaultLoadStart();
		vendingMachineServiceInstance.VendingMachineDefaultLoadStart();
		
		
		// System.out.println();
		// vendingMachineServiceInstance.findAllCoins().forEach(e->e.getValue());
		

		
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
					" \n [Value Inserted] " + tempCoinPool + " kr " +
					" \n [Vending Machine] " + vendingMachineServiceInstance. + " kr " +
					" \n [Wallet] " + vendingMachineServiceInstance.getUserCashAmount() + " kr " + "\n" +
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

	private void purchaseProduct() {
		// TODO Auto-generated method stub
		System.out.println("\n Standing in front of the vending machine \n"
				+ "\n What product do you want to purchase \n"
				+ "Product code... ");
		int userInputCode = KeyboardInput.getInt();
		Product tempProduct = vendingMachineServiceInstance.userPurchaseProduct(userInputCode);
		tempCoinPool -= tempProduct.getProductPrice();
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
				case 1: tempCoinPool += Denomination._1KR.getValue();break;
				case 2: tempCoinPool += Denomination._5KR.getValue();break;
				case 3: tempCoinPool += Denomination._10KR.getValue();break; 
				case 4: tempCoinPool += Denomination._20KR.getValue();break; 
				case 5: tempCoinPool += Denomination._50KR.getValue();break; 
				case 6: tempCoinPool += Denomination._100KR.getValue();break; 
				case 7: tempCoinPool += Denomination._500KR.getValue();break; 
				case 8: tempCoinPool += Denomination._1000KR.getValue();break; 
				case 9: stopLoop = true; break;
				default: System.out.println("Wrong input");
			}
		}
		vendingMachineServiceInstance.addCashToUser(-tempCoinPool);
	}

	private void examineProducts() {
		System.out.println("\n Examining the vending machines products \n");
		vendingMachineServiceInstance.examineVendingMachineInventory().forEach(n -> System.out.print(n.StringBuilder()));
	}
}
