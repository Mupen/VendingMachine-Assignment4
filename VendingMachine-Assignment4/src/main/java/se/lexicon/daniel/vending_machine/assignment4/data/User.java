package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;

public class User implements UserSignatures {
	private VendingMachineSignatures vendingMachineInstance;
	private Integer userCash = 0;
	
	private static final UserSignatures userInstance = new User();
	public static UserSignatures getUserInstance() {return userInstance;}
	
	private List<Product> userInventory;
	private User() {userInventory = new ArrayList<>();}
	
	public int getCashAmount() {return userCash;}
	
	public void setCashAmount(Integer userCash) {this.userCash = userCash;}
	
	public void addCashAmount(Integer userCash) {this.userCash += userCash;}
	
	public Product addToInventory(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		if(findProductById(product.getProductId()) != null) {
			throw new IllegalArgumentException("Product Object with same id exists in storage");
		}
		else {
			this.userInventory.add(product);
			vendingMachineInstance.removeProduct(product);
			System.out.println(product.getProductName() + "Was added to user inventory and removed Vending Machine inventory ");
			return product;
		}	
	}
	
	public void useProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		if(findProductById(product.getProductId()) != null) {
			throw new IllegalArgumentException("Product Object with same id exists in storage");
		}
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
	
	public void removeProduct(Optional<Product> product) {
		userInventory.remove(product.get());
	}
	
	public Optional<Product> findProductById(Integer id){
		return userInventory.stream()
				.filter(Product -> Product.getProductId().equals(id))
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
