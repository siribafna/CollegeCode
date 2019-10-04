/*
 * Homework 4 - Exercise 9.10
 * Siri Bafna
 * Purpose: use the Quadratic Equation and classes to show the use of classes and objects to calculate
 */

import java.util.Scanner;
public class Exercise_09_10 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in); // takes in user input
		double a, b, c; // to catch the double coefficients 
		
		System.out.print("Enter 3 numbers: (A, B, and C): "); // prompts user to enter
		a = input.nextDouble(); // input.nextDouble to initiate all the values
		b = input.nextDouble();
		c = input.nextDouble();
		
		QuadraticEquation practice = new QuadraticEquation(a, b, c); // creates new objects and sends coef. values to constructor
		double discriminant = practice.getDiscriminant(); // calls and stores the discriminant
		if (discriminant == 0) { // tests to see if discrim is 0 so only one root is shown
			System.out.println("Root 1: " + practice.getRoot1(discriminant));
		}
		else if(discriminant < 0) { // if less than 0, no roots are shown
			System.out.println("The equation has no roots.");
		}
		else { // all else, all roots are called and shown
			System.out.println("Root 1: " + practice.getRoot1(discriminant));
			System.out.println("Root 2: " + practice.getRoot2(discriminant));
		}
		
		
		
	}
}
