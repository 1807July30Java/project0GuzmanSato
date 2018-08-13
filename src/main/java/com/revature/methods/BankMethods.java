package com.revature.methods;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.BankAccount;
import com.revature.pojo.User;
import com.revature.sql.ConnectionUtil;

public class BankMethods implements AccountMethods {

	public BankAccount viewAccount(User u, int accountID) {
		BankAccount ba = null;
		int id;
		String stmt = "SELECT ID FROM USER WHERE USERNAME = "
				+ u.getUsername() + " AND PASSWORD = " + u.getPassword();
		
		try {
			PreparedStatement pstmt = ConnectionUtil.getConnection().prepareStatement(stmt);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next())
				return ba;
			else {
				id = rs.getInt(1);
				String baStmt = "SELECT * FROM ACCOUNT WHERE ID = " + id;
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	public int createAccount(User u, int accountID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteAccount(User u, int accountID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int TransactionHistory(int accountID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
