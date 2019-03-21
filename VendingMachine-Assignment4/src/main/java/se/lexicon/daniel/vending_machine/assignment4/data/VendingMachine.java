package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import se.lexicon.daniel.vending_machine.assignment4.models.ChewingGum;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Drink;
import se.lexicon.daniel.vending_machine.assignment4.models.Food;
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
		vendingMachineCoinsStorage.add(five);
		vendingMachineCoinsStorage.add(five);
		vendingMachineCoinsStorage.add(five);
		vendingMachineCoinsStorage.add(five);
		vendingMachineCoinsStorage.add(ten);
		vendingMachineCoinsStorage.add(ten);
		vendingMachineCoinsStorage.add(ten);
		vendingMachineCoinsStorage.add(ten);
		vendingMachineCoinsStorage.add(twenty);
		vendingMachineCoinsStorage.add(twenty);
		vendingMachineCoinsStorage.add(fifty);
		vendingMachineCoinsStorage.add(oneHundred);
		vendingMachineCoinsStorage.add(fiveHundred);
		vendingMachineCoinsStorage.add(oneThousand);
		
		
		/**
		 * @param productId is an int sequencer
		 * @param productName is an String
		 * @param productCode is an int
		 * @param productPrice is an int
		 * @param volume is an int
		 * @param carbonated is an boolean
		 * @param taste is an String
		 * @param productPackaging is an String
		 * @param productWeight is an int
		 */

		// String productName, int productCode, int productPrice, String productPackaging, int productWeight, int volume, 
		// boolean carbonated, String taste, String packaging, int weight

		vendingMachineInventory.add(new Drink("Coca Cola Zero", 1, 12, 33, true, "Sodium citrate", "Can", 360));
		vendingMachineInventory.add(new Drink("Coca Cola Zero", 1, 12, 33, true, "Sodium citrate", "Can", 360));
		vendingMachineInventory.add(new Drink("Coca Cola Zero", 1, 12, 33, true, "Sodium citrate", "Can", 360));
		
		vendingMachineInventory.add(new Drink("Coca cola light", 2, 12, 33, true, "Citric acid", "Can", 360));
		vendingMachineInventory.add(new Drink("Coca cola light", 2, 12, 33, true, "Citric acid", "Can", 360));
		vendingMachineInventory.add(new Drink("Coca cola light", 2, 12, 33, true, "Citric acid", "Can", 360));
		
		vendingMachineInventory.add(new Drink("Fanta Orange", 3, 12, 33, true, "Orange", "Can", 360));
		vendingMachineInventory.add(new Drink("Fanta Orange", 3, 12, 33, true, "Orange", "Can", 360));
		vendingMachineInventory.add(new Drink("Fanta Orange", 3, 12, 33, true, "Orange", "Can", 360));

		/**
		 * Food have the following values
		 * @param productId is an int sequencer
		 * @param productName is an String
		 * @param productCode is an int
		 * @param productPrice is an int
		 * @param foodtype is an String
		 * @param taste is an string
		 * @param productPackaging is an String
		 * @param weight is an int
		 */

		
		vendingMachineInventory.add(new Food("Pizza Mozzarella", 4, 32, "Frozen", "Chesey with bread", "Cartons", 450));
		vendingMachineInventory.add(new Food("Pizza Mozzarella", 4, 32, "Frozen", "Chesey with bread", "Cartons", 450));
		vendingMachineInventory.add(new Food("Pizza Mozzarella", 4, 32, "Frozen", "Chesey with bread", "Cartons", 450));
		
		vendingMachineInventory.add(new Food("Ost hamburgare", 5, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));
		vendingMachineInventory.add(new Food("Ost hamburgare", 5, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));
		vendingMachineInventory.add(new Food("Ost hamburgare", 5, 45, "Frozen", "Chesey and meaty", "Cartons with plastic", 325));

		vendingMachineInventory.add(new Food("Beer sausage", 6, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		vendingMachineInventory.add(new Food("Beer sausage", 6, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		vendingMachineInventory.add(new Food("Beer sausage", 6, 20, "Plastic", "Beer with a spicy mix", "can", 225));
		
		/**
		 * Chewing Gum have the following values
		 * @param productId is an int sequencer
		 * @param productName is an String
		 * @param productCode is an int
		 * @param productPrice is an int
		 * @param amount is an int
		 * @param taste is an String
		 * @param packaging is an String
		 * @param Weight is an String
		 */

		vendingMachineInventory.add(new ChewingGum("Doublemint", 7, 30, 20, "Mint", "Bottle 150ml", 72));
		vendingMachineInventory.add(new ChewingGum("Doublemint", 7, 30, 20, "Mint", "Bottle 150ml", 72));
		vendingMachineInventory.add(new ChewingGum("Doublemint", 7, 30, 20, "Mint", "Bottle 150ml", 72));
		
		vendingMachineInventory.add(new ChewingGum("Juicy Fruit", 8, 20, 25, "Banana", "Plastic bag", 42));
		vendingMachineInventory.add(new ChewingGum("Juicy Fruit", 8, 20, 25, "Banana", "Plastic bag", 42));
		vendingMachineInventory.add(new ChewingGum("Juicy Fruit", 8, 20, 25, "Banana", "Plastic bag", 42));
		
		vendingMachineInventory.add(new ChewingGum("Dubble Bubble", 9, 10, 10, "Lemonade", "paper", 36));
		vendingMachineInventory.add(new ChewingGum("Dubble Bubble", 9, 10, 10, "Lemonade", "paper", 36));
		vendingMachineInventory.add(new ChewingGum("Dubble Bubble", 9, 10, 10, "Lemonade", "paper", 36));
		
	}
	
	public List<Denomination> getVendingMachineCoins() {return this.vendingMachineCoinsStorage;}
	
	public int addCoinsTogether() {
		int coinsToValue = 0;
		for(Denomination denomination : vendingMachineCoinsStorage) {
			coinsToValue += denomination.getValue();
		}
		return coinsToValue;	
	}
	
	public void addCoin(Denomination coin) throws IllegalArgumentException {
		if(!coin.equals(null)) {vendingMachineCoinsStorage.add(coin);}
		else {throw new IllegalArgumentException("Denomination elements is null");}
	}
	
	public void addCoinsCollection(List<Denomination> coins) throws IllegalArgumentException {
		if(!coins.contains(null)) {vendingMachineCoinsStorage.addAll(coins);}
		else {throw new IllegalArgumentException("Denomination elements is null");}
	}
	
	public void removesCoin(Denomination coins) {
		for(Denomination denomination : vendingMachineCoinsStorage) {
			if(coins.equals(denomination)) {
				vendingMachineCoinsStorage.remove(denomination);
			}
		}
	}
	
	
	
	
	
	@Override
	public List<Denomination> removeCoinsCollection(List<Denomination> coins) {
		this.vendingMachineCoinsStorage.removeIf(p -> {return coins.stream().anyMatch(x -> (p.getValue() == x.getValue()));});
		return coins;
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
