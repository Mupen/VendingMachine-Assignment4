package se.lexicon.daniel.vending_machine.assignment4.models;

public class ChewingGum extends Product {
	private Integer amount;
	private String taste;
	
	/**
	 * @param productId is an Integer
	 * @param productName is an String
	 * @param productCode is an Integer
	 * @param productPrice is an Integer
	 * @param amount is an Integer
	 * @param taste is an String
	 * @param packaging is an String
	 */

	public ChewingGum(String productName, Integer productCode, Integer productPrice, String productPackaging, Integer productWeight, Integer amount, 
			String taste, String packaging) {
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
	 * @param productId is an Integer
	 * @param productName is an String
	 * @param productCode is an Integer
	 * @param productPrice is an Integer
	 * @param amount is an Integer
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
		
		sb.append(" [Amount] = ");
		sb.append(amount + "\n");
		
		sb.append(" [Taste] = ");
		sb.append(taste + "\n");
		
		sb.append(" [Packaging] = ");
		sb.append(super.getProductPackaging() + "\n");
		
		sb.append(" [Packaging] = ");
		sb.append(super.getProductWeight() + "\n");
		
		return sb.toString(); 
	}

}
