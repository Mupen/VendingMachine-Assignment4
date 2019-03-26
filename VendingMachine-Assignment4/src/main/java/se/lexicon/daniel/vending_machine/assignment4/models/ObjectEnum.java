package se.lexicon.daniel.vending_machine.assignment4.models;

import java.util.UUID;

public final class ObjectEnum {
	// Data type variables
	private final String id = UUID.randomUUID().toString();
	private final Denomination denomination;
	// Constructor
	public ObjectEnum(Denomination denomination) {this.denomination = denomination;}
	// Getters 
	public String getId() {return id;}
	public Denomination getDenomination() {return denomination;}

	
	
}
