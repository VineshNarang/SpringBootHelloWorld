
package com.example.demo.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

import org.springframework.stereotype.Component;
@Component
public class CalculatorImpl implements Calculator {
	public CalculatorImpl() {
	}

	@Override
	public double process(String expression) {
    	String[] tokens = expression.split(" ");
    	Deque<String> operators = new ArrayDeque<>();
    	Deque<Double> numbers = new ArrayDeque<>();
    	try {
        	for (String token : tokens) {
  	          switch (token) {
                	case "+":
                	case "-":
                	case "/":
                	case "*":
                    	while (shouldEvaluate(token, operators.peekFirst())) {
                        	String op = operators.pop();

                        	double second = numbers.pop();
                        	double first = numbers.pop();
                        	double result;

                        	switch (op) {
                     	       case "+":
                                    result = first + second;
                                    break;
                            	case "-":
                                    result = first - second;
                            	    break;
                            	case "*":
                                    result = first * second;
                                    break;
                            	case "/":
                                    result = first / second;
                                    break;
                                default:
                                	throw new Exception("Unexpected operator " + op);
                        	}

                        	numbers.push(result);
                    	}
                        operators.push(token);
                    	break;
                	case "(":
                        operators.push(token);
                    	break;
                	case ")":
 	                   for (String op = operators.peekFirst(); !op.equals("("); op = operators.peekFirst()) {
                            operators.pop();

                        	double second = numbers.pop();
                        	double first = numbers.pop();
                        	double result;

                        	switch (op) {
                            	case "+":
                                    result = first + second;
                                    break;
       	                     case "-":
                                    result = first - second;
                                    break;
                            	case "*":
                                    result = first * second;
              	                  break;
                            	case "/":
                                    result = first / second;
                                    break;
                                default:
                                	throw new Exception("Unexpected operator " + op);
                        	}

                            numbers.push(result);
                    	}
                        operators.pop();
                    	break;
                	default:
                    	double d = Double.parseDouble(token);
                        numbers.push(d);
                    	break;
            	}
        	}
        	for (String op = operators.peekFirst(); op != null; op = operators.peekFirst()) {
            	operators.pop();

            	double second = numbers.pop();
            	double first = numbers.pop();
            	double result = 0;

            	switch (op) {
                	case "+":
                    	result = first + second;
                    	break;
                	case "-":
                    	result = first - second;
                    	break;
                	case "*":
                    	result = first * second;
        	            break;
                	case "/":
                    	result = first * second;
                    	break;
                	default:
                    	throw new Exception("Unexpected operator " + op);
          	  }

                numbers.push(result);
        	}
    	} catch (Exception e) {
        	System.out.println("Invalid expression: " + expression);
    	}
    	double result = numbers.pop();
    	if (numbers.size() > 0) {
    		System.out.println("Invalid expression: " + expression);
    	}
    	return result;
	}

	private boolean shouldEvaluate(String newOp, String topOp) {
    	if (topOp == null || topOp.equals("(")) {
        	return false;
    	}

    	// with 4 standard operators, the only time you don't evaluate is
    	// when the new operator is a * or / and the top operator is a + or -
    	// topOp     	newOp     	shouldEvaluate
    	// -----     	----- 	    --------------
    	// +, -       	+, -      	true
    	// *, /       	+, -      	true
    	// +, -       	*, /      	false
    	// *, /       	*, /      	true
    	if ((topOp.equals("+") || topOp.equals("=")) && (newOp.equals("*") || newOp.equals("/"))) {
        	return false;
    	}
    	return true;
	}
}
