import java.util.Scanner;
public class TArrayBasedQueueMain {
	static Scanner reader=new Scanner(System.in);
public static void main(String[] args) {
	boolean doContinue=true;
	ArrayBasedQ Q;
	while (true) {
	System.out.println("Enter the maximum size of the queue");
	int N=reader.nextInt();
	try {
	Q=new ArrayBasedQ(N+1);
	break;
	}
	catch(RuntimeException e) {
		System.out.println("You should provide an appropriate size to the queue");
		System.out.println("---------------------------------------------------");
	}
	}
	while (doContinue) {
System.out.println("Choose one of the following options");
System.out.println("-----------------------------------");
System.out.println("1-Insert an element in the queue");
System.out.println("2-Remove an element from the queue");
System.out.println("3-Size of the queue");
System.out.println("4-Check whether the queue is empty");
System.out.println("5-Exit");
System.out.println("----------------------------------");
String Choice =reader.next();
Integer nChoice;
try {
nChoice=Integer.parseInt(Choice);
}
catch (Exception e) {
	System.out.println("Invalid Option");
	System.out.println();
	continue;
}
switch (nChoice) {
case 1:
	System.out.println("Enter the element");
	String input=reader.next();
	try {
	Q.enqueue(input);
	System.out.println(input + " Has been inserted in the queue");
	System.out.println();
	}
	catch (RuntimeException e){
		System.out.println("You can't add elements to the queue");
		System.out.println("The queue is full");
		System.out.println();
	}
	break;
case 2:
	try {
	Object output=(String)Q.dequeue();
	System.out.println(output + " Has been removed from the queue");
	System.out.println();
	}
	catch(RuntimeException e) {
		System.out.println("You can't remove items from the queue");
		System.out.println("The queue is Empty ");
		System.out.println();
	}
	break;
case 3:
	System.out.println("The queue has " +Q.size() + " Elements");
	System.out.println();
	break;
case 4:
	if(Q.isEmpty()) {
		System.out.println("The queue is Empty");
		System.out.println();
	}
	else {
		System.out.println("The queue is not empty");
		System.out.println("The queue has "+ Q.size() + " Elements");
		System.out.println();
	}
	break;
case 5:
	doContinue=false;
	break;
default :
	System.out.println("Invalid Option");
	System.out.println();
}

}
}
}
