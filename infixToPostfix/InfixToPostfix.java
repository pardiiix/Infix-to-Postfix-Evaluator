package infixToPostfix;

import java.util.Stack;

public class InfixToPostfix {
	
	//find higher precedence. Higher number means higher precedence
	public static int Prec(char ch)
	{
		switch (ch)
		{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		}
		return -1;
	}
	
	public static String infixToPostfix(String exp)
	{
		String postfix_string = new String("");
		
		//create a new stack
		Stack<Character> operator_stack = new Stack<>();
		
		for (int i=0 ; i < exp.length() ; i++)
		{
			char c = exp.charAt(i);
			
			//add digit to postfix_string
			if (Character.isLetterOrDigit(c))
				postfix_string += c;
			
			//if the character is neither letter nor digit, it is an operator
			else
			{
				//while previous operator is in operator_stack and the new operator's precedence is less or equal to
				//operator_stack's precedence, add the higher precedent operator to postfix_string
				while (!operator_stack.isEmpty() && Prec(c) <= Prec(operator_stack.peek()))
					postfix_string += operator_stack.pop();
				
				//push operator to operator_stack
				operator_stack.push(c);
			}	

		}
		while (!operator_stack.isEmpty())
			postfix_string += operator_stack.pop();
		return postfix_string;

	}
	
	public static void main(String[] args) {
		 String exp = "1+3*8"; 
	     System.out.println(infixToPostfix(exp)); 
	}
}
