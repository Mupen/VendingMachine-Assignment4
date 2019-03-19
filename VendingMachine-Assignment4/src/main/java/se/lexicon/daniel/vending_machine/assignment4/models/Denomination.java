package se.lexicon.daniel.vending_machine.assignment4.models;

public enum Denomination {
	_1KR(1),
	_2KR(2),
	_5KR(5),
	_10KR(10);
	
	private int totalValue;

	private Denomination(int value) { // give the enum the value to the left
		this.totalValue = value;
	}

	public int getValue() { // give the left value of the enum
		return this.totalValue;
	}

	@Override
	public String toString() {
		return this.totalValue + " Kr";
	}
}
