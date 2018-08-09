package com.revature.console;

import java.util.Scanner;

public class BankConsole {
	public void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Saguz Bank");
		System.out.println("Do you have an account? (yes/no): ");
		String hasAccount = input.nextLine();
		if (hasAccount.equals("no") || hasAccount.equals("n")) {
			System.out.println("Would you like to create an account? (yes/no): ");
			String wantsToRegister = input.nextLine();
			if (wantsToRegister.equals("no") || wantsToRegister.equals("n")) {
				System.out.println("Then you have no business here");
			} else if (wantsToRegister.equals("yes") || wantsToRegister.equals("y")) {
				// REGISTRATION
				System.out.println("Awesome, please enter your desired username: ");

			}
		} else if (hasAccount.equals("yes") || hasAccount.equals("y")) {
			//HAS ACCOUNT -- LOGIN
		}
	}
}
