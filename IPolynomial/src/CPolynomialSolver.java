
public class CPolynomialSolver implements IPolynomialSolver {
    private Study A=new Study();
	private Study B=new Study();
	private Study C=new Study();
	private Study R=new Study();
 private void insertionSort(Study List) {
	 PolyNode ins=new PolyNode();
	 PolyNode Pivot=new PolyNode();
	 int i=0;
	 int insIndex=0;
	 if(List.size()>1) {
		while(i<List.size()-1){
			Pivot=(PolyNode)(List.get(i+1));
			List.remove(i+1);
			insIndex=i;
			ins=(PolyNode)(List.get(insIndex));
			while(insIndex>=0&&ins.getExponent()<Pivot.getExponent()) {
				insIndex--;
				if(insIndex<0)
					break;
				ins=(PolyNode)(List.get(insIndex));
			}
			List.add(insIndex+1, Pivot);
			if(insIndex==i) {
				i++;
			}
		}
	 }
 }

 private Study checkChar(char poly) {//will throw exception if poly isn't A,B,C
	 switch (poly) {
	 case 'A': 
		 return A; 
	 case 'B':  
		 return B;
	 case 'C': 
		 return C;
	 default :
		 throw new IllegalArgumentException();
	 } 
 }
 private Study checkCharR(char poly) {
	 Study List=new Study();
	 if(poly!='R') {
		 List=checkChar(poly);
		 return List;
	 }
	 else {
		 List =R;
		 return R;
	 }
 }
 private int checkSize(char poly) { //will throw exception if poly isn't A,B,C
	 int size;
	 switch (poly) {
	 case 'A': 
		 size =A.size();
		 return size;
	 case 'B' : 
		 size =B.size();
		 return size;
	 case 'C' :
		 size =C.size();
		 return size;
	default : 
		throw new IllegalArgumentException();
	 }
 }
 private void removeDuplicates(Study List) {
	 PolyNode Rnode;
	 for(int Count1=0;Count1<List.size();Count1++) {//To remove Duplicates and store them in one element
			Rnode=new PolyNode(); 
			PolyNode Pnode=new PolyNode();
			Rnode=(PolyNode)(List.get(Count1));
			for(int Count2=Count1+1;Count2<List.size();Count2++) {
				Pnode=(PolyNode)(List.get(Count2));
				if(Pnode.getExponent()==Rnode.getExponent()) {
					Rnode.setCoeff(Pnode.getCoeff()+Rnode.getCoeff());
					List.remove(Count2);
				}
			}
		}
 }
 private void removeZeroCoeff(Study List) {
	 PolyNode P=new PolyNode();
	 int i=0;
	 while(i<List.size()) {
		 P=(PolyNode)(List.get(i));
		 if(P.getCoeff()==0) {
			 List.remove(i);
		 }
		 else {
			 i++;
		 }
	 }
 }
 public void arrayToSLL(int [][] terms, Study List) {
	 PolyNode P;
	 for(int i=0;i<terms.length;i++) {
		 P=new PolyNode();
		 P.setCoeff(terms[i][0]);
		 P.setExponent(terms[i][1]);
		 List.add(i, P);
		 }
	 
 }
 public void  setPolynomial(char poly,int [][] terms ) {//setPolynomial throws exception if terms==null
	   //it will throw exception if the char poly isn't A,B,C
if(terms==null) {
throw new NullPointerException();
}
else if (terms.length==0) {
throw new IllegalArgumentException();
}

else {
Study List=new Study();
List=checkChar(poly);//Make List point to A or B or C 
clearPolynomialSpecial(poly);
arrayToSLL(terms,List);
removeZeroCoeff(List);
removeDuplicates(List);
insertionSort(List);
}
}
 
 
 
 
 public String print(char poly) {//throws Exception if poly isn't A,B,C,R or if poly is unset
	 Study List=new Study();
	 String polyString;
	 List=checkCharR(poly);
	 if(List.size()==0) {
		 throw new IllegalArgumentException();
	 }
	 else {
		 PolyNode P=new PolyNode();
		 polyString="";
		 boolean First=true;    /*A boolean to indicate if this is the First element in the polynomial or not
		 							So as not to put + before it*/
		 boolean zeroCoeff=true; //a boolean to indicate if all coeffecients =0
		 int i=0;
		 for(i=0;i<List.size();i++) {
			 P=(PolyNode)(List.get(i));
			 if(P.getCoeff()!=0) { // if it is equal to zero so there is no term (Special case for test)
				 zeroCoeff=false;
				 if(P.getExponent()!=0) {//if it is zero so you don't need to put X^
					 if(P.getCoeff()>0) {
						 if(!First) {
						 First=false;
						 polyString+=" ";
						 polyString+="+";
						 polyString+=" ";
						 }
						 if(P.getCoeff()!=1) {//if it is equal to one so we don't have to put it
							 polyString+=(P.getCoeff()).toString();
							 polyString+=" ";
						 }
					 }
					 else {
						 if(P.getCoeff()!=-1) {
							 if (!First) {
							 polyString+=" ";
							 }
							 polyString+=P.getCoeff().toString();
							 polyString+=" ";
						 }
						 else {
							 polyString+=" ";
							 polyString+="-";
							 polyString+=" ";
							 
						 }
						 
					 }
					 polyString+="X";
					 if(P.getExponent()!=1) {//if the exponent equal to 1 we don't put ^
						 polyString+="^";
						 polyString+=P.getExponent().toString();
					 }
				 }
				 else {//exponent = 0
					 if(P.getCoeff()>0) {//we put + 
						 if(!First) {
							 polyString+=" ";
							 polyString+="+";
							 polyString+=" ";
							 polyString+=P.getCoeff().toString();
							
						 }
						 else {//if it is the first term don't put +
							 First=false;
							 polyString+=P.getCoeff().toString();
						 }
						 
					 }
					 else {//coeffecient <0 then the getCoeff().toString() will put the sign
						if(!First) {
						 polyString+=" ";
						}
						 polyString+=P.getCoeff().toString();

						
					 }
				 }
			 }
			 First=false;
		 }
		 if(zeroCoeff) {
			 polyString="0";
		 }
	 }
	 return polyString;
 }
 
 
 
 
 private void clearPolynomialSpecial(char poly) {//Doesn't throw exceptions if the list is enmpty
	 Study List=new Study();					//used in add subtract multiply and set
	 List=checkCharR(poly);
	 if(List.size()!=0) {
		 List.clear();
 }
 }
 public void clearPolynomial(char poly) {//throws exception if the list is empty
	 Study List=new Study();
	 List=checkChar(poly);
	 if (List.size()!=0) {
		 List.clear();
	 }
	 else 
		 throw new IllegalArgumentException();
 }
 
 public float evaluatePolynomial(char poly,float value) {//throw exception if the list is empty or not A,B,C or R
	 Study List=new Study();
	 List=checkCharR(poly);
	 if(List.size()==0) {
		 throw new IllegalArgumentException();
	 }
	 else {
		float Soln=0;
		PolyNode P=new PolyNode();
		for(int i=0;i<List.size();i++) {
			P=(PolyNode)(List.get(i));
			Soln+=P.getCoeff()*Math.pow(value, P.getExponent());
		}
		return Soln;
	 }
	 
 }
public int [][] add(char poly1,char poly2){//throw exception if one of the polys is unset or not A,B,C 
	 Study List1=new Study();
	 Study List2=new Study();
	 List1=checkChar(poly1);
	 List2=checkChar(poly2);
	 if(List1.isEmpty()||List2.isEmpty()) {
		 throw new IllegalArgumentException();
	 }
	 else {
		 int [][] Soln;
		PolyNode Rnode;
		PolyNode N1=new PolyNode();
		PolyNode N2=new PolyNode();
		int i=0;
		int j=0;
		int index=0;
		clearPolynomialSpecial('R');
		N1=(PolyNode)(List1.get(0));
		N2=(PolyNode)(List2.get(0));
		while(i<List1.size()&&j<List2.size()) {
			while(i<List1.size()&&j<List2.size()&&N1.getExponent()!=N2.getExponent()) {
				if(N1.getExponent()>N2.getExponent()) {
					Rnode=new PolyNode();
					Rnode.setCoeff(N1.getCoeff());
					Rnode.setExponent(N1.getExponent());
					R.add(index++,Rnode);
					if(i!=List1.size()-1) {
					N1=(PolyNode)(List1.get(++i));
					}
					else {
						++i;
					}
				}
				else {
					Rnode=new PolyNode();
					Rnode.setCoeff(N2.getCoeff());
					Rnode.setExponent(N2.getExponent());
					R.add(index++,Rnode);
					if(j!=List2.size()-1)
					N2=(PolyNode)(List2.get(++j));
					else {
						++j;
					}
				}
			}
			if(i<List1.size()&&j<List2.size()) {
				Rnode=new PolyNode();
				Rnode.setCoeff(N1.getCoeff()+N2.getCoeff());
				Rnode.setExponent(N1.getExponent());
				R.add(index++,Rnode);
				if(i!=List1.size()-1) {
				N1=(PolyNode)(List1.get(++i));
				}
				else {
					++i;
				}
				if(j!=List2.size()-1) {
					N2=(PolyNode)(List2.get(++j));
				}
				else 
					++j;
			}
		}
		while(j<List2.size()) {
			Rnode=new PolyNode();
			Rnode.setCoeff(N2.getCoeff());
			Rnode.setExponent(N2.getExponent());
			R.add(index++,Rnode);
			if(j!=List2.size()-1)
			N2=(PolyNode)(List2.get(++j));
			else 
			++j;
		}
		while(i<List1.size()) {
			Rnode=new PolyNode();
			Rnode.setCoeff(N1.getCoeff());
			Rnode.setExponent(N1.getExponent());
			R.add(index++,Rnode);
			if(i!=List1.size()-1)
			N1=(PolyNode)(List1.get(++i));
			else 
				++i;
		}
		removeZeroCoeff(R);
		if(R.size()==0) {
			Rnode=new PolyNode();
			Rnode.setCoeff(0);
			Rnode.setExponent(0);
			R.add(0,Rnode);
		}
		Soln=toArray(R);
		return Soln;
	 }
 }

public int [][] subtract(char poly1,char poly2){//Throws Exception if any of the polynomials is unset or it is not A,B or C
	 Study List1=new Study();
	 Study List2=new Study();
	 List1=checkChar(poly1);
	 List2=checkChar(poly2);
	 if(List1.isEmpty()||List2.isEmpty()) {
		 throw new IllegalArgumentException();
	 }
	 else {
		 int [][] Soln;
		PolyNode Rnode;
		PolyNode N1=new PolyNode();
		PolyNode N2=new PolyNode();
		int i=0;
		int j=0;
		int index=0;
		N1=(PolyNode)(List1.get(0));
		N2=(PolyNode)(List2.get(0));
		clearPolynomialSpecial('R');
		while(i<List1.size()&&j<List2.size()) {
			while(i<List1.size()&&j<List2.size()&&N1.getExponent()!=N2.getExponent()) {
				if(N1.getExponent()>N2.getExponent()) {
					Rnode=new PolyNode();
					Rnode.setCoeff(N1.getCoeff());
					Rnode.setExponent(N1.getExponent());
					R.add(index++,Rnode);
					if(i!=List1.size()-1) {
					N1=(PolyNode)(List1.get(++i));
					}
					else {
						++i;
					}
				}
				else {
					Rnode=new PolyNode();
					Rnode.setCoeff(-N2.getCoeff());
					Rnode.setExponent(N2.getExponent());
					R.add(index++,Rnode);
					if(j!=List2.size()-1)
					N2=(PolyNode)(List2.get(++j));
					else {
						++j;
					}
				}
			}
			if(i<List1.size()&&j<List2.size()) {
				Rnode=new PolyNode();
				Rnode.setCoeff(N1.getCoeff()-N2.getCoeff());
				Rnode.setExponent(N1.getExponent());
				R.add(index++,Rnode);
				if(i!=List1.size()-1) {
				N1=(PolyNode)(List1.get(++i));
				}
				else {
					++i;
				}
				if(j!=List2.size()-1) {
					N2=(PolyNode)(List2.get(++j));
				}
				else 
					++j;
			}
		}
		while(j<List2.size()) {
			Rnode=new PolyNode();
			Rnode.setCoeff(-N2.getCoeff());
			Rnode.setExponent(N2.getExponent());
			R.add(index++,Rnode);
			if(j!=List2.size()-1)
			N2=(PolyNode)(List2.get(++j));
			else 
			++j;
		}
		while(i<List1.size()) {
			Rnode=new PolyNode();
			Rnode.setCoeff(N1.getCoeff());
			Rnode.setExponent(N1.getExponent());
			R.add(index++,Rnode);
			if(i!=List1.size()-1)
			N1=(PolyNode)(List1.get(++i));
			else 
				++i;
		}
		removeZeroCoeff(R);
		if(R.size()==0) {
			Rnode=new PolyNode();
			Rnode.setCoeff(0);
			Rnode.setExponent(0);
			R.add(0,Rnode);
		}
		Soln=toArray(R);
		return Soln;
	 }
 }
 
 public int [][] multiply(char poly1,char poly2){//will throw exception if any of the polynomials isn't set or not A,B,C 
	int size1=0;
	int size2=0;
	Study L=new Study();
	Study K=new Study();
	int [][] Soln;
	L=checkChar(poly1);
	K=checkChar(poly2);
	size1=checkSize(poly1);
	size2=checkSize(poly2);
	if(L.isEmpty()||K.isEmpty()) {
		throw new IllegalArgumentException();
	}
	else {
		int i=0,j=0,index=0;
		PolyNode q=new PolyNode();
		PolyNode w=new PolyNode();
		PolyNode Rnode;
		clearPolynomialSpecial('R');
		while(i<size1) {
			q=(PolyNode)(L.get(i));
			j=0;
			while(j<size2) {
				w=(PolyNode)(K.get(j));
				Rnode=new PolyNode();
				Rnode.setCoeff(q.getCoeff()*w.getCoeff());
				Rnode.setExponent(q.getExponent()+w.getExponent());
				R.add(index++,Rnode);
				j++;
			}
			i++;
		}
	removeZeroCoeff(R);
	removeDuplicates(R);
	insertionSort(R);
	if(R.size()==0) {
		Rnode=new PolyNode();
		Rnode.setCoeff(0);
		Rnode.setExponent(0);
		R.add(0,Rnode);
	}
	Soln=toArray(R);
	}
	return Soln;
}
 public int [][] toArray(Study List) {
	 int [][] Soln;
	 PolyNode Rnode;
	 Soln=new int [List.size()][2];
		for(int i=0;i<Soln.length;i++) {
			Rnode=new PolyNode();
			Rnode=(PolyNode)List.get(i);
			Soln[i][0]=Rnode.getCoeff();
			Soln[i][1]=Rnode.getExponent();
		}
		return Soln;
 }
}
