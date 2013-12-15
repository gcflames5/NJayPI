package net.njay.njaypi.Currency;

/**
 * 
 * @author Jordan
 *
 */

public class Currency{
	private String currencyName = "Dollars";
	private String currencySymbol = "$";
	
	
	public String getCurrencyName() {
		return currencyName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
}
