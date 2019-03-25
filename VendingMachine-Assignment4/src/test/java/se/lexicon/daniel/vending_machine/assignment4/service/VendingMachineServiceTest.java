package se.lexicon.daniel.vending_machine.assignment4.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.lexicon.daniel.vending_machine.assignment4.data.User;
import se.lexicon.daniel.vending_machine.assignment4.data.UserSignatures;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachine;
import se.lexicon.daniel.vending_machine.assignment4.data.VendingMachineSignatures;
import se.lexicon.daniel.vending_machine.assignment4.models.Denomination;

public class VendingMachineServiceTest {
	
	//This is what we are going to test
	private VendingMachineServiceSignatures serviceInstance = VendingMachineService.getVendingMachineService();
	private UserSignatures userInstance = User.getUserInstance();
	private VendingMachineSignatures vendingMachineInstance = VendingMachine.getVendingMachineInstance();
	private List<Denomination> tempList;
	
	//Runs BEFORE each test
	@Before
	public void init() {
		this.tempList = new ArrayList<Denomination>();
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void test_addCoinsToUser() {
		
		// Check if it is no coins in it
		assertNotEquals(tempList, serviceInstance.getAllUsersCoins());
		
		tempList.add(Denomination._100KR);
		serviceInstance.addCoinsToUser(tempList);
		tempList.remove(Denomination._100KR);
		
		tempList.addAll(serviceInstance.getAllUsersCoins());
		
		// Check if the are same list of coins in it
		assertEquals(serviceInstance.getAllUsersCoins(), tempList);
		
	}
	
	@Test
	public void test_addCoinsToVendingMachinen() {
		
		// Check if it is no coins in it
		assertNotEquals(tempList, serviceInstance.getAllVendingMachinenCoins());
		
		tempList.add(Denomination._100KR);
		serviceInstance.addCoinsToVendingMachinen(tempList);
		tempList.remove(Denomination._100KR);
		
		tempList.addAll(serviceInstance.getAllVendingMachinenCoins());
		
		// Check if the are same list of coins in it
		assertEquals(serviceInstance.getAllVendingMachinenCoins(), tempList);
		
	}
	
	@Test
	public void test_addCoinsToInBetweenStorage() {
		
		// Check if it is no coins in it
		assertEquals(serviceInstance.getInBetweenCoinsStorageCoins(), tempList);
		
		tempList.add(Denomination._100KR);
		serviceInstance.addCoinsToInBetweenStorage(tempList);
		
		// Check if the are same list of coins in it
		assertEquals(serviceInstance.getInBetweenCoinsStorageCoins(), tempList);
		
	}
	
	@Test
	public void test_removeCoinsFromUser() {
		
		assertNotEquals(serviceInstance.getAllUsersCoins(), tempList);
		
		serviceInstance.removeCoinsFromUser(serviceInstance.getAllUsersCoins());
		
		assertEquals(serviceInstance.getAllUsersCoins(), tempList);
	}
	
	@Test
	public void test_removeCoinsFromVendingMachinen() {
		
		assertNotEquals(serviceInstance.getAllVendingMachinenCoins(), tempList);
		
		tempList = serviceInstance.getAllVendingMachinenCoins();
		serviceInstance.removeCoinsFromVendingMachinen(tempList);
		
		assertEquals(serviceInstance.getAllVendingMachinenCoins(), tempList);
	}
	
	@Test
	public void test_removeCoinsFromInBetweenStorage() {
		
		assertNotEquals(serviceInstance.getInBetweenCoinsStorageCoins(), tempList);
		
		tempList = serviceInstance.getInBetweenCoinsStorageCoins();
		serviceInstance.removeCoinsFromInBetweenStorage(tempList);
		
		assertEquals(serviceInstance.getAllVendingMachinenCoins(), tempList);
		
	}

}
