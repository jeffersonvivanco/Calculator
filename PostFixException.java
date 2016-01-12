package Calculator;

/**
 * @author Jefferson Vivanco
 * @class This class is to create the post fix exception used in the ExpressionTools class and calculator class. 
 * 		  Note: This class was not created by me, it was in the project instructions
 */
@SuppressWarnings("serial")
public class PostFixException extends Exception{

	/**
	 * Calls the super class (Exception class) in this constructor
	 */
	public PostFixException(){
		super();
	}
	
	/**
	 * @param message Calls the super class with message
	 */
	public PostFixException(String message){
		super(message); 
	}
}
