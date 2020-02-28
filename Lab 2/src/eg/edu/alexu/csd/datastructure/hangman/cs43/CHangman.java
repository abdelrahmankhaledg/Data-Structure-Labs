package eg.edu.alexu.csd.datastructure.hangman.cs43;

import java.io.IOException;
import java.util.Random;
import java.io.*;
import java.lang.Character;
public class CHangman implements IHangman {

private String Reader;//used to read word by word from the file and store them in the dictionary
private String HiddenWord=null;//the string which will be printed to user afer guessing one char
private StringBuffer Hidden=new StringBuffer(20);
private String[] words=null;// The array in which the dictionary will be stored
private String word=null;//the String in which the random secret word will be stored
private int Wrong;//Number of wrong guesses 
private int rightGuess=0;//counter for rightguesses over all,if it equals the length of the secret word then it is a win 
private boolean win=false;//a flag to return null if the user guessed all right and wants to use the guess function again
private boolean loss=false;//same as win but for lose case
private char[] Characters=null;//the character which will contain  the characters of the word 
private boolean filled=false;//a flag to check whether the string buffer is filled or not 


public String [] ReadFile(String [] Dictionary) {
	int i=0;
	try(BufferedReader br=new BufferedReader(new FileReader("Hangman.txt"))){//line separated file 
		while((i<Dictionary.length)) {
			Reader=br.readLine();
			Dictionary[i++]=Reader;
		}
	}
	catch (IOException e) {
		e.getMessage();
	}
	return Dictionary;
}
public void setDictionary(String [] words) {
this.words=ReadFile(words);
}




public String selectRandomSecretWord() {
Random rand=new Random();
this.word=words[rand.nextInt(words.length)];
return this.word;
}




public String guess(Character c) throws Exception {
	
	if (win==true||loss==true) {
		return null;
	}
	else {
		if (checkBuggySecretWord(this.word)) {				//check the buggy secret word 
		throw new Exception();
}
	
	
		else if  (checkBuggyInput(c)==1){//Null character
			if(filled==false) {
		Characters=this.word.toCharArray();
		for(int i=0;i<Characters.length;i++) {
			Hidden.insert(i, '-');
		}
			}
			else {
				return HiddenWord;
			}
		filled=true;
		HiddenWord=Hidden.toString();
	}
	
	
	else if (checkBuggyInput(c)==2) {//Character is not alphabet
		throw new Exception("only alphabets are allowed");
	}
	
	
	
	else {
		int equalitiesCounter=0;//counter for how many characters are equal and if it is zero then no equalities and the guess is wrong
		Character ch;
		Characters=word.toCharArray();
		
		
		//this loop will fill the HiddenChars array with -
		for(int i=0;i<Characters.length;i++) {
			if(filled==false) 
			Hidden.insert(i,'-');
		}
		filled=true;
		for(int i=0;i<Characters.length;i++) {
			if((((ch=Characters[i]).toString().toUpperCase()).equals(c.toString().toUpperCase())==true)) {
				if ((ch=Hidden.charAt(i)).toString().toUpperCase().contentEquals(c.toString().toUpperCase())==false) {
				Hidden.setCharAt(i,Characters[i]);
				equalitiesCounter++;
				rightGuess++;
			}
			}
		}
		if(rightGuess==Characters.length) {
			win=true;
			return null;
		}
		if(equalitiesCounter==0&&win==false) {
			this.Wrong--;
			if(this.Wrong>0) {
				System.out.println("Number of Remaining Wrong Guesses is "+ Wrong);
			}
			else if (this.Wrong<=0) {
				System.out.println("Number of Remaining Wrong Guesses is "+ 0);
				loss=true;
				return null;
			}
		}
		HiddenWord=Hidden.toString();
	}
	
	return HiddenWord;
	}
}
public boolean checkBuggySecretWord(String word) { 	//check buggy secret words
	boolean Bug=false;
	 if (word==null){
		Bug=true;
	}
	 else if (word.isEmpty()) {
		 Bug=true;
	 }
	else {
		char[] Characters=word.toCharArray();
		if(Characters.length==1) {
			Bug=true;
		}
		else {
		for(int j=0;j<Characters.length;j++) {
			if (!(Characters[j]>=65&&Characters[j]<=90)&&!(Characters[j]>=97&&Characters[j]<=122)) {//check if the character is not a capital alphabet
				Bug=true;
				break;
			}
			}
		}
	}
	return Bug;
}
public int checkBuggyInput(Character x) {
	int Bug=0;
	if((x==null)) {
		Bug=1;
	}
	else if (!(x>=65&&x<=90)&&!(x>=97&&x<=122)) {
		Bug=2;
	}
	return Bug;
}
public void setMaxWrongGuesses(Integer max )  {
	if(max==null) {
		Wrong=1;
	}
	else if (max<0) {
		Wrong=1;
	}
	else {
		Wrong=max;
	}
}
}
