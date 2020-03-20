import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
class TStudy {
static Study List=new Study();
static PolyNode P=new PolyNode(5,4);
static PolyNode Q=new PolyNode(3,2);
static PolyNode N=new PolyNode(3,3);
static PolyNode G=new PolyNode(1,1);
static PolyNode K=new PolyNode(7,0);
@BeforeAll
static void  BF() {
	List.add(P);
	List.add(Q);
	List.add(N);
	List.add(G);
	List.add(K);
}
@Test
 void testAdd1() {
	assertEquals(P,(List.get(0)));
}
@Test void testAdd2() {
	assertEquals(Q,List.get(1));
}
@Test
void testAdd3() {
	assertEquals(N,List.get(2));
}
@Test
void testAdd4() {
	assertEquals(G,List.get(3));
}
@Test
void testAdd5() {
	assertEquals(K,List.get(4));
}
@Test 
void testAdd6(){
	PolyNode In=new PolyNode(7,8);
	List.add(3, In);
	PolyNode Out=(PolyNode)List.get(3);
	assertEquals(7,Out.getCoeff());
	assertEquals(8,Out.getExponent());
}
@Test
void testAdd7() {
	PolyNode In=new PolyNode(1,2);
	PolyNode Out=new PolyNode();
	List.add(0,In);
	Out=(PolyNode)List.get(0);
	assertEquals(1,Out.getCoeff());
	assertEquals(2,Out.getExponent());
	
}
@Test 
void testGet1() {
	assertThrows(IllegalArgumentException.class,()->List.get(7));
}
@Test 
void testGet2() {
	assertThrows(IllegalArgumentException.class,()-> List.get(-5));
}
@Test
void testGet3() {
	Study emptyList=new Study();
	assertThrows(IllegalArgumentException.class,()-> emptyList.get(2));
}

@Test
void testSet1() {
	PolyNode In=new PolyNode(20,30);
	List.set(2, In);
	PolyNode Out=new PolyNode();
	Out=(PolyNode)List.get(2);
	assertEquals(20,Out.getCoeff());
	assertEquals(30,Out.getExponent());
	
}
@Test
void testSet2() {
	Study emptyList=new Study();
	assertThrows(RuntimeException.class,()->emptyList.set(2, P));
}
@Test
void testSet3() {
	assertThrows(IllegalArgumentException.class,()->List.set(10, Q));
}
@Test
void testSet4() {
	assertThrows(IllegalArgumentException.class,()->List.set(-3, Q));
}
@Test
void testSet5() {
	PolyNode In=new PolyNode(4,5);
	List.set(0, In);
	PolyNode Out=(PolyNode)(List.get(0));
	assertEquals(4,Out.getCoeff());
	assertEquals(5,Out.getExponent());
	assertFalse(List.isEmpty());
}
@Test
void testSet6() {
	PolyNode In=new PolyNode(3,2);
	List.set(List.size()-1, In);
	PolyNode Out=new PolyNode();
	Out=(PolyNode)(List.get(List.size()-1));
	assertEquals(3,Out.getCoeff());
	assertEquals(2,Out.getExponent());
}
@Test
void testRemove1() {
	List.remove(3);//We added (7,8) at 3  and added (1,2) at 1 so when removing it , PolyNode (7,8) will be 3 and Node N will be Removed
	PolyNode Out=new PolyNode();
	Out=(PolyNode)List.get(3);
	assertEquals(7,Out.getCoeff());
	assertEquals(8,Out.getExponent());
	assertEquals(6,List.size());
}
@Test 
void testRemove2() {
	Study emptyList=new Study();
	assertThrows(NullPointerException.class,()-> emptyList.remove(5));
}
@Test
void testRemove3() {
	assertThrows(IllegalArgumentException.class,()->List.remove(20));
}
@Test 
void testRemove4() {
	List.remove(0);//We added (1,2) as the first element and set it to(4,5) ,after removing it P will be the first
	assertEquals(P,List.get(0));
}
@Test
void testRemove5() {
	List.remove(List.size()-1);//We removed the last node which was K but set to(3,2) ,after remove G will be the last node
	assertEquals(G,List.get(List.size()-1));
}
@Test
void testContains1() {
	assertTrue(List.contains(G));
}
@Test
void testContains2() {
	PolyNode H=new PolyNode(100,100);
	assertFalse(List.contains(H));
}
@Test
void TheLastTest1() {
	ILinkedList SubList=new Study();
	SubList=(Study)(List.sublist(1,3));
	assertEquals(3,SubList.size());
	assertEquals(List.get(1),SubList.get(0));
	assertEquals(List.get(2),SubList.get(1));
	assertEquals(List.get(3),SubList.get(2));
}
@Test
void TheLastTest2() {
	assertThrows(IllegalArgumentException.class,()->List.sublist(-5, 10));
}
@Test
void TheLastTest3() {
	assertThrows(IllegalArgumentException.class,()->List.sublist(5, -10));
}
@Test
void TheLastTest4() {
	assertThrows(IllegalArgumentException.class,()->List.sublist(2, 1));
}@Test
void TheLastTest5() {
	ILinkedList SubList=new Study();
	SubList=(Study)(List.sublist(0,2));
	assertEquals(3,SubList.size());
	assertEquals(List.get(0),SubList.get(0));
	assertEquals(List.get(1),SubList.get(1));
	assertEquals(List.get(2),SubList.get(2));
}
@Test
void TheLastTest6() {
	assertThrows(IllegalArgumentException.class,()->List.sublist(3, 6));
}
@Test
void TheLastTest7() {
	assertThrows(IllegalArgumentException.class,()->List.sublist(4, 6));
}
@Test 
void TheLastTest8() {
	PolyNode C=new PolyNode(12,15);
	assertThrows(IllegalArgumentException.class,()->List.add(-5, C));
}
@Test
void TheLastTest9() {
	PolyNode C=new PolyNode(12,15);
	assertThrows(IllegalArgumentException.class,()->List.add(5, C));
}
@Test
void TheLastTestm() {
	PolyNode In =new PolyNode(20,21);
	List.add(4,In);
	PolyNode Out=new PolyNode();
	Out=(PolyNode)(List.get(4));
	assertEquals(In,Out);
}

@Test 
void TheLastTestn() {
	List.clear();
	assertEquals(0,List.size());
	assertTrue(List.isEmpty());
}

}

