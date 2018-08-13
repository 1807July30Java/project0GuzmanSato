package com.revature.methods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.User;
import com.revature.sql.ConnectionUtil;

public class BankMethods implements AccountMethods {

	public List<BankAccount> viewAccount(User u) {
		String stmt = "SELECT * FROM BANK_USERS WHERE BANK_USERS.USER_NAME = ? AND BANK_USERS.USER_PASSWORD = ?";

		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(stmt);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() == false) {
				System.out.println("Incorrect Credentials");
				return null;
			}
			else {
				System.out.println("Correct Credentials");
				int id = rs.getInt(1);
				
				String baStmt = "SELECT * FROM ACCOUNTS WHERE USER_ID = ?";
				connection.close();
				connection = ConnectionUtil.getConnection();
				PreparedStatement pstmt2 = connection.prepareStatement(baStmt);
				pstmt2.setInt(1, id);
				ResultSet rs2 = pstmt2.executeQuery();
				
				if(rs2.next() == false) {
					System.out.println("No Accounts");
				}
				
				rs2.beforeFirst();
				ArrayList<BankAccount> blist = new ArrayList<BankAccount>();
				while(rs2.next()) {
					int colAccID = rs2.findColumn("ACCOUNT_ID");
					int colBal = rs2.findColumn("ACCOUNT_BALANCE");
					BankAccount ba = new BankAccount(rs2.getInt(colAccID), rs2.getDouble(colBal), id);
					blist.add(ba);
				}
				
				
				rs.close();
				connection.close();
				
				rs2.close();
				connection.close();
				
				return blist;
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
		int uid = u.getUserID();
		String stmt = "INSERT INTO ACCOUNTS(ACCOUNT_BALANCE,USER_ID) VALUES (0,?)";
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(stmt);
			pstmt.setInt(1,uid);
			ResultSet rs = pstmt.executeQuery();
			connection.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteAccount(int accountID) {
		// TODO Auto-generated method stub
		String stmt = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
		Connection connection;
		try {
			connection = ConnectionUtil.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(stmt);
			pstmt.setInt(1,accountID);
			ResultSet rs = pstmt.executeQuery();
			connection.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int TransactionHistory(int accountID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
