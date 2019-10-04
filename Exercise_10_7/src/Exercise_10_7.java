/*
 * In Class Assignment #3 
 * 10.02.2019
 * Siri Bafna
 * Purpose: To create an array of objects, specifically based on accounts, and changing the properties of it based on user choice
 */

import java.util.Scanner;

public class Exercise_10_7 {
	public static void main(String[] args) {
		Scanner inputID = new Scanner(System.in); 
	
		Account[] accounts = new Account[10]; // creates array of accounts objects
		
		for(int i = 0; i < 10; i++) {
			accounts[i] = new Account(i, 100); // initializes and creates an instance of each object with id number and initial balance
		}
		System.out.print("Enter an ID number: ");
		boolean loop = true; // initializing loop, never false because according to instructions, loop is never supposed to end
		int userChoice = 0; //initializing user choice
		while(loop) {
			userChoice = inputID.nextInt(); // user enters id number
			if (userChoice >= 0 && userChoice <= 9) { // tests for validity
				accountMenu(userChoice, accounts); // if valid, sends id to account menu method
			}
			System.out.print("Enter a number between 0 - 9: "); // if id isnt valid, or user finishes menu, prompt to try again
		}
	}
	
	public static void accountMenu(int iD, Account[] accounts) {
		Scanner input = new Scanner(System.in);
		System.out.println("*Menu*"); // display menu to user
		System.out.println("1) View Current Balance");
		System.out.println("2) Withdraw Money");
		System.out.println("3) Deposit Money");
		System.out.println("4) Exit");
		
		int userMenuChoice = 0; //initializing user choice
		
		boolean loop = true; // set loop to true to start with
		while(loop) {

			userMenuChoice = input.nextInt(); // enters user choice, goes into if statement according to choice
			if (userMenuChoice == 1) {
				System.out.println("Balance: " + accounts[iD].getBalance()); // simply presents the balance to the user
				System.out.println();
				System.out.println("1) View Current Balance"); // presents menu again because user has not chosen to exit
				System.out.println("2) Withdraw Money");
				System.out.println("3) Deposit Money");
				System.out.println("4) Exit");
			}
			else if (userMenuChoice == 2) {
				System.out.print("How much money would you like to withdraw?: "); // prompts user to withdraw money
				double money = input.nextDouble();
				accounts[iD].withdrawMoney(money); // sends money to account class, subtracts from balance
				System.out.println("Remaining Balance: " + accounts[iD].getBalance()); // presents balance back to user
				System.out.println();
				System.out.println("1) View Current Balance"); // presents menu again because user has not chosen to exit
				System.out.println("2) Withdraw Money");
				System.out.println("3) Deposit Money");
				System.out.println("4) Exit");
			}
			else if (userMenuChoice == 3) { // same as withdraw however, this time user adds to balance in account class
				System.out.print("How much money would you like to deposit?: ");
				double money = input.nextDouble();
				accounts[iD].depositMoney(money);
				System.out.println("Remaining Balance: " + accounts[iD].getBalance());
				System.out.println();
				System.out.println("1) View Current Balance"); // presents menu again because user has not chosen to exit
				System.out.println("2) Withdraw Money");
				System.out.println("3) Deposit Money");
				System.out.println("4) Exit");
			}
			else if (userMenuChoice == 4) { // user chose to exit, therefore
				loop = false; // exit loop
			}
		}	
	}
}	

 