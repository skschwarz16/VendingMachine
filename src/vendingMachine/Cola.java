package vendingMachine;

import java.math.BigDecimal;

public class Cola extends Product {
	
	static int amountInMachine = 10;
	private BigDecimal price = new BigDecimal(".50");
	
	public BigDecimal getPrice() {
		return price;
	}
	
	protected void setAmountInMachine(int amount) {
		Cola.amountInMachine = amount;
		
	}
	
	public int getAmountInMachine() {
		return amountInMachine;
	}
	
}
