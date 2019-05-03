package simple.calculator.console.com;

public class Expression {
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