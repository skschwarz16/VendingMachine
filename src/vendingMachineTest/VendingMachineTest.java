package vendingMachineTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vendingMachine.Chips;
import vendingMachine.VendingMachine;

public class VendingMachineTest {
	VendingMachine vm;
	@Before
	public void setUp(){
		vm = new VendingMachine();
	}
	
	@Test
	public void whenNickelIsInsertedScreenIsUpdated(){ 
		vm.insertCoin("Nickel");
		String screen = vm.getDisplay();
		assertEquals("$0.05", screen );
	}
	
	@Test
	public void whenDimeIsInsertedScreenIsUpdated(){
		vm.insertCoin("Dime");
		String screen = vm.getDisplay();
		assertEquals("$0.10", screen );
	}
	
	@Test
	public void whenInvalidCoinIsInsertedCoinIsRejected(){
		vm.insertCoin("Penny");
		String screen = vm.getDisplay();
		assertEquals("Invalid Coin", screen );
	}
	
	@Test
	public void whenNoCoinHasBeenInsertedDisplayInsertCoint(){
		assertEquals("INSERT COIN", vm.getDisplay());
		
	}
	
	@Test
	public void when$1HasBeenInsertedAndChipsSelectedDispenseChips(){
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		Chips chips = new Chips(); 
		int before = Chips.getAmountInMachine();
		vm.select(chips);
		assertEquals(before - 1 , Chips.getAmountInMachine());
		assertEquals("Thank You", vm.getDisplay());
	}
	
	@Test
	public void when75CentsHasBeenInsertedAndChipsSelectedDisplayPrice(){
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		Chips chips = new Chips(); 
		int before = Chips.getAmountInMachine();
		vm.select(chips);
		assertEquals(before , Chips.getAmountInMachine());
		assertEquals("Price: $1.00", vm.getDisplay());
	}
	
}
