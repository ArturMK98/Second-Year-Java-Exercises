/**
 *  Student Name: Artur Karolewski
 *  Student Number: 17388976
 *  Lab 1: Huffman Part 1
 *
 *    This program works as follows:
 *      - 1: The user is prompted to enter a String
 *      - 2: Binary representation of that String is printed out to the screen
 *      - 3: The number of times each character appeared is printed out to the screen
 */

import java.util.*;

public class HuffmanP1 {

    public static void main(String args[]) {
        
        Scanner scan = new Scanner(System.in);

        // Array which will keep track of how many times each letter occurs
        int[] ASCIIarray = new int[256];
        System.out.print("Enter a sentence: ");
        String sentence = scan.nextLine();

        scan.close();

        for (int i = 0; i < sentence.length(); i++) {

            // Go to the next line when 7 binary char representations are on current line
            if (i % 7 == 0) {

                System.out.println();
            }

            // Increment the value of ASCIIarray at index equal to the int value of the char
            ASCIIarray[(int) sentence.charAt(i)]++;

            // If length is less than 7 then binary number is missing leading zeros
            if (Integer.toBinaryString((int) sentence.charAt(i)).length() < 7) {

                for (int j = Integer.toBinaryString((int) sentence.charAt(i)).length(); j < 7; j++) {

                    System.out.print("0");
                }
            }

            // Casts the current char to an int and then converts that int to a binary String
            System.out.print(Integer.toBinaryString((int) sentence.charAt(i)) + " ");
        }

        System.out.println("\n");

        for (int i = 0; i < ASCIIarray.length; i++) {

            if (ASCIIarray[i] > 0) {

                // If appeared once then print 'time' not 'times'
                if (ASCIIarray[i] < 2) {

                    System.out.println("'" + (char) i + "'" + " appeared " + ASCIIarray[i] + " time");

                } else {

                    System.out.println("'" + (char) i + "'" + " appeared " + ASCIIarray[i] + " times");
                }
            }
        }
    }
}