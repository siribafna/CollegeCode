
public class QuadraticEquation {

	private double a, b, c; // private doubles
	
	//constructor
	QuadraticEquation (double a, double b, double c) {
		this.a = a; // uses this to identify this object
		this.b = b;
		this.c = c;
	}
	// getters for all the coeffecients
	public double getA() {
		return this.a; 
	}
	public double getB() {
		return this.b;
	}
	public double getC() {
		return this.c;
	}
	 // method to calculate discriminant
	public double getDiscriminant() {
	
		double discriminant = Math.pow(getB(), 2) - 4 * (getA() * getC()); // formula to calculate discriminant
		return discriminant; // returns it as value of function
	}
	// method to calculate roots	
	public double getRoot1 (double discriminant) { 
		if (discriminant < 0) // if discriminant is 0, returns 0
			return 0;
		double rootOne = (-getB() + Math.sqrt(discriminant)) / (2 * getA()); // formula for getting root 1
		return rootOne; // returns as value of function
	
		
	}
	// repeat for root 2
	public double getRoot2 (double discriminant) {
		if (discriminant < 0)
			return 0;
		
		double rootTwo = (-getB() - Math.sqrt(discriminant)) / (2 * getA());
		return rootTwo;
	
		
	}
	
}
	
	
	

