package se.lexicon.daniel.vending_machine.assignment4.models;

public abstract class Product {
	private static int sequencer = 0;
	private int productId;
	private String productName;
	private int productCode;
	private int productPrice;
	private String productPackaging;
	private int productWeight;
	
	
	/**
	 * @param productId is an int
	 * @param productName is an String
	 * @param productCode is an int
	 * @param productPrice is an int
	 */
	
	public Product(String productName, int productCode, int productPrice, String productPackaging, int productWeight) {
		super();
		this.productId = ++sequencer;
		this.productName = productName;
		this.productCode = productCode;
		this.productPrice = productPrice;
		this.productPackaging = productPackaging;
		this.productWeight = productWeight;
	}
	
	public int getProductId() {return productId;}
	public String getProductName() {return productName;}
	public void setProductName(String productName) {this.productName = productName;}
	public int getProductCode() {return productCode;}
	public void setProductCode(int productCode) {this.productCode = productCode;}
	public int getProductPrice() {return productPrice;}
	public void setProductPrice(int productPrice) {this.productPrice = productPrice;}
	public String getProductPackaging() {return productPackaging;}
	public void setProductPackaging(String productPackaging) {this.productPackaging = productPackaging;}
	public int getProductWeight() {return productWeight;}
	public void setProductWeight(int productWeight) {this.productWeight = productWeight;}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productCode;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productPackaging == null) ? 0 : productPackaging.hashCode());
		result = prime * result + productPrice;
		result = prime * result + productWeight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (productCode != other.productCode)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPackaging == null) {
			if (other.productPackaging != null)
				return false;
		} else if (!productPackaging.equals(other.productPackaging))
			return false;
		if (productPrice != other.productPrice)
			return false;
		if (productWeight != other.productWeight)
			return false;
		return true;
	}

	
	
}
