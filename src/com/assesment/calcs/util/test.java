package com.assesment.calcs.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test {
public static void main(String args[]){
	String myString = "51+3-2";

	 List<String> operatorList = new ArrayList<String>();
	 List<String> operandList = new ArrayList<String>();
	 StringTokenizer st = new StringTokenizer(myString, "+-*/", true);
	 while (st.hasMoreTokens()) {
	    String token = st.nextToken();

	    if ("+-/*".contains(token)) {
	       operatorList.add(token);
	    } else {
	       operandList.add(token);
	    }
	 }

	 System.out.println("Operators:" + operatorList);
	 System.out.println("Operands:" + operandList);
}
}
