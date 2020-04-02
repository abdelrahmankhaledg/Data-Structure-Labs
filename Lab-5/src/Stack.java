import java.util.EmptyStackException;

/***
 * The class is an implementation of the stack datastructure
 * 
 * 
 *
 */

public class Stack implements IStack {
	/**
	 * 
	 * The node class of the stack data structure
	 *
	 */
	private class Node {
		/**
		 * element is the element which will be stored in the node
		 * 
		 * 
		 * 
		 * 
		 *
		 */
		private Object element;
		/**
		 * next is the next node which this node points to
		 */
		private Node next;
		/**
		 * Empty Constructor of the node class
		 */
		public Node() {
			this(null,null);
		}
		/**
		 * Constructor of the node class which takes 2 parameters
		 * @param element
		 * The element which will be stored in the node
		 * @param next
		 * The next Node that this node will point to
		 */
		public Node(Object element,Node next) {
			this.element=element;
			this.next=next;
		}
		/**
		 * 
		 * @return The element stored in the node
		 */
		public Object getElement() {
			return element;
		}
		
		/**
		 * 
		 * @return The next node which this node points to
		 */
		public Node getNext() {
			return next;
		}
		/**
		 * 
		 * @param element
		 * The element which will be stored in the node
		 */
		public void setElement(Object element) {
			this.element=element;
		}
		/***
		 * 
		 * @param next 
		 * The next node which this node points to 
		 */
		public void setNext(Node next) {
			this.next=next;
		}
		
		
		}
	/**
	 * Top is the top element of the stack
	 */
	
private Node top=null;
/**
 * Size is the size of the stack
 */
private int size=0;
/***
 *  Get the number of elements in the stack and has no parameters
 *
 * @return The number of elements in the stack
 */
public int size(){
	return size;
}

/**
 * Check whether the stack is empty 
 * 
 * @return boolean to determine whether the stack is empty
 */
public boolean isEmpty() {
	return (size==0);
}


/**
 * Examine the top element of the stack or throw EmptyStackException if the stack is empty
 *
 * @return Top element of the stack
 */
public Object peek() {
	if(isEmpty()) {
		throw new EmptyStackException();
	}
	return top.getElement();
}


/**
 * Get the top element and remove it from the stack or throw EmptyStackException if the stack is empty 
 * 
 * @return Top element of the stack
 */
public Object pop() {
	if(isEmpty()) {
		throw new EmptyStackException();
	}
	Object temp=top.getElement();
	top=top.getNext();
	size--;//reduce the size of the stack;
	return temp;
}



/**
* Pushes an item onto the top of this stack.
*
* @param element
* to insert
*/



public void push(Object element) {
	if(element==null) {
		throw new NullPointerException("Null Object is passed ");
	}
	Node newNode=new Node(element,top);
	top=newNode;
	size++;
}
}
