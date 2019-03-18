package se.lexicon.daniel.vending_machine.assignment4.models;

public class Food extends Product {
	private String foodtype;
	private String taste;

	/**
	 * @param productId is an int
	 * @param productName is an String
	 * @param productCode is an int
	 * @param productPrice is an int
	 * @param foodtype is an String
	 * @param taste is an String
	 * @param productPackaging is an String
	 * @param productWeight is an int
	 */
	
	public Food(String productName, int productCode, int productPrice, String foodtype, String taste, String productPackaging, int productWeight) {
		super(productName, productCode, productPrice, productPackaging, productWeight);
		this.foodtype = foodtype;
		this.taste = taste;
	}

	@Override
	public String Examine() {
		String productData = "Food: "+ super.getProductName() + " (" + foodtype + ") with "+ taste + " " + super.getProductWeight() + " g " + super.getProductPrice() + " kr ";
		return productData;
	}

	@Override
	public String Use() {
		return "Eating " + super.getProductName() +" *chew chew*";
	}
	
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
		
		sb.append(" [Foodtype] = ");
		sb.append(this.foodtype + "\n");
		
		sb.append(" [Taste] = ");
		sb.append(this.taste + "\n");
		
		sb.append(" [Packaging] = ");
		sb.append(super.getProductPackaging() + "\n");
		
		sb.append(" [Weight] = ");
		sb.append(super.getProductPackaging() + "\n");
		
		return sb.toString(); 
	}
}
