package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class VendingMachine implements VendingMachineSignatures {
	private int cash;

	private static final VendingMachineSignatures vendingMachineInstance = new VendingMachine();
	public static VendingMachineSignatures getVendingMachineInstance() {return vendingMachineInstance;}

	private List<Product> vendingMachineInventory;
	private VendingMachine() {vendingMachineInventory = new ArrayList<>();}
	
	public int getCashAmount() {return cash;}
	public void setCashAmount(int cash) {this.cash = cash;}
	public void addCashAmount(int cash) {this.cash += cash;}

	public String getInventory() {return vendingMachineInventory.toString();}
	
	public void addToInventory(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			this.vendingMachineInventory.add(product);
		}	
	}
	
	public void removeProduct(Product product) {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			this.vendingMachineInventory.remove(product);
		}
	}
	

	public Optional<Product> findProductById(int id){
		return vendingMachineInventory.stream()
				.filter(Product -> Product.getProductId() == id)
				.findFirst();
	}
	
	public Optional<Product> findProductByCode(int code){
		return vendingMachineInventory.stream()
				.filter(Product -> Product.getProductCode() == code)
				.findFirst();
	}

	public List<Product> findAllProducts() {
		List<Product> objectList = new ArrayList<Product>();
		for(Product productObject : vendingMachineInventory) {
			if(!productObject.equals(null)) {
				objectList.add(productObject);
			}
		}
		return objectList;		
	}
}
