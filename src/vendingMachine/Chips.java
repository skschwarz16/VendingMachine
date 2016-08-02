package vendingMachine;

import java.math.BigDecimal;

public class Chips {
	static int amountInMachine = 10;
	private BigDecimal price = new BigDecimal("1.00");
	
	public BigDecimal getPrice() {
		return price;
	}

	public void dispense() {
		amountInMachine--; 
	}
}
