/**
 * 	Student Name: Artur Karolewski
 * 	Student Number: 17388976
 *  CS210: Lab 10
 *  
 *  	This program works as follows:
 *  		- 1: The user is prompted to enter the amount of years the want to keep their money
 *  			 in the bank for.
 *  		- 2: The user is then prompted to enter the % interest they will receive.
 *  		- 3: The user is then prompted to enter their balance.
 *  		- 4: The new balance after interest is added is then printed out to the screen.
 */

import java.util.*;

public class CompoundInterest {
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the amount of years you wish to keep your money in the bank for.");	
		int years = scan.nextInt();
		
		System.out.println("Enter the % interest.");
		double percent = scan.nextDouble();
		
		System.out.println("Enter your balance.");;
		double bal = scan.nextDouble();
		scan.close();
		
		System.out.println("After " + years + " years and at the rate of " + percent + "%, your balance will be �"
						   + Math.round(getInterest(years, percent, bal)* 100.0)/100.0);
	}
	
	public static double getInterest(int years, double percent, double bal) {
		
		if (years == 0) {
			
			return bal;
		}
		
		double interest = bal * percent/100;
		return getInterest(years-1, percent, bal + interest);
	}
}
