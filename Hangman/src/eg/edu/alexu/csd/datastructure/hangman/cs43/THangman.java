package eg.edu.alexu.csd.datastructure.hangman.cs43;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.lang.Integer;
class THangman {
static CHangman HM=null;
static Scanner s=null;
static String [] words=new String [10];
int numOfInputs=-1;
/*method of testing the guess function 
 * 1-print the secret word before test
 * 2-make an array of characters (inputCharacters) of size equal to the number of letters in the secret word 
 * 3-the array will take characters as input which will be the input for the guess function
 * 4-another array of Strings of the same size as the previous array will be made
 * 5-it will hold the corresponding strings which are expected to be produced for the input Characters in the (inputCharacters )array 
 * 6-Losing and winning conditions will also be tested and description at the last test function
 */

static String word=null;
static char [] Characters=null;//an array in which the characters of the secret word will be stored 
static char[] inputCharacters=null;//the array in which input characters will be stored
static String [] expectedStrings=null;//the array in which the expected strings out of the guess function are stored
static char WR;	
@BeforeAll
public static void BA() {
		HM=new CHangman();
		s=new Scanner(System.in);
		HM.setDictionary(words);
		System.out.println("Enter the maximum number of wrong guesses");
		Integer max=s.nextInt();
		HM.setMaxWrongGuesses(max);
	word=HM.selectRandomSecretWord();
	Characters=word.toCharArray();
	inputCharacters=new char[Characters.length];
	expectedStrings=new String[Characters.length];
	}
	
	@Test
	public void testCheckBuggySecretWord() {//additional function to test the buggy secret words and it is called inside the guess function
		assertTrue(HM.checkBuggySecretWord("a"));
		assertTrue(HM.checkBuggySecretWord("0"));
		assertTrue(HM.checkBuggySecretWord("@"));
		assertTrue(HM.checkBuggySecretWord("$"));
		assertTrue(HM.checkBuggySecretWord("az12"));
		assertTrue(HM.checkBuggySecretWord("$%sc@"));
		assertTrue(HM.checkBuggySecretWord("gf   as"));
		assertTrue(HM.checkBuggySecretWord("as\tas"));
		assertTrue(HM.checkBuggySecretWord("12sx"));
		assertTrue(HM.checkBuggySecretWord(""));
		assertTrue(HM.checkBuggySecretWord(null));
		
	} 
	@Test
	public void testCheckBuggyInput() {//additional function to check the buggy input from the user ,it is called inside the guess function and if input is buggy throw exception
		assertEquals(1, HM.checkBuggyInput(null));
		assertEquals(2, HM.checkBuggyInput((char)0));
		assertEquals(2, HM.checkBuggyInput(' '));
		assertEquals(2, HM.checkBuggyInput('\t'));
		assertEquals(2, HM.checkBuggyInput('\f'));
		assertEquals(2, HM.checkBuggyInput('\r'));
		assertEquals(2, HM.checkBuggyInput('\n'));
		assertEquals(2, HM.checkBuggyInput('1'));
		assertEquals(2, HM.checkBuggyInput('5'));
		assertEquals(2, HM.checkBuggyInput('#'));
		assertEquals(2, HM.checkBuggyInput('*'));	
	}
	@Test 
	public void testGuess() {
		System.out.println(word);
		System.out.println(Characters.length);
			for(int i=0;i<inputCharacters.length;i++) {
			if((inputCharacters[i]=s.next().charAt(0))=='#') {
				break;
			}
			else {
				numOfInputs++;
			expectedStrings[i]=s.next();
			}
			}
		try {
			
		for(int i=0;i<=numOfInputs;i++) {
			assertEquals(expectedStrings[i],HM.guess(inputCharacters[i]));
			}
		System.out.println("Enter the expected output of the null input");
		assertEquals(s.next(),HM.guess(null));
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
@Test 
public void testWinLose() {//we make wrong guesses  and leave the last wrong guess to this function to check
							//or we make all right guesses and we leave the last right guess for this function to test
	System.out.println("Enter the winning or losing character ");//a character that is used to check the winning or losing in assertThrows
	WR=s.next().charAt(0);
	try {
		while(WR!='#') {
		assertEquals(null,HM.guess(WR));
		WR=s.next().charAt(0);
		}
	}catch(Exception e) {
		e.getMessage();
	}
}
}