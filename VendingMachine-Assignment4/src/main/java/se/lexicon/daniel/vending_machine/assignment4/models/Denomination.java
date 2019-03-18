package se.lexicon.daniel.vending_machine.assignment4.models;

public enum Denomination {
	_1KR(1),
	_2KR(2),
	_5KR(5),
	_10KR(10),
	_20KR(20),
	_50KR(30),
	_100KR(100),
	_200KR(200),
	_500KR(500),
	_1000KR(1000);
	private int totalValue;
	

	private Denomination (int value) {
		this.totalValue = totalValue;
	}

	public int getValue() {
		return this.totalValue;
	}

	@Override
	public String toString() {
		return this.totalValue + " Kr";
	}
}
