package net.njay.njaypi.Currency;

/** 
 * 
 * @author Jordan
 *
 */

public class Account {
	private String username;
	private double balance;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void addToBalance(double amount) {
		balance += amount;
	}
	
	public void subtractFromBalance(double amount) {
		balance -= amount;
	}
	
	public void payTo(Account acc, double amount) {
		this.balance -= amount;
		acc.addToBalance(amount);
	}
}
