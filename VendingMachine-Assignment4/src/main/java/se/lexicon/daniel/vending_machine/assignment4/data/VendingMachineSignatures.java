package se.lexicon.daniel.vending_machine.assignment4.data;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineSignatures {
	void examineProduct();
	boolean insertCash(int Cash);
	Product purchaseProduct(int money, int prodNum);
	int returnChange();
	int getBalance();
}
