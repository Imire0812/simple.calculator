package simple.calculator.console.com;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	
	interface Number {
		public String toString();

		public int toInt();
	}

	static class Expression {
		int lhs;
		int rhs;
		String op;

		int evaluate() {
			if (op.equals("+")) {
				return lhs + rhs;
			} else if (op.equals("-")) {
				return lhs - rhs;
			} else if (op.equals("*")) {
				return lhs * rhs;
			} else {
				return lhs / rhs;
			}
		}
	}

	int value;

	public String toString() {
		return String.valueOf(value);
	}

	public int toInt() {
		return value;
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Введите что надо посчитать: ");
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		Expression expr = parseString(line);
		System.out.println(expr.evaluate());

	}

	public static Expression parseString(String line) {
		Pattern pattern = Pattern.compile("^ *(\\d+) *([\\+\\-\\*\\/]) *(\\d+) *$");
		Pattern romanPattern = Pattern.compile("^ *([XVI]+) *([\\+\\-\\*\\/]) *([XVI]+) *$");
		
		Matcher matcher = pattern.matcher(line);
		String romanMatcher = romanPattern.toString();
		
		int lhs;
		int rhs;
		
		int leftInt;
		int rightInt;
		
		
		
		Expression expr = new Expression();
		
		if (matcher.find()) {
			lhs = Integer.parseInt(matcher.group(1));
			rhs = Integer.parseInt(matcher.group(3));
			expr.op = matcher.group(2);
		} else {
			throw new java.lang.RuntimeException("Incorrect expression");
		}
		expr.lhs = lhs;
		expr.rhs = rhs;
		return expr;
		
		if (romanMatcher.format(romanMatcher, args)) {
			leftInt = Convert.parse(romanMatcher.toUpperCase());
	        rightInt = Convert.parse(romanMatcher.toUpperCase());
	        expr.op = romanMatcher.toUpperCase();
		} else {
			throw new java.lang.RuntimeException("Incorrect expression");
		}
		
		
	}
}