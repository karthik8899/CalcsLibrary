package com.assesment.calcs;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class CalcsAppliation {

	public static void main(String[] args) {

		HashMap<String,Integer>  priority = new HashMap<String,Integer>();
		priority.put("*", Integer.valueOf(2));
		priority.put("/", Integer.valueOf(2));
		priority.put("+", Integer.valueOf(1));
		priority.put("-", Integer.valueOf(1));
		
		if(args.length > 0) {
			System.out.println("Input entered: " + args[0]);
		} else {
			System.out.println("Please, enter expression to caluculate");
		}
		Stack<String> operatorStack = new Stack<String>();
		Stack<Integer> operandStack = new Stack<Integer>();
		String expr = args[0].trim();
  
		StringTokenizer st = new StringTokenizer(expr,"+-*/", true);
		while(st.hasMoreElements()) {
			
			String currentElement=st.nextToken();
			System.out.println(currentElement);
			if(!isOperator(currentElement)){
				operandStack.push(Integer.parseInt(currentElement));
				
			}else{
				while(!operatorStack.isEmpty() && 
						priority.get(currentElement) < priority.get(operatorStack.peek())){
					Integer operand2= operandStack.pop();
					Integer operand1= operandStack.pop();
					String operator= operatorStack.pop();
					operandStack.push(evaluate(operand1, operand2, operator));
				}
				
				operatorStack.push(currentElement);
				
			}
			
		}
		while(!operatorStack.isEmpty()){
			Integer operand2= operandStack.pop();
			Integer operand1= operandStack.pop();
			String operator= operatorStack.pop();
			operandStack.push(evaluate(operand1, operand2, operator));
		}
		
		System.out.println("result is  "+ operandStack.pop());
		
		
	}
	
	private static int evaluate(Integer operand1, Integer operand2, String operator){
		if(operator.equals("+")){
			return operand1 + operand2;
		}
		else if(operator.equals("-")){
			return (operand1 - operand2);
		}
		else if(operator.equals("*")){
			return operand1 * operand2;
		}
		else if(operator.equals("/")){
			return operand1 / operand2;
		}
		return -1;
	}
	
	private static Boolean isOperator(String element){
		if(element.equalsIgnoreCase("+") ||
		   element.equalsIgnoreCase("-") ||
		   element.equalsIgnoreCase("*") ||
		   element.equalsIgnoreCase("/"))
		{
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
			
	}

}
