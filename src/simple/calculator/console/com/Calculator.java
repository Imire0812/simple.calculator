package simple.calculator.console.com;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		
		System.out.println("Введите что надо посчитать: ");
		Scanner rs = new Scanner(System.in);
		int first = rs.nextInt();
		String operator = rs.next();
		int second = rs.nextInt();
		
		if (operator.equals("*")){
            System.out.println((first * second));
        }
        if (operator.equals("/")){
            System.out.println((first / second));
        }
        if (operator.equals("+")){
            System.out.println((first + second));
        }
        if (operator.equals("-")){
            System.out.println((first - second));
        }
		
	}

}