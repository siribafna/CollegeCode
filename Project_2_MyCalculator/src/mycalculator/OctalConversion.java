package mycalculator;

import java.util.Stack;

// Calculations done for Oct, take a string instead of int

public class OctalConversion {

	public static String evaluateExpression(String expression) {
		Stack<String> operandStack = new Stack<>();

		Stack<Character> operatorStack = new Stack<>();
		expression = insertBlanks(expression);

		String[] tokens = expression.split(" ");

		for (String token : tokens) {
			if (token.length() == 0)
				continue;
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {

				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
						|| operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '%')) {
					processAnOperator(operandStack, operatorStack);
				}

				operatorStack.push(token.charAt(0));
			} else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/'
						|| operatorStack.peek() == '%')) {
					processAnOperator(operandStack, operatorStack);
				}

				operatorStack.push(token.charAt(0));
			} else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			} else if (token.trim().charAt(0) == ')') {

				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}

				operatorStack.pop();
			} else {

				operandStack.push(new String(token));
			}
		}

		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	public static void processAnOperator(Stack<String> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = octToDecConversion(operandStack.pop());
		int op2 = octToDecConversion(operandStack.pop());
		if (op == '+')
			operandStack.push(decToOctConversion(op2 + op1));
		else if (op == '-')
			operandStack.push(decToOctConversion(op2 - op1));
		else if (op == '*')
			operandStack.push(decToOctConversion(op2 * op1));
		else if (op == '/')
			operandStack.push(decToOctConversion(op2 / op1));
		else if (op == '%') {
			operandStack.push(decToOctConversion(op2 % op1));
		}
	}

	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '%')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}

	public static int octToDecConversion(String str) {
		return Integer.parseInt(str, 8);
	}

	public static String decToOctConversion(int number) {
		return Integer.toOctalString(number);
	}

	/////////////////////////////////////////////

	public static String evaluateExpressionForLong(String expression) {
		Stack<String> operandStack = new Stack<>();

		Stack<Character> operatorStack = new Stack<>();
		expression = insertBlanks(expression);

		String[] tokens = expression.split(" ");

		for (String token : tokens) {
			if (token.length() == 0)
				continue;
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {

				while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
						|| operatorStack.peek() == '*' || operatorStack.peek() == '/' || operatorStack.peek() == '%')) {
					processAnOperatorForLong(operandStack, operatorStack);
				}

				operatorStack.push(token.charAt(0));
			} else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
				while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/'
						|| operatorStack.peek() == '%')) {
					processAnOperatorForLong(operandStack, operatorStack);
				}

				operatorStack.push(token.charAt(0));
			} else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			} else if (token.trim().charAt(0) == ')') {

				while (operatorStack.peek() != '(') {
					processAnOperatorForLong(operandStack, operatorStack);
				}

				operatorStack.pop();
			} else {

				operandStack.push(new String(token));
			}
		}

		while (!operatorStack.isEmpty()) {
			processAnOperatorForLong(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	public static void processAnOperatorForLong(Stack<String> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		long op1 = octToDecConversion(operandStack.pop());
		long op2 = octToDecConversion(operandStack.pop());
		if (op == '+')
			operandStack.push(decToOctConversionForLong(op2 + op1));
		else if (op == '-')
			operandStack.push(decToOctConversionForLong(op2 - op1));
		else if (op == '*')
			operandStack.push(decToOctConversionForLong(op2 * op1));
		else if (op == '/')
			operandStack.push(decToOctConversionForLong(op2 / op1));
		else if (op == '%') {
			operandStack.push(decToOctConversionForLong(op2 % op1));
		}
	}

	public static String decToOctConversionForLong(long number) {
		return Integer.toOctalString((int) number);
	}

	public static long octToDecConversionForLong(String str) {
		return Integer.parseInt(str, 8);
	}

}
