/* Homework 3 - Exercise 7.11
 * 
 * Siri Bafna
 * Purpose: Prompt the user to enter a list and then find the standard deviation and mean of the list
 */

import java.util.Scanner;
public class Exercise_7_11 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in); // Scanner to get input from user
		
		System.out.print("Enter ten numbers: "); // prompt the user to enter the list
		double[] arr = new double[10]; // already know size is going to be ten numbers, initialization
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextDouble(); // place all the elements of the list into an array
		}
		
		double mean = mean(arr); // calls the mean function and stores the returned value
		double deviation = deviation(arr); // calls the deviation function and stores the returned value
		System.out.println("The mean is " + String.format("%.2f", mean)); // prints out in accurate decimal form represented
		System.out.println("The deviation is " + String.format("%.5f", deviation));

	}
	public static double mean(double[] x) {
		
		double sum = 0; // initialization of sum
		for(int i = 0; i < x.length; i++) 
			sum = sum + x[i]; // for loop continues to add onto sum
		double mean = sum / x.length; // after the loop ends, divides it by length aka total elements, returning an average
		return mean; // returns back to main
	}
	
	public static double deviation(double[] x) {
		
		double mean = mean(x); // calls in mean function to have value stored for this function as well
		double sum = 0; // initialization of sum
		for(int i = 0; i < x.length; i++) {
			sum = sum + (Math.pow(x[i] - mean, 2)); // for loop continues to add to sum with the formula of stan. deviation in mind, everything is powered by 2
		}
		
		double deviation = Math.sqrt(sum / (x.length - 1)); // uses sqrt function to square root the total and find the deviation
		return deviation; // returns value back to main function
	}
	


}
