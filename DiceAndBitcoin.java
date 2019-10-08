/**
 * 	Student Name: Artur Karolewski
 * 	Student Number: 17388976
 *  Lab 11: Dice and BitCoin
 *  
 *  	This program works as follows:
 *  		- 1: The program prompts the user to enter the number of times they wish to 
 *  			 roll a dice.
 *  		- 2: The program then calculates the amount of times 6 comes up on the dice
 *  			 in the amount of rolls specified, the % of times 6 has showed up, and
 *  			 how many BitCoins have been mined (taking that 1 BitCoin is mined every
 *  			 10 minutes or 200 rolls).
 *  		- 3: The results are then printed out to the screen.
 */

import java.util.*;

public class DiceAndBitcoin {
	
	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
        int rolls;
        int sides = 6;
        int sec = 3;
        int bitCoin = 600;
        int bitCoinsMined = 0;
        int total = 0;
        
        
        System.out.println("Enter the number of rolls: ");
        rolls = scan.nextInt();
        scan.close();
        
        for (int j = 0; j <= rolls; j++) {
        	
        	if ((int) (Math.random()*(sides) + 1) == 6){
        		
        		total++;       		
        	}
                
                if(bitCoin == 0) {
                	
                	bitCoinsMined++;
                	bitCoin = 600;
                }
                
                bitCoin -= sec;  
         }
        
        System.out.println("After " + rolls + " rolls:");
        System.out.println("The number 6 occured " + total + " times with " + (total*1.0/rolls)*100 + "% occurance.");
        System.out.println(bitCoinsMined + " bitcoins have been mined."); 
    }
}
