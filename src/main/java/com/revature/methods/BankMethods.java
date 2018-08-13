package com.revature.methods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.BankAccount;
import com.revature.pojo.User;
import com.revature.sql.ConnectionUtil;

public class BankMethods implements AccountMethods {

	public BankAccount viewAccount(User u) {
		String stmt = "SELECT * FROM BANK_USERS WHERE USER_NAME = ? AND USER_PASSWORD = ?";
		
		
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(stmt);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2, u.getPassword());
			ResultSet rs = pstmt.executeQuery();
			connection.close();

			if(rs.next() == false) {
				System.out.println("Incorrect Credentials");
				connection.close();
				return null;
				
			}
			

			else {
				System.out.println("Correct Credentials");
				int id = rs.getInt(1);
				String baStmt = "SELECT * FROM ACCOUNTS WHERE USER_ID = ?";
				connection = ConnectionUtil.getConnection();
				pstmt = connection.prepareStatement(baStmt);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				connection.close();
				
				return new BankAccount(rs.getInt(1),rs.getDouble(2),id);
				
				
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
