/*
 In Class Assignment
 Siri Bafna
 Purpose: To calculate and measure to see if a credit card number is valid in several ways
 */
import java.util.Scanner;
public class Exercise_6_31 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a credit card number as a long integer:"); // prompts the user to enter
		long number = input.nextLong(); // users input stored	
		
		if (isValid(number) == true) { // tests to see if method isValid is true, if yes, presents to the user
			System.out.println(number + " is valid");
		}
		if (isValid(number) == false)
			System.out.println(number + " is not valid");
		
	}
	public static boolean isValid(long number) {
		boolean valid = true; // initialization 
		long prefix = getPrefix(number, 1); 
		int k = 1; // for the first digit testing
		if (prefix < 4 || prefix > 6) { // if first isnt accurate
			prefix = getPrefix(number, 2);
			k = 2;			
			if (prefix != 37) // tests for 37
				return false; // false if neither of these qualify
			}	
		int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		
		if ((sum % 10) == 0) { // takes the sum out with modulus to see if its divisible by 10
			return true; // sets to true if sum is correct
			}
		return false;
	}
	public static long getPrefix(long number, int k) { 
		
		int size = getSize(number); // stored in the variable for easier use
		// just in case credit card numbers are different sizes, all are valid to be able to be counted as "accurate", did different division for each
		if (size == 13) {
			if (k == 1) {
				number = number / 1000000000000L;
				return number;
			}
			
			if (k == 2) {
				number = number / 1000000000000L;
				return number;
			}	
		}
		if (size == 14) {
			if (k == 1) {
				number = number / 10000000000000L;
				return number;
			}
			
			if (k == 2) {
				number = number / 10000000000000L;
				return number;			
			}
		}
		if (size == 15) {
			if (k == 1) {
				number = number / 100000000000000L;
				return number;
			}
			
			if (k == 2) {
				number = number / 100000000000000L;
				return number;
			}
		}
		if (size == 16) {
			if (k == 1) {
				number = number / 1000000000000000L;
				return number;
			}
			
			if (k == 2) {
				number = number / 1000000000000000L;
				return number;
			}
		}
			else if (size < 13 || size > 16)
				return 0;
		return 0;
		
	}
	public static boolean prefixMatched(long number, int d) { 
		long prefix = getPrefix(number, 1); 
		if (prefix == 4 || prefix == 5 || prefix == 6) // tests to see if it matches credit card requirements
			return true;
		prefix = getPrefix(number, 2);
		if (prefix == 37)
			return true;
		else
			return false;
		
	}
	public static int getSize(long d) {
		int count = 0;
		while (d > 0) { // continues to divide until we see how many times is necessary to reach single digits
			d = d / 10;
			count++;
		}
		return count; // returns as value
		
	}
	public static int sumOfDoubleEvenPlace(long number) { // used to calculate and multiply even numbers
		int sum = 0;
		for(int i = 1; i <= 16; i++) { // for loop to go through the credit number
			if(i % 2 == 0) { // for any even digit
				sum = sum + getDigit((int)(number % 10) * 2);  // access to getDigit to manipulate the number, then double       
			}
			number = number / 10; // to continue to minimize and move along the number
	      	}
		return sum;      
	}

	public static int getDigit(int number) {
		if (number < 10)
	     return number; // keeps the same if number is less than 10
		else
			return (number / 10) + (number % 10); // adds each digit instead

		}	
	public static int sumOfOddPlace(long number) {
		int sum = 0;
		for(int i = 1; i <= 16; i++) {
	      if(i % 2 == 1) // loop access to all the odd numbers
	    	  sum = sum + (int)(number%10); // helps get access to single digits and add to sum
	      number = number / 10; // get number minimized
	      }
		return sum;   
	}
}		
		