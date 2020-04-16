public class ArrayBasedQ implements IQueue,IArrayBased {
   private int f=0,r=0;
   private int N;//Maximum size of the queue array
   private Object[] arr;


    public void show(){
        for(int i=f;i<r;i++)
            System.out.println(arr[i]+" ");
    }
    public ArrayBasedQ() {
    	this(1000);
    }
    public ArrayBasedQ(int N) {
    	if(N<=0) {
    		throw new RuntimeException();
    	}
    	this.N=N;
    	arr=new Object[N];
    }
	@Override
	public void enqueue(Object item) {
		if(item==null) {
			throw new NullPointerException();
		}
		if(f==((r+1)%N)) {
			throw new RuntimeException();		
		}
		arr[r]=item;
		r=(r+1)%N;
	}
	@Override
	public Object dequeue() {
		if(isEmpty()) {
			throw new RuntimeException();
		}
		Object temp =arr[f];
		arr[f]=null;
		f=(f+1)%N;
		return temp;
	}
	@Override
	public boolean isEmpty() {
		return f==r;
	}
	@Override
	public int size() {
		return (N-f+r)%N;
	}
	public Object front() {
		if(isEmpty()) {
			throw new RuntimeException();
		}
		return arr[f];
	}
    

}