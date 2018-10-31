package infixToPostfix;

import java.util.Stack;

public class evaluatePostfix extends InfixToPostfix {
	
	public static int evaluate(String a) {
	
	//create a new stack of Integer
	Stack<Integer> evaluation_stack = new Stack<>();
	
	for (int i=0 ; i < a.length() ; i++)
	{
		char c = a.charAt(i);
		if (Character.isLetterOrDigit(c))
			//parse character to integer, and push to evaluation_stack
			evaluation_stack.push(Integer.parseInt(String.valueOf(c)));
		else
		{
			int op1 = evaluation_stack.pop();
			int op2 = evaluation_stack.pop();
			
			//for each case of */+- does its operation between op1 and op2
			switch (c)
			{
			case '+':
				evaluation_stack.push(op1 + op2);
				break;
			case '-':
				evaluation_stack.push(op2 - op1);
				break;
			case '*':
				evaluation_stack.push(op2 * op1);
				break;
			case '/':
				evaluation_stack.push(op2 / op1);
				break;
			}
		}	
	}
//return the final value
return evaluation_stack.peek();
	}
	public static void main(String[] args) {
		
		 //giving it an example
		 String exp = "8-3-4*6-3"; 
		
		 //change infix to Postfix and calling it a
		 String a = infixToPostfix(exp); 
		 System.out.println(a);
		 
		 //evaluate the value of a, and printing it
	     System.out.println(evaluate(a)); 
	}
}
