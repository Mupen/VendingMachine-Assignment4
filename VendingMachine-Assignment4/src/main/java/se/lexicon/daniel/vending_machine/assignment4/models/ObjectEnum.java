package se.lexicon.daniel.vending_machine.assignment4.models;

import java.util.UUID;

public class ObjectEnum {
	
	// Data type variables
	private final String id = UUID.randomUUID().toString();
	private final Denomination denomination;
	private int amount = 1;
	
	// Constructor
	public ObjectEnum(Denomination denomination) {this.denomination = denomination;}
	
	// Getters 
	public String getId() {return id;}
	
	public int getAmount() {return amount;}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
	
	public void subAmount(int amount) {
		this.amount -= amount;
	}

	public Denomination getDenomination() {return denomination;}

	
	
}
