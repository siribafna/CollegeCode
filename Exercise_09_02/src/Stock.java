
public class Stock {
	
	//string data fields
	String symbol;
	String name;
	
	// double data fields
	double previousClosingPrice;
	double currentPrice;
	
	Stock(String specifiedSymbol, String specifiedName) {
		
		// constructor assigns values to strings
		symbol = specifiedSymbol;
		name = specifiedName;
	}
	
	double getChangePercent() {
		 // method calculates percentage difference
		double amount = (currentPrice - previousClosingPrice) / previousClosingPrice;
		double percentage = amount * 100;
		return percentage;
	}
	
}
