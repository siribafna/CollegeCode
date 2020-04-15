package mycalculator;

import java.util.Stack;

// to make all calculations done in long if QWORD is in use

public class QWordConversion {
	// long answer;

	public long evaluateExpression(String expression) {
		Stack<Long> operandStack = new Stack<>();

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

				operandStack.push(new Long(token));
			}
		}

		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	public void processAnOperator(Stack<Long> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		long op1 = operandStack.pop();
		long op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
		else if (op == '%') {
			operandStack.push(op2 % op1);
		}
	}

	public String insertBlanks(String s) {
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

	public String decToHexaConversion(long number) {
		return Integer.toHexString((int) number);
	}

	public String decToBinConversion(long number) {
		return Integer.toBinaryString((int) number);
	}

	public String decToOctConversion(long number) {
		return Integer.toOctalString((int) number);
	}

	public String decToDecConversion(long number) {
		return Integer.toString((int) number);
	}

}
