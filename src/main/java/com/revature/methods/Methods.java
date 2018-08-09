package com.revature.methods;

import com.revature.pojo.User;

public interface Methods {
	
	//Register
	public User login(String username, String password);
	public User register(String username,String password);
	
	//Super User
	public int createUser(String username, String password);
	public int deleteUser(String username, int accountID);
	public int updateUser(String username);
	public int viewAccountSuper(int accountID);
	
	//User
	public int chooseAccount(int num);
	public int createTransaction(int accountID,double amount);
	public int viewAccount(int accountID);
	
	//Super User and User
	public int createAccount(String username, String password);
	public int deleteAccount(String username, String password);
	
	//Bonus
	public int TransactionHistory(String accountID);
	
	
}
