import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.Generated;

//Designed by Brendan Davy
//
//Creates a random password by asking for number of characters, type of characters, and my own format, palindrome.

public class PasswordGenerator {
	public static void main(String[] Args){
		//introduction
		//ask about password parameters
			//length
				int length = getLength();
				//odd/even length check
			//types of characters used (numbers, caps, specials)
				//boolean upperCase = askUpperCase();
				//boolean numbers = askNumbers();
				//boolean specials = askSpecials();
				//make sure at least one type is used
			//palindrome usage?
				//boolean palindrome = askPalindrome();
				//if yes, stick specials at the end?
				//boolean stickAtEnd = false;
				//if (palindrome && specials){
					//stickAtEnd = askAtEnd();
				//}
					//if yes, how many to put on at end?
				//int addAtEnd = 0;
				//if (stickAtEnd){
					//addAtEnd = askNumberForEnd();
				//}
		//create password
			char[] password = new char[length /*+ addAtEnd*/];
			/*if (palindrome && !stickAtEnd){
				//make array password.length-add / 2 filled, then mirror
			}else if (palindrome){
				//make array length-add / 2 filled, then mirror and add specials at end
			}else{
				*///easist. make array then random, depending on chars used
				generatePassword(password/*, upperCase, numbers, specials*/);
			//}
			
		//display password
			System.out.print(password);
			//write to file?
		//again?
		//exit
	}
	
	public static int getLength(){
		System.out.print("How many characters long would you like the password to be? ");
		Scanner console = new Scanner (System.in);
		try{
			int length = console.nextInt();
			console.close();
			return length;
		}
		catch(InputMismatchException exception){
			System.out.print("That's not a number. Please enter your desired length using numerals. ");
			
			return getLength();
		}
	}
	
	/* public static boolean askUpperCase() throws NoSuchElementException{
		System.out.print("Would you like this password to contain upper-case characters? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		console.close();
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			return askUpperCase();
		}
	}
	
	public static boolean askNumbers() throws NoSuchElementException{
		System.out.print("Would you like this password to contain numbers? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		console.close();
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			return askNumbers();
		}
	}
	
	public static boolean askSpecials() throws NoSuchElementException{
		System.out.print("Would you like this password to special characters? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		console.close();
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			return askSpecials();
		}
	}
	
	public static boolean askPalindrome() throws NoSuchElementException{
		System.out.print("Would you like this password to contain upper-case characters? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		console.close();
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			return askPalindrome();
		}
	}
	
	public static boolean askAtEnd() throws NoSuchElementException{
		System.out.print("Would you like the special characters to be placed at the end of the palindrome? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		console.close();
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			return askAtEnd();
		}
	}
	
	public static int askNumberForEnd() throws NoSuchElementException{
		System.out.print("How many special characters would you like added to the end? ");
		Scanner console = new Scanner (System.in);
		try{
			int length = console.nextInt();
			console.close();
			return length;
		}
		catch(InputMismatchException exception){
			System.out.print("That's not a number. Please enter your number using numerals. ");
			
			return askNumberForEnd();
		}
	} */
	
	public static void generatePassword(char[] password/*, boolean upperCase, boolean numbers, boolean specials*/){
		//if (upperCase && numbers && specials){
			for (int i = 0; i < password.length; i++){
				SecureRandom rand = new SecureRandom();
				char placement = (char) (rand.nextInt(94) + 33);
				password[i] = placement;
			}
		//}
	}
}