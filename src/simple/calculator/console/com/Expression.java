package simple.calculator.console.com;

public class Expression {
	int lhs;
	int rhs;
	String op;

	int evaluate() throws Exception {
		
		//I get a lot of code with a switch
		try {
			if (op.equals("+")) {
				return lhs + rhs;
			} else if (op.equals("-")) {
				return lhs - rhs;
			} else if (op.equals("*")) {
				return lhs * rhs;
			} else {
				return lhs / rhs;
			}
		} catch (Exception e) {
			throw new Exception("Invalid");
		}
		
		
	}

}
