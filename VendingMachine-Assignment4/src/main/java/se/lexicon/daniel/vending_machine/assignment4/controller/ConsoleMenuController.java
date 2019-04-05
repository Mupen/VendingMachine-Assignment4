package se.lexicon.daniel.vending_machine.assignment4.controller;
import java.util.List;
import java.util.stream.Collectors;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;
import se.lexicon.daniel.vending_machine.assignment4.service.VendingMachineService;
import se.lexicon.daniel.vending_machine.assignment4.service.VendingMachineServiceSignatures;
import se.lexicon.daniel.vending_machine.assignment4.utils.KeyboardInput;

public class ConsoleMenuController {
	private boolean running;
	private VendingMachineServiceSignatures serviceInstance;
	private int userSwitchInput;
	private int userInputAmount;
	private List<Denomination> tempCoinPool;
	
	ObjectEnum one = new ObjectEnum(Denomination._1KR);
	ObjectEnum five = new ObjectEnum(Denomination._5KR);
	ObjectEnum ten = new ObjectEnum(Denomination._10KR);
	ObjectEnum twenty = new ObjectEnum(Denomination._20KR);
	ObjectEnum fifty = new ObjectEnum(Denomination._50KR);
	ObjectEnum oneHundred = new ObjectEnum(Denomination._100KR);
	ObjectEnum fiveHundred = new ObjectEnum(Denomination._500KR);
	ObjectEnum oneThousand = new ObjectEnum(Denomination._1000KR);
	
	public ConsoleMenuController() {
		serviceInstance = VendingMachineService.getVendingMachineService();
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
					" \n [Value Inserted] " + serviceInstance.getInBetweenCoinsStorageCoinsValue() + " kr " +
					" \n [Vending Machine] " + serviceInstance.getVendingMachinensCoinsValue() + " kr " +
					" \n [Wallet] " + serviceInstance.getUsersCoinsValue() + " kr " + "\n" +
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
		serviceInstance.returnCoinsFromVendingMachinen();
	}

	private void purchaseProduct() {
		System.out.println("\n Standing in front of the vending machine \n"
				+ "\n What product do you want to purchase \n"
				+ "Product code... ");
		int userInputCode = KeyboardInput.getInt();
		Product tempProduct = serviceInstance.userPurchaseProduct(userInputCode);
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
			System.out.println("\n Amount? \n");
			userInputAmount = KeyboardInput.getInt();
			
			switch (userSwitchInput) {
				case 1: 
					serviceInstance.removeCoinsFromUser(one, userInputAmount);
					serviceInstance.addCoinsToVendingMachinen(one, userInputAmount);
					;break;
				case 2: 
					serviceInstance.removeCoinsFromUser(five, userInputAmount);
					serviceInstance.addCoinsToVendingMachinen(five, userInputAmount);
					;break;
				case 3: 
					serviceInstance.removeCoinsFromUser(ten, userInputAmount);
					serviceInstance.addCoinsToVendingMachinen(ten, userInputAmount);
					break; 
				case 4: 
					serviceInstance.removeCoinsFromUser(twenty, userInputAmount);
					serviceInstance.addCoinsToVendingMachinen(twenty, userInputAmount);
					break; 
				case 5: 
					serviceInstance.removeCoinsFromUser(fifty, userInputAmount);
					serviceInstance.addCoinsToVendingMachinen(fifty, userInputAmount);
					break;  
				case 6: 
					serviceInstance.removeCoinsFromUser(oneHundred, userInputAmount);
					serviceInstance.addCoinsToVendingMachinen(oneHundred, userInputAmount);
					break;   
				case 7: 
					serviceInstance.removeCoinsFromUser(fiveHundred, userInputAmount);
					serviceInstance.addCoinsToVendingMachinen(fiveHundred, userInputAmount);
					break;   
				case 8: 
					serviceInstance.removeCoinsFromUser(oneThousand, userInputAmount);
					serviceInstance.addCoinsToVendingMachinen(oneThousand, userInputAmount);
					break;   
				case 9: stopLoop = true; break;
				default: System.out.println("Wrong input");
			}
		}
	}

	private void examineProducts() {
		System.out.println("\n Examining the vending machines products \n");
		
        // Get element stream them and filter them with distinctByKey
        List<Product> distinctElements = serviceInstance.examineVendingMachineInventory().stream()
                                            .filter(KeyboardInput.distinctByKey(p -> p.getProductCode()) )
                                            .collect( Collectors.toList());
        
        // Let's verify distinct elements
        distinctElements.forEach(p->System.out.print(p.StringBuilder()));
        
	}
}
