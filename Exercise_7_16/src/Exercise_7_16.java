/*
 * Homework 3 - Exercise 7.16
 * Siri Bafna
 * Purpose: Perform linear search and binary search on a randomly allocate array
 */
public class Exercise_7_16 {
	public static void main(String args[]) {
		
		int[] list = new int[100000]; // create an array with 1000000 elements
		
		for(int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 5000); // randomly insert numbers from 0-50000
		}
		
		int key = (int) (Math.random() * 5000); // set key to be a random number as well

		double startTime = System.nanoTime(); // set start time for linear Search
		
		int linSearch = linearSearch(list, key); // call linear search on the array
		
		double endTime = System.nanoTime();  // end time noted
		double executionTime = (endTime - startTime) / 1000000; // find the delta and divide to get milliseconds
		
		System.out.println("Linear Search Execution Time: " + String.format("%.4f", executionTime) + " milliseconds"); // format and output time
		
		if (linSearch == -1) // if linSearch does not find number and index
			System.out.println("The number " + key + " was not found!"); // output not found
		else
			System.out.println("Linear Search: The number " + key + " was found at location " + linSearch); // else output location
		
		list = sortInAscendingOrder(list); // calls before time is stamped
		
		startTime = System.nanoTime(); // time to find binary search
		
		int binarySearch = binarySearch(list, key); // calls into binary search function
		
		endTime = System.nanoTime();
		executionTime = (endTime - startTime) / 1000000;
		
		System.out.println("Binary Search Execution Time: " + String.format("%.4f", executionTime) + " milliseconds"); // output formatted execution time
	
		if (binarySearch == -1) // if index and number arent found
			System.out.println("The number " + key + " was not found!"); // output not found
		else
			System.out.println("Binary Search: The number " + key + " was found at location " + binarySearch); // else output found
	}
	public static int linearSearch (int [] list, int key) { 
		// function for linear search
		
		for(int i = 0; i < list.length; i++) { // goes through each element
			if (key == list[i]) { // if key is found within array
				return i; // returns the index
			}
		}

		return -1; // if not found, returns -1
	}
	
	public static int binarySearch(int [] list, int key) {

		// function for binary search
		
		
		int low = 0; // initialize low for binary search
		int high = list.length - 1; // initialize high to be last index

		while (high >= low) { // loop starts to perform binary search
			int mid = (low + high) / 2; // initialize mid index for bin. search
			if (key < list[mid]) { // if key is less than mid, will search only the front half
				high = mid - 1; // will minimize the loop spectrum
			}
			else if (key == list[mid]) { // if key = middle index, send it 
				return mid;
			}
			else 
				low = mid + 1; // number is higher than mid, shortens spectrum to the second half
		}	
		return -1; // return -1 if not found anything
	}
	
	public static int [] sortInAscendingOrder(int [] list) {
		
		// for loop to sort the array in ascending order
				for (int i = 0; i < list.length - 1; i++) {
					
					int currentMin = list[i]; // stores term into variable
					int index = i; // stores location into index
					
					for (int j = i; j < list.length; j++) { // starts another loop to test it with different terms
						if (currentMin > list[j]) { // if greater than term + 1 than i, 
							currentMin = list[j]; // stores term of list into the current min
							index = j; // and location into index
						}
					}
					
					if (index != i) {
						list[index] = list[i]; // if the previous if statement didn't go through, stores past terms back into it
						list[i] = currentMin;
					}
					
				}
		return list; // return sorted array	
		
	}
	

}
