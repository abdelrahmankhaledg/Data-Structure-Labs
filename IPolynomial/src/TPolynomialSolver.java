import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
class TPolynomialSolver {
static CPolynomialSolver PS;
	@BeforeAll
	static void BA() {
		PS=new CPolynomialSolver();
	}
	@Test
	void testSetPolynomial1() {
		PS.setPolynomial('A', new int[][] {{1,2},{2,4},{3,5}});
		assertEquals("3 X^5 + 2 X^4 + X^2",PS.print('A'));
	}
	
	@Test 
	void testSetPolynomial2() {
		PS.setPolynomial('B',new int [][] {{-2,2},{-3,4}});
		assertEquals("-3 X^4 -2 X^2",PS.print('B'));
	}
	
	@Test
	void testSetPolynomial3() {
		PS.setPolynomial('C', new int[][] {{2,2},{3,4},{2,1}});
		assertEquals("3 X^4 + 2 X^2 + 2 X", PS.print('C'));
	}
	@Test 
	void testSetPolynomial4() {
		PS.setPolynomial('A',new int [][] {{3,2},{4,2}} );
		assertEquals("7 X^2",PS.print('A'));
	}
	@Test
	void testSetPolynomial5() {
		PS.setPolynomial('B', new int [][] {{-2,3},{-4,3}});
		assertEquals("-6 X^3",PS.print('B'));
	}
	@Test 
	void testSetPolynomial6() {
		PS.setPolynomial('C', new int [][] {{5,1},{-5,1},{3,2}});
		assertEquals("3 X^2",PS.print('C'));
	}
	@Test 
	void testSetPolynomial7() {
		PS.setPolynomial('A', new int[][] {{5,0},{3,-2},{1,-1}});
		assertEquals("5 + X^-1 + 3 X^-2",PS.print('A'));
	}
	@Test 
	void testSetPolynomial8() {
		PS.setPolynomial('B', new int [][] {{-3,-2},{1,2},{-2,-2}});
		assertEquals("X^2 -5 X^-2",PS.print('B'));
	}
	@Test 
	void testSetPolynomial9() {
		PS.setPolynomial('A', new int [][] {{5,2},{-5,2}});
		assertEquals("0",PS.print('A'));
	}
	@Test
	void testSetPolynomial10() {
		PS.setPolynomial('B',new int [][]{{0,0}} );
		assertThrows(IllegalArgumentException.class,()->PS.print('B'));
	}
	@Test 
	void testSetPolynomialNullAndThrow() {
		assertThrows(IllegalArgumentException.class,() ->PS.setPolynomial('R', new int [][] {{1,1}})); 
		assertThrows(NullPointerException.class,()-> PS.setPolynomial('A',null));
		assertThrows(IllegalArgumentException.class,() -> PS.setPolynomial('A', new int [0][0]));
	}
	@Test 
	void testPrint1() {
		PS.setPolynomial('A', new int [][] {{1,1}});
		assertEquals("X",PS.print('A'));
	}
	@Test
	void testPrint2() {
		PS.setPolynomial('B', new int [][] {{5,0}});
		assertEquals("5",PS.print('B'));
	}
	@Test
	void testPrint3() {
		PS.setPolynomial('C', new int [][] {{2,2},{3,1},{-5,0}});
		assertEquals("2 X^2 + 3 X -5",PS.print('C'));
	}
	@Test
	void testPrint4() {
	PS.setPolynomial('A', new int [][] {{5,2},{1,0},{1,-1}});
	assertEquals("5 X^2 + 1 + X^-1",PS.print('A'));
	}
	@Test
	void testPrint5() {
		PS.setPolynomial('C', new int[][] {{-5,0},{2,-1}});
		assertEquals("-5 + 2 X^-1",PS.print('C'));
	}
	@Test
	void testPrint6() {
		PS.setPolynomial('B', new int[][] {{5,3},{-5,0},{-2,-1}});
		assertEquals("5 X^3 -5 -2 X^-1",PS.print('B'));
	}
	@Test
	void testPrint7() {
		PS.setPolynomial('A', new int [][] {{5,3},{2,4},{7,0}});
		assertEquals("2 X^4 + 5 X^3 + 7",PS.print('A'));
	}
	@Test
	void testPrint8() {
		PS.setPolynomial('B', new int[][] {{2,7},{-3,3},{-50,0}});
		assertEquals("2 X^7 -3 X^3 -50",PS.print('B'));
	}
	@Test
	void testPrint9() {
		assertThrows(IllegalArgumentException.class,()-> PS.print('F'));
	}
	@Test 
	void testClear1() {//Test Clear 
		PS.setPolynomial('A',new int[][] {{2,2},{3,4},{2,1}} );
		PS.clearPolynomial('A');
		assertThrows(IllegalArgumentException.class,()->PS.print('A')); 
	}
	@Test
	void testClear2() {
		PS.setPolynomial('B',new int [][] {{2,2},{3,4},{2,1}} );
		PS.clearPolynomial('B');
		assertThrows(IllegalArgumentException.class,()->PS.print('B'));
	}
	@Test 
	void testClear3() {
		PS.setPolynomial('C', new int[][]{{2,2},{3,4},{2,1}});
		PS.clearPolynomial('C');
		assertThrows(IllegalArgumentException.class,()->PS.print('C'));
	}
	@Test
	void testClear4() { //Test Clear for a polynomial not A,B,C or R 
		assertThrows(IllegalArgumentException.class,() ->PS.clearPolynomial('F'));
	}
	@Test
	void testClear5() {//Test clear for unsetPolynomial
		assertThrows(IllegalArgumentException.class,()->PS.clearPolynomial('A'));
	}
	@Test 
	void testEvaluate1() {
		PS.setPolynomial('B',new int [][] {{1,2},{3,3},{4,5}});
		assertEquals(0.75f,PS.evaluatePolynomial('B', 0.5f));
	}
	@Test
	void testEvaluate2(){
		PS.setPolynomial('C', new int [][] {{-5,3},{4,3},{2,2}});
		assertEquals(-105.875f,PS.evaluatePolynomial('C', 5.5f));
	}
	@Test 
	void testEvaluate3(){
		PS.setPolynomial('A', new int[][] {{5,2},{3,1},{2,0}});
		assertEquals(919.5625f,PS.evaluatePolynomial('A', 13.25f));
	}
	@Test
	void testEvaluate4() {
		PS.setPolynomial('B', new int [][] {{5,-1},{2,2},{5,-3}});
		assertEquals(-49.5f,PS.evaluatePolynomial('B',-0.5f));
	}
	@Test
	void testEvaluate5() {
		PS.setPolynomial('C',  new int [][] {{3,2},{2,3},{4,1}});
		assertEquals(-49.96875f, PS.evaluatePolynomial('C', -3.25f));
	}
	@Test 
	void testEvaluate6() {
		PS.setPolynomial('A',  new int [][] {{4,-2},{3,-1},{5,2}});
		assertEquals(6f,PS.evaluatePolynomial('A', -1));
	}
	@Test
	void testEvaluate7() {
		PS.setPolynomial('B',  new int [][] {{3,1},{4,0},{5,2}});
		assertEquals(4f,PS.evaluatePolynomial('B', 0));
	}
	@Test
	void testEvaluate8() {
		PS.setPolynomial('C',new int[][] {{1,2}});
		PS.clearPolynomial('C');
		assertThrows(IllegalArgumentException.class,()-> PS.evaluatePolynomial('C', 10));
	}
	@Test
	void testAdd1() {
		PS.setPolynomial('A',  new int [][] {{3,2},{5,1},{2,0}});
		PS.setPolynomial('B',  new int [][] {{4,2},{7,1},{3,0}});
		assertArrayEquals( new int [][] {{7,2},{12,1},{5,0}},PS.add('A', 'B'));
	}
	@Test
	void testAdd2() {
		PS.setPolynomial('C',  new int [][] {{-8,3},{2,2},{-2,0}});
		PS.setPolynomial('B',  new int [][] {{7,3},{4,2},{3,0}});
		assertArrayEquals( new int [][] {{-1,3},{6,2},{1,0}},PS.add('C', 'B'));
	}
	@Test 
	void testAdd3() {
		PS.setPolynomial('A',  new int [][] {{3,3},{1,0}});
		PS.setPolynomial('B',  new int [][] {{2,2},{1,1}});
		assertArrayEquals( new int [][] {{3,3},{2,2},{1,1},{1,0}},PS.add('A','B'));
		assertEquals("3 X^3 + 2 X^2 + X + 1",PS.print('R'));
	}
	@Test 
	void testAdd4(){
		PS.setPolynomial('A',  new int [][] {{4,2},{1,1}});
		PS.setPolynomial('B',  new int [][] {{1,3},{3,4}});
		assertArrayEquals( new int [][] {{3,4},{1,3},{4,2},{1,1}},PS.add('A','B'));
	}
	@Test
	void testAdd5() {
		PS.setPolynomial('A',  new int [][] {{10,5},{2,4},{1,1}});
		PS.setPolynomial('B',  new int [][] {{4,4},{3,2},{1,1},{1,0}});
		assertArrayEquals( new int [][] {{10,5},{6,4},{3,2},{2,1},{1,0}},PS.add('A','B'));
	}
	@Test
	void testAdd6() {
		PS.setPolynomial('A',  new int [][] {{-2,-3},{4,-2},{1,1}});
		PS.setPolynomial('B',  new int [][] {{4,-4},{-6,3},{-10,1},{-5,0}});
		assertArrayEquals( new int [][] {{-6,3},{-9,1},{-5,0},{4,-2},{-2,-3},{4,-4}},PS.add('A','B'));
	}
	@Test
	void testAdd7() {
		PS.setPolynomial('A',new int [][] {{2,2},{1,1},{1,0}});
		PS.setPolynomial('B', new int [][] {{-2,2},{-1,1},{-1,0}});
		assertArrayEquals(new int [][] {{0,0}},PS.add('A', 'B'));
		assertEquals("0",PS.print('R'));
	}
	@Test
	void testAdd8() {
		PS.setPolynomial('A', new int[][]{{2,3},{3,4},{4,2}});
		PS.setPolynomial('B', new int[][]{{2,1},{2,0}});
		assertArrayEquals(new int[][] {{3,4},{2,3},{4,2},{2,1},{2,0}},PS.add('A', 'B'));
	}
	@Test
	void testAddThrows() {
		assertThrows(IllegalArgumentException.class, ()-> PS.add('K', 'G'));
		PS.clearPolynomial('A');
		assertThrows(IllegalArgumentException.class,()->PS.add('A', 'B'));
	}
	@Test
	void testSub1() {
		PS.setPolynomial('A', new int [][] {{5,3},{3,2},{1,0}});
		PS.setPolynomial('B', new int [][] {{4,2},{1,1},{-1,-1}});
		assertArrayEquals(new int [][] {{5,3},{-1,2},{-1,1},{1,0},{1,-1}},PS.subtract('A', 'B'));
	}
	@Test 
	void testSub2() {
		PS.setPolynomial('B', new int [][] {{3,5},{2,4},{1,1}});
		PS.setPolynomial('C', new int [][] {{3,5},{2,4},{1,1}});
		assertArrayEquals(new int [][] {{0,0}},PS.subtract('B', 'C'));
		assertEquals("0",PS.print('R'));
	}
	@Test
	void testSub3() {
		PS.setPolynomial('A', new int [][] {{3,3},{1,0}});
		PS.setPolynomial('C', new int [][] {{2,2},{1,1}});
		assertArrayEquals(new int [][] {{3,3},{-2,2},{-1,1},{1,0}},PS.subtract('A', 'C'));
		assertEquals("3 X^3 -2 X^2 - X + 1",PS.print('R'));
	}
	@Test
	void testSub4() {
		PS.setPolynomial('B', new int [][] {{4,2},{1,1}});
		PS.setPolynomial('C', new int [][] {{3,4},{1,3}});
		assertArrayEquals(new int [][] {{-3,4},{-1,3},{4,2},{1,1}},PS.subtract('B', 'C'));
		assertEquals("-3 X^4 - X^3 + 4 X^2 + X",PS.print('R'));
	}
	@Test 
	void testSub5() {
		PS.setPolynomial('A', new int [][] {{-3,3},{5,-1},{-3,-2}});
		PS.setPolynomial('C', new int [][] {{-4,4},{5,3},{-4,1},{3,-2}});
		assertArrayEquals(new int [][] {{4,4},{-8,3},{4,1},{5,-1},{-6,-2}},PS.subtract('A', 'C'));
		assertEquals("4 X^4 -8 X^3 + 4 X + 5 X^-1 -6 X^-2",PS.print('R'));
	}
	@Test
	void testSub6() {
		PS.setPolynomial('B', new int [][] {{2,2}});
		PS.setPolynomial('C', new int [][] {{-3,3}});
		assertArrayEquals(new int [][] {{3,3},{2,2}},PS.subtract('B', 'C'));
		assertEquals("3 X^3 + 2 X^2",PS.print('R'));
	}
	@Test
	void testSub7() {
		PS.setPolynomial('A', new int [][] {{2,2}});
		PS.setPolynomial('C', new int [][] {{-3,2}});
		assertArrayEquals(new int [][] {{5,2}},PS.subtract('A', 'C'));
		assertEquals("5 X^2",PS.print('R'));
	}
	@Test 
	void testSub8() {
		PS.setPolynomial('A', new int[][]{{2,3},{3,4},{4,2}});
		PS.setPolynomial('B', new int[][]{{2,1},{2,0}});
		assertArrayEquals(new int[][] {{3,4},{2,3},{4,2},{-2,1},{-2,0}},PS.subtract('A', 'B'));
	}
	@Test
	void testSubThrows() {
		PS.setPolynomial('A', new int[][]{{2,3},{3,4},{4,2}});
		PS.setPolynomial('B', new int[][]{{2,1},{2,0}});
		assertThrows(IllegalArgumentException.class,()-> PS.subtract('A', 'N'));
		PS.clearPolynomial('B');
		assertThrows(IllegalArgumentException.class,()-> PS.subtract('A', 'B'));
	}
	@Test
	void testMultiply1() {
		PS.setPolynomial('B', new int [][] {{5,2},{1,1},{3,0}});
		PS.setPolynomial('C', new int [][] {{6,3},{3,2},{5,0}});
		assertArrayEquals(new int [][] {{30,5},{21,4},{21,3},{34,2},{5,1},{15,0}},PS.multiply('B', 'C'));
		assertEquals("30 X^5 + 21 X^4 + 21 X^3 + 34 X^2 + 5 X + 15",PS.print('R'));
	}
	@Test
	void testMultiply2() {
		PS.setPolynomial('B', new int [][] {{5,0}});
		PS.setPolynomial('C', new int [][] {{2,3},{5,2},{1,0}});
		assertArrayEquals(new int [][] {{10,3},{25,2},{5,0}},PS.multiply('B', 'C'));
	}
	@Test
	void testMultiply3() {
		PS.setPolynomial('B', new int [][] {{0,0}});
		PS.setPolynomial('C', new int [][] {{5,3},{4,0},{12,-3}});
		assertThrows(IllegalArgumentException.class,()->PS.multiply('B', 'C'));
	}
	@Test 
	void testMultiply4() {
		PS.setPolynomial('C', new int [][] {{-3,4},{-2,3},{3,2}});
		PS.setPolynomial('A', new int [][] {{2,-3},{-4,-1},{-5,2}});
		assertArrayEquals(new int [][] {{15,6},{10,5},{-15,4},{12,3},{8,2},{-18,1},{-4,0},{6,-1}},PS.multiply('C', 'A'));
		assertEquals("15 X^6 + 10 X^5 -15 X^4 + 12 X^3 + 8 X^2 -18 X -4 + 6 X^-1",PS.print('R'));
	}
	@Test
	void testMultiply5() {
		PS.setPolynomial('B', new int [][] {{5,2},{-7,-8},{6,1}});
		assertArrayEquals(new int [][] {{25,4},{60,3},{36,2},{-70,-6},{-84,-7},{49,-16}},PS.multiply('B', 'B'));
	}
	@Test
	void testMultiply6() {
		PS.setPolynomial('B', new int [][] {{-4,0}});
		PS.setPolynomial('C', new int [][] {{-5,-5},{3,2},{2,-10},{4,-8}});
		assertArrayEquals(new int [][] {{-12,2},{20,-5},{-16,-8},{-8,-10,}},PS.multiply('B', 'C'));
	}
	@Test
	void testMultiply7() {
		PS.setPolynomial('B', new int [][] {{2,2},{3,1},{4,0}});
		PS.setPolynomial('C', new int [][] {{2,4},{3,5},{7,0}});
		assertArrayEquals(new int [][] {{6,7},{13,6},{18,5},{8,4},{14,2},{21,1},{28,0}},PS.multiply('B', 'C'));
	}
	@Test 
	void testMutiplyThrows() {
		assertThrows(IllegalArgumentException.class,()-> PS.multiply('O', 'P'));
		PS.setPolynomial('B', new int[][] {{1,1}});
		PS.clearPolynomial('B');
		assertThrows(IllegalArgumentException.class,()-> PS.multiply('B', 'C'));
	}
	@Test
	void testZeroCoeffecients() {
		PS.setPolynomial('A', new int [][] {{0,0},{0,0},{0,0}});
		assertThrows(IllegalArgumentException.class,()-> PS.print('A'));//A is considered usnet
		assertThrows(IllegalArgumentException.class,()->PS.print('R'));//R is unset
		PS.setPolynomial('A', new int [][] {{3,2},{4,1},{2,3}});
		PS.setPolynomial('B', new int[][] {{-3,2},{-4,1},{-2,3}});
		assertArrayEquals(new int[][] {{0,0}},PS.add('A', 'B'));//R is 0
		assertEquals("0",PS.print('R'));
		assertEquals(0,PS.evaluatePolynomial('R', 5));
		assertArrayEquals(new int[][] {{0,0}},PS.subtract('A','A'));//R is 0
		assertEquals("0",PS.print('R'));
		assertEquals(0,PS.evaluatePolynomial('R', 0));
		
	}

}
