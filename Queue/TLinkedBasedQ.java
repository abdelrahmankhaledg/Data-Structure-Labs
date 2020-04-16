import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TLinkedBasedQ {
static LinkedBasedQ Q=new LinkedBasedQ();
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

