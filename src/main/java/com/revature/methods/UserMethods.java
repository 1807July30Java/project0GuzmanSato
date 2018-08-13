package com.revature.methods;

import com.revature.pojo.User;

public interface UserMethods {
	
	public boolean createUser(String username, String password);
	//for super user
	public boolean deleteUser(String username);
	//I dont think we need this:
	//public boolean updateUser(String username);
	public User getUserByName(String username);
	
	public User getUser(String username,String password);	
}
