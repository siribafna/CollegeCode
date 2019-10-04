
/*
 * In Class Assignment #3 
 * 10.02.2019
 * Siri Bafna
 * Purpose: To create a program that calculated all prime numbers from 1-120 and puts it in a stack of ints, and presented them back to the user
 * in a reverse order
 */

public class Exercise_10_6 {

	public static void main(String[] args) {
		
		StackOfIntegers stackOfInt = new StackOfIntegers(); // creates a new stack of integers
		
		for(int i = 2; i <= 120; i++) {
			if(testPrime(i)) // calls testprime, which tests to see if number is prime, if true
				stackOfInt.push(i); // pushes that number into the stack
		}
		
		System.out.println("Prime numbers from 1 - 120 (in reverse order): "); // after all numbers are being pushed,
		
		while(!stackOfInt.empty()) {
			System.out.print(stackOfInt.pop() + " "); // 'pops', back to user the numbers in that stack
		}
		
	}
	
	public static boolean testPrime(int i) {
		for(int j = 2; j <= i / 2; j++) { // starting at 2 and not going greater than i/2, tests to see if it can be divisible by an even number
			if(i % j == 0) // if true, and no remainder exists, 
				return false; // they are not prime
		}
		return true; // else they can return as prime numbers
		
	}
}
