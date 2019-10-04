import java.util.Scanner;

public class Exercise_7_15 {
	public static void main(String args[]) {
		Scanner input = new Scanner (System.in);
		int numbers[] = new int[10];
		
		System.out.print("Enter ten numbers: ");
		
		for (int i = 0; i < 10; i++) {
			numbers[i] = input.nextInt();
		}
		
		System.out.println("Wow.");
		
	}
		
}
