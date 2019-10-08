/**
 * 	Student Name: Artur Karolewski
 *  Student Number: 17388976
 *  
 *  	This program works as follows:
 *  		- 1: The program prompts the user to enter the amount of rolls, number of dice and
 *  			 the number of faces on the dice.
 *  		- 2: The program then calculates the number of times that each number on the dice occurred
 *  			 and the the % of time that each number occurred.
 *  		- 3: The information if then printed out to the screen.
 */

import java.util.*;

public class DiceRoll {
	
	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
        int rolls;
        int sides;
        int dice;
        
        
        System.out.println("Enter the number of rolls: ");
        rolls = scan.nextInt();
        
        System.out.println("Enter the number of dice: ");
        dice = scan.nextInt();
        
        System.out.println("Enter the number of sides on the dice: ");
        sides = scan.nextInt();
        scan.close();
        
        int[] num = new int[(dice*sides) - (dice-1)];
        
        System.out.printf("%-5s %9s %7s %n", "#","Count", "Freq %");         
        
        for (int len = 1; len <= rolls; len++){
        	
            int total = 0;
            for (int i = 1; i <= dice; i++){
            	
                total += (int) (Math.random()*(sides) + 1);
            }
            
            num[total-dice]++;  
        }
        
        for (int i = 0; i <= (dice*sides-dice); i++){
        	
            System.out.printf("%-5d %9d %6.2f%s %n", i + dice, num[i], (num[i]*1.0/rolls)*100, "%");
        }
        
        System.out.printf("%-5s %9d %6s %n", "Total", rolls, "100%");       
    }
}