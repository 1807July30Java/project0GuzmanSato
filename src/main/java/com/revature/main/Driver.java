package com.revature.main;

import java.util.Scanner;

import com.revature.methods.DriverMethods;
import com.revature.methods.UserMethods;
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
				while (!accountMade || !cancel) {
					System.out.println("Enter your desired username: ");
					System.out.println("if you would like to cancel, type cancel");
					String desiredName = input.nextLine();
					if (desiredName.equals("cancel")) {
						cancel = true;
					} else {
						// RUN possibleUser = getUserByName(desiredName);
						if (!DriverMethods.doesUserNameExist(desiredName)) {
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
				System.out.println("Please type in your username:");
				String username = input.nextLine();
				System.out.println("Please type in your password:");
				String password = input.nextLine();

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
