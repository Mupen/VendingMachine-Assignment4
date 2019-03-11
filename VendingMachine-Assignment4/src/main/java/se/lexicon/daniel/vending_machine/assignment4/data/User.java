package se.lexicon.daniel.vending_machine.assignment4.data;

public class User implements UserSignatures {
	private String selection;
	private String inventory;
	private int money;
	
	public User() {
		this.selection = "None";
		this.inventory = "Empty";
		this.money = 0;
	}
	
	public void useItem() {}
	
	public String getSelection() {return selection;}
	
	public void Select(String selection) {this.selection = selection;}
	
	public String getInventory() {return inventory;}

	public void addToInventory(String inventory) {this.inventory = inventory;}
	
	public int getMoney() {return money;}
}
