/*
 Homework 2 Exercise 5.23
 Show summation results and compare them to show accuracy of computations
 */
public class Exercise_5_23 {
	public static void main(String[] args) {
		int N = 50000; // final number iteration
		double sumLeftToRight = 0; // initialization
		double sumRightToLeft = 0;
		
		for (int i = 1; i <= N; i++) { // for loop to keep sum growing
			sumLeftToRight = sumLeftToRight + (1.0/i); // left to right, traditional method
			sumRightToLeft = sumRightToLeft + (1.0/(N - i + 1)); // +1 for debugging, backwards, subtract from N and continue to add
		}
		
		System.out.println("Left to Right Summation: " + sumLeftToRight); // output to user
		System.out.println("Right to Left Summation: " + sumRightToLeft);
	}
}

