/*
 Homework 2 - Exercise 5_21
 Date: 09/04/2019
 Name: Siri Bafna
 Purpose: Create a program that uses user input for years and loan amount and calculates loans with different percentages of interest
 */
import java.util.Scanner;
public class Exercise_5_21 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in); // in order to get user input
		int loanAmount, numberOfYears; // two variables we get from user, loan amount and number of years
		
		System.out.print("Loan Amount: "); 
		loanAmount = input.nextInt(); //input loan
		System.out.print("Number of Years: ");
		numberOfYears = input.nextInt(); // input number of years
		
		double annualInterestRate = 5.000; // program consists of interest rates only from 5-8%, starting at 5.000
		
		System.out.printf( "%1s %22s %16s", "Interest Rate","Monthly Payment", "Total Payment"); //formatted printing
		System.out.println(); //extra statement to fix format
		while (annualInterestRate <= 8.000) { // while loop presenting data as long as interest rate is from 5-8%
			double monthlyInterestRate = annualInterestRate / 1200; // divided by 100 * 12, 100-to get it in percentage form, 12- number of monthly payments in a year
			double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate,  numberOfYears * 12)); //formula for finding monthly payment
			double totalPayment = monthlyPayment * numberOfYears * 12; // formula to get total payment
			
			String interestRateFormatted = String.format("%.3f", annualInterestRate);  // formatting the interest rate into 3 digits
			String monthlyPaymentFormatted = String.format("%.2f", monthlyPayment); // formatting monthly payment into 2 digits
			String totalPaymentFormatted = String.format("%.2f", totalPayment); // formatting total payment into 2 digits
			
			System.out.printf( "%-5s %20s %20s",interestRateFormatted + "%", monthlyPaymentFormatted,totalPaymentFormatted); // present data to user with proper spacing
			System.out.println(); // formatting debug, helps put in different lines
			
			annualInterestRate = annualInterestRate + .125; // continues to add increments of 1/8 until loop ends
		}
		
	}

}
