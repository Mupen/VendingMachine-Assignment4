package se.lexicon.daniel.vending_machine.assignment4.data;

public interface UserSignatures {
	void useItem();
	String getSelection();
	void Select(String selection);
	String getInventory();
	void addToInventory(String inventory);
	int getMoney();
}
