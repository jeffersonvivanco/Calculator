package Calculator;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * @author Jefferson Vivanco
 * @class This is the runnable class. In this class we read the input file and print out the results of each line to the output file. Here we also
 * 		  check if the user entered two command line arguments. 
 */
public class Calculator {
	
	/**
	 * @param args This is the arguments at the command line, there should be two
	 * @throws FileNotFoundException this is the exception in case the file the use puts doesn't exist 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		//-------------------------------------------------------//Making sure the user entered 2 command line arguments		
		if(args.length != 2)
		{
			System.err.println("Please make sure you entered 2 command line "
					+ "arguments");
			System.exit(-1);
		}
		//-------------------------------------------------------//CREATING FILE & CHECKING IF FILE EXISTS AND READABLE 		
		File userFile = new File(args[0]); 
		if(!userFile.exists() || !userFile.canRead())
		{
			System.err.printf("ERROR: cannot read file %s.\n\n",args[0]);
			System.exit(-1);
		}
		//-------------------------------------------------------//READING INPUT FILE, CREATING AND VERIFYING OUTPUT FILE , AND WRITING TO OUPUT FILE
		Scanner readFile = new Scanner(userFile);
		File outputFile = new File(args[1]);
	
		PrintWriter output = new PrintWriter(outputFile);

		while(readFile.hasNext()) // while the file input file has lines left, convert to postfix and evaluate
		{	
			String y = ExpressionTools.infixToPostFix(readFile.nextLine());
			try {											// This is surrounded by a try catch because it sees if it raises an exception, 
															//if it does it returns INVALID to the output file 
				output.println(ExpressionTools.evaluate(y));
			}catch (PostFixException e) {
				output.println("INVALID");
			}catch (ArithmeticException e){
				output.println("INVALID");
			}
		}
		readFile.close();
		output.close();

		
	}
}
