package com.revature.methods;

import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public interface AccountMethods {
		
	//Dont need these if we just check if user is super
	//public BankAccount viewAccountSuper(int accountID);
	//public int deleteAccountSuper(int accountID);
	public List<BankAccount> viewAccount(User u);
	public int createAccount(User u,int accountID);
	public int deleteAccount(User u,int accountID);

	
	//Bonus
	public int TransactionHistory(int accountID);
	
	
}
