import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class TArrayBasedQ {

static ArrayBasedQ Q=new ArrayBasedQ();
ArrayBasedQ Q2;
/*
 * The Numeric test are for testing if the number of elements of the queue is negative or if the queue is full 
 */

@Test
void test1() {
	assertThrows(RuntimeException.class,()-> Q2=new ArrayBasedQ(-5));
}
@Test
void test2() {
	Q2=new ArrayBasedQ(3);
	Q2.enqueue(5);
	Q2.enqueue(7);
	assertThrows(RuntimeException.class,()->Q2.enqueue(7));
}
@Test
void testA() {
	assertEquals(0,Q.size());
	assertTrue(Q.isEmpty());
	assertThrows(RuntimeException.class,()->Q.dequeue());
}
@Test
void testB() {
	Q.enqueue(5);
	Q.enqueue(3);
	assertEquals(2,Q.size());
}
@Test
void testC() {
	assertEquals(5,(int)Q.dequeue());
}
@Test
void testD() {
	Q.enqueue(7);
	assertEquals(2,Q.size());
	assertEquals(3,(int)Q.dequeue());
}
@Test
void testE() {
	assertEquals(7,Q.dequeue());
}
@Test
void testF() {
	assertEquals(0,Q.size());
	assertThrows(RuntimeException.class,()->Q.dequeue());
	assertTrue(Q.isEmpty());
}
@Test
void testG() {
	Q.enqueue(9);
	Q.enqueue(7);
	assertEquals(2,Q.size());
}
@Test
void testH() {
	Q.enqueue(3);
	Q.enqueue(5);
	assertEquals(9,Q.dequeue());
}
@Test
void testI(){
	assertThrows(NullPointerException.class,()->Q.enqueue(null));
}
}
