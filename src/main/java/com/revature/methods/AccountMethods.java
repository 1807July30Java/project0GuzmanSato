package com.revature.methods;

import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public interface AccountMethods {
		
	public BankAccount viewAccountSuper(int accountID);
	public BankAccount viewAccount(int accountID);
	public int createAccount(int accountID);
	public int deleteAccount(int accountID);
	public int deleteAccountSuper(int accountID);
	
	//Bonus
	public int TransactionHistory(int accountID);
	
	
}
