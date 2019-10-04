/*
 * In Class Assignment #3 
 * 10.02.2019
 * Siri Bafna
 * Purpose: To create a method to sort elements from a list and display it back to the user.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_11_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // prompt the user
		
 		ArrayList<Integer> numbers = new ArrayList<Integer>(); // creates a new array of ints
		System.out.print("Enter 5 numbers to be sorted: ");
		for(int i = 0; i < 5; i++) { 
			numbers.add(input.nextInt()); // initializes each array value
		}
	
		sort(numbers); // passes numbers to the sort method
	}
	
	public static void sort(ArrayList<Integer> list) {
		
		for(int i = 0; i < 5; i++) { // nested for loop comparing first element to each other element and on
			for(int j = list.size() - 1; j > i; j--) { // reverse loop going from end to front
				if(list.get(i) > list.get(j)) { // if first element is greater than last element
					int temp = list.get(j); // swapping method: stores smaller number into temp
					int jtemp = list.get(i); // stores greater number into jtemp
					list.set(i,temp);	// sets small number in the front
					list.set(j, jtemp); // and big number at the end
				}	
				// continues until all elements are tested
			}
		}
		System.out.println("These are the five numbers, sorted: "); // presents back to the user
		for(int i = 0; i < 5; i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
}
