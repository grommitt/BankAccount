package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		
		account1.seeTotal();
		account1.accountCount();
		account1.depositMoney("checking", 50);
		account1.seeTotal();
		account1.withdrawMoney("checking", 75);
		account1.seeTotal();
		account1.depositMoney("checking", 75);
		account1.seeTotal();
		account1.withdrawMoney("checking", 75);
		account1.seeTotal();
	}

}
