package se.lexicon.daniel.vending_machine.assignment4.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Drink;
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;
import se.lexicon.daniel.vending_machine.assignment4.utils.KeyboardInput;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;

public class User implements UserSignatures {
	private VendingMachineSignatures vendingMachineInstance;
	
	private static final UserSignatures userInstance = new User();
	public static UserSignatures getUserInstance() {return userInstance;}
	
	ObjectEnum one = new ObjectEnum(Denomination._1KR);
	ObjectEnum five = new ObjectEnum(Denomination._5KR);
	ObjectEnum ten = new ObjectEnum(Denomination._10KR);
	ObjectEnum twenty = new ObjectEnum(Denomination._20KR);
	ObjectEnum fifty = new ObjectEnum(Denomination._50KR);
	ObjectEnum oneHundred = new ObjectEnum(Denomination._100KR);
	ObjectEnum fiveHundred = new ObjectEnum(Denomination._500KR);
	ObjectEnum oneThousand = new ObjectEnum(Denomination._1000KR);
	private List<ObjectEnum> userCoinsStorage;
	private List<Product> userInventory;
	
	private User() {
		userInventory = new ArrayList<Product>();
		userCoinsStorage = new ArrayList<ObjectEnum>();
		
		userCoinsStorage.add(one);
		userCoinsStorage.add(five);
		userCoinsStorage.add(ten);
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
	public List<ObjectEnum> getUserCoins() {return this.userCoinsStorage;}
	
	@Override
	public int addCoinsTogether() {
		int coinsToValue = 0;
		for(ObjectEnum denomination : userCoinsStorage) {
			coinsToValue += denomination.getDenomination().getValue();
		}
		return coinsToValue;	
	}
	
	@Override
	public void addCoinsCollection(List<ObjectEnum> coins) throws IllegalArgumentException {
		for(ObjectEnum denomination : coins) {
			if(denomination == null) {throw new IllegalArgumentException("one of the coins is null");}
			else {userCoinsStorage.add(denomination);}
		}
	}
	
	@Override
	public void removeCoinsCollection(List<ObjectEnum> coins) throws IllegalArgumentException {
		for(ObjectEnum denomination : coins) {
			if(denomination.equals(null)) {throw new IllegalArgumentException("one of the coins is null");}
			switch (denomination.getDenomination()) {
				case _1KR: userCoinsStorage.stream().filter(c->c.equals(denomination)).forEach(c->c.getDenomination().subtractAmount(denomination.getDenomination().getValue())); break;
				case _5KR: userCoinsStorage.stream().filter(c->c.equals(denomination)).forEach(c->c.getDenomination().subtractAmount(denomination.getDenomination().getValue())); break;
				case _10KR: userCoinsStorage.stream().filter(c->c.equals(denomination)).forEach(c->c.getDenomination().subtractAmount(denomination.getDenomination().getValue())); break;
				case _20KR: userCoinsStorage.stream().filter(c->c.equals(denomination)).forEach(c->c.getDenomination().subtractAmount(denomination.getDenomination().getValue())); break;
				case _50KR: userCoinsStorage.stream().filter(c->c.equals(denomination)).forEach(c->c.getDenomination().subtractAmount(denomination.getDenomination().getValue())); break;
				case _100KR: userCoinsStorage.stream().filter(c->c.equals(denomination)).forEach(c->c.getDenomination().subtractAmount(denomination.getDenomination().getValue())); break;
				case _500KR: userCoinsStorage.stream().filter(c->c.equals(denomination)).forEach(c->c.getDenomination().subtractAmount(denomination.getDenomination().getValue())); break;
				case _1000KR: userCoinsStorage.stream().filter(c->c.equals(denomination)).forEach(c->c.getDenomination().subtractAmount(denomination.getDenomination().getValue())); break;
			}
		}
	}
}
