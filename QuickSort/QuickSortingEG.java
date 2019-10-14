/**
 *  Student Name: Artur Karolewski
 *  Student Number: 17388976
 *
 *    This program works as follows:
 *      - 1: The user is prompted to enter the size of an array
 *      - 2: The user is then prompted to manually enter each element in the array
 *      - 3: The original array is printed out to the screen
 *      - 4: The array is then sorted using the QuickSort method and QuickSort class
 *      - 5: The sorted array is printed out to the screen
 */

import java.util.*;

public class QuickSortingEG {

    public static void main(String args[]) {

        System.out.print("Enter the length of your array: ");
        int[] numsArray = fillArray();

        System.out.print("The original array: ");
        printArray(numsArray);

        QuickSort nums = new QuickSort();
        nums.sort(numsArray, 0, numsArray.length-1);

        System.out.print("Sorted array: ");
        printArray(numsArray);

    }

    public static int[] fillArray() {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] array = new int[n];

        for (int i = 0; i < array.length; i++) {

            System.out.print("Input element " + i + ": ");
            array[i] = scan.nextInt();
        }

        scan.close();
        return array;
    }

    public static void printArray(int[] array){

        System.out.print("{ ");

        for (int i = 0; i < array.length -1; i++) {

            System.out.print(array[i] + ", ");
        }

        System.out.println(array[array.length-1] + " }");
    }
}
