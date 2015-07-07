import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

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
			//types of characters used (numbers, caps, specials)
				boolean upperCase = askUpperCase();
				boolean numbers = askNumbers();
				boolean specials = askSpecials();
				//make sure at least one type is used
			//palindrome usage?
				boolean palindrome = askPalindrome();
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
			//if (palindrome && stickAtEnd){
				//
			//}else{
				generatePassword(password, palindrome, specials, upperCase, numbers);
			//}
			
		//display password
			System.out.print(password);
			//write to file?
		//again?
		//exit
	}
	
	public static int getLength(){
		System.out.println("How many characters long would you like the password to be? ");
		Scanner console = new Scanner (System.in);
		try{
			int length = console.nextInt();
			return length;
		}
		catch(InputMismatchException exception){
			System.out.print("That's not a number. Please enter your desired length using numerals. ");
			System.out.println();
			return getLength();
		}
	}
	
	public static boolean askUpperCase() throws NoSuchElementException{
		System.out.println("Would you like this password to contain upper-case characters? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			System.out.println();
			return askUpperCase();
		}
	}
	
	public static boolean askNumbers() throws NoSuchElementException{
		System.out.println("Would you like this password to contain numbers? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			System.out.println();
			return askNumbers();
		}
	}
	
	public static boolean askSpecials() throws NoSuchElementException{
		System.out.println("Would you like this password to special characters? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			System.out.println();
			return askSpecials();
		}
	}
	
	public static boolean askPalindrome(){
		System.out.println("Would you like this password use a palindrome format? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			System.out.println();
			return askPalindrome();
		}
	}
	
	/*public static boolean askAtEnd() throws NoSuchElementException{
		System.out.println("Would you like the special characters to be placed at the end of the palindrome? (Y/N) ");
		Scanner console = new Scanner (System.in);
		char answer = Character.toUpperCase(console.next().charAt(0));
		
		if (answer == 'Y'){
			return true;
		} else if (answer =='N'){
			return false;
		}else{
			System.out.print("Nice try. Please give a valid answer (Y or N)");
			System.out.println();
			return askAtEnd();
		}
	} */
	
	/*public static int askNumberForEnd() throws NoSuchElementException{
		System.out.println("How many special characters would you like added to the end? ");
		Scanner console = new Scanner (System.in);
		try{
			int length = console.nextInt();
			return length;
		}
		catch(InputMismatchException exception){
			System.out.print("That's not a number. Please enter your number using numerals. ");
			System.out.println();
			return askNumberForEnd();
		}
	} */

	public static void generatePassword(char[] password, boolean palindrome, boolean specials, boolean upperCase, boolean numbers){
		SecureRandom rand = new SecureRandom();
		if (palindrome){
			int length = password.length;
			Stack<Character> otherHalf = new Stack<Character>();
			int i = 0;
			while (i < length / 2){
				char placement = (char) randomSequence(specials, upperCase, numbers);
				password[i] = placement;
				otherHalf.push(placement);
				i++;
			}
			if (length % 2 == 1){
				otherHalf.push((char) randomSequence(specials, upperCase, numbers));
			}
			while (!otherHalf.isEmpty()){
				password[i] = (char) otherHalf.pop();
				i++;
			}
		}else{
			for (int i = 0; i < password.length; i++){
				char placement = (char) randomSequence(specials, upperCase, numbers);
				password[i] = placement;
			}
		}
	}
	
	public static int randomSequence(boolean specials, boolean upperCase, boolean numbers){
		SecureRandom rand = new SecureRandom();
		int placement = (rand.nextInt(94) + 33);
		if (!specials){
			if (placement >= 33 && placement <= 47 || placement >=58 && placement <= 64 || placement >= 91 && placement <= 96 || placement >= 123 && placement <= 126){
				return randomSequence(specials, upperCase, numbers);
			}
		}
		if (!upperCase){
			if (placement >= 65 && placement <= 90){
				return randomSequence(specials, upperCase, numbers);
			}
		}
		if (!numbers){
			if (placement >= 48 && placement <= 57){
				return randomSequence(specials, upperCase, numbers);
			}
		}
		return placement;
	}
}