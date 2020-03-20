

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
public static void main (String [] args) {
	CPolynomialSolver PS = new CPolynomialSolver();
	Scanner scan = new Scanner(System.in);
	char A, B, C, R;
	while (true) {
			List<List<Integer>> Dynamic = new ArrayList<List<Integer>>();
			System.out.println("Please choose an action : ");
			System.out.println("------------------------");
			System.out.println();
			System.out.println("1- Set a polynomial variable");
			System.out.println("2- Print the value of a polynomial variable");
			System.out.println("3- Add two polynomials");
			System.out.println("4- Subtract two polynomials");
			System.out.println("5- Multiply two polynomials ");
			System.out.println("6- Evaluate a polynomial at some point");
			System.out.println("7- Clear a polynomial variable");
			System.out.println("=======================================================");
		int action = scan.nextInt();
			try {
				if (action == 1) {
					System.out.println("Insert the variable name A , B or C ");
					char set = scan.next().charAt(0);
					System.out.println("Insert the polynomial terms in the form :");
					System.out.println(" (coeff1,exp1) , (coeff2,exp2) , ....");
					String hi = scan.nextLine();
					String str = scan.nextLine();
					String[] strArray = str.replace(")", "").replace("(", "").split(",");
					for (int i = 0; i < strArray.length; i++) {
						strArray[i] = strArray[i].trim();
					}
					int k = 0;
					if (set == 'A') {
						for (int p = 0; p < (strArray.length / 2); p++) {
							Dynamic.add(new ArrayList<Integer>());
						}
						for (int i = 0; i < (strArray.length / 2); i++) {
							for (int j = 0; j < 2; j++) {
								Dynamic.get(i).add(Integer.parseInt(String.valueOf(strArray[k])));
								k++;
							}
						}
						int[][] terms = new int[Dynamic.size()][2];
						for (int i = 0; i < Dynamic.size(); i++) {
							for (int j = 0; j < 2; j++) {
								terms[i][j] = Dynamic.get(i).get(j);
							}
						}
						PS.setPolynomial('A', terms);
						System.out.println("Polynomial A is set");
					} else if (set == 'B') {
						for (int p = 0; p < (strArray.length / 2); p++) {
							Dynamic.add(new ArrayList<Integer>());
						}
						for (int i = 0; i < (strArray.length / 2); i++) {
							for (int j = 0; j < 2; j++) {
								Dynamic.get(i).add(Integer.parseInt(String.valueOf(strArray[k])));
								k++;
							}
						}
						int[][] terms2 = new int[Dynamic.size()][2];
						for (int i = 0; i < Dynamic.size(); i++) {
							for (int j = 0; j < 2; j++) {
								terms2[i][j] = Dynamic.get(i).get(j);
							}
						}
						PS.setPolynomial('B', terms2);
						System.out.println("Polynomial B is set");
					} else if (set == 'C') {
						for (int p = 0; p < (strArray.length / 2); p++) {
							Dynamic.add(new ArrayList<Integer>());
						}
						for (int i = 0; i < (strArray.length / 2); i++) {
							for (int j = 0; j < 2; j++) {
								Dynamic.get(i).add(Integer.parseInt(String.valueOf(strArray[k])));
								k++;
							}
						}
						int[][] terms3 = new int[Dynamic.size()][2];
						for (int i = 0; i < Dynamic.size(); i++) {
							for (int j = 0; j < 2; j++) {
								terms3[i][j] = Dynamic.get(i).get(j);
							}
						}
						PS.setPolynomial('C', terms3);
						System.out.println("Polynomial C is set");
					}
					System.out.println("=======================================================");
				}
			}catch (Exception e){
				System.out.println("Insufficient Polynomial");
			};
			if (action == 2) {
				try {
					System.out.println("Insert the variable number A,B,C or R ");
					char set = scan.next().charAt(0);
					if (set == 'A') {
						System.out.println("A value is : " + PS.print('A'));
					} else if (set == 'B') {
						System.out.println("B value is : " + PS.print('B'));
					} else if (set == 'C') {
						System.out.println("C value is : " + PS.print('C'));
					} else if (set == 'R') {
						System.out.println("R value is : " + PS.print('R'));
					}
					System.out.println("=======================================================");
				}catch (Exception e){
					System.out.println("There is no Polynomial to print , Please set a Polynomial ");
				}
			}
			try {
				if (action == 3) {
					System.out.println("Insert first operand variable name: A, B or C");
					char set = scan.next().charAt(0);
					System.out.println("Insert second operand variable name: A, B or C");
					char set2 = scan.next().charAt(0);
					int[][] sol = PS.add(set, set2);
					System.out.println("Result set in R : " + PS.print('R'));
					System.out.println("=======================================================");
				}
				if (action == 4) {
					System.out.println("Insert first operand variable name: A, B or C");
					char set = scan.next().charAt(0);
					System.out.println("Insert second operand variable name: A, B or C");
					char set2 = scan.next().charAt(0);
					int[][] sol = PS.subtract(set, set2);
					System.out.println("Result set in R : " + PS.print('R'));
					System.out.println("=======================================================");
				}
				if (action == 5) {
					System.out.println("Insert first operand variable name: A, B or C");
					char set = scan.next().charAt(0);
					System.out.println("Insert second operand variable name: A, B or C");
					char set2 = scan.next().charAt(0);
					int[][] sol = PS.multiply(set, set2);
					System.out.println("Result set in R : " + PS.print('R'));
					System.out.println("=======================================================");
				}
			}catch (Exception e){
				System.out.println("One of the polynomial or Both may be empty , Please set a polynomial");
			}
			try {
				if (action == 6) {
					System.out.println("Enter the Polynomail A , B , C or R");
					char set = scan.next().charAt(0);
					System.out.println("Enter the point to calculate the polynomial : ");
					int point = scan.nextInt();
					float hi = PS.evaluatePolynomial(set, point);
					System.out.println("Evaluation at " + point + " is : " + hi);
					System.out.println("=======================================================");
				}
				if (action == 7) {
					System.out.println("Choose the polynomial to be cleared ( A,B or C )");
					char set = scan.next().charAt(0);
					PS.clearPolynomial(set);
					System.out.println("Polynomial cleared");
					System.out.println("=======================================================");
				}
			}catch (Exception e){
				System.out.println("One of the polynomial or Both may be empty , Please set a polynomial");
			}
	}
}
}

