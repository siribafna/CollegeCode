/*
 * In Class Assignment #3 
 * 10.02.2019
 * Siri Bafna
 * Purpose: To create a method to remove all duplicates from a list and display it back to the user.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_11_13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<Integer> numbers = new ArrayList<Integer>(); // creates new array to store the number
		System.out.print("Enter 10 numbers: ");
		for(int i = 0; i < 10; i++) { 
			numbers.add(input.nextInt()); // initializes the array with values
		}
		 
		removeDuplicates(numbers); // calls the remove duplicates method, passing the list

	}
	
	public static void removeDuplicates(ArrayList<Integer> list) {
		
		for(int i = 0; i < 10; i++) { // for loop to test for and remove duplicates
			for(int j = list.size() - 1; j > i; j--) { // nested for loop to test from starting of array to end of array
				if(list.get(i) == list.get(j)) { // if beginning element = any element after it
					list.remove(i); // removes that element from the list
				}	

			}
		}
		
		System.out.println("These are the remaining distinct numbers: "); // presents the distinct numbers back to user
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
