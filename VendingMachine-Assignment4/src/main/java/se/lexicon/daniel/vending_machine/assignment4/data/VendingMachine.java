package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class VendingMachine implements VendingMachineSignatures {

	private static final VendingMachineSignatures vendingMachineInstance = new VendingMachine();
	public static VendingMachineSignatures getVendingMachineInstance() {return vendingMachineInstance;}
	private Denomination one;
	private Denomination five;
	private Denomination ten;
	private Denomination twenty;
	private Denomination fifty;
	private Denomination oneHundred;
	private Denomination fiveHundred;
	private Denomination oneThousand;
	
	private List<Denomination> vendingMachineCoinsStorage;
	private List<Product> vendingMachineInventory;
	private VendingMachine() {
		
		one = Denomination._1KR;
		five = Denomination._5KR;
		ten = Denomination._10KR;
		twenty = Denomination._20KR;
		fifty = Denomination._50KR;
		oneHundred = Denomination._100KR;
		fiveHundred = Denomination._500KR;
		oneThousand = Denomination._1000KR;
		
		vendingMachineInventory = new ArrayList<Product>();
		vendingMachineCoinsStorage = new ArrayList<Denomination>();
		
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(five);
		vendingMachineCoinsStorage.add(five);
		vendingMachineCoinsStorage.add(ten);
		vendingMachineCoinsStorage.add(ten);
		vendingMachineCoinsStorage.add(twenty);
		vendingMachineCoinsStorage.add(twenty);
		vendingMachineCoinsStorage.add(twenty);
		vendingMachineCoinsStorage.add(fifty);
		vendingMachineCoinsStorage.add(fifty);
		vendingMachineCoinsStorage.add(oneHundred);
		vendingMachineCoinsStorage.add(oneHundred);
		vendingMachineCoinsStorage.add(oneHundred);
		vendingMachineCoinsStorage.add(oneHundred);
		vendingMachineCoinsStorage.add(oneHundred);
		vendingMachineCoinsStorage.add(fiveHundred);
		vendingMachineCoinsStorage.add(oneThousand);
	}
	
	public List<Denomination> getVendingMachineCoins() {return this.vendingMachineCoinsStorage;}
	
	public int addCoinsTogether() {
		int coinsToValue = 0;
		for(Denomination denomination : vendingMachineCoinsStorage) {
			coinsToValue += denomination.getValue();
		}
		return coinsToValue;	
	}
	
	public void addCoins(List<Denomination> coins) throws IllegalArgumentException {
		if(!coins.equals(null)) {vendingMachineCoinsStorage.addAll(coins);}
		else {throw new IllegalArgumentException("Denomination elements is null");}
	}
	
	public void removesCoins(List<Denomination> coins) {
		for(Denomination denomination : vendingMachineCoinsStorage) {
			if(coins.contains(denomination)) {
				vendingMachineCoinsStorage.remove(denomination);
			}
		}
	}
	
	
	

	public String getInventory() {return vendingMachineInventory.toString();}
	
	public void addProduct(Product product) throws IllegalArgumentException {
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
