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
	private int totalAmount = 1;

	private Denomination(int value) {
		this.totalValue = totalAmount * value;
	}
	
	public int getValue() {return this.totalValue;}
	
	public int getAmount() {return totalAmount;}

	public void addAmount(int amount) {this.totalAmount += amount;}
	
	public void subtractAmount(int amount) {this.totalAmount -= amount;}

	public String StringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n *** Coin Storage *** \n");
		
		sb.append(" [Coin] = ");
		sb.append(totalValue + " Kr \n");
		
		sb.append(" [Amount] = ");
		sb.append(totalAmount + " st \n");
		
		return sb.toString(); 
	}
}
