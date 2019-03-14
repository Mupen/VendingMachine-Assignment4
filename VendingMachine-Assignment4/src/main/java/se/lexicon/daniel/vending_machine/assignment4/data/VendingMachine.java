package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.ChewingGum;
import se.lexicon.daniel.vending_machine.assignment4.models.Drink;
import se.lexicon.daniel.vending_machine.assignment4.models.Food;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class VendingMachine implements VendingMachineSignatures {
	private Integer vendingMachineCash;

	private static final VendingMachineSignatures vendingMachineInstance = new VendingMachine();
	public static VendingMachineSignatures getVendingMachineInstance() {return vendingMachineInstance;}

	private List<Product> vendingMachineInventory;
	private VendingMachine() {vendingMachineInventory = new ArrayList<>();}
	
	public Integer getCashAmount() {return vendingMachineCash;}
	public void setCashAmount(Integer vendingMachineCash) {this.vendingMachineCash = vendingMachineCash;}
	public void addCashAmount(Integer vendingMachineCash) {this.vendingMachineCash += vendingMachineCash;}

	public String getInventory() {return vendingMachineInventory.toString();}

	public void addToInventory(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		if(findProductById(product.getProductId()).get().equals(product)) {
			throw new IllegalArgumentException("Product Object with same id exists in storage");
		}
		else {
			this.vendingMachineInventory.add(product);
		}	
	}
	
	public void removeProduct(Product productObject) {
		vendingMachineInventory.remove(productObject);
	}
	

	public Optional<Product> findProductById(Integer id){
		return vendingMachineInventory.stream()
				.filter(Product -> Product.getProductId().equals(id))
				.findFirst();
	}
	
	public Optional<Product> findProductByCode(Integer code){
		return vendingMachineInventory.stream()
				.filter(Product -> Product.getProductCode().equals(code))
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
