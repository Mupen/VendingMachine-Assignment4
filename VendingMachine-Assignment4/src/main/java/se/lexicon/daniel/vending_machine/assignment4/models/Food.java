package se.lexicon.daniel.vending_machine.assignment4.models;

public class Food extends Product 
{
	private String foodtype;
	private String taste;
	private int weight;

	/**
	 * @param id an int
	 * @param name 
	 * @param price
	 * @param foodtype for ex. meat, bread
	 * @param taste type of spice etc
	 * @param weight
	 */
	public Food(int id, String name, int price, int weight, String foodtype, String taste) {
		super(id, name, price);
		this.foodtype = foodtype;
		this.taste = taste;
		this.weight = weight;
	}

	@Override
	public String Examine() {
		String productData = "Food: "+ super.getName() + " (" + foodtype + ") with "+ taste + " " + weight + " g " + super.getPrice() + " kr ";
		return productData;
	}

	@Override
	public String Use() {
		return "Eating " + super.getName() +" *chew chew*";
	}

	@Override
	public String toString() {
		return super.getName() + " " + weight + " g " + super.getPrice() + " kr ";
	}

}
