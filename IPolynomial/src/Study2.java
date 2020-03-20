

import java.awt.dnd.DnDConstants;

public class Study2 implements ILinkedList {

    class DNode{
        Object data;
        DNode next;
        DNode prev;
    }
    DNode head,tail;
    static Study2 list2 = new Study2();

    public static void main(String[] args){
        list2.add(5);
        list2.add(12);
        list2.insertAtStart(10);
        list2.insertAtStart(16);
        list2.add(1,1);

        list2.clear();
        try{
        list2.deleteAtStart();
        }
        catch (Exception e){
            System.out.println("you can't Delete an empty list");
        };


        //System.out.println(list2.size());
        //list2.show();
    }



    public void insertAtStart(Object element){ // insert element at the start
        DNode node = new DNode();
        node.data=element;
        node.next=head;
        node.prev=null;
        head=node;
    }

    public void deleteAtStart() throws NullPointerException{
        if(head == null){
            throw new NullPointerException("You can't delete an empty List");
        }else if (head.next==null){
            head=null;
        }else{
            head=head.next;
            head.prev=null;
        }

    }

    @Override
    public void add(int index, Object element) {
        DNode node = new DNode();
        node.data=element;
        if(index==0){
            insertAtStart(element);
        }
        else if(index<0) {
        	throw new IllegalArgumentException();
        }
        else{
            DNode n = head;
            for(int i=0; i<index-1;i++){
            	if(n!=null)
                n= n.next;
            }
            if(n==null)
            	throw new IllegalArgumentException();
            if(n.next!=null) {
            n.next.prev=node;
            }
            node.next=n.next;
            node.prev=n;
            n.next=node;
        }


    }

    @Override
    public void add(Object element) {
        DNode node = new DNode();
        node.data=element;
        if(head == null){
            head=tail=node;
            head.prev=null;
            tail.next=null;
        }else{
            tail.next=node;
            node.prev=tail;
            tail=node;
            tail.next=null;
        }
    }

    public void show(){
        DNode node = head;
        if(head == null){
            throw new NullPointerException();
        }else{
            while (node!=null){
                System.out.println(node.data);
                node=node.next;
            }
        }
    }

    @Override
    public Object get(int index) {
        DNode node = head;
        if(node ==null) {
        	throw new IllegalArgumentException();
        }
        if(index<0) {
        	throw new IllegalArgumentException();
        }
        for(int i =0 ;i<index;i++){
        	if(node.next!=null)
            node = node.next;
        	else 
        	throw new IllegalArgumentException();
        }
        return node.data;
    }

    @Override
    public void set(int index, Object element) {
        DNode node = head;
        if(node ==null) {
        	throw new RuntimeException();
        }
        else if (index<0) {
        	throw new IllegalArgumentException();
        }
        for(int i=0 ;i <index;i++){
        	if(node.next!=null)
            node=node.next;
        	else 
        		throw new IllegalArgumentException();
        }
        node.data=element;
    }

    @Override
    public void clear() {
        if (head == null) {
            throw new NullPointerException();
        } else {
            DNode node = head;
            while (node != null) {
                node = node.next;
                deleteAtStart();
            }
        }
    }

    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void remove(int index) {
        if (head == null) {
            throw new NullPointerException();
        }
        else if(index<0) 
        	throw new IllegalArgumentException();
        	else {
            DNode node = head;
            DNode m=null;
            if (index == 0) {
                deleteAtStart();
            } else {
                for (int i = 0; i < index - 1; i++) {
                	if(node.next!=null)
                    node = node.next;
                	else 
                		throw new IllegalArgumentException();//List node of index < index-1 or equal to it doesn't exist 
                }
               m=node.next;
                if(m==null)
                	throw new IllegalArgumentException();//The node of index==index doesn't Exist
               
                node.next = m.next;
                if(node.next!=null)
                node.next.prev = node;
     
            }
        }
    }

    @Override
    public int size() {
        DNode n = head;
        int count=0;
        if(head == null){
            return count;
        }else{
            while(n!=null){
                count++;
                n=n.next;
            }
            return count;
        }
    }

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        Study2 kilo = new Study2();
        DNode n=head;
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
        //kilo.show();
        return kilo;
    }

    @Override
    public boolean contains(Object o) {
        DNode n=head;
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
