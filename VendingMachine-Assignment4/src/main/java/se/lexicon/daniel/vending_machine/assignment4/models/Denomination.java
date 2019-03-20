package se.lexicon.daniel.vending_machine.assignment4.models;

public enum Denomination {
	_1KR(1),
	_5KR(5),
	_10KR(10),
	_20KR(20),
	_50KR(50),
	_100KR(100),
	_500KR(500),
	_1000KR(1000);
	
	private int totalValue;

	private Denomination(int value) { // give the enum the value to the left
		this.totalValue = value;
	}

	public int getValue() { // give the left value of the enum
		return this.totalValue;
	}

	public String StringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n *** Coin Storage *** \n");
		
		sb.append(" [Coin] = ");
		sb.append(totalValue + " Kr \n");
		
		return sb.toString(); 
	}
}
