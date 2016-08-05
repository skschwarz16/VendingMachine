package vendingMachine;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class VendingMachine {
	private BigDecimal currentAmount = new BigDecimal(0);
	public BigDecimal nickelValue = new BigDecimal(".05");
	public BigDecimal dimeValue = new BigDecimal(".10");
	public BigDecimal quarterValue = new BigDecimal(".25");
	NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	private String display = "INSERT COIN";
	private ArrayList<String> coinsReturned = new ArrayList<>(); 
	

	public void insertCoin(String coin) {
			coin = coin.toLowerCase();
			BigDecimal increase = new BigDecimal(0); 
			switch(coin){
			case("nickel"):
				increase = nickelValue;
				break;
			case("dime"):
				increase = dimeValue;
				break;
			case("quarter"):
				increase = quarterValue;
				break;
			default:
				setDisplay("Invalid Coin");
				return;
			}
		    currentAmount = currentAmount.add(increase);
			setDisplay(n.format(currentAmount));
	}

	public <T extends Product> void select(T item) {
		if(currentAmount.compareTo(item.getPrice()) >= 0){
			item.dispense();
			currentAmount = currentAmount.subtract(item.getPrice());
			if(!currentAmount.equals(0))
				returnCoins();
			setDisplay("Thank You");
		}
		else{
			setDisplay("Price: " + n.format(item.getPrice()));
		}
		
	}

	public void returnCoins() {
		int numberOfQuartersToReturn = currentAmount.divideToIntegralValue(quarterValue).intValueExact();
		currentAmount = currentAmount.remainder(quarterValue);
		for(int i = 0; i < numberOfQuartersToReturn; i++){
			coinsReturned.add("Quarter");
		}
		
	}

	public String[] getCoinsReturned() {
		return coinsReturned.toArray(new String[0]); 
	}
	
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}
