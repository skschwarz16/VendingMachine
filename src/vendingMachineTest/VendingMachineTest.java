package vendingMachineTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vendingMachine.Candy;
import vendingMachine.Chips;
import vendingMachine.Cola;
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
	public void when50CentsHasBeenInsertedAndChipsSelectedDispenseChips(){
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		Chips chips = new Chips(); 
		int before = chips.getAmountInMachine();
		vm.select(chips);
		assertEquals(before - 1 , chips.getAmountInMachine());
		assertEquals("Thank You", vm.getDisplay());
	}
	
	@Test
	public void when25CentsHasBeenInsertedAndChipsSelectedDisplayPrice(){
		vm.insertCoin("Quarter");
		Chips chips = new Chips(); 
		int before = chips.getAmountInMachine();
		vm.select(chips);
		assertEquals(before , chips.getAmountInMachine());
		assertEquals("Price: $0.50", vm.getDisplay());
	}
	
	@Test
	public void when$1HasBeenInsertedAndColaSelectedDispenseCola(){
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		Cola cola = new Cola(); 
		int before = cola.getAmountInMachine();
		vm.select(cola);
		assertEquals(before - 1 , cola.getAmountInMachine());
		assertEquals("Thank You", vm.getDisplay());
	}
	
	@Test
	public void when65CentsHasBeenInsertedAndCandySelectedDispenseCandy(){
		vm.insertCoin("Quarter");
		vm.insertCoin("Quarter");
		vm.insertCoin("Nickel");
		vm.insertCoin("Dime");
		Candy candy = new Candy(); 
		int before = candy.getAmountInMachine();
		vm.select(candy);
		assertEquals(before - 1 , candy.getAmountInMachine());
		assertEquals("Thank You", vm.getDisplay());
	}
	
}
