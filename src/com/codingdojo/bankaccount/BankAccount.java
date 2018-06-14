package com.codingdojo.bankaccount;


public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int numberOfAccounts;
	private static double totalCashStored;
	
	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	// create a private method that returns a random ten digit account number
	/*private long newAccount() {
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		long new_account_number = rand.nextLong(1_000_000_000L, 9_999_999_999L); 
		return new_account_number;
	}*/
	private String newAccount() {
		String accountNumber = "";
		for(int i = 0; i<10; i++) {
			int random = (int) (Math.random()*10);
			accountNumber += random;
		}
		return accountNumber;
	}
	
	// constructor
	public BankAccount() {
		this.accountNumber = newAccount();
		numberOfAccounts++;
	}
	
	public static int accountCount() {
		System.out.println("There are " + numberOfAccounts + " bank accounts ");
		return numberOfAccounts;
	}
	
	// allow a user to deposit money into either the checking or saving, be sure to add to total amount stored
	public void depositMoney(String accountType, double amount) {
		if(accountType == "checking") {
			this.checkingBalance += amount;
		}
		else if(accountType == "savings") {
			this.savingsBalance += amount;
		}
		totalCashStored += amount;
		System.out.println("Deposited $" + amount + " into your "+ accountType + " account.");
	}
	
	// withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds
	public void withdrawMoney(String accountType, double amount) {
		if(accountType == "checking") {
			if(amount > this.checkingBalance) {
				System.out.println("You only have $" + this.getCheckingBalance() + " in you checking account.Insufficient funds.");
				System.out.println("$" + amount + " was not withdrawn from you checking account.");
			}
			else if(amount <= this.checkingBalance) {
				this.checkingBalance -= amount;
				System.out.println("Withdrew $" + amount + " from your checking account.");
			}
		}
		else if(accountType == "savings") {
			if(amount > this.savingsBalance) {
				System.out.println("You only have $" + this.getSavingsBalance() + " in you savings account.Insufficient funds.");
				System.out.println("$" + amount + " was not withdrawn from you savings account.");
			}
			else if(amount <= this.checkingBalance) {
				this.savingsBalance -= amount;
				System.out.println("Withdrew $" + amount + " from your savings account.");
			}
		}
		totalCashStored -= amount;
	}
	
	// see the total money from the checking and savings
	public void seeTotal() {
		System.out.println("You have $" + this.getCheckingBalance() + " in your checking account.");
		System.out.println("You have $" + this.getSavingsBalance() + " in your savings account.");
	}
}
