package vendingMachine;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class VendingMachine {
	private BigDecimal currentAmount = new BigDecimal(0);
	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	private String display = "";

	public void insertCoin(String coin) {
			coin = coin.toLowerCase();
			switch(coin){
			case("nickel"):
				currentAmount = currentAmount.add(new BigDecimal(.05));
				break;
			}
			setDisplay(n.format(currentAmount));
	}
	
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}
