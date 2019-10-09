/**
 *  Student Name: Artur Karolewski
 *  Student Number: 17388976
 *  Lab 0: Vertcoin Wallet
 *
 *    This program works as follows:
 *      - 1: A random 64 digit hexadecimal number is generated
 *      - 2: 80 is added to the front of the randomly generated hex
 *      - 3: The SHA-256 of the hex with 80 in front is generated
 *      - 4: The first 8 digits of the SHA-256 are taken and added
 *           to the end of the hex number with 80 in the beginning
 *      - 5: A base 58 encoding of the hex number with 80 in the beginning
 *           and the first 8 digits of the SHA-256 hash in the end is generated
 *      - 6: All the steps from the random 64 digit hex to the base 58 encoding
 *           are printed out to the screen
 */

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class RandomKey {
    public static void main(String args[]) {

        String myHex = randomHex64();
        System.out.println("Random hex: " + myHex + "\n");
        String s80 = "80" + myHex;
        System.out.println("80 String: " + s80 + "\n");

        try {

            String shaS80 = sha256(s80);
            System.out.println("SHA256 80 String: " + shaS80 + "\n");
            String sshaS80 = sha256(shaS80);
            System.out.println("Second SHA256 80 String: " + sshaS80 + "\n");
            String first8 = s80 + sshaS80.substring(0, 8);
            System.out.println("New 80 String: " + first8 + "\n");
            byte[] n8s = hexStringToByteArray(first8);
            String b58 = encode(n8s);
            System.out.println("Base58: " + b58 + "\n");

        } catch (NoSuchAlgorithmException e){}
    }

    static String randomHex64(){

        int numOfDigits = 64;
        Random r = new Random();
        StringBuffer sb = new StringBuffer();

        while(sb.length() < numOfDigits){
            
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numOfDigits);
    }

    static String sha256(String input) throws NoSuchAlgorithmException {

        byte[] in = hexStringToByteArray(input);
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(in);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < result.length; i++) {

            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public static byte[] hexStringToByteArray(String s) {

        int len = s.length();
        byte[] data = new byte[len / 2];

        for (int i = 0; i < len ; i += 2) {

            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }

        return data;
    }

    public static String encode(byte[] input) { 

        BigInteger BASE = BigInteger.valueOf(58); 
        String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
        BigInteger bi = new BigInteger(1, input); 
        StringBuffer s = new StringBuffer(); 

        while (bi.compareTo(BASE) >= 0) {

            BigInteger mod = bi.mod(BASE); 
            s.insert(0, ALPHABET.charAt(mod.intValue())); 
            bi = bi.subtract(mod).divide(BASE); 
        } 

        s.insert(0, ALPHABET.charAt(bi.intValue())); 

        for (byte anInput : input) { 

            if (anInput == 0) {

                s.insert(0, ALPHABET.charAt(0));

            } else {

                break; 
            }
        } 
        
        return s.toString(); 
    } 
}
