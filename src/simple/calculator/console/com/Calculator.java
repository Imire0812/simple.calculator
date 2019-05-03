package simple.calculator.console.com;

import java.io.IOException;
import java.lang.NullPointerException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	 boolean numValid = true;
     boolean opValid = true;
	public static class Expression {
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
		
		int lhs = 0;
		int rhs = 0;

		Expression expr = new Expression();
		
		if (matcher.find()) {
			lhs = Integer.parseInt(matcher.group(1));
			rhs = Integer.parseInt(matcher.group(3));
			expr.op = matcher.group(2);
		} else if (line.length() == -1) {
			int resultInt = 0;
			int lhs1 = Convert.parse(romanMatcher.toUpperCase());
			int rhs2 = Convert.parse(romanMatcher.toUpperCase());
	        expr.op = romanMatcher.toString();
	        
		} 
		expr.lhs = lhs;
		expr.rhs = rhs;
		return expr;
		
		
		
	}
}