package se.lexicon.daniel.vending_machine.assignment4.models;

public class Drink extends Product {
	private Integer volume;
	private boolean carbonated;
	private String taste;

	/**
	 * @param productId is an Integer sequencer
	 * @param productName is an String
	 * @param productCode is an Integer
	 * @param productPrice is an Integer
	 * @param volume is an Integer
	 * @param carbonated is an boolean
	 * @param taste is an String
	 * @param productPackaging is an String
	 * @param productWeight is an Integer
	 */
	
	public Drink(String productName, Integer productCode, Integer productPrice, Integer volume, 
			boolean carbonated, String taste, String productPackaging, Integer productWeight) {
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
	 * @param productId is an Integer
	 * @param productName is an String
	 * @param productCode is an Integer
	 * @param productPrice is an Integer
	 * @param volume is an Integer
	 * @param carbonated is an boolean
	 * @param taste is an String
	 * @param packaging is an String
	 */

	@Override
	public String StringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n *** FightingLedger *** \n");
		
		sb.append(" [Id] = ");
		sb.append(super.getProductId() + "\n");
		
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
