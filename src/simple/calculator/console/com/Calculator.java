package simple.calculator.console.com;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	int lhs;
	int rhs;
	String op;

	public static void main(String[] args) throws Exception {
	
	        System.out.println("Enter what you need to calculate: ");
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			Expression expr = parseString(line);
			
			System.out.println(expr.evaluate());
			System.out.println(Convert.format(expr.evaluate()));

			}

	public static Expression parseString(String line) {

		Pattern pattern = Pattern.compile("^ *(\\d+) *([\\+\\-\\*\\/]) *(\\d+) *$");
		Pattern romanPattern = Pattern.compile("^ *([XVI]+) *([\\+\\-\\*\\/]) *([XVI]+) *$");

		Matcher matcher = pattern.matcher(line);
		Matcher romanMatcher = romanPattern.matcher(line);

		int lhs = 0;
		int rhs = 0;

		Expression expr = new Expression();

		if (matcher.find()) {
			lhs = Integer.parseInt(matcher.group(1));
			rhs = Integer.parseInt(matcher.group(3));
			expr.op = matcher.group(2);
		} else if (romanMatcher.find()){
			lhs = Convert.parse(romanMatcher.group(1));
			rhs = Convert.parse(romanMatcher.group(3));
			expr.op = romanMatcher.toString();
		} else {
			throw new java.lang.RuntimeException("Incorrect expression");
		}
		expr.lhs = lhs;
		expr.rhs = rhs;
		return expr;

	}
}