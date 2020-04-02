import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
@TestMethodOrder(Alphanumeric.class)
class StackTest {
static Stack S= new Stack();
	@Test
	@Order(1)
	void testA() {
		assertThrows(EmptyStackException.class,()->S.peek());
	}
	@Test
	@Order(2)
	void testB() {
		assertThrows(EmptyStackException.class,()->S.pop());
	}
	@Test
	@Order(3)
	void testC() {
		assertEquals(0,S.size());
	}
	@Test
	@Order(4)
	void testD() {
		assertTrue(S.isEmpty());
	}
	@Test
	@Order(5)
	void testE() {
		S.push(5);
		S.push(3);
	}
	@Test
	@Order(6)
	void testF() {
		assertEquals(3,(int)S.pop());
	}
	@Test
	@Order(7)
	
	void testG() {
		S.push(7);
	}
	@Test
	@Order(8)
	void testH() {
		assertEquals(7,S.pop());
	}
	@Test
	@Order(9)
	void testI() {
		assertEquals(5,S.peek());
	}
	@Test
	@Order(10)
	void testJ() {
		assertEquals(1,S.size());
	}
	@Test
	@Order(11)
	void testK() {
		assertEquals(5,S.pop());
	}
	@Test
	@Order(12)
	void testL() {
		assertThrows(EmptyStackException.class,()->S.pop());
	}
	@Test
	@Order(13)
	void testM() {
		assertThrows(EmptyStackException.class,()->S.peek());
	}
	@Test
	@Order(14)
	void testN() {
		assertTrue(S.isEmpty());
	}
	@Test
	@Order(15)
	void testO() {
		S.push(9);
		S.push(7);
		S.push(3);
		S.push(5);
	}
	@Test
	@Order(16)
	void testP() {
		assertEquals(4,S.size());
	}
	@Test
	@Order(17)
	void testQ() {
		assertEquals(5,S.pop());
	}
	@Test
	@Order(18)
	void testR() {
		S.push(8);
	}
	@Test
	@Order(19)
	void testS() {
		assertEquals(8,S.pop());
	}
	@Test
	@Order(20)
	void testT() {
		assertEquals(3,S.pop());
	}
	@Test
	@Order(21)
	void testU() {
		assertThrows(NullPointerException.class,()->S.push(null));
	}

}
