package se.lexicon.daniel.vending_machine.assignment4.models;

public abstract class Product {
	private static int sequencer = 0;
	private Integer productId;
	private String productName;
	private Integer productCode;
	private Integer productPrice;
	private String productPackaging;
	private Integer productWeight;
	
	
	/**
	 * @param productId is an Integer
	 * @param productName is an String
	 * @param productCode is an Integer
	 * @param productPrice is an Integer
	 */
	
	public Product(String productName, Integer productCode, Integer productPrice, String productPackaging, Integer productWeight) {
		super();
		this.productId = ++sequencer;
		this.productName = productName;
		this.productCode = productCode;
		this.productPrice = productPrice;
		this.productPackaging = productPackaging;
		this.productWeight = productWeight;
	}
	
	public Integer getProductId() {return productId;}
	public String getProductName() {return productName;}
	public void setProductName(String productName) {this.productName = productName;}
	public Integer getProductCode() {return productCode;}
	public void setProductCode(Integer productCode) {this.productCode = productCode;}
	public Integer getProductPrice() {return productPrice;}
	public void setProductPrice(Integer productPrice) {this.productPrice = productPrice;}
	public String getProductPackaging() {return productPackaging;}
	public void setProductPackaging(String productPackaging) {this.productPackaging = productPackaging;}
	public Integer getProductWeight() {return productWeight;}
	public void setProductWeight(Integer productWeight) {this.productWeight = productWeight;}

	/** 
	 * @return a string with information
	 */
	
	public abstract String Examine();

	/**
	 * @return a string with info about how to use the product
	 */
	
	public abstract String Use();
	
	/**
	 * @return a toString will make it a stringbuilder
	 */
	
	public abstract String StringBuilder();
	
}
