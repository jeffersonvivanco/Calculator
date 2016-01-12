package Calculator;
import java.util.*; 
/**
 * @author Jefferson Vivanco 
 * @class This is the static class where the postfix converter and the postfix evaluator are located. This class' constructor is private cause
 * 		  we dont want the user creating instances of this class. 
 */
public class ExpressionTools {

	private ExpressionTools(){}; //Creating private constructor so it can't be instantiated.
	
	//-----------------------------------------------------//INFIX TO POSTFIX CONVERTER 
	/**
	 * @param infixEx This string is an infix expression from the input file. This is the string that will get converted to postfix 
	 * @return The postfix version of the infix expression that was passed 
	 */
	public static String infixToPostFix(String infixEx)
	{
		MyStack<String> operatorStack = new MyStack<String>();//stack used to store operators 
		String postFixExpression = ""; //expression that will be returned at the end (will contain the operands and operators)
		@SuppressWarnings("resource")
		Scanner token = new Scanner(infixEx); //used to read each line in a document 
		@SuppressWarnings("resource")
		Scanner token2 = new Scanner(infixEx);
		while(token2.hasNext())
		{
			if(token2.next().equals("(") && token2.next().equals(")"))
				return "invalid";
		}
		token2.close();
		int counterBracesLeft = 0;
		int counterBracesRight = 0;
		
		while(token.hasNext())//this loop is used to read all the elements in one line
		{			
			if(token.hasNextInt()) {		
				int nextInt = token.nextInt();
				if(nextInt < 0)
					return "invalid";
				postFixExpression = postFixExpression + nextInt + " ";
			}
			else {
				String nextToken = token.next();						//creating token
				Node<String> operator = new Node<String>(nextToken);	//creating a node of the token so it can be added to the stack 			
				if(nextToken.equals("("))
				{
					counterBracesLeft++;
					operatorStack.push(operator);			
				}
				else if(nextToken.equals("*"))
				{
					if(!operatorStack.empty())
					{			
						while(!operatorStack.empty()&&compare(operatorStack.peek().getData().toString(),nextToken)>=0)//checks if token from stack
																					//has greater precedence or equal, if it has, it gets popped 
						{		
							postFixExpression = postFixExpression+operatorStack.pop().getData()+" ";
						}
					}
					operatorStack.push(operator);
				}
				else if(nextToken.equals("/"))
				{
					if(!operatorStack.empty())
					{
						while(!operatorStack.empty()&&compare(operatorStack.peek().getData().toString(),nextToken)>=0)
						{
							postFixExpression = postFixExpression+operatorStack.pop().getData()+" ";
						}
					}
					operatorStack.push(operator);
				}
				else if(nextToken.equals("+"))
				{
					if(!operatorStack.empty())
					{
						while(!operatorStack.empty()&&compare(operatorStack.peek().getData().toString(),nextToken)>=0)
						{
							postFixExpression = postFixExpression+operatorStack.pop().getData()+" ";
						}
					}
					operatorStack.push(operator);
				}
				else if(nextToken.equals("-"))
				{
					if(!operatorStack.empty())
					{
						while(!operatorStack.empty()&&compare(operatorStack.peek().getData().toString(),nextToken)>=0)
						{
							postFixExpression = postFixExpression+operatorStack.pop().getData()+" ";
						}
					}
					operatorStack.push(operator);
				}
				else if(nextToken.equals(")"))
				{
					counterBracesRight++;
					while(!operatorStack.empty())
					{
						if(!operatorStack.peek().getData().equals("("))
							postFixExpression = postFixExpression+operatorStack.pop().getData()+" ";
						else
						{
							operatorStack.pop();
							break;
						}
					}
				}
				else{										//This else statement will take care if any other character is entered
					return "invalid";								//besides an operator or an operand 					
				}
			}			
		}
		token.close();
		while(!operatorStack.empty())
		{
			postFixExpression = postFixExpression+operatorStack.pop().getData()+" "; 
		}
		if(counterBracesRight != counterBracesLeft)
			return "invalid";
		return postFixExpression; 
	}
	//-----------------------------------------------------//COMPARE METHOD USE TO GET PRECEDENCE FOR INFIX TO POSTIX CONVERTER 
	/**
	 * @param xFromStack This is the operator from the top of the stack 
	 * @param token This is the operator from the token
	 * @return Compares both operators and decides which one has higher precedence, it returns 0 or 1 if it has equal or higher precendence, 
	 * 		   -1 if it has less
	 */
	public static int compare(String xFromStack, String token)
	{
		if(xFromStack.equals(token))
			return 0;
		else if(xFromStack.equals("+") && token.equals("-"))
			return 0;
		else if(xFromStack.equals("-")&& token.equals("+"))
			return 0;
		else if(xFromStack.equals("*") && token.equals("/"))
			return 0;
		else if(xFromStack.equals("/") && token.equals("*"))
			return 0; 
		else if(xFromStack.equals("*") && token.equals("+"))
			return 1; 
		else if(xFromStack.equals("/") && token.equals("+"))
			return 1; 
		else if(xFromStack.equals("*") && token.equals("-"))
			return 1; 
		else if(xFromStack.equals("/") && token.equals("-"))
			return 1;
		else 
			return -1;
	}
	//-----------------------------------------------------//POSTFIX EVALUATOR 

	
	/**
	 * @param expression This is the postfix expression that will get evaluated 
	 * @return The result of the postfix expression 
	 * @throws PostFixException The exception thrown if the expression cannot be evaluated 
	 * Note: This method was taken from the lecture 5 notes and modified to fit the program 
	 */
	@SuppressWarnings("resource")
	public static int evaluate(String expression) throws PostFixException { //throws exception if postfix cannot be evaluated
		
		MyStack<Integer> stack = new MyStack<Integer>();

		Node<Integer> value;
		String operator;
		Integer operand1;
		Integer operand2;
		Integer result = 0; //this is the result of the expression 

		Scanner tokenizer = new Scanner(expression);

		while (tokenizer.hasNext()) {
			if (tokenizer.hasNextInt()) {
				// Process operand.			
				value = new Node<Integer>(tokenizer.nextInt());
				stack.push(value);
			} else {
				// Process operator.
				operator = tokenizer.next();

				// Obtain second operand from stack.
				if (stack.empty()) {
					tokenizer.close();
					throw new PostFixException(
							"Not enough operands - stack underflow");
				}
				operand2 = stack.peek().getData();
				stack.pop();

				// Obtain first operand from stack.
				if (stack.empty()) {
					tokenizer.close();
					throw new PostFixException(
							"Not enough operands - stack underflow");
				}
				operand1 = stack.peek().getData();
				stack.pop();

				// Perform operation.
				if (operator.equals("/")){
					double resultOne = ((double)operand1)/((double)operand2);
					if(resultOne % 1 == 0)
						result = (operand1 / operand2);
					else 
						throw new PostFixException("number is not an integer");
				}
				else if (operator.equals("*"))
					result= operand1 * operand2;
				else if (operator.equals("+"))
					result = operand1 + operand2;
				else if (operator.equals("-"))
					result=operand1 - operand2;
				else {
					tokenizer.close();
					throw new PostFixException("Illegal symbol: " + operator);
				}
				// Push result of operation onto stack.
				stack.push(new Node<Integer>(result));
			}
		}
		tokenizer.close();
		// Obtain final result from stack.
		if (stack.empty())
			throw new PostFixException("Not enough operands - stack underflow");
		result = stack.peek().getData();
		stack.pop();

		// Stack should now be empty.
		if (!stack.empty())
			throw new PostFixException("Too many operands - operands left over");

		// Return the final.
		if(result<0)
			throw new PostFixException("The result is a negative number");
		return result;
	}	
}
