package mycalculator;

import java.util.Stack;

// calculations done for HEXA conversion, to take in String instead of int

public class HexaConversion {

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
		int op1 = hexToDecConversion(operandStack.pop());
		int op2 = hexToDecConversion(operandStack.pop());
		if (op == '+')
			operandStack.push(decToHexaConversion(op2 + op1));
		else if (op == '-')
			operandStack.push(decToHexaConversion(op2 - op1));
		else if (op == '*')
			operandStack.push(decToHexaConversion(op2 * op1));
		else if (op == '/')
			operandStack.push(decToHexaConversion(op2 / op1));
		else if (op == '%') {
			operandStack.push(decToHexaConversion(op2 % op1));
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

	public static int hexToDecConversion(String str) {
		return Integer.parseInt(str, 16);
	}

	public static String decToHexaConversion(int number) {
		return Integer.toHexString(number);
	}

	/////////////////////////////////////////

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
		long op1 = hexToDecConversionForLong(operandStack.pop());
		long op2 = hexToDecConversionForLong(operandStack.pop());
		if (op == '+')
			operandStack.push(decToHexaConversionForLong(op2 + op1));
		else if (op == '-')
			operandStack.push(decToHexaConversionForLong(op2 - op1));
		else if (op == '*')
			operandStack.push(decToHexaConversionForLong(op2 * op1));
		else if (op == '/')
			operandStack.push(decToHexaConversionForLong(op2 / op1));
		else if (op == '%') {
			operandStack.push(decToHexaConversionForLong(op2 % op1));
		}
	}

	public static long hexToDecConversionForLong(String str) {
		return Integer.parseInt(str, 16);
	}

	public static String decToHexaConversionForLong(long number) {
		return Integer.toHexString((int) number);
	}
}
