package se.lexicon.daniel.vending_machine.assignment4.models;

public class Drink extends Product {
	private int volume;
	private boolean carbonated;
	private String taste;

	/**
	 * @param productId is an int sequencer
	 * @param productName is an String
	 * @param productCode is an int
	 * @param productPrice is an int
	 * @param volume is an int
	 * @param carbonated is an boolean
	 * @param taste is an String
	 * @param productPackaging is an String
	 * @param productWeight is an int
	 */
	
	public Drink(String productName, int productCode, int productPrice, int volume, 
			boolean carbonated, String taste, String productPackaging, int productWeight) {
		super(productName, productCode, productPrice, productPackaging, productWeight);
		this.volume = volume;
		this.carbonated = carbonated;
		this.taste = taste;
	}



	@Override
	public String Examine() {
		String productData = "Drink: "+ super.getProductName() + " with " + taste + " " + (carbonated ? "carbonated" : "") + " "
				+ volume / 10 + " cl " + "in " + super.getProductPackaging() +" "+ super.getProductPrice() + " kr ";

		return productData;
	}

	@Override
	public String Use() {
		return "Drinking " + super.getProductName() +" *slurp slurp*";
	}
	
	/**
	 * @param productId is an int
	 * @param productName is an String
	 * @param productCode is an int
	 * @param productPrice is an int
	 * @param volume is an int
	 * @param carbonated is an boolean
	 * @param taste is an String
	 * @param packaging is an String
	 */

	@Override
	public String StringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n *** Drink Products*** \n");
		
		sb.append(" [Name] = ");
		sb.append(super.getProductName() + "\n");
		
		sb.append(" [Code] = ");
		sb.append(super.getProductCode() + "\n");
		
		sb.append(" [Price] = ");
		sb.append(super.getProductPrice() + "\n");
		
		sb.append(" [Volume] = ");
		sb.append(volume + "\n");
		
		sb.append(" [Carbonated] = ");
		sb.append(carbonated + "\n");
		
		sb.append(" [Taste] = ");
		sb.append(taste + "\n");
		
		sb.append(" [Packaging] = ");
		sb.append(super.getProductPackaging() + "\n");
		
		sb.append(" [Weight] = ");
		sb.append(super.getProductWeight() + "\n");
		
		return sb.toString(); 
	}

}
