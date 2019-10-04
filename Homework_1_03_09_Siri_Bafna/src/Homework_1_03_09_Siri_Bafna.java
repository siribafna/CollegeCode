/*
Homework 1 Exercise 3.09
CS 2336.502
Name: Siri Bafna
Date: 08/28/19
Project: To create a program that displays the ten digit ISBN number after using user input
to read in the first 9 with the use of modulus and if statements, as well as Scanner.

 */
import java.util.Scanner;
public class Homework_1_03_09_Siri_Bafna {
	public static void main(String [] args) {
		Scanner input = new Scanner (System.in); // to allow user input from console
		int isbnNum; // variable that gets the 9-digit ISBN from the user
		
		System.out.print("Enter the first 9 digits of an ISBN: "); // asking for user entry
		isbnNum = input.nextInt(); // to get user input
		
		int d1 = isbnNum / 100000000; //in order to get to the first digit
		int leftoverISBN = isbnNum % 100000000; //in the leftover variable, all digits but the first digit are included 
		int d2 = leftoverISBN / 10000000; // division and remainders continue to access each digit and store in a variable
		leftoverISBN = leftoverISBN % 10000000;
		int d3 = leftoverISBN / 1000000;
		leftoverISBN = leftoverISBN % 1000000;
		int d4 = leftoverISBN / 100000;
		leftoverISBN = leftoverISBN % 100000;
		int d5 = leftoverISBN / 10000;
		leftoverISBN = leftoverISBN % 10000;
		int d6 = leftoverISBN / 1000;
		leftoverISBN = leftoverISBN % 1000;
		int d7 = leftoverISBN / 100;
		leftoverISBN = leftoverISBN % 100;
		int d8 = leftoverISBN / 10;
		leftoverISBN = leftoverISBN % 10;
		int d9 = leftoverISBN / 1;
		leftoverISBN = leftoverISBN % 1;
		
		// d10 equation
		int d10 = ((d1 * 1) + (d2 * 2) + (d3 * 3) + (d4 * 4) + (d5 * 5) + (d6 * 6) + (d7 * 7) + (d8 * 8) + (d9 * 9)) % 11;
		
		// if/else statements display full ISBN to user
		if (d10 == 10)
			System.out.println("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + "X");
		else
			System.out.println("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);
	}

}
