/**
 *  Student Name: Artur Karolewski
 *  Student Number: 17388976
 *
 *    This program works as follows:
 *      - 1: The program prompts the user to enter the number of digits they want in a hex String
 *      - 2: The program prints out a random hex String with the number of digits the user specified
 */

import java.util.*;

public class RandomHex {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter how many digits you want in your hex String");
        int numOfDigits = scan.nextInt();
        scan.close();

        Random r = new Random();
        StringBuffer sb = new StringBuffer();

        while(sb.length() < numOfDigits){
            
            sb.append(Integer.toHexString(r.nextInt()));
        }

        System.out.println("Random hex: " + sb.toString().substring(0, numOfDigits));
    }
}