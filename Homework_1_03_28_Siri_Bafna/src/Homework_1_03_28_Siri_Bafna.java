/*
Homework 1 Exercise 3.28
Name: Siri Bafna
CS 2336.502
Date: 08/28/19
Project: To create a program that analyzes rectangles and their location/size, and assesses if they are a)inside one or the other, 
b) overlapping each other, or c) neither. Program was used with some basic math division, else and if statements and 
Scanner input to get input from the user.

 */

import java.util.Scanner;
public class Homework_1_03_28_Siri_Bafna {
	public static void main (String [] args) {
		Scanner input = new Scanner (System.in); // to allow user input
		
		System.out.print("Enter r1's center x-, y-coordinates, width, and height: "); // prompts user entry
		double r1CenterX = input.nextDouble(); //puts each value into its designated variable
		double r1CenterY = input.nextDouble();
		double r1Width = input.nextDouble();
		double r1Height = input.nextDouble();
		
		//repeat user entry and variable designation with r2 rectangle
		System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
		double r2CenterX = input.nextDouble();
		double r2CenterY = input.nextDouble();
		double r2Width = input.nextDouble();
		double r2Height = input.nextDouble();
		
		//calculations
		// R1 WIDTH AND HEIGHT
		double r1TopSide = r1CenterY - (r1Height/2);
		double r1BottomSide = r1CenterY + (r1Height/2);
		double r1RightSide = r1CenterX + (r1Width/2);
		double r1LeftSide = r1CenterX - (r1Width/2);
		
		//R2 WIDTH AND HEIGHT
		double r2TopSide = r2CenterY + (r2Height/2);
		double r2BottomSide = r2CenterY - (r2Height/2);
		double r2RightSide = r2CenterX + (r2Width/2);
		double r2LeftSide = r2CenterX - (r2Width/2);
		
		//r2 being inside the rectangle
		if ((r2TopSide >= r1TopSide) && (r2BottomSide <= r1BottomSide) && (r2RightSide <= r1RightSide) && (r2LeftSide >= r1LeftSide))
			System.out.println("r2 is inside r1");
		
		//r2 overlapping the triangle
		else if ((r1RightSide > r2LeftSide) || (r1BottomSide > r2TopSide)) // tests the borders of 
			System.out.println("r2 overlaps r1");
		// all else solutions, not inside or overlapping
		else 
			System.out.println("r2 does not overlap r1");			
				
	}

}
