/*
 * Homework 3 - Exercise 7.15
Siri Bafna
Purpose: to eliminate duplicates in an array
 */

import java.util.Scanner;

public class Exercise_07_15 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in); // allows user to enter inut
		System.out.print("Enter ten numbers: ");
		
		int numbers[] = new int[10];
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt(); // stores ten digit input as an array

		}
		int array[] = eliminateDuplicates(numbers);	// calls the function in order to start process
		
	}
	public static int[] eliminateDuplicates(int[] list) {
		int length = list.length;
		for(int i = 0; i < length - 1; i++) { 
			for(int j = i+1; j < length; j++) {
				if(list[i] == list[j]) { // compares one array to the other, digit by digit, if same number arrives, pushes to the end
					list[j] = list[length - 1]; // and lessens the length
					length--; // altogether dissapearing
				}
			}
		}
		System.out.print("The distinct numbers are: ");
		for(int i = 0; i < length; i++) {
			System.out.print(list[i] + " "); // presents it to the user
		}
		return list; // return type as array
	}

}
