package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;

public class User implements UserSignatures {
	private VendingMachineSignatures vendingMachineInstance;
	private int cash = 0;
	
	private static final UserSignatures userInstance = new User();
	public static UserSignatures getUserInstance() {return userInstance;}
	
	private List<Product> userInventory;
	private User() {userInventory = new ArrayList<>();}
	
	public int getCashAmount() {return cash;}
	public void setCashAmount(int cash) {this.cash = cash;}
	public void addCashAmount(int cash) {this.cash += cash;}
	
	public Product addToInventory(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			this.userInventory.add(product);
			vendingMachineInstance.removeProduct(product);
			System.out.println(product.getProductName() + "Was added to user inventory and removed Vending Machine inventory ");
			return product;
		}	
	}
	
	public void useProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {	
			Optional<Product> Productobject = findProductById(product.getProductId());
			Productobject.get().Use();
			removeProduct(Productobject);
		}
	}
	
	public void examineProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			Optional<Product> Productobject = findProductById(product.getProductId());
			Productobject.get().Examine();
		}

	}
	
	public void removeProduct(Optional<Product> product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			userInventory.remove(product.get());
		}
	}
	
	public Optional<Product> findProductById(int id){
		return userInventory.stream()
				.filter(Product -> Product.getProductId() == id)
				.findFirst();
	}
	
	public List<Product> findByNameLike(String name){
		return userInventory.stream()
				.filter(product -> product.getProductName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
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
