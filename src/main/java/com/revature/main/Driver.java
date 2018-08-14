package com.revature.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.methods.AccountMethods;
import com.revature.methods.BankMethods;
import com.revature.methods.DriverMethods;
import com.revature.methods.UserMethods;
import com.revature.pojo.BankAccount;
import com.revature.pojo.User;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean exitCode = false;
		System.out.println("Welcome to Saguz Bank");
		while (!exitCode) {
			System.out.println("Main Menu");
			System.out.println("Actions: login,register,exit");
			System.out.println("What would you like to do?: ");
			String action = input.nextLine();
			if (action.equals("register")) {
				// Registering
				System.out.println("thanks for choosing to register");
				boolean accountMade = false;
				boolean cancel = false;
				while (!accountMade && !cancel) {
					System.out.println("Enter your desired username: ");
					System.out.println("if you would like to cancel, type cancel");
					String desiredName = input.nextLine();
					if (desiredName.equals("cancel")) {
						cancel = true;
					} else {
						// RUN possibleUser = getUserByName(desiredName);
						UserMethods method = new DriverMethods();
						User possibleUser = method.getUserByName(desiredName);
						if (possibleUser != null) {
							// User with that name exists
							System.out.println("Username is taken, please select another");
							System.out.println("if you would like to cancel and login, please type cancel");
						} else {
							// Can make user with that name
							System.out.println("Enter your desired password: ");
							String password = input.nextLine();
							UserMethods dm = new DriverMethods();
							boolean success = dm.createUser(desiredName, password);

							if (success) {
								System.out.println("User account created: login at the main menu with credentials");
								accountMade = true;
							}

						}
					}
				}
			} else if (action.equals("login")) {
				// Logging in
				UserMethods method = new DriverMethods();

				boolean loggedIn = false;
				boolean exit = false;
				String username = "";
				String password = "";
				while (!exit) {
					System.out.println("Please type in your username:");
					username = input.nextLine();
					if (username.equals("cancel")) {
						exit = true;
					} else {
						User possibleUser = method.getUserByName(username);
						if (possibleUser == null) {
							// user with that name not existing
							System.out.println("Username does not exist, try again");
							System.out.println("if you would like to cancel and login, please type cancel");
						} else {
							System.out.println("Please type in your password:");
							password = input.nextLine();
							if (!possibleUser.getPassword().equals(password)) {
								System.out.println("Invalid login credentials");
							} else {
								// user has ok credentials
								User user = new User(username, password);
								AccountMethods bankMethod = new BankMethods();
								System.out.println("Welcome " + username);
								while (!exit) {
									System.out.println("What would you like to do?:");
									System.out.println("manage (accounts), exit , delete");
									String choice = input.nextLine();
									if (choice.equals("manage")) {
										List<BankAccount> bm = bankMethod.viewAccount(user);
										if (bm == null) {
											System.out.println("No accounts under this user");
										} else {
											boolean backout = false;
											while (!backout) {
												System.out.println("Account Number | Balance");
												for(BankAccount account : bm) {
													System.out.println(account.getAccountID() + " | $" + account.getBalance());
												}
												System.out.println("Would you like to perform an action on any account?");
												System.out.println("Type the account number you would like to change or 0 to return to user menu");
												int option = input.nextInt();
												if(option==0) {
													backout= true;
												}else {
													int accountNumber = option;
													System.out.println("you have selected " + accountNumber);
													System.out.println("Would you like to ...");
													System.out.println("add (funds), withdraw, delete");
													String accOption = input.nextLine();
													if(accOption.equals("add")) {
														System.out.println("How much");
														double amount = input.nextDouble();

													} else if (accOption.equals("withdraw")) {
														System.out.println("How much");
														double amount = input.nextDouble();
														boolean ahhh = false;
														try {
														   ahhh = BankMethods.changeValue(accountNumber,(-amount));
														} catch (SQLException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														} catch (IOException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
														if (ahhh) {
															System.out.println("Sucess");
														} else {
															System.out.println("Failure");
														}
														
													} else if (accOption.equals("delete")) {
														System.out.println("AHHHHHHH");
													}
												}
											}
											
										}
									} else if (choice.equals("exit")) {
										exit = true;
									} else if (choice.equals("delete")) {

									}
								}

							}
						}
					}

				}
			} else if (action.equals("exit")) {
				System.out.println("You have selected exit, are you sure(y/n):");
				String isSure = input.nextLine();
				if (isSure.equals("y")) {
					exitCode = true;
					System.out.println("Have a nice day!");
				}
			} else {
				System.out.println("Please enter a valid command");
			}
		}
		input.close();
	}
}
