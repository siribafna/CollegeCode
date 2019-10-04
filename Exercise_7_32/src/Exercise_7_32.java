/* Homework 3 - Exercise 7.32
 * 
 * Siri Bafna, CS 2336.502
 * Purpose: To create a partition method that divides an array into two parts, parts smaller than the pivot
 * and greater than the pivot, aka the first element
 */ 

import java.util.Scanner;
public class Exercise_7_32 {
	public static void main(String args[]) {
		Scanner input = new Scanner (System.in); // use scanner CS to prompt user
		
		System.out.print("Enter list: "); // prompts user to enter list
		
		int size = input.nextInt(); // first number in the list stored as the size as instructed
		
		int[] partitionNum = new int[size]; // initialize the array
		
		for(int i = 0; i < partitionNum.length; i++) { // puts in rest of the list into the array with first number as the size
			partitionNum[i] = input.nextInt();
		}
		
		partition(partitionNum); // calls the partition method and sends the array to it for manipulation
	}
	
	public static int partition(int[] list) {

		int pivotLocation = 0; // initializing pivot location as being the first element of the array
		
		for(int i = 0; i < list.length; i++) { // for loop to go through array 
			
			if (list[i] < list[pivotLocation]) { // if a number is less than the first element
				int shift = list[i];
				for (int j = i; j > 0; j--) { // shifting elements to the RIGHT, from the textbook, except changed the increments to fit the situation
					list[j] = list[j-1];
				}
				list[0] = shift; // as it sends it to the front, 
				pivotLocation++; // pivot location, aka the "first element" also shifts to the right
			}
			
		}
		
		System.out.print("After the partition, the list is ");
		
		for(int i = 0; i < list.length; i++) {
			
			System.out.print(list[i] + " "); // prints out array to the user
		}
	return 1; // return statement serves no purpose, therefore returns 1 aka true
	} 
}
