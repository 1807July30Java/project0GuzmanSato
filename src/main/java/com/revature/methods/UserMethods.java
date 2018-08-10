package com.revature.methods;

import com.revature.pojo.User;

public interface UserMethods {
	
	public int createUser(String username, String password);
	public int deleteUser(String username, int accountID);
	public int updateUser(String username);
	
	
	
}
