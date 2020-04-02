import java.util.EmptyStackException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	boolean Continue=true;
	Stack stack=new Stack();
	Scanner S=new Scanner(System.in);
	while(Continue) {
		
		System.out.println("Choose one of the following options");
		System.out.println("======================================================================");
		System.out.println();
		System.out.println("1-Push an element into the stack");
		System.out.println();
		System.out.println("2-Peek on the top element of the stack");
		System.out.println();
		System.out.println("3-Pop the top element off the stack");
		System.out.println();
		System.out.println("4-Check Number of elements in the stack");
		System.out.println();
		System.out.println("5-Check Whether the stack is empty or not");
		System.out.println();
		System.out.println("6-to exit");
		System.out.println("======================================================================");
		System.out.println();
		String inputChoice;
		int Choice=0;
		inputChoice=S.next();
		try {
			Choice=Integer.parseInt(inputChoice);
		}
		catch(Exception e) {
			System.out.println("Invalid Option");
			System.out.println();
			continue;
		}
		switch (Choice) {
		case 1:
			try  {
				System.out.println("Enter the element");
				String str=S.next();
				stack.push(str);
				System.out.println((String)stack.peek()+" has been pushed into the stack");
				System.out.println("======================================================================");
				System.out.println();
			}
			catch (NullPointerException e) {
				System.out.println("Null object is not allowed");
				System.out.println();
			}
			break;
		case 2:
			try {
				System.out.println("The Top element of the stack is " + (String)stack.peek());
				System.out.println("======================================================================");
				System.out.println();
			}
			catch(EmptyStackException e) {
				System.out.println("The stack is empty");
				System.out.println();
			}
			break;
		case 3:
			try {
				System.out.println("The popped element off the stack is "+ (String)stack.pop());
				System.out.println("======================================================================");
				System.out.println();
			}
			catch (EmptyStackException e) {
				System.out.println("The Stack is empty");
				System.out.println();
			}
			break;
		case 4:
			System.out.println("The number of elements in the stack is "+ stack.size());
			System.out.println("======================================================================");
			System.out.println();
			break;
		case 5 :
			if(stack.isEmpty()) {
				System.out.println("The stack is empty");
				System.out.println("======================================================================");
				System.out.println();
			}
			else {
				System.out.println("The stack is not empty and has "+stack.size()+ " element(s)" );
				System.out.println("======================================================================");
				System.out.println();
			}
			break;
		case 6:
			Continue=false;
			break;
		default :
			System.out.println("Invalid option");
			System.out.println();
		}
}
}
}
