package se.lexicon.daniel.vending_machine.assignment4.models;

public class Drink extends Product {
	private int volume;
	private boolean carbonated;
	private String taste;
	private String packaging;

	public Drink(int id, String name, int price, int volume, boolean carbonated, String taste, String packaging) {
		super(id, name, price);
		this.volume = volume;
		this.carbonated = carbonated;
		this.taste = taste;
		this.packaging = packaging;
	}

	@Override
	public String Examine() {
		String productData = "Drink: "+ super.getName() + " with " + taste + " " + (carbonated ? "carbonated" : "") + " "
				+ volume / 10 + " cl " + "in " + packaging+" "+ super.getPrice() + " kr ";

		return productData;
	}

	@Override
	public String Use() {
		return "Drinking " + super.getName() +" *slurp slurp*";
	}

	@Override
	public String toString() {
		return super.getName() + " " + volume / 10 + " cl " + super.getPrice() + " kr ";
	}

}
