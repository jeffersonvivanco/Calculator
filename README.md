# Calculator

Program Description: 

This program is a backend for a very simple calculator. The program takes in an input file (first command line argument) with mathematical expressions such as:
23 - 2 * 5
4 - 9 * 11 + 155 * ( 21 - 17 ) / 3
( ( 15 / ( 7 - ( 1 + 1 ) ) ) - ( 2 + ( 1 + 1 ) ) 
and determines their value. Each expression is on its own line. As the second command line argument the program takes in the name of the output file. The program prints out to the output file whether an expression was valid or invalid. The program evaluates the mathematical expressions by converting them from an infix expression to a postfix expression. 

Program Files: 

Calculator.java: This class provides the main method. This class is responsible for reading the input file and creating an                    output file and writing the results on it. 

ExpressionTools.java: This class provides the methods for infix to postfix conversion and to evaluate the postfix                                  expressions. 

MyStack.java: This class provides a referenced based inplementation of a stack. 

PostFixException.java: This class represents the exception that should be thrown when errors in the expression occur. 

Sample input file: You may use this file to test out the program--> desExpressions.txt 
