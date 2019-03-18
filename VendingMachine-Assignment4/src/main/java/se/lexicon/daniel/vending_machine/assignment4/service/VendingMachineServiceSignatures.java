package se.lexicon.daniel.vending_machine.assignment4.service;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public interface VendingMachineServiceSignatures {
	
	public void VendingMachineDefaultLoadStart();
	public void UserDefaultLoadStart();
	
	public void userExamineProduct(Product product);
	
	public int getVendingMachineCashAmount();
	
	public int getUserCashAmount();
	
	public void addCashToVendingMachine(int cash);
	
	public void addCashToUser(int cash);
	
	public void userPurchaseProduct(int code);
	
	public void userUseProduct(Product product);

	public void userExamineInventory();
}
