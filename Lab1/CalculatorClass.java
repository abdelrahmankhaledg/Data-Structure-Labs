public class CalculatorClass implements ICalculator {
public int add(int x,int y) {
	return x+y;
}
public float divide(int x,int y) {
	if(y==0) {
		throw new RuntimeException("You cannot divide by zero");
	}
	else if (x==0) {//this if statement because (float)0/-10 returns -0 and not 0 
		return 0;
	}
	else
	return (float)x/y;
}
}

