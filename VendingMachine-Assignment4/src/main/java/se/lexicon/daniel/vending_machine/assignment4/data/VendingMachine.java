package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.ArrayList;
import java.util.List;

import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class VendingMachine implements VendingMachineSignatures {
	private List<Product> vendingMachineInventory;
	private int vendingMachineCash;

	private static final VendingMachineSignatures vendingMachineInstance = new VendingMachine();
	public static VendingMachineSignatures getVendingMachineInstance() {return vendingMachineInstance;}

	public VendingMachine() {
		this.vendingMachineCash = 200; // 100k
	}

	public int getCashAmount() {return vendingMachineCash;}
	public void setCashAmount(int vendingMachineCash) {this.vendingMachineCash = vendingMachineCash;}
	public void addCashAmount(int vendingMachineCash) {this.vendingMachineCash += vendingMachineCash;}

	public String getInventory() {return vendingMachineInventory.toString();}

	public List<Product> addToInventory(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException();}
		if(findProductById(product.getProductId()) != null) {
			throw new IllegalArgumentException("Product Object with same id exists in storage");
		}
		else {
			vendingMachineInventory.add(product);
			return vendingMachineInventory;
		}	
	}

	public Product findProductById(int productId) {
		for(Product productObject : vendingMachineInventory) {
			if(productObject.getProductId() == productId) {
				return productObject;
			}
		}
		return null;
	}

	public void removeProduct(Product productObject) {
		vendingMachineInventory.remove(productObject);
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
