package se.lexicon.daniel.vending_machine.assignment4.service;
import static org.junit.Assert.assertEquals;
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
import se.lexicon.daniel.vending_machine.assignment4.models.ObjectEnum;

public class VendingMachineServiceTest {
	
	//This is what we are going to test
	private VendingMachineServiceSignatures serviceInstance = VendingMachineService.getVendingMachineService();
	private VendingMachineSignatures vendingMachineInstance = VendingMachine.getVendingMachineInstance();
	private UserSignatures userInstance = User.getUserInstance();
	
	// List ObjectEnum
	private List<ObjectEnum> tempList1;
	private List<ObjectEnum> tempList2;
	
	ObjectEnum one;
	ObjectEnum five;
	ObjectEnum ten;
	ObjectEnum twenty;
	ObjectEnum fifty;
	ObjectEnum oneHundred;
	ObjectEnum fiveHundred;
	ObjectEnum oneThousand;

	//Runs BEFORE each test
	@Before
	public void init() {
		
		this.tempList1 = new ArrayList<ObjectEnum>();
		this.tempList2 = new ArrayList<ObjectEnum>();
		one = new ObjectEnum(Denomination._1KR);
		five = new ObjectEnum(Denomination._5KR);
		ten = new ObjectEnum(Denomination._10KR);
		twenty = new ObjectEnum(Denomination._20KR);
		fifty = new ObjectEnum(Denomination._50KR);
		oneHundred = new ObjectEnum(Denomination._100KR);
		fiveHundred = new ObjectEnum(Denomination._500KR);
		oneThousand = new ObjectEnum(Denomination._1000KR);
		
	}
	
	@After
	public void tearDown() {
		tempList1.clear();
		tempList2.clear();
	}
	
	@Test public void test_addCoinsToUser() {
		
		assertEquals(1755, serviceInstance.getUsersCoinsValue());
		
		serviceInstance.addCoinsToUser(one, 10);
		assertEquals(1765, serviceInstance.getUsersCoinsValue());
		serviceInstance.removeCoinsFromUser(one, 10);
		
		serviceInstance.addCoinsToUser(five, 5);
		assertEquals(1780, serviceInstance.getUsersCoinsValue());
		serviceInstance.removeCoinsFromUser(five, 5);
		
		serviceInstance.addCoinsToUser(ten, 5);
		assertEquals(1805, serviceInstance.getUsersCoinsValue());
		serviceInstance.removeCoinsFromUser(ten, 5);
		
		serviceInstance.addCoinsToUser(twenty, 1);
		assertEquals(1775, serviceInstance.getUsersCoinsValue());
		serviceInstance.removeCoinsFromUser(twenty, 1);
		
		serviceInstance.addCoinsToUser(fifty, 1);
		assertEquals(1805, serviceInstance.getUsersCoinsValue());
		serviceInstance.removeCoinsFromUser(fifty, 1);
		
		serviceInstance.addCoinsToUser(oneHundred, 1);
		assertEquals(1855, serviceInstance.getUsersCoinsValue());
		serviceInstance.removeCoinsFromUser(oneHundred, 1);
		
		serviceInstance.addCoinsToUser(fiveHundred, 1);
		assertEquals(2255, serviceInstance.getUsersCoinsValue());
		serviceInstance.removeCoinsFromUser(fiveHundred, 1);
		
		serviceInstance.addCoinsToUser(oneThousand, 1);
		assertEquals(2755, serviceInstance.getUsersCoinsValue());
		serviceInstance.removeCoinsFromUser(oneThousand, 1);
		
		assertEquals(1755, serviceInstance.getUsersCoinsValue());
		
	}
	
	@Test public void test_addCoinsToVendingMachinen() {
		
		assertEquals(27030, serviceInstance.getVendingMachinensCoinsValue());
		
		serviceInstance.addCoinsToVendingMachinen(one, 80);
		assertEquals(27110, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.removeCoinsFromVendingMachinen(one, 80);
		
		serviceInstance.addCoinsToVendingMachinen(five, 70);
		assertEquals(27380, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.removeCoinsFromVendingMachinen(five, 70);
		
		serviceInstance.addCoinsToVendingMachinen(ten, 60);
		assertEquals(27630, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.removeCoinsFromVendingMachinen(ten, 60);
		
		serviceInstance.addCoinsToVendingMachinen(twenty, 50);
		assertEquals(28030, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.removeCoinsFromVendingMachinen(twenty, 50);
		
		serviceInstance.addCoinsToVendingMachinen(fifty, 40);
		assertEquals(29030, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.removeCoinsFromVendingMachinen(fifty, 40);
		
		serviceInstance.addCoinsToVendingMachinen(oneHundred, 30);
		assertEquals(30030, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.removeCoinsFromVendingMachinen(oneHundred, 30);
		
		serviceInstance.addCoinsToVendingMachinen(fiveHundred, 20);
		assertEquals(37030, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.removeCoinsFromVendingMachinen(fiveHundred, 20);
		
		serviceInstance.addCoinsToVendingMachinen(oneThousand, 10);
		assertEquals(37030, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.removeCoinsFromVendingMachinen(oneThousand, 10);
		
		assertEquals(27030, serviceInstance.getVendingMachinensCoinsValue());
	
	}

	@Test public void test_removeCoinsFromUser() {
		
		int ExpectedValue = 1755;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		
		serviceInstance.removeCoinsFromUser(one, 10);
		ExpectedValue = 1745;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		serviceInstance.addCoinsToUser(one, 10);
		
		serviceInstance.removeCoinsFromUser(five, 5);
		ExpectedValue = 1730;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		serviceInstance.addCoinsToUser(five, 5);
		
		serviceInstance.removeCoinsFromUser(ten, 5);
		ExpectedValue = 1705;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		serviceInstance.addCoinsToUser(ten, 5);
		
		serviceInstance.removeCoinsFromUser(twenty, 1);
		ExpectedValue = 1735;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		serviceInstance.addCoinsToUser(twenty, 1);
		
		serviceInstance.removeCoinsFromUser(fifty, 1);
		ExpectedValue = 1705;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		serviceInstance.addCoinsToUser(fifty, 1);
		
		serviceInstance.removeCoinsFromUser(oneHundred, 1);
		ExpectedValue = 1655;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		serviceInstance.addCoinsToUser(oneHundred, 1);
		
		serviceInstance.removeCoinsFromUser(fiveHundred, 1);
		ExpectedValue = 1255;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		serviceInstance.addCoinsToUser(fiveHundred, 1);
		
		serviceInstance.removeCoinsFromUser(oneThousand, 1);
		ExpectedValue = 755;
		assertEquals(ExpectedValue, serviceInstance.getUsersCoinsValue());
		serviceInstance.addCoinsToUser(oneThousand, 1);
		
	}
	
	@Test public void test_removeCoinsFromVendingMachinen() {
		
		int ExpectedValue = 27030;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		
		serviceInstance.removeCoinsFromVendingMachinen(one, 80);
		ExpectedValue = 26950;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.addCoinsToVendingMachinen(one, 80);
		
		serviceInstance.removeCoinsFromVendingMachinen(five, 70);
		ExpectedValue = 26680;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.addCoinsToVendingMachinen(five, 70);
		
		serviceInstance.removeCoinsFromVendingMachinen(ten, 60);
		ExpectedValue = 26430;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.addCoinsToVendingMachinen(ten, 60);
		
		serviceInstance.removeCoinsFromVendingMachinen(twenty, 50);
		ExpectedValue = 26030;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.addCoinsToVendingMachinen(twenty, 50);
		
		serviceInstance.removeCoinsFromVendingMachinen(fifty, 40);
		ExpectedValue = 25030;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.addCoinsToVendingMachinen(fifty, 40);
		
		serviceInstance.removeCoinsFromVendingMachinen(oneHundred, 30);
		ExpectedValue = 24030;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.addCoinsToVendingMachinen(oneHundred, 30);
		
		serviceInstance.removeCoinsFromVendingMachinen(fiveHundred, 20);
		ExpectedValue = 17030;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.addCoinsToVendingMachinen(fiveHundred, 20);
		
		serviceInstance.removeCoinsFromVendingMachinen(oneThousand, 10);
		ExpectedValue = 17030;
		assertEquals(ExpectedValue, serviceInstance.getVendingMachinensCoinsValue());
		serviceInstance.addCoinsToVendingMachinen(oneThousand, 10);
		
	}
	
	@Test public void test_returnCoinsFromVendingMachinen() {}
	
}
