
/*
 * In Class Assignment #3 
 * 10.02.2019
 * Siri Bafna
 * Purpose: To create a method to add all elements from a list and display it back to the user.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_11_12 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<Double> numbers = new ArrayList<Double>(); // create array of double numbers
		System.out.print("Enter 5 numbers to be added: ");
		for(int i = 0; i < 5; i++) { 
			numbers.add(input.nextDouble()); // user enters and initializes the array
		}
		
		System.out.println("The sum of all five numbers is " + sum(numbers)); // presents the return of sum of the numbers to the user, equivalent of calling it

	}
	
	public static double sum(ArrayList<Double> list) {
		
		double sum = 0; // initializing sum
		for(int i = 0; i < 5; i++) {
			sum += list.get(i); // for as long as the array goes, sum = sum + list[i];
		}
		return sum; //returns sum value to user
	}
}