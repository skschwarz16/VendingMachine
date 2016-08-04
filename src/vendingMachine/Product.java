package vendingMachine;

import java.math.BigDecimal;

public abstract class Product{
	static int amountInMachine = 0;
	
	public void dispense() {
		setAmountInMachine(amountInMachine - 1); 
	}

	public BigDecimal getPrice() {
		return null;
	}

	private static void setAmountInMachine(int amountInMachine) {
		Product.amountInMachine = amountInMachine;
	}

	public static int getAmountInMachine() {
		return amountInMachine;
	}

}
