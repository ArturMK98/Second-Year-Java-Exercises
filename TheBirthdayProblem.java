/**
 * 	Student Name: Artur Karolewski
 * 	Student Number: 17388976
 * 	CS210: Lab 10
 * 
 * 		This program works as follows:
 * 			- 1: The user is prompted to enter a number of people in a class.
 * 			- 2: The program then calculates the probability that a pair of
 * 				 people in that class share the same birthday.
 * 			- 3: The result is then printed out to the screen.
 */


import java.util.*;

public class TheBirthdayProblem {
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of people in the class.");
		int numOfPeople = scan.nextInt();
		scan.close();
		
		double value = (1 - percent(numOfPeople)) * 100;
		
		System.out.printf("Probability of a pair of people sharing birthday in a class of %d: %.2f%%", numOfPeople, value);
	}
	
	public static double percent(int n) {
		
		if(n == 0) {
			
			
			return 1.0;
			
			
		} else if (n == 1) {
			
			return 1.0;
			
		} else {
			
			double value = (double) (366-n)/ (double) 365;
			return (value * percent(n-1));
		}
	}

}
