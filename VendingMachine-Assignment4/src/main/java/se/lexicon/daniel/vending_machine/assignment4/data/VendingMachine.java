package se.lexicon.daniel.vending_machine.assignment4.data;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class VendingMachine implements VendingMachineSignatures {
	int moneyPool;
	int[] denomination;
	Product[] products;
	
	public void examineProduct() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean insertCash(int cash) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Product purchaseProduct(int cash, int productNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public int returnChange() {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
}
