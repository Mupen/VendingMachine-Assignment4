package se.lexicon.daniel.vending_machine.assignment4.models;

public class User {
	private String selection;
	private String inventory;
	private int cash;
	
	public User() {
		this.selection = "None";
		this.inventory = "Empty";
		this.cash = 0;
	}
	
	public int getCashAmount() {return cash;}
	public void setCashAmount(int cash) {this.cash = cash;}
	public void addCashAmount(int cash) {this.cash += cash;}

	public void getInventoryItem() {}
	public void setInventoryItem() {}
	public void addInventoryItem() {}
	
	
	public String getSelection() {return selection;}
	
	public void Select(String selection) {this.selection = selection;}
	
	public String getInventory() {return inventory;}

	public void addToInventory(String inventory) {this.inventory = inventory;}
}
