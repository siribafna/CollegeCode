package mycalculator;

import java.util.Stack;

// helps convert in binary, takes in string instead of int

public class BinaryConversion {
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
		int op1 = binToDecConversion(operandStack.pop());
		int op2 = binToDecConversion(operandStack.pop());
		if (op == '+')
			operandStack.push(decToBinConversion(op2 + op1));
		else if (op == '-')
			operandStack.push(decToBinConversion(op2 - op1));
		else if (op == '*')
			operandStack.push(decToBinConversion(op2 * op1));
		else if (op == '/')
			operandStack.push(decToBinConversion(op2 / op1));
		else if (op == '%') {
			operandStack.push(decToBinConversion(op2 % op1));
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

	public static int binToDecConversion(String str) {
		return Integer.parseInt(str, 2);
	}

	public static String decToBinConversion(int number) {
		return Integer.toBinaryString(number);
	}

	/////////////////////////////////////////////////////////////

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
		long op1 = binToDecConversionForLong(operandStack.pop());
		long op2 = binToDecConversionForLong(operandStack.pop());
		if (op == '+')
			operandStack.push(decToBinConversionForLong(op2 + op1));
		else if (op == '-')
			operandStack.push(decToBinConversionForLong(op2 - op1));
		else if (op == '*')
			operandStack.push(decToBinConversionForLong(op2 * op1));
		else if (op == '/')
			operandStack.push(decToBinConversionForLong(op2 / op1));
		else if (op == '%') {
			operandStack.push(decToBinConversionForLong(op2 % op1));
		}
	}

	public static long binToDecConversionForLong(String str) {
		return Integer.parseInt(str, 2);
	}

	public static String decToBinConversionForLong(long number) {
		return Integer.toBinaryString((int) number);
	}
}
