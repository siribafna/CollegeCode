/*
 * Homework 4, Exercise 9.1
 * Siri Bafna
 * Purpose: Create a Rectangle class and calculate area and perimeter using width and height
 */
public class Exercise_09_01 {
	public static void main(String args[]) {
		
		// create two new rectangles given (width, height)
		Rectangle rec1  = new Rectangle(4, 40);
		Rectangle rec2 = new Rectangle(3.5, 35.9);
		
		// outputting results
		System.out.println("Rectangle 1: ");
		System.out.println("Width: " + rec1.width);
		System.out.println("Height: " + rec1.height);
		System.out.println("Area: " + rec1.getArea());
		System.out.println("Perimeter: " + rec1.getPerimeter());
		System.out.println();
		System.out.println("Rectangle 2: ");
		System.out.println("Width: " + rec2.width);
		System.out.println("Height: " + rec2.height);
		System.out.printf("Area: %.1f", rec2.getArea());
		System.out.println();
		System.out.println("Perimeter: " + rec2.getPerimeter());
	}

}
