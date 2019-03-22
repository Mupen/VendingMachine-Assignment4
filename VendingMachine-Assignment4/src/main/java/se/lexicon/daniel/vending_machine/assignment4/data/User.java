package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Drink;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;

public class User implements UserSignatures {
	private VendingMachineSignatures vendingMachineInstance;
	
	private static final UserSignatures userInstance = new User();
	public static UserSignatures getUserInstance() {return userInstance;}
	
	private Denomination one;
	private Denomination five;
	private Denomination ten;
	private Denomination twenty;
	private Denomination fifty;
	private Denomination oneHundred;
	private Denomination fiveHundred;
	private Denomination oneThousand;
	private List<Denomination> userCoinsStorage;
	private List<Product> userInventory;
	
	private User() {
		one = Denomination._1KR;
		five = Denomination._5KR;
		ten = Denomination._10KR;
		twenty = Denomination._20KR;
		fifty = Denomination._50KR;
		oneHundred = Denomination._100KR;
		fiveHundred = Denomination._500KR;
		oneThousand = Denomination._1000KR;
		
		userInventory = new ArrayList<Product>();
		userCoinsStorage = new ArrayList<Denomination>();
		
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(one);
		userCoinsStorage.add(five);
		userCoinsStorage.add(five);
		userCoinsStorage.add(five);
		userCoinsStorage.add(five);
		userCoinsStorage.add(five);
		userCoinsStorage.add(five);
		userCoinsStorage.add(ten);
		userCoinsStorage.add(ten);
		userCoinsStorage.add(ten);
		userCoinsStorage.add(ten);
		userCoinsStorage.add(ten);
		userCoinsStorage.add(ten);
		userCoinsStorage.add(twenty);
		userCoinsStorage.add(twenty);
		userCoinsStorage.add(fifty);
		userCoinsStorage.add(oneHundred);
		userCoinsStorage.add(fiveHundred);
		userCoinsStorage.add(oneThousand);
		
		userInventory.add(new Drink("Coca Cola Zero", 1, 12, 33, true, "Sodium citrate", "Can", 360));
	}
	
	
	
	
	@Override
	public void addProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		if(userInventory.stream().anyMatch(p -> p.getProductId() == product.getProductId())) {throw new IllegalArgumentException("Product Is already in users Inventory");}
		else {
			this.userInventory.add(product);
			vendingMachineInstance.removeProduct(product);
			System.out.println(product.getProductName() + "Was added to user inventory and removed from Vending Machine inventory ");
		}
	}
	
	@Override
	public void useProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		if(userInventory.stream().anyMatch(p->p.getProductId() == product.getProductId())) {
			this.userInventory.remove(product);
		}
	}
	
	@Override
	public void examineProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			Optional<Product> productObject = findProductById(product.getProductId());
			productObject.get().Examine();
		}
	}
	
	@Override
	public void removeProduct(Optional<Product> product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		else {
			userInventory.remove(product.get());
		}
	}
	
	@Override
	public Optional<Product> findProductById(int id){
		return userInventory.stream()
				.filter(Product -> Product.getProductId() == id)
				.findFirst();
	}
	
	@Override
	public List<Product> findByNameLike(String name){
		return userInventory.stream()
				.filter(product -> product.getProductName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Product> findAllProducts() {
		List<Product> objectList = new ArrayList<Product>();
		for(Product productObject : userInventory) {
			if(!productObject.equals(null)) {
				objectList.add(productObject);
			}
		}
		return objectList;		
	}
	
	
	
	@Override
	public List<Denomination> getUserCoins() {return this.userCoinsStorage;}
	
	@Override
	public int addCoinsTogether() {
		int coinsToValue = 0;
		for(Denomination denomination : userCoinsStorage) {
			coinsToValue += denomination.getValue();
		}
		return coinsToValue;	
	}
	
	@Override
	public void addCoinsCollection(List<Denomination> coins) throws IllegalArgumentException {
		for(Denomination denomination : coins) {
			if(denomination == null) {throw new IllegalArgumentException("one of the coins is null");}
			else {userCoinsStorage.add(denomination);}
		}
	}
	
	@Override
	public void removeCoinsCollection(List<Denomination> coins) {
		for(Denomination denomination : coins) {
			if(denomination == null) {throw new IllegalArgumentException("one of the coins is null");}
			this.userCoinsStorage.removeIf(c->c.equals(denomination));
		}
	}
}
