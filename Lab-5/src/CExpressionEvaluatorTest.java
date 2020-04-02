import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CExpressionEvaluatorTest {
CExpressionEvaluator EV=new CExpressionEvaluator();
	@Test
	void testConvert1() {//Null expression as input.
		assertThrows(RuntimeException.class,()->EV.infixToPostfix(null));
	}
	
	@Test
	void testConvert2() {//Missing right parenthesis.
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("a * (b+c *d"));
	}
	@Test
	void testConvert3() {//Missing left parenthesis.
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("a * b+c) *d"));
	}
	@Test
	void testConvert4() {
		assertEquals("a b c + * d *", EV.infixToPostfix("a * (b + c) * d"));
	}
	@Test
	void testConvert5() {//The following tests are for negative sign in numeric operands.
		assertEquals("0 5 - 6 +",EV.infixToPostfix("-5 + 6"));
	}
	@Test 
	void testConvert6() {
		assertEquals("6 0 5 - *",EV.infixToPostfix("6 * -5"));
	}
	@Test
	void testConvert7() {
		assertEquals("6 0 5 - -",EV.infixToPostfix("6 - -5"));
	}
	@Test 
	void testConvert8() {
		assertEquals("0 4 - 3 0 2 - + * 0 4 - *",EV.infixToPostfix("-4 * (3 + -2) * -4"));
	}
	@Test
	void testConvert9() {
		assertEquals("6 0 5 - 7 + * 0 7 - *",EV.infixToPostfix("6 * (-5 + 7) * -7"));
	}
	@Test
	void testConvert10() {//The following tests for negative sign in variable operands.
		assertEquals("A 0 B - C + * 0 D - *",EV.infixToPostfix("A * (-B + C) * -D"));	
	}
	@Test
	void testConvert11() {
		assertEquals("0 A - B 0 C - + * 0 D - *",EV.infixToPostfix("-A * (B + -C) * -D"));
	}
	@Test 
	void testConvert12() {//The following test are regular tests for overall conversion
		assertEquals("2 3 4 * +",EV.infixToPostfix("2 + 3 * 4"));
	}
	@Test
	void testConvert13() {
		assertEquals("a b * 5 +",EV.infixToPostfix("a * b + 5"));
	}
	@Test
	void testConvert14() {
		assertEquals("1 2 + 7 *",EV.infixToPostfix("(1 + 2) * 7"));
	}
	
	@Test
	void testConvert15() {
		assertEquals("a b * c /",EV.infixToPostfix("a * b / c"));
	}
	
	@Test
	void testConvert16() {
		assertEquals("a b c - d + / e a - * c *",EV.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
	}
	
	@Test
	void testConvert17() {
		assertEquals("a b / c - d e * + a c * -",EV.infixToPostfix("a / b - c + d * e - a * c"));
	}
	@Test
	void testConver18() {
		assertEquals("300 23 + 43 21 - * 84 7 + /",EV.infixToPostfix("(300+23)*(43-21)/(84+7)"));
	}
	@Test 
	void testConvert19() {
		assertEquals("4 8 + 6 5 - * 3 2 - 2 2 + * /",EV.infixToPostfix("(4+8)*(6-5)/((3-2)*(2+2))"));
	}
	@Test
	void testConvert20() {
		assertEquals("a b c d * e - * f g h * + * + i -",EV.infixToPostfix("a+b*(c*d-e)*(f+g*h)-i"));
	}
	@Test
	void testConvert21() {
		assertEquals("A B C + * D /",EV.infixToPostfix("A*(B+C)/D"));
	}
	@Test
	void testConver22() {
		assertEquals("0 400 - 300 0 200 - + * 0 400 - *",EV.infixToPostfix("-400 * (300 + -200) * -400"));
	}
	@Test
	void testConvert23() {
		assertEquals("3 a * 5 / b * 7 c * - 8 d * 8 * e * + 5 a * 4 * c * -",EV.infixToPostfix("3*a / 5*b - 7*c + 8*d * 8*e - 5*a * 4*c"));
	}
	@Test
	void testConvert24() {
		assertEquals("15 a * 17 b * 20 c * 30 * d * 500 e * - * 340 f * 220 g * 120 * h * + * + 1000 i * -",EV.infixToPostfix("15*a+17*b*(20*c*30*d-500*e)*(340*f+220*g*120*h)-1000*i"));
	}
	@Test
	void testConvert25() {
		assertEquals("0 2200 - a * 0 110 - b * 0 750 - c * - 0 423 - d * + / 0 1111 - e * 0 4223 - a * - * 0 500 - * c *",EV.infixToPostfix("(-2200*a / (-110*b - -750*c + -423*d)) * (-1111*e - -4223*a) * -500*c"));
	}
	@Test
	void testConvert26() {//Special cases for Operators
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("+ 5*6"));	
	}
	@Test
	void testConvert27() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("6*(/4*3)"));	
	}
	@Test
	void testConvert28() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("5*C+800*(200+200*B-)"));	
	}
	@Test
	void testConvert29() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("200*600*A+400-120+(550-200*B)+"));	
	}
	@Test
	void testConvert30() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("5//7"));	
	}
	@Test
	void testConvert31() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("5+3/+12"));	
	}
	@Test
	void testConvert32() {
	assertEquals("13 0 5 - /",EV.infixToPostfix("13/-5"));	
	}
	@Test
	void testConvert33() {
	assertEquals("12 0 20 - +",EV.infixToPostfix("12+-20"));	
	}
	@Test
	void testConvert34() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("15-*63"));	
	}
	@Test
	void testConvert35() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("20-+14"));	
	}
	@Test
	void testConvert36() {//Special Cases For numbers and variables 
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("400 500*12"));	
	}
	@Test
	void testConvert37() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("12*A C*200"));	
	}
	
	@Test
	void testConvert38() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("16(20+30)"));	
	}
	@Test
	void testConvert39() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("(3600+740)210"));	
	}
	@Test
	void testConvert40() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("-500 16"));	
	}
	@Test
	void testConvert41() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("- -5*12"));	
	}
	@Test
	void testConvert42() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("---521+304"));	
	}
	@Test
	void testConvert43() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("(56-20)(70-12)"));	
	}
	@Test
	void testConvert44() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("16*D(20+30)"));	
	}
	@Test
	void testConvert45() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("(K*L+C*D)A*B"));	
	}
	@Test
	void testConvert46() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("-A*B 300*C"));	
	}
	@Test
	void testConvert47() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("- -k*n"));	
	}
	@Test
	void testConvert48() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("---x*y*z*k*l*m"));	
	}
	@Test
	void testConvert49() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("(A+B)(C-D)"));	
	}
	@Test
	void testConvert50() {//Checking errors in parenthesis
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("5*6+17*()-18"));	
	}
	@Test
	void testConvert51() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("((()))"));	
	}
	@Test
	void testConvert52() {//Check Empty Expression
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("     "));	
	}
	@Test
	void testConvert53() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix(""));	
	}
	@Test
	void testConvert54() {
	assertEquals("5 6 +",EV.infixToPostfix("((5+6))"));	
	}
	
	@Test
	void testConvert55() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("(         )"));	
	}
	@Test
	void testConvert56() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("A * * B"));	
	}
	@Test
	void testConvert57() {
	assertThrows(RuntimeException.class,()->EV.infixToPostfix("13+12 (20+25)"));	
	}
	@Test
	void testConvert59() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("225*A 225"));	
	}
	@Test
	void testConvert60() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("A525 * 600"));	
	}
	
	@Test
	void testConvert61() {//Next test cases are for Infix expression with Symbols 
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("3*a# / 5*b - 7*c + 8*d * 8*e - 5*a * 4*c"));	
	}
	
	@Test
	void testConvert62() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("(5+12$)"));	
	}
	
	@Test
	void testConvert63() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("(12*300})"));	
	}
	
	@Test
	void testConvert64() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("12!*13"));	
	}
	
	@Test
	void testConvert65() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("25+24["));	
	}
	
	@Test
	void testConvert66() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("12+120^1325"));	
	}
	@Test
	void testConvert67() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("(   (      (    )   )       )  "));
	}
	@Test
	void testConvert68() {//Special case of only a positive number 
		assertEquals("500",EV.infixToPostfix("    500    "));
	}
	@Test
	void testConvert69() {//Special case of only a negative number
		assertEquals("0 2300 -",EV.infixToPostfix("   -2300   "));
	}
	@Test
	void testConvert70() {//Special case of only one variable 
		assertEquals("A",EV.infixToPostfix("A"));
	}
	@Test
	void testConvert71() {//Case of only one negative variable
		assertEquals("0 A -",EV.infixToPostfix("  -A   "));
	}
	@Test 
	void testConvert72(){//Some other cases that was handled later
		assertEquals("500 A *",EV.infixToPostfix("500 * A"));
	}
	@Test
	void testConvert73() {
		assertEquals("0 500 - 0 A - *",EV.infixToPostfix("-500 * -A"));
	}
	@Test
	void testConvert74(){
		assertEquals("3 A * 0 B - *",EV.infixToPostfix("3*A*-B"));
	}
	@Test
	void testConvert75() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("AB"));
	}
	@Test
	void testConvert76() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("3A"));
	}
	@Test
	void testConvert77() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("500AB"));
	}
	@Test
	void testConvert78(){
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("    A   B    "));
	}
	@Test
	void testConvert79() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("  50   40  "));
	}
	@Test
	void testConvert80() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("("));
	}
	@Test
	void testConvert81() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix(")"));
	}
	@Test
	void testConvert82() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("   *    "));
	}
	@Test
	void testConvert83() {//Some other valid cases 
		assertEquals("A B + C D - * E + F G + /",EV.infixToPostfix("( ( A + B ) * ( C - D ) + E ) / (F + G)"));
	}
	@Test
	void testConvert84() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("5 6 -"));
	}
	
	@Test
	void testEvaluate1() {
		assertEquals(8,EV.evaluate("6 2 / 3 - 4 2 * +"));
	}
	@Test
	void testEvaluate2() {
		assertEquals(-4,EV.evaluate("2 3 1 * + 9 -"));
	}
	@Test
	void testEvaluate3() {
		assertEquals(757,EV.evaluate("100 200 + 2 / 5 * 7 +"));
	}
	@Test
	void testEvaluate4() {
		assertEquals(-40000,EV.evaluate("300 400 200 - 1000 + / 200 600 - * 400 *"));
	}
	@Test
	void testEvaluate5() {///Special Case division by zero
		assertThrows(ArithmeticException.class,()->EV.evaluate("5 4 + 0 / "));
	}
	@Test
	void testEvaluate6() {//Special Case empty expression
		assertThrows(RuntimeException.class,()->EV.evaluate("         "));
	}
	@Test
	void testEvaluate7() {//no operands for *
		assertThrows(RuntimeException.class,()->EV.evaluate("50 40 - *"));
	}
	@Test
	void testEvaluate8() {//no operands to -
		assertThrows(RuntimeException.class,()->EV.evaluate("- 40 50 +"));
	}
	@Test
	void testEvaluate9() {//1 missing operand
		assertThrows(RuntimeException.class,()->EV.evaluate("40 -"));
	}
	@Test
	void testEvaluate10() {//no Operators 
		assertThrows(RuntimeException.class,()->EV.evaluate("40 50 "));
	}
	@Test
	void testEvaluate11() {//Only one number in the postfix expression
		assertEquals(500,EV.evaluate("   500    "));
	}
	@Test
	void testEvaluate12() {//Only one negative number in the postfix expression
		assertEquals(-340554,EV.evaluate("  0 340554 - "));
	}
	@Test
	void testEvaluate13() {//Only operator in the postfix expression
		assertThrows(RuntimeException.class,()->EV.evaluate("   *       "));
	}
	@Test
	void testEvaluate14() {
	assertThrows(RuntimeException.class,()->EV.evaluate("         "));	
	}
	@Test
	void testEvaluate15() {//Special case of variables and numbers together in the postfix expression
		assertThrows(RuntimeException.class,()->EV.evaluate("500 A *"));
	}
	@Test
	void testEvaluate16() {//Special characters in the postfix expression such as $#
		assertThrows(RuntimeException.class,()->EV.evaluate("2000 $ -"));
		
	}
	@Test
	void testEvaluate17() {
		assertThrows(RuntimeException.class,()->EV.evaluate("(5000 -40000) * 12") );
	}
	@Test 
	void testEvaluate18(){//Divsion by zero 
		assertThrows(ArithmeticException.class,()->EV.evaluate("700 500 400 - 100 - /"));
	}
	@Test
	void testEvaluate19() {//Operator at the beginning of the postfix expression 
		assertThrows(RuntimeException.class,()->EV.evaluate("- 5 4 *"));
	}
	@Test
	void testEvaluate20() {//Operand at the end of the postfix expression
		assertThrows(RuntimeException.class,()->EV.evaluate(" 700 200 * 800"));
	}
	@Test
	void testEvaluate30() {
		assertThrows(RuntimeException.class,()->EV.evaluate(null));
	}
	@Test
	void testEvaluate31() {

		assertEquals(500,EV.evaluate("500"));
	}
	@Test
	void testEvaluate32() {
		assertEquals(20,EV.evaluate("18 2 +"));
	}
	@Test
	void testEvaluate33() {
		assertEquals(20,EV.evaluate("5 4 *"));
	}
	@Test
	void testEvaluate34() {
		assertEquals(34,EV.evaluate("44 10 -"));
	}
	@Test
	void testEvaluate35() {
		assertEquals(5,EV.evaluate("10 2 /"));
	}
	@Test
	void testEvaluate36() {
		assertEquals(16,EV.evaluate("0 4 - 3 0 2 - + * 0 4 - *"));
	}
	@Test
	void testEvaluate37() {
		assertEquals(-84,EV.evaluate("6 0 5 - 7 + * 0 7 - *"));
	}
	@Test
	void testEvaluate38() {
		assertEquals(3,EV.evaluate("4 8 + 6 5 - * 3 2 - 2 2 + * /"));
	}
	@Test
	void testEvaluate39() {
		assertEquals(78,EV.evaluate("300 23 + 43 21 - * 84 7 + /"));
	}
	//////Some more legal tests for both functions :
	@Test
	void testConvert85() {
		assertEquals("4 7 8 + / 15 * 2 - 2 3 / 20 * +",EV.infixToPostfix("4/(7+8)*15-2+2/3*20"));
	}
	@Test
	void testEvaluate40() {
		assertEquals(15,EV.evaluate("4 7 8 + / 15 * 2 - 2 3 / 20 * +"));
	}
	@Test
	void testConvert86() {
		assertEquals("5 14 12 20 - * + 15 /",EV.infixToPostfix("( 5 + 14 * ( 12 - 20 ) ) / 15"));
	}
	@Test
	void testEvaluate41() {
		assertEquals(-7,EV.evaluate("5 14 12 20 - * + 15 /"));
	}
	@Test
	void testConvert87() {
		assertEquals("12 43 57 * 33 / + 12 -",EV.infixToPostfix("12 + 43 * 57 / 33 - 12"));
	}
	@Test
	void testEvaluate42() {
		assertEquals(74,EV.evaluate("12 43 57 * 33 / + 12 -"));
	}
	@Test
	void testConvert88() {
		assertThrows(RuntimeException.class,()->EV.evaluate("4 * / 3"));
	}
	@Test
	void testConvert89() {
		assertThrows(RuntimeException.class,()->EV.infixToPostfix("(5*6)(7*8)"));
	}
	@Test
	void testConvert90() {
		assertEquals("55 67 +",EV.infixToPostfix("    (  (  (  (  ( (55 + 67 ) ) ))))"));
	}
	@Test
	void testConvert91() {
		assertEquals("A B + C n d + * f / - g +",EV.infixToPostfix("A +B -C *(n +d )/f +g"));
	}
	@Test
	void testConvert92() {
		assertEquals("A B + C D - * E + F G + /",EV.infixToPostfix("( ( A + B ) * ( C - D ) + E ) / (F + G)"));
	}
}
