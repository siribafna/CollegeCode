/*
 * Homework 3 - Exercise 7.19
 * 
 * Siri Bafna
 * Purpose: Create a program which analyzes a list from the user and sees if it is sorted in ascending order or not
 */


import java.util.Scanner;
public class Exercise_7_19 {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter list: ");
		int size = input.nextInt();
		int[] list = new int[size];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = input.nextInt();
		}
		
		boolean tOrF = isSorted(list);
		if (tOrF == false)
			System.out.println("The list is not sorted");
		else
			System.out.println("The list is already sorted");
			
	}
	
	public static boolean isSorted(int [] list) {
		
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i+1])
				return false;
		}
		return true;
	}
}
