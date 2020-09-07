package com.Telstra.bank;

public class Account {
	public long A_no;
	private double balance;
	public static long min_balance, max_deposit;
	
	static {
		min_balance = 1000;
		max_deposit = 1000000;
	}
	
	public Account(long a_no, double balance) {
		super();
		A_no = a_no;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(int amount){
		if(amount<max_deposit) {
			balance+=amount;
			return true;
		}
		return false;	
	}
	
	public boolean withdraw(int amount){
		if(this.balance-amount<min_balance) {
			balance-=amount;
			return true;
		}
		return false;	
	}
}
