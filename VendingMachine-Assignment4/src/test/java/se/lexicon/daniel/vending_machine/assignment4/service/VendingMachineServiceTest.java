package se.lexicon.daniel.vending_machine.assignment4.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.vending_machine.assignment4.data.User;
import se.lexicon.daniel.vending_machine.assignment4.data.UserSignatures;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachine;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;

public class VendingMachineServiceTest {
	
	//This is what we are going to test
	private VendingMachineServiceSignatures serviceInstance = VendingMachineService.getVendingMachineService();
	private VendingMachineSignatures vendingMachineInstance = VendingMachine.getVendingMachineInstance();
	private UserSignatures userInstance = User.getUserInstance();
	
	// List ObjectEnum
	private List<ObjectEnum> tempList1;
	private List<ObjectEnum> tempList2;
	int value1 = 0;
	int value2 = 0;
	int value3 = 0;
	int value4 = 0;
	
	ObjectEnum one = new ObjectEnum(Denomination._1KR);
	ObjectEnum five = new ObjectEnum(Denomination._5KR);
	ObjectEnum ten = new ObjectEnum(Denomination._10KR);
	ObjectEnum twenty = new ObjectEnum(Denomination._20KR);
	ObjectEnum fifty = new ObjectEnum(Denomination._50KR);
	ObjectEnum oneHundred = new ObjectEnum(Denomination._100KR);
	ObjectEnum fiveHundred = new ObjectEnum(Denomination._500KR);
	ObjectEnum oneThousand = new ObjectEnum(Denomination._1000KR);
	//Runs BEFORE each test
	@Before
	public void init() {
		this.tempList1 = new ArrayList<ObjectEnum>();
		tempList1.add(one);
		tempList1.add(five);
		tempList1.add(ten);
		tempList1.add(twenty);
		tempList1.add(fifty);
		tempList1.add(oneHundred);
		tempList1.add(fiveHundred);
		tempList1.add(oneThousand);
		
		this.tempList2 = new ArrayList<ObjectEnum>();
		tempList2.add(one);
		tempList2.add(five);
		tempList2.add(ten);
		tempList2.add(twenty);
		tempList2.add(fifty);
		tempList2.add(oneHundred);
		tempList2.add(fiveHundred);
		tempList2.add(oneThousand);
	}
	
	@After
	public void tearDown() {
		tempList1.clear();
		tempList2.clear();
		value1 = 0;
		value2 = 0;
		value3 = 0;
		value4 = 0;
	}
	
	@Test
	public void test_addCoinsToUser() {
		
		// Check if it is no coins in it
		for(ObjectEnum denomination : tempList1) {value1 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		assertEquals(value1, serviceInstance.getUsersCoinsValue());
		System.out.println(value1 + " and " + serviceInstance.getUsersCoinsValue());
		
		serviceInstance.addCoinsToUser(tempList1);
		assertNotEquals(value1, serviceInstance.getUsersCoinsValue());
		System.out.println(value1 + " and " + serviceInstance.getUsersCoinsValue());
		
		
		assertEquals(value1, serviceInstance.getUsersCoinsValue());
		
		tempList1.remove(oneHundred);

		
		tempList1.addAll(serviceInstance.getAllUsersCoins());
		
		// Check if the are same list of coins in it
		assertEquals(serviceInstance.getAllUsersCoins(), tempList1);
		
	}
	
	@Test
	public void test_addCoinsToVendingMachinen() {
		
		
		// Check if it is no coins in it
		assertNotEquals(tempList1, serviceInstance.getAllVendingMachinenCoins());
		
		tempList1.add(oneHundred);
		serviceInstance.addCoinsToVendingMachinen(tempList1);
		tempList1.remove(oneHundred);
		
		tempList1.addAll(serviceInstance.getAllVendingMachinenCoins());
		
		// Check if the are same list of coins in it
		assertEquals(serviceInstance.getAllVendingMachinenCoins(), tempList1);
		
	}
	
	@Test
	public void test_addCoinsToInBetweenStorage() {
		
		// Check if it is no coins in it
		assertEquals(serviceInstance.getInBetweenCoinsStorageCoins(), tempList1);
		
		tempList1.add(oneHundred);
		serviceInstance.addCoinsToInBetweenStorage(tempList1);
		
		// Check if the are same list of coins in it
		assertEquals(serviceInstance.getInBetweenCoinsStorageCoins(), tempList1);
		
	}
	
	@Test
	public void test_removeCoinsFromUser() {
		// Same value
		for(ObjectEnum denomination : serviceInstance.getAllUsersCoins()) {value1 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		for(ObjectEnum denomination : tempList1) {value2 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		assertEquals(value1, value2);
		
		// remove all coins from user
		serviceInstance.removeCoinsFromUser(tempList1);
		
		// Not same value 
		for(ObjectEnum denomination : serviceInstance.getAllUsersCoins()) {value3 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		for(ObjectEnum denomination : tempList1) {value4 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		assertNotEquals(value3, value4);
	}
	
	@Test
	public void test_removeCoinsFromVendingMachinen() {
		// Same value
		for(ObjectEnum denomination : serviceInstance.getAllVendingMachinenCoins()) {value1 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		for(ObjectEnum denomination : tempList2) {value2 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		assertEquals(value1, value2);
		
		// remove all coins from user
		serviceInstance.removeCoinsFromVendingMachinen(tempList1);
		
		// Not same value 
		for(ObjectEnum denomination : serviceInstance.getAllVendingMachinenCoins()) {value3 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		for(ObjectEnum denomination : tempList1) {value4 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		assertNotEquals(value3, value4);
	}
	
	@Test
	public void test_returnCoinsFromVendingMachinen() {
		// Same value
		for(ObjectEnum denomination : serviceInstance.getAllUsersCoins()) {value1 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		for(ObjectEnum denomination : tempList1) {value2 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		// System.out.println(value1 + " and " + value2);
		assertNotEquals(value1, value2);
		
		// remove all coins from user
		serviceInstance.givenCoinsToVendingMachinen(tempList1);
		serviceInstance.returnCoinsFromVendingMachinen();
		
		// Not same value 
		for(ObjectEnum denomination : serviceInstance.getAllUsersCoins()) {value3 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		for(ObjectEnum denomination : tempList1) {value4 += (denomination.getDenomination().getValue() * denomination.getAmount());}
		// System.out.println(value3 + " and " + value4);
		assertNotEquals(value3, value4);
	}
}
