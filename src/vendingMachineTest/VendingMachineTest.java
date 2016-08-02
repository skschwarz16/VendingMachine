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
	
	public void when$1HasBeenInsertedAndChipsSelectedDispenseChips(){
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		Chips chips = new Chips(); 
		vm.select(chips);
	}
	
}
