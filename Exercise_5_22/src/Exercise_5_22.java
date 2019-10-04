import java.util.Scanner;

public class Exercise_5_22 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in); // in order to get user input
		int numberOfYears; // number of years as an int
		double annualInterestRate, loanAmount; // two variables as doubles
		
		System.out.print("Loan Amount: "); 
		loanAmount = input.nextDouble(); //input loan
		System.out.print("Number of Years: ");
		numberOfYears = input.nextInt(); // input number of years
		System.out.print("Annual Interest Rate: ");
		annualInterestRate = input.nextDouble(); //input interestRate

		double monthlyInterestRate = annualInterestRate / 1200; // divided by 100 * 12, 100-to get it in percentage form, 12- number of monthly payments in a year
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate,  numberOfYears * 12)); //formula for finding monthly payment
		double totalPayment = monthlyPayment * numberOfYears * 12; // formula to get total payment
		
		System.out.println();
		String monthlyPaymentFormatted = String.format("%.2f", monthlyPayment); // formatting monthly payment into 2 digits
		String totalPaymentFormatted = String.format("%.2f", totalPayment); // formatting total payment into 2 digits
		System.out.println("Monthly Payment: " + monthlyPaymentFormatted); //output for user
		System.out.println("Total Payment: " + totalPaymentFormatted);
		
		System.out.println();
		  
		System.out.printf("%-5s %20s %20s %17s", "Payment#", "Interest", "Principal", "Balance");
		System.out.println();
		int paymentNum = 0; //initialization of payment
		double balance = loanAmount;
	
		while (paymentNum < numberOfYears * 12) { // while loop presenting data as long as payment deadlines are passed
			double interest = monthlyInterestRate * balance;
			double principal = monthlyPayment - interest;
			balance = balance - principal;
			paymentNum++;
			
			//formatting
			String interestFormatted = String.format("%.2f", interest);
			String principalFormatted = String.format("%.2f", principal);
			String balanceFormatted = String.format("%.2f", balance);
			
			System.out.printf("%-5s %20s %20s %20s", paymentNum, interestFormatted, principalFormatted, balanceFormatted);
			System.out.println();
		
		}
	}

}
