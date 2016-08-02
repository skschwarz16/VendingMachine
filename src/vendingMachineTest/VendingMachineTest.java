package vendingMachineTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import vendingMachine.VendingMachine;

public class VendingMachineTest {
	
	@Test
	public void whenCoinIsInsertedScreenIsUpdated(){
		VendingMachine vm = new VendingMachine(); 
		vm.insertCoin("Nickel");
		String screen = vm.getDisplay();
		assertEquals("$0.05", screen );
	}
	
}
