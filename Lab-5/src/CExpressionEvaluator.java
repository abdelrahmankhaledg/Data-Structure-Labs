import java.util.EmptyStackException;

/*****
 * This Class is used to change the infix expressions to postfix expressions using infixToPostfix function 
 *  String infix expression
 *  String postfix expression
 * The class is also used to  evaluate the numeral postfix expressions using the evaluate fucntion
 *  String numeral postfix expression 
 *  integer value representing the result of the postfix expression and if the result if float it is casted to integer
 * 
 * 
 * 
 */
public class CExpressionEvaluator implements IExpressionEvaluator{
	
	/***
	 * Check if the given symbol is an operator + - /* .
	 * @param  symbol   
	 * @return A boolean to determine whether the input character is an operator.
	 */
	private boolean checkSymbol(char symbol) {
		
		
		
		if(symbol=='+'||symbol=='-'||symbol=='*'||symbol=='/') {
		return true;
		}
		return false;
	}
	
	
	/***
	 * Used to check the precedence of operators.
	 * @param symbol.
	 * @return An integer 1 or 0 where 1 means the precedence of / and * and the 0 means the precedence of + and - .
	 */
	private int checkPrecedence(char symbol) {
		
		
	
		
		
		if(symbol=='*'||symbol=='/') {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	/**
	 * Used to check if the character is a number or an alphabet.
	 * @param  symbol .
	 * @return a boolean which determines whether the input character is an alphabetical character or numeral value .
	 * 
	 */
	private boolean isAlnum(char symbol) {
		
		if(isNum(symbol)||isAlpha(symbol)){
			return true;
		}
		return false;
	}
	
	
	/**
	 *
	 * @param  symbol
	 * @return a boolean to determine whether the input character is an alphabetical character
	 */
	
	private boolean isAlpha(char symbol) {
		
		if((symbol>=65&&symbol<=90)||(symbol>=97&&symbol<=122)) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param symbol
	 * @return a boolean to determine whether the input character is a a digit or not 
	 */
	
	private boolean isNum(char symbol) {
		
		
		
		
		if((symbol>=48&symbol<=57)) {
			return true;
		}
		return false;
	}
	
	

	/****
	 * Used to remove the spaces in a String .
	 * @param  expression.
	 * @return String similar to input but has no spaces.
	 */
	private String removeSpaces(String expression) {
		
		
		
		
		
		
		String noSpaces="";
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)!=' ') {
				noSpaces+=expression.charAt(i);
			}
		}
		return noSpaces;
	}
	
	
	/***
	 * Used to change negative sign such as -5 to 0-5 .
	 * @param expression.
	 * infix expression
	 * @return A String similar to the input but any negative number is converted to subtraction from zero operation (0 - ).
	 */
	
	private String changeNegative(String expression) {
		
		
		
		
		String noSpaceExpression=removeSpaces(expression);
		String noNegative="";
		for(int i=0;i<noSpaceExpression.length();i++) {
			
			if(noSpaceExpression.charAt(i)=='-') {
				
				//Check if the next Character after the - is not an operator nor parenthesis 
				
				if((i+1)<noSpaceExpression.length()&&isAlnum(noSpaceExpression.charAt(i+1))) {
					
					//Check if the - is the first character in the string or it comes after an opening parenthesis or it comes after an operator 
					//then it is a negative sign and not a minus operator 
					
					if(i==0||checkSymbol(noSpaceExpression.charAt(i-1))||noSpaceExpression.charAt(i-1)=='(') {
						noNegative+="(0-";
						i++;//To start from i+1 (To start after  the -)
						while(i<noSpaceExpression.length()&&isAlnum(noSpaceExpression.charAt(i))) {
							noNegative+=noSpaceExpression.charAt(i);
							i++;
						}
						noNegative+=")";
						i--;//It will be incremented in the next iteration
					}
					else {//It's Minus Operator
						noNegative+=noSpaceExpression.charAt(i);
					}
				}
				else {//It's Minus Operator 
					noNegative+=noSpaceExpression.charAt(i);
				}
			}
			else {//A Variable Number Parenthesis or Operator other than minus
				
				noNegative+=noSpaceExpression.charAt(i);
			}
		}
		//The noNegative String contains no spaces and has no negative operands but subtraction from zero operation (0 -) 
		return noNegative;
	}
	
	/*****
	 * Checks whether the operator in the input expression are wrong formed such as /* (one operator after another) 
	 * " * an operator at the beginning of the expression
	 * * " an operator before the end of the expression
	 * (/ an operator after the opening parenthesis
	 * / )an operator before the closing parenthesis
	 * @param noNegative
	 *  An infix expression with no spaces and any negative number is converted to subtraction from zero (0 - ) 
	 * @return a boolean which determines whether there is an error in the expression or not.
	 */
	
	private boolean checkOperators(String noNegative) {
		
		
		
		
		//Expression starts with an operator.even if it is minus sign because we converted the minus sign into 0 - 
		if(checkSymbol(noNegative.charAt(0))) {

			return true;
		}
			//Operator comes at the end of an expression
		if(checkSymbol(noNegative.charAt(noNegative.length()-1))) {
			
			
			return true;
		}
		
		for(int i=0;i<noNegative.length();i++) {
			if(noNegative.charAt(i)=='(') {
				//Operator comes after the opening of parenthesis 
				if((i+1)<noNegative.length()&&checkSymbol(noNegative.charAt(i+1))){
					return true;
				}
			}
			else if(noNegative.charAt(i)==')') {
					//operator comes before the closing of a parenthesis 
				if(((i-1)>=0&&checkSymbol(noNegative.charAt(i-1)))) {
						
						return true;
				}
			}
				//Operator comes after another operator 
				else if (checkSymbol(noNegative.charAt(i))) {
					if((i+1)<noNegative.length()&&checkSymbol(noNegative.charAt(i+1))) {
						return true;
					}
				}
			}
		return false;
		}
	

	/**Check if there is an error with the numbers in the expression such as 400 500 with no operator between them .
	 * or 4000 A and no operator between them
	 * or 5B A number and a variable with no * operator between them
	 * @param expression.
	 * infix expression
	 * @return boolean to determine if the expression is not correct.
	 */
	
	
	private boolean checkNumbers(String expression) {
		
		
		
		int i=0;
		while(i<expression.length()) {
			//If the current character is a digit 
			if(isNum(expression.charAt(i))) {
			//Loop until the character is not a digit 
			while(i<expression.length()&&isNum(expression.charAt(i))) {
				i++;
			}
			//Check if it is not the last character
			if(i<expression.length()) {
				//Loop until there is no spaces 
				while(i<expression.length()&&expression.charAt(i)==' ') {
					i++;
				}
				//If there is no operator or closing parenthesis after the number and this is not the last number in the string 
				//then return that an error occurred 
				if(i<expression.length()&&!checkSymbol(expression.charAt(i))&&expression.charAt(i)!=')') {
					return true;
				}
			}
			
			}
			i++;
		}
		
		return false;
	}
	
	
	/**
	 * Checks if there is errors in the expression such as 
	 * A525 a variable and a number with no operators between them 
	 * or AB two variables with no operators between them 
	 *@param noNegative
	 *An infix expression with no spaces and any negative number is converted to subtraction from zero (0 - ) 
	 *@return A boolean which determines if the expression is not correct
	 *
	 */
	
	private boolean checkVariables(String noNegative) {
		
		for(int i =0;i<noNegative.length();i++) {
			//Check if the current character is an alphabetical character
			if(isAlpha(noNegative.charAt(i))) {
				//Check if the next character is a number 
				if((i+1)<noNegative.length()&&isAlnum(noNegative.charAt(i+1))) {
					return true;
				}
			}
		}
		return false;
	}
	
	/***
	 * Checks if there is other characters than + - / * ( ) Alphabets and characters in the expression 
	 * @param noNegative
	 * An infix with no spaces and any negative number is converted to subtraction from zero (0 - ) 
	 * @return  boolean which determines if there are special characters in the input expression or not   
	 * 
	 * */ 
	private boolean checkSpecialCharacter(String noNegative) {
	
		for(int i=0;i<noNegative.length();i++) {
			if(!checkSymbol(noNegative.charAt(i))&&noNegative.charAt(i)!='('&&noNegative.charAt(i)!=')' &&!isAlnum(noNegative.charAt(i))) {
				return true;
			}
		}
		return false;
		 
	}
	
	/**Checks whether there is an error with the parenthesis in the expression such as 5 (  (no operator between the parenthesis the number)
	 * and ) 5 (no operator between the parenthesis and the number).
	 * ) ( two parenthesis and no operator between them 
	 * @param noNegative.
	 * An infix with no spaces and any negative number is converted to subtraction from zero (0 - ) 
	 * @return boolean to determine if the expression is not correct.
	 */
	
	private boolean checkParenthesisErrors(String noNegative) {
		
		
		
		
		
		
		for(int i=0;i<noNegative.length();i++) {
			//Check if there is an opening parenthesis and no operator before it.
			if(noNegative.charAt(i)=='('&&(i-1)>=0&&!checkSymbol(noNegative.charAt(i-1))&&noNegative.charAt(i-1)!='(') {
				return true;
			}//Check if there a closing parenthesis and there is no operator after it 
			else if (noNegative.charAt(i)==')'&&(i+1)<noNegative.length()&&!checkSymbol(noNegative.charAt(i+1))&&noNegative.charAt(i+1)!=')') {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Used to check whether the expression is empty or  has empty parenthesis only such as "()"  .
	 *@param  expression.
	 *infix expression
	 *@return a boolean to determine if the expression is not correct.
	 *
	 */
	private boolean checkEmptyExpression(String expression) {
	
		
		
		
		
		
		String noSpaceExpression=removeSpaces(expression);
		//Check if the expression has only spaces
		if(noSpaceExpression.length()==0) {
			return true;
		}
		for (int i=0;i<noSpaceExpression.length();i++) {
			//Check if there is empty parenthesis inside the infix expression
			if(noSpaceExpression.charAt(i)=='(') {
				if((i+1)<noSpaceExpression.length()&&noSpaceExpression.charAt(i+1)==')') {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Used to check whether the parenthesis are wrong constructed for example an opening parenthesis with no closing one and vice versa.
	 * @param  expression.
	 * infix expression
	 * @return a boolean to determine whether there is an error in the parenthesis construction 
	 */
	private boolean checkParenthesisConstruction(String expression) {
		
		
		
		Stack S= new Stack();
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)=='(') {
				S.push(expression.charAt(i));
			}
			else if(expression.charAt(i)==')') {
				if(S.isEmpty()) {//Nothing to match with
					return true;
				}
				else {//The parenthesis are well constructed 
					S.pop();
				}
			}
		}
		if(!S.isEmpty()) {
			return true;
		}
		return false;
	}
	
	
	/***
	 * Checks whether there is an error in the expression or not 
	 * @param expression
	 * infix expression
	 * @return a boolean to determine if there is an error in the expression
	 * 
	 * 
	 * */
	private boolean checkError(String expression) {
		
		
		
		
		
		String noNegative=changeNegative(expression);
		return (checkEmptyExpression(expression)||checkOperators(noNegative)||checkNumbers(expression)||checkVariables(noNegative)||checkParenthesisConstruction(expression)||checkParenthesisErrors(noNegative)||checkSpecialCharacter(noNegative));
	}
	
	
	/**Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term) 
	*it may throw RuntimeException if the input expression is wrong-formed or if it is null
	* @param expression
	* infix expression
	* @return postfix expression
	* */
	
	
	public String infixToPostfix(String expression) {
		
		
		
		
	if(expression==null){
		throw new RuntimeException();
}
	if(checkError(expression)) {
		throw new RuntimeException();
	}
String postfix="";
Stack symbols=new Stack();
String noNegative=changeNegative(expression);//A string equal to expression but without spaces and the negative operands are changed to subtraction from zero operation (0 - )
for(int i=0;i<noNegative.length();i++){
	//Check if the current symbol is an operator 
		if(checkSymbol(noNegative.charAt(i)) ){
			//Check if the precedence of the current operator is lower than or equal to that in the stack 
			while(!symbols.isEmpty()&&checkPrecedence(noNegative.charAt(i))<=checkPrecedence((char)symbols.peek())&&checkSymbol((char)symbols.peek())) {
				postfix+=(char)symbols.pop();
				postfix+=" ";
			}
			symbols.push(noNegative.charAt(i));
		
		}
		else if (noNegative.charAt(i)=='(') {
			symbols.push(noNegative.charAt(i));
		}
		
		else if (noNegative.charAt(i)==')'){
			while(!symbols.isEmpty()){
				if((char)symbols.peek()!='('){
					postfix+=(char)symbols.pop();
					postfix+=" ";
				}
				else {
					//The next symbol in the stack is ( and we will discard it 
					symbols.pop();
					break;
				}
			}//end while
		}//end else if 
		else {//it is not one of the symbols and not a closing parenthesis
			
				while(i<noNegative.length()&&isAlnum(noNegative.charAt(i))) {
					postfix+=noNegative.charAt(i);
					i++;
				}
					postfix+=" ";
					i--;
				//it will be incremented in the next iteration
		}
		
}//end for 
while(!symbols.isEmpty()) {
	//when reaching the end of the expression pop all the elements  off the stack
	//and into the postfix string
	postfix+=(char)symbols.pop();
	if(symbols.size()!=0)
	postfix+=" ";
	}
	//A loop to remove the last space in the postfix string which is generated sometimes
	String Out="";
	for(int i=0;i<postfix.length()-1;i++) {
		Out+=postfix.charAt(i);
	}
	if(postfix.charAt(postfix.length()-1)!=' ')
		Out+=postfix.charAt(postfix.length()-1);
return Out;
}
	
	
	
	
	/***
	 * Check whether the input postfix expression contains Variables or not such as A or B as these cannot be evaluated
	 * @param expression
	 * postfix expression
	 * @return A boolean to determine whether there is a variable in the postfix expression or not
	 */
private boolean checkVariablesPF(String expression) {
	
	for(int i=0;i<expression.length();i++) {
		if(isAlpha(expression.charAt(i))) {
			return true;
		}
	}
	return false;
}



/***
 * Checks whether the input postfix expression has unwanted characters or not such as $# etc
 * @param expression
 * postfix expression
 * @return a boolean to determine whether the expression has unwanted characters or not 
 * 
 */

private boolean checkSpecialCharactersPF(String expression) {
	
	for(int i=0;i<expression.length();i++) {
		//If the character is not an operator - + * / not a numeric operand 5 10 
		if(!isNum(expression.charAt(i))&&!checkSymbol(expression.charAt(i))&&expression.charAt(i)!=' ') {
			return true;
		}
	}
	return false;
}


/**
 * 
 * Checks whether the postfix expression contains only one positive number or not
 * @param expression
 * postfix expression
 * @return 
 * a boolean to determine whether the expression is only one number  
 */
private boolean checkOnlyOne(String expression) {
	
	boolean onlyOne=true;
	int i=0;
	while(i<expression.length()&&expression.charAt(i)==' ') {
	//Ignore all the  spaces at the begging of the expression
	i++;
	}
	while(i<expression.length()&&isNum(expression.charAt(i))){
		i++;
	}
	while((i<expression.length()&&expression.charAt(i)==' ')) {//Ignore spaces at the end of the expression
			i++;
	}
	if(i<expression.length()) {//There are some other numbers or operators 
		onlyOne=false;
	}
	return onlyOne;
	
}
/**
 * Checks whether there is an error in the input postfix expression
 *@param expression
 *postfix expression
 *@return boolean to determine if there is an error in the postfix expression
 *
 */
	
private boolean checkErrorsPF(String expression) {
	
	String noSpaceExpression=removeSpaces(expression);
	return (noSpaceExpression.length()==0||checkVariablesPF(expression)||checkSpecialCharactersPF(expression));
}






/**
* Evaluate a postfix numeric expression, with a single space separator
* it may throw RuntimeException if the input expression is null or if it is wrong-formed 
* it may throw ArithmeticException if there is division by zero
* @param expression
* postfix expression
* @return the expression evaluated value
*/

public int evaluate(String expression) {
	
	
	
	
	if (expression==null) {
		throw new RuntimeException();
	
	}
	if(checkErrorsPF(expression)) {
		throw new RuntimeException();
	}
	if(checkOnlyOne(expression)) {//A string that contains only one number
		String noSpaceExpression=removeSpaces(expression);
		Integer number=Integer.parseInt(noSpaceExpression);
		return number;
	}
	String sNumber="";
	float nNumber;
	float operand1=0;
	float operand2=0;
	float result=0;
	Stack numbers=new Stack();
	int i=0;
	while(i<expression.length()) {
		if(isNum(expression.charAt(i))) {
			sNumber="";
			while(i<expression.length()&&isAlnum(expression.charAt(i))) {
				sNumber+=expression.charAt(i);
				i++;
			}
			nNumber=Float.parseFloat(sNumber);
			numbers.push(nNumber);
		}
		else if(expression.charAt(i)==' ') {
			i++;
		}
		//Else the character is an operator
		else {
			//If the stack has 2 or more operands
			if(numbers.size()>=2) {
				operand2=(float)numbers.pop();
				operand1=(float)numbers.pop();
			}
			else {
				throw new RuntimeException();
			}
			switch(expression.charAt(i)) {
			case '+':
				result=operand1+operand2;
				break;
			case '-' :
				result=operand1-operand2;
				break;
			case '*' :
				result=operand1*operand2;
				break;
			case '/':
				if(operand2==0) {
					throw new ArithmeticException("Division By Zero");
				}
				result=operand1/operand2;
				break;
			}
			i++;
			//If this operation was not the last one push the result in the stack 
			numbers.push(result);
			
		}
		
	}
	result=(float)numbers.pop();
	if(!numbers.isEmpty()) {
		throw new RuntimeException();
	}
	return (int) result;
}
}
