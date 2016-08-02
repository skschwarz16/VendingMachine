package vendingMachine;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class VendingMachine {
	private BigDecimal currentAmount = new BigDecimal(0);
	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	private String display = "INSERT COIN";

	public void insertCoin(String coin) {
			coin = coin.toLowerCase();
			BigDecimal increase = new BigDecimal(0); 
			switch(coin){
			case("nickel"):
				increase = new BigDecimal(".05");
				break;
			case("dime"):
				increase = new BigDecimal(".10");
				break;
			case("quarter"):
				increase = new BigDecimal(".25");
				break;
			default:
				setDisplay("Invalid Coin");
				return;
			}
		    currentAmount = currentAmount.add(increase);
			setDisplay(n.format(currentAmount));
	}
	
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void select(Chips chips) {
		if(currentAmount.compareTo(chips.getPrice()) >= 0){
			chips.dispense();
			currentAmount = currentAmount.subtract(chips.getPrice());
			if(currentAmount.equals(0))
				returnCoins();
			setDisplay("Thank You");
		}
		else{
			setDisplay("Price: " + n.format(chips.getPrice()));
		}
		
	}

	private void returnCoins() {
		//coins released to coin return
		currentAmount = new BigDecimal(0);
		
	}

}
