package com.assesment.calcs.util;

public final class CalcsUtil {

	public static int evaluate(Integer operand1, Integer operand2, String operator){
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
	
	public static Boolean isOperator(String element){
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
