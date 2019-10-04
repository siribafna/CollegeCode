
public class Rectangle {
 
	double width, height; // two variables in the class
	
	//default constructor setting default values
	Rectangle () { 
		width = 1;
		height = 1;
	}
	
	// constructor makeing 
	Rectangle(double specifiedWidth, double specifiedHeight) {
		width = specifiedWidth;
		height = specifiedHeight;
		
	}
	
	double getArea() {
		// get area function
		double area = width * height;
		return area;
	}
	
	double getPerimeter() {
		// get perimeter function
		double perimeter = width * 2 + height * 2;
		return perimeter;
	}
	
}
