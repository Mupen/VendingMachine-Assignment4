package se.lexicon.daniel.vending_machine.assignment4.models;

public abstract class Product {
	private int productId;
	private String productName;
	private int productPrice;
	
	public Product(int productId, String productName, int productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductId() {
		return productId;
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
