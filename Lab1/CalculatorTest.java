import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
public class CalculatorTest {
static CalculatorClass Calc;
@BeforeAll
public static void BA() {
Calc=new CalculatorClass();
}
@Test
public void TestAdd() {
	assertEquals(5, Calc.add(2, 3));
	assertEquals(3,Calc.add(0,3));
	assertEquals(-10,Calc.add(-12, 2));
	assertEquals(-12,Calc.add(-10, -2));
	assertEquals(0,Calc.add(0, 0));
	assertEquals(0,Calc.add(-2, 2));
	assertEquals(-5,Calc.add(0, -5));
	assertEquals(47,Calc.add(52, -5));
}
@Test 
public void TestDivide() {
	assertEquals(2.5,Calc.divide(5, 2));
	assertEquals(((float)-1/3),Calc.divide(-3, 9));
	assertEquals(6.5,Calc.divide(-13,-2));
	assertEquals(-12,Calc.divide(24,-2));
	assertEquals(0,Calc.divide(0, 10));
	assertEquals(0,Calc.divide(0, -10));
	assertEquals(0,Calc.divide(-0, 10));
	assertEquals(0,Calc.divide(-0,-10));
	assertThrows(RuntimeException.class,() -> Calc.divide(5,0));
	assertThrows(RuntimeException.class,() -> Calc.divide(-5,0));
	assertThrows(RuntimeException.class,() -> Calc.divide(0,0));
}
}

