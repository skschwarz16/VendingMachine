package vendingMachine;

import java.math.BigDecimal;

public abstract class Product{
		
	public void dispense() {
		setAmountInMachine(getAmountInMachine() - 1); 
	}

	public abstract BigDecimal getPrice();

	abstract void setAmountInMachine(int amount);

	abstract int getAmountInMachine();
}
