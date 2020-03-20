
import java.util.EmptyStackException;
public class Study implements ILinkedList{

    public class Node {
        Object data;
        Node next;
    }
    static Study list = new Study();
    public static void main(String[] args) {
        Object hi;
        int size;
        /*list.add(18);
        list.add(45);
        list.add(12);
        list.insertAtStart(25);
        list.add(0,55);*/

        /*if(list.contains(55)==true){
            System.out.println("tmam ysta");
        }else {
            System.out.println("msh tmam y3m enta");
        }*/

        //list.set(0,1);

        /*list.remove(2);
        list.delete();
        list.deleteAtStart();*/
        try {
            list.clear();
        }catch (Exception e){
            System.out.println("you can't clear an empty LL");
        }

        /*hi=list.get(3);
        System.out.println(hi);*/

        //list.sublist(3,4);

        size=list.size();
        System.out.println(size);


    }

    Node head;
    public void add(Object element){ // insert element at the end
        Node node = new Node();
        node.data=element;
        node.next=null;
        if(head == null){
            head=node;
        }else{
            Node n = head;
            while(n.next != null){
                n=n.next;
            }
            n.next=node;
        }
    }

    public void show(){ // print all the elements
        Node node=head;
        if(head==null){
            throw new NullPointerException();
        }else{
        while(node.next !=null){
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data);
    }}

    public void insertAtStart(Object data){ // insert element at the start
        Node node = new Node();
        node.data=data;
        node.next=head;
        head=node;
    }

    public void add(int index , Object element){ // insert element at a certain index
        Node node=new Node();
        node.data=element;
        if(index==0){
            insertAtStart(element);
        }
        else if (index<0) {
        	throw new IllegalArgumentException();
        }
        else {
            Node n = head;
            for (int i = 0; i < index - 1; i++) {
            	if(n!=null)
            	n = n.next;
            	else 
            		throw new IllegalArgumentException();
                
            }
            if(n==null)
            	throw new IllegalArgumentException();
            node.next = n.next;
            n.next = node;
        }
    }

    public void remove(int index){
        if(head==null){
            throw new NullPointerException();
        }
        else if(index<0) {
        	throw new IllegalArgumentException();
        }
        else{
        if(index == 0){
            head = head.next;
        }else {
            Node n = head;
            Node m=null;
            for (int i = 0; i < index - 1; i++) {
            	if(n.next!=null)//List ends before or at index-1
                n = n.next;
            	else 
            		throw new IllegalArgumentException();
            }
            m = n.next;
            if(m==null)
            	throw new IllegalArgumentException();
            n.next=m.next;
            // mmkn brdo tt3ml kda
            //n.next=n.next.next
            // mn 8er el m 5ales
        }
    }}

    public void delete() throws EmptyStackException { // delete tail
        if(head == null){
            throw new EmptyStackException();
        }else if(head.next==null){
            head=null;
        }else{
            Node n=head;
            while(n.next.next!= null){
                n=n.next;
            }
            n.next=null;
        }
    }

    public void deleteAtStart()throws EmptyStackException{
        if(head == null){
            throw new EmptyStackException();
        }else if(head.next==null){
            head=null;
        }else{
            head = head.next;
        }
    }

    public int size(){
        Node n = head;
        int count=0;
        if(head == null){
            return count;
        }else{
            while(n.next!=null){
                count++;
                n=n.next;
            }
            count++;
            return count;
        }
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }
    }

    public void clear(){
        Node n=head;
        while(n.next!=null){
            n=n.next;
            deleteAtStart();
        }
        deleteAtStart();
    }


    public Object get(int index) {
        Node n=head;
        if(head==null) {
        	throw new IllegalArgumentException();
        }
        else if(index<0) {
        	throw new IllegalArgumentException();
        }
        for(int i=0 ; i<index;i++){
            if(n.next!=null)
        	n=n.next;
            else 
            	throw new IllegalArgumentException();
        }
        return n.data;
    }


    public ILinkedList sublist(int fromIndex, int toIndex) {
        Study kilo = new Study();
        Node n=head;
        if(n==null) {
        	throw new IllegalArgumentException();
        }
        else if(fromIndex<0||toIndex<0||toIndex<fromIndex) {
        	throw new IllegalArgumentException();
        }
        
        for(int j=0;j <fromIndex;j++) {
        	if(n.next!=null)  
        		n=n.next;
        		else 
        		throw new IllegalArgumentException();
        }
        
        for(int i = fromIndex; i<=toIndex; i++){
            if(n!=null) {
            	kilo.add(n.data);
            	n=n.next;
            }
            else 
            	throw new IllegalArgumentException();
 
        }
       // System.out.println(kilo.size());
       // kilo.show();
        return kilo;
    }


    public void set(int index, Object element) {
        Node n=head;
        if(n==null) {
        	throw new RuntimeException();
        }
        else if (index<0)
        	throw new IllegalArgumentException();
        for(int i=0 ; i<index;i++){
        	if(n.next!=null)
            n=n.next;
        	else 
        		throw new IllegalArgumentException();
        }
        n.data=element;
    }


    public boolean contains(Object o) {
        Node n=head;
        while(n.next!=null){
            if(n.data==o){
                return true;
            }else{
                n=n.next;
            }
        }
        if(n.data==o){
            return true;
        }else{
            return false;
        }
    }
   


}
