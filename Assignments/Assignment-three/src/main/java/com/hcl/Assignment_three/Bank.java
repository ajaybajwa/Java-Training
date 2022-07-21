package com.hcl.Assignment_three;

public class Bank {

	public float deposit(float amount, float balance ) {
		float newBalance = balance + amount;
		System.out.println("Balance after deposit is $" +newBalance);
		return newBalance;
	}
	
	public float withdraw(float amount, float balance) {
		if (balance >= amount) {
			float newBalance = balance - amount;
			System.out.println("Balance after withdrawal is $" +newBalance);
			return newBalance;
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Bank b = new Bank();
		b.deposit(5000, 10000);
		b.withdraw(2000, 15000);
	}
}
