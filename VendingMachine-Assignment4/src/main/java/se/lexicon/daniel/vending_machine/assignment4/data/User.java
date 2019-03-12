package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class User implements UserSignatures {
	private List<Product> userInventory;
	private int userCash;
	
	private static final UserSignatures userInstance = new User();
	public static UserSignatures getUserInstance() {return userInstance;}
	
	public User() {
		this.userCash = 100; // 100k
	}
	
	public int getCashAmount() {return userCash;}
	
	public void setCashAmount(int userCash) {this.userCash = userCash;}
	
	public void addCashAmount(int userCash) {this.userCash += userCash;}
	
	public void useProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			Product	Productobject = findProductById(product.getProductId());
			Productobject.Use();
			removeProduct(Productobject);
		}
	}
	
	public void examineProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			Product	Productobject = findProductById(product.getProductId());
			Productobject.Examine();
		}
	}
	
	public void addToInventory(Product product) throws IllegalArgumentException {
		if(product == null) {
			throw new IllegalArgumentException("Product Object is null");}
		if(findProductById(product.getProductId()) != null) {
			throw new IllegalArgumentException("Product Object with same id exists in storage");
		}
		else {
			userInventory.add(product);
		}	
	}
	
	
	public Product findProductById(int productId) {
		for(Product productObject : userInventory) {
			if(productObject.getProductId() == productId) {
				return productObject;
			}
		}
		return null;
	}
	
	
	public void removeProduct(Product productObject) {
		userInventory.remove(productObject);
	}

	
	public List<Product> findAllProducts() {
		List<Product> objectList = new ArrayList<Product>();
		for(Product productObject : userInventory) {
			if(!productObject.equals(null)) {
				objectList.add(productObject);
			}
		}
		return objectList;		
	}


}
