/**
 * 	This program works as follows:
 * 		- 1: The program prompts the user to enter a credit card number.
 * 		- 2: When the user enters a card number the Card.java class uses
 * 			 the Luhn algorithm to determine if the credit card number entered
 * 			 is valid or invalid.
 * 		- 3: If the card is valid "VALID" is printed out to the screen, if not,
 * 			 "INVALID" is printed out to the screen.
 * 		- 4: Works for any 16 digit credit card number.
 */


import java.util.*;

public class Luhn {
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter a credit card number to check if it is VALID or INVALID");
		Card c1 = new Card (scan.nextLine());
		scan.close();
		
		System.out.println(c1.isValid());		
	}
}
