package mycalculator;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[]) {

		// set up the Jframe for calculator and calls calculator
		Calculator window = new Calculator();
		window.setTitle("Programming Calculator");
		window.setVisible(true);
		window.setSize(450, 450);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}