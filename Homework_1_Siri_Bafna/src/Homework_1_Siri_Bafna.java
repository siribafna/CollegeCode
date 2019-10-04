import java.util.Scanner;
public class Homework_1_Siri_Bafna {
	public static void main(String [] args) {
		Scanner input = new Scanner (System.in);
		int isbnNum;
		
		System.out.print("Enter the first 9 digits of an ISBN: ");
		isbnNum = input.nextInt();
		
		int d1 = isbnNum / 100000000;
		int leftoverISBN = isbnNum % 100000000;
		int d2 = leftoverISBN / 10000000;
		leftoverISBN = leftoverISBN % 10000000;
		int d3 = leftoverISBN / 1000000;
		leftoverISBN = leftoverISBN % 1000000;
		int d4 = leftoverISBN / 100000;
		leftoverISBN = leftoverISBN % 100000;
		int d5 = leftoverISBN / 10000;
		leftoverISBN = leftoverISBN % 10000;
		int d6 = leftoverISBN / 1000;
		leftoverISBN = leftoverISBN % 1000;
		int d7 = leftoverISBN / 100;
		leftoverISBN = leftoverISBN % 100;
		int d8 = leftoverISBN / 10;
		leftoverISBN = leftoverISBN % 10;
		int d9 = leftoverISBN / 1;
		leftoverISBN = leftoverISBN % 1;
		
		// d10 equation
		int d10 = ((d1 * 1) + (d2 * 2) + (d3 * 3) + (d4 * 4) + (d5 * 5) + (d6 * 6) + (d7 * 7) + (d8 * 8) + (d9 * 9)) % 11;
		
		if (d10 == 10)
			System.out.println("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + "X");
		else
			System.out.println("The ISBN-10 number is " + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10);
	}

}
