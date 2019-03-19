package se.lexicon.daniel.vending_machine.assignment4.controller;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
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
					" \n [Vending Machine] " + vendingMachineServiceInstance.getVendingMachineCashAmount() + " kr " +
					" \n [Wallet] " + vendingMachineServiceInstance.getUserCashAmount() + " kr " + "\n" +
					" \n [1] Examine the product " + Denomination._5KR.getValue() + " in the machine. \n" +
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
				examineProducts(); // What action do you want to take?
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
				// userInputCashAmount = KeyboardInput.getInt();
				// userInputProductNumber = KeyboardInput.getInt();
				// vendingMachineInstance.purchaseProduct(userInputCashAmount, userInputProductNumber);
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

	private void insertCoin() {
		boolean stopLoop = false;
		while(!stopLoop) {
			System.out.println("\n Standing in front of the vending machine you start inserting coins \n"
					+ "\n [1] 1kr"
					+ "\n [2] 2kr"
					+ "\n [3] 5kr"
					+ "\n [4] 10kr"
					+ "\n [5] Stop inserting coins");
			
			userSwitchInput = KeyboardInput.getInt();
			switch (userSwitchInput) {
				case 1: 
					vendingMachineServiceInstance.addCashToVendingMachine(1); 
					vendingMachineServiceInstance.addCashToUser(-1); 
				break;
				case 2: 
					vendingMachineServiceInstance.addCashToVendingMachine(2); 
					vendingMachineServiceInstance.addCashToUser(-2);
				break; 
				case 3: 
					vendingMachineServiceInstance.addCashToVendingMachine(5); 
					vendingMachineServiceInstance.addCashToUser(-5);
				break;
				case 4: 
					vendingMachineServiceInstance.addCashToVendingMachine(10); 
					vendingMachineServiceInstance.addCashToUser(-10);
				break;
				case 5: stopLoop = true; break;
				default: System.out.println("Wrong input");
				
				
			}
		}
	}

	private void examineProducts() {
		System.out.println("\n Examining the vending machines products \n");
		vendingMachineServiceInstance.examineVendingMachineInventory().forEach(n -> System.out.print(n.StringBuilder()));
	}
}
