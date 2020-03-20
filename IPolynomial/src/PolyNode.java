
public class PolyNode extends Object {
	private Integer coeff;
	private Integer exponent;
	public PolyNode() {	
	}
	public PolyNode(Integer newCoeff,Integer newExponent) {
		coeff=newCoeff;
		exponent=newExponent;
	}
	public void setCoeff(int newCoeff) {
		coeff=newCoeff;
	}
	public void setExponent(int newExponent) {
		exponent=newExponent;
	}
	public Integer getCoeff() {
		return coeff;
	}
	public Integer getExponent() {
		return exponent;
	}
	
	
}
