package vendingMachine;

import java.math.BigDecimal;

public class Chips {
	private static int amountInMachine = 10;
	private BigDecimal price = new BigDecimal("1.00");
	

	public void dispense() {
		setAmountInMachine(getAmountInMachine() - 1); 
	}

	public BigDecimal getPrice() {
		return price;
	}

	private static void setAmountInMachine(int amountInMachine) {
		Chips.amountInMachine = amountInMachine;
	}

	public static int getAmountInMachine() {
		return amountInMachine;
	}


}
