package se.lexicon.daniel.vending_machine.assignment4.models;

public class ChewingGum extends Product {
	private int amount;
	private String taste;
	
	/**
	 * @param productId is an int
	 * @param productName is an String
	 * @param productCode is an int
	 * @param productPrice is an int
	 * @param amount is an int
	 * @param taste is an String
	 * @param productPackaging is an String
	 * @param productWeight is an int
	 */

	public ChewingGum(String productName, int productCode, int productPrice, int amount, 
			String taste, String productPackaging, int productWeight) {
		super(productName, productCode, productPrice, productPackaging, productWeight);
		this.amount = amount;
		this.taste = taste;
	}

	@Override
	public String Examine() {
		String productData = "Candy: " + super.getProductName() + " " + taste + " " + amount + " g in " + super.getProductPackaging() + " "
				+ super.getProductPrice() + " kr ";

		return productData;
	}

	@Override
	public String Use() {
		return "Eating " + super.getProductName() + " *nom nom*";
	}
	
	
	/**
	 * @param productId is an int
	 * @param productName is an String
	 * @param productCode is an int
	 * @param productPrice is an int
	 * @param amount is an int
	 * @param taste is an String
	 * @param packaging is an String
	 */

	@Override
	public String StringBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n *** Chewing Gum Products*** \n");
		
		sb.append(" [Name] = ");
		sb.append(super.getProductName() + "\n");
		
		sb.append(" [Code] = ");
		sb.append(super.getProductCode() + "\n");
		
		sb.append(" [Price] = ");
		sb.append(super.getProductPrice() + "\n");
		
		sb.append(" [Amount] = ");
		sb.append(amount + "\n");
		
		sb.append(" [Taste] = ");
		sb.append(taste + "\n");
		
		sb.append(" [Packaging] = ");
		sb.append(super.getProductPackaging() + "\n");
		
		sb.append(" [Weight] = ");
		sb.append(super.getProductWeight() + "\n");
		
		return sb.toString(); 
	}

}
