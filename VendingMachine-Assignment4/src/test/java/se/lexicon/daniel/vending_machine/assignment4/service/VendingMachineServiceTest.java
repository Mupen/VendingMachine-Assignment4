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
		tempList1.addAll(serviceInstance.getAllUsersCoins());
		this.tempList2 = new ArrayList<ObjectEnum>();
		

	}
	
	@After
	public void tearDown() {
		this.tempList1.clear();
		this.tempList2.clear();
	}
	
	@Test
	public void test_addCoinsToUser() {
		
		// Check if it is no coins in it
		assertNotEquals(tempList1, serviceInstance.getAllUsersCoins());
		
		tempList1.add(oneHundred);
		
		serviceInstance.addCoinsToUser(tempList1);
		
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
		assertEquals(value1, value2);
		System.out.println(x);
		serviceInstance.removeCoinsFromUser(tempList1);
		for(ObjectEnum denomination : serviceInstance.getAllUsersCoins()) {value1 += denomination.getDenomination().getValue();}
		for(ObjectEnum denomination : tempList1) {value2 += denomination.getDenomination().getValue();}
		assertNotEquals(value1, value2);
	}
	
	@Test
	public void test_removeCoinsFromVendingMachinen() {
		
		assertNotEquals(serviceInstance.getAllVendingMachinenCoins(), tempList1);
		serviceInstance.removeCoinsFromVendingMachinen(serviceInstance.getAllVendingMachinenCoins());
		assertEquals(serviceInstance.getAllVendingMachinenCoins(), tempList1);
		
		tempList1.add(oneHundred);
		serviceInstance.addCoinsToVendingMachinen(tempList1);
		serviceInstance.removeCoinsFromVendingMachinen(tempList1);
		
		assertEquals(serviceInstance.getAllVendingMachinenCoins(), tempList2);
	}
	
	@Test
	public void test_removeCoinsFromInBetweenStorage() {
		
		assertNotEquals(serviceInstance.getAllUsersCoins(), tempList1);
		serviceInstance.removeCoinsFromUser(serviceInstance.getAllUsersCoins());
		assertEquals(serviceInstance.getAllUsersCoins(), tempList1);
		
		tempList1.add(oneHundred);
		serviceInstance.addCoinsToUser(tempList1);
		serviceInstance.removeCoinsFromUser(tempList1);
		
		assertEquals(serviceInstance.getAllUsersCoins(), tempList2);
	}
}
