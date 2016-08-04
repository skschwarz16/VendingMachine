package vendingMachine;

import java.math.BigDecimal;

public class Candy extends Product {
	static int amountInMachine = 10;
	private BigDecimal price = new BigDecimal(".65");
	public BigDecimal getPrice() {
		return price;
	}

}
