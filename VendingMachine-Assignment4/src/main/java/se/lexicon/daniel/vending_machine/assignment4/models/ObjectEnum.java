package se.lexicon.daniel.vending_machine.assignment4.models;

import java.util.UUID;

public class ObjectEnum {
	
	// Data type variables
	private final String id = UUID.randomUUID().toString();
	private final Denomination denomination;
	private int amount;
	
	// Constructor
	public ObjectEnum(Denomination denomination) {this.denomination = denomination;}
	
	// Getters 
	public String getId() {return id;}
	
	public int getAmount() {return amount;}
	
	public void addAmount(int add) {
		this.amount += add;
	}
	
	public void subAmount(int sub) {
		if(this.amount >= sub) {this.amount -= sub;}
		else {System.out.println("You can't remove more of a coins when the exist");}
	}

	public Denomination getDenomination() {return denomination;}

	
	
}
