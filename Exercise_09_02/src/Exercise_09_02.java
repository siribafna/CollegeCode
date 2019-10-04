/*
 * Homework 4 - Exercise 9.2
 * Siri Bafna
 * Purpose: Create a stock class which calculates price changes and reports back to console
 */

public class Exercise_09_02 {
	public static void main(String args[]) {
		// create new stock with desired requirements
		Stock assignedStock = new Stock("ORCL", "Oracle Corporation");
		// assign values to the data fields of Stock class
		assignedStock.previousClosingPrice = 34.5;
		assignedStock.currentPrice = 34.35;
		
		//output results to console in absolute value
		System.out.printf("Price Change (Absolute Value): %.2f",Math.abs(assignedStock.getChangePercent()));
		System.out.print("%");
		System.out.println();
		
		// output results to console regular (probably negative)
		System.out.printf("Price Change (Regular): %.2f",assignedStock.getChangePercent());
		System.out.print("%");
		System.out.println();
	}

}
