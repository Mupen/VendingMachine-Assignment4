package se.lexicon.daniel.vending_machine.assignment4.models;

public abstract class Product {
	private int id;
	private String name;
	private int price;
	
	public Product(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}

	
	/** 
	 * @return a string with information
	 */
	public abstract String Examine();

	/**
	 * @return a string with info about how to use the product
	 */
	public abstract String Use();
	
	public abstract String toString();
	
}
