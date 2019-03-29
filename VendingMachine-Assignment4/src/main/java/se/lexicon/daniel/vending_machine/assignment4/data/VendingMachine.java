package se.lexicon.daniel.vending_machine.assignment4.data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import se.lexicon.daniel.vending_machine.assignment4.models.ChewingGum;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.Drink;
import se.lexicon.daniel.vending_machine.assignment4.models.Food;
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;
import se.lexicon.daniel.vending_machine.assignment4.models.Product;

public class VendingMachine implements VendingMachineSignatures {

	private static final VendingMachineSignatures vendingMachineInstance = new VendingMachine();
	public static VendingMachineSignatures getVendingMachineInstance() {return vendingMachineInstance;}
	
	ObjectEnum one = new ObjectEnum(Denomination._1KR);
	ObjectEnum five = new ObjectEnum(Denomination._5KR);
	ObjectEnum ten = new ObjectEnum(Denomination._10KR);
	ObjectEnum twenty = new ObjectEnum(Denomination._20KR);
	ObjectEnum fifty = new ObjectEnum(Denomination._50KR);
	ObjectEnum oneHundred = new ObjectEnum(Denomination._100KR);
	ObjectEnum fiveHundred = new ObjectEnum(Denomination._500KR);
	ObjectEnum oneThousand = new ObjectEnum(Denomination._1000KR);
	
	private List<ObjectEnum> transnationalBalanceStorage;
	private List<ObjectEnum> vendingMachineCoinsStorage;
	private List<Product> vendingMachineInventory;
	
	private VendingMachine() {
		vendingMachineInventory = new ArrayList<Product>();
		transnationalBalanceStorage = new ArrayList<ObjectEnum>();
		vendingMachineCoinsStorage = new ArrayList<ObjectEnum>();
		
		vendingMachineCoinsStorage.add(one);
		vendingMachineCoinsStorage.add(five);
		vendingMachineCoinsStorage.add(ten);
		vendingMachineCoinsStorage.add(twenty);
		vendingMachineCoinsStorage.add(fifty);
		vendingMachineCoinsStorage.add(oneHundred);
		vendingMachineCoinsStorage.add(fiveHundred);
		vendingMachineCoinsStorage.add(oneThousand);
		
		for(ObjectEnum coins : vendingMachineCoinsStorage)
		{
		   //Do something
		   if(coins.equals(one)){one.addAmount(80);}
		   if(coins.equals(five)){five.addAmount(70);}
		   if(coins.equals(ten)){ten.addAmount(60);}
		   if(coins.equals(twenty)){twenty.addAmount(50);}
		   if(coins.equals(fifty)){fifty.addAmount(40);}
		   if(coins.equals(oneHundred)){oneHundred.addAmount(30);}
		   if(coins.equals(fiveHundred)){fiveHundred.addAmount(20);}
		   if(coins.equals(oneThousand)){oneThousand.addAmount(10);}
		}
		
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
	
	@Override
	public void addProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		if(vendingMachineInventory.stream().anyMatch(p -> p.getProductId() == product.getProductId())) {throw new IllegalArgumentException("Product Is already in vending machine Inventory");}
		else {
			this.vendingMachineInventory.add(product);
			vendingMachineInstance.removeProduct(product);
			System.out.println(product.getProductName() + "Was added to vending machine inventory and removed from users inventory ");
		}
	}
	
	@Override
	public void removeProduct(Product product) throws IllegalArgumentException {
		if(product == null) {throw new IllegalArgumentException("Product Object is null");}
		if(vendingMachineInventory.stream().anyMatch(p->p.getProductId() == product.getProductId())) {
			this.vendingMachineInventory.remove(product);
		}
	}
	
	@Override
	public String getInventory() {return vendingMachineInventory.toString();}
	
	@Override
	public Optional<Product> findProductById(int id){
		return vendingMachineInventory.stream()
				.filter(Product -> Product.getProductId() == id)
				.findFirst();
	}
	
	@Override
	public Optional<Product> findProductByCode(int code){
		return vendingMachineInventory.stream()
				.filter(Product -> Product.getProductCode() == code)
				.findFirst();
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> objectList = new ArrayList<Product>();
		for(Product productObject : vendingMachineInventory) {
			if(!productObject.equals(null)) {
				objectList.add(productObject);
			}
		}
		return objectList;		
	}
	
	
	@Override
	public List<ObjectEnum> findCoinByName(Denomination denomination){
		return vendingMachineCoinsStorage.stream()
				.filter(c -> c.getDenomination().equals(denomination))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<ObjectEnum> getVendingMachineCoins() {return this.vendingMachineCoinsStorage;}
	
	@Override
	public int addCoinsTogether() {
		int coinsToValue = 0;
		for(ObjectEnum denomination : vendingMachineCoinsStorage) {
			coinsToValue += (denomination.getDenomination().getValue() * denomination.getAmount());
		}
		return coinsToValue;	
	}
	
	
	@Override
	public void confirmPurchase(int cost) throws IllegalArgumentException {
		if(cost == 0) {System.out.println("Can't change value with a 0");}
		else {
			for(ObjectEnum coins : vendingMachineCoinsStorage)
			{
				
				//Do something
				if(coins.getDenomination().getValue() <= cost)	{
					coins.subAmount(1); 
					cost -= coins.getDenomination().getValue();
				}
			}
		}
	}
	
	@Override
	public void addCoins(ObjectEnum type, int amount) throws IllegalArgumentException {
		if(type == null) {throw new IllegalArgumentException("one of the coins is null");}
		if(amount == 0) {System.out.println("Can't change value with a 0");}
		else {
			for(ObjectEnum coins : transnationalBalanceStorage)
			{
			   //Do something
			   if(coins.getDenomination().equals(type.getDenomination())){coins.addAmount(amount);}
			}
		}
	}
	
	@Override
	public void removeCoins(ObjectEnum type, int amount) throws IllegalArgumentException {
		if(type == null) {throw new IllegalArgumentException("one of the coins is null");}
		if(amount == 0) {System.out.println("Can't change value with a 0");}
		else {
			for(ObjectEnum coins : vendingMachineCoinsStorage)
			{
			   //Do something
			   if(coins.getDenomination().equals(type.getDenomination())){coins.subAmount(amount);}
			}
		}
	}
	
	
	
	// removeCoinsCollection this.vendingMachineCoinsStorage.removeIf(p -> {return coins.stream().anyMatch(x -> (p.getValue() == x.getValue()));});
}
