package vendingMachineTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import vendingMachine.VendingMachine;

public class VendingMachineTest {
	
	@Test
	public void whenNickelIsInsertedScreenIsUpdated(){
		VendingMachine vm = new VendingMachine(); 
		vm.insertCoin("Nickel");
		String screen = vm.getDisplay();
		assertEquals("$0.05", screen );
	}
	
	@Test
	public void whenDimeIsInsertedScreenIsUpdated(){
		VendingMachine vm = new VendingMachine(); 
		vm.insertCoin("Dime");
		String screen = vm.getDisplay();
		assertEquals("$0.10", screen );
	}
	
	@Test
	public void whenInvalidCoinIsInsertedCoinIsRejected(){
		VendingMachine vm = new VendingMachine(); 
		vm.insertCoin("Penny");
		String screen = vm.getDisplay();
		assertEquals("Invalid Coin", screen );
	}
	
}
