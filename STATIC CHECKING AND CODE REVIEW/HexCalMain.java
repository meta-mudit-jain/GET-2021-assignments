package com.Specifications;
/**
 * @author Mudit Jain
 */

import java.util.Scanner;

/* Design a class HexCalc that supports following methods for hexadecimal arithmetic.
   You can assume that this class will be working with only positive integers.

    Methods to add, subtract, multiply and divide two hexadecimal numbers.
    Each of the methods will receive hexadecimal numbers as strings, and will return the computed value as hexadecimal string.
    The strategy that can be followed by each of the methods is to convert the strings into numbers, perform the computation, and reconvert the result back into hexadecimal representation.
    Methods to compare two hexadecimal numbers for ==, > and <.
    Each of these methods will return a boolean value.
    Implement these methods without converting the arguments to decimal numbers for comparison.
    Return the decimal representation of hexadecimal number.
    Return the hexadecimal representation of decimal number.
*/
class HexCal {

    public int convertIntoDecimal(String s){
        int convertedNum=Integer.parseInt(s,16);
        return convertedNum;
    }
    public String convertIntoHexadecimal(int i){
        return Integer.toHexString(i).toUpperCase();

    }
    public String addHex(String s1,String s2 ){
        int sumResult = convertIntoDecimal(s1)+convertIntoDecimal(s2);
        String hex = Integer.toHexString(sumResult).toUpperCase();
        return hex;
    }
    public String subtractHex(String s1,String s2 ){
        int num1 = convertIntoDecimal(s1);
        int num2 = convertIntoDecimal(s2);
        if(num1>num2)
            return Integer.toHexString(num1-num2).toUpperCase();
        else
            return Integer.toHexString(num2-num1).toUpperCase();
    }
    public String multiplyHex(String s1,String s2 ){
        int mulResult = convertIntoDecimal(s1)*convertIntoDecimal(s2);
        String hex = Integer.toHexString(mulResult).toUpperCase();
        return hex;
    }
    public String divideHex(String s1,String s2 ){
        int divResult = convertIntoDecimal(s1)/convertIntoDecimal(s2);
        String hex = Integer.toHexString(divResult).toUpperCase();
        return hex;
    }
    public boolean isEqual(String s1,String s2){
        return  s1.compareToIgnoreCase(s2)==0?true:false ;
    }
    public boolean isGreater(String s1,String s2){
        return  s1.compareToIgnoreCase(s2)>0?true:false ;
    }
    public boolean isSmaller(String s1,String s2){
        return  s1.compareToIgnoreCase(s2)<0?true:false ;
    }

}
public class HexCalMain {
    public static void main(String[] args) {
        HexCal obj = new HexCal();
        int exitCode;
        do{
        System.out.println("WELCOME TO HEXADECIMAL CALCULATOR\n");
        System.out.println("PRESS 1 TO CONVERT A DECIMAL INTO HEXADECIMAL");
        System.out.println("PRESS 2 TO CONVERT A HEXADECIMAL NUMBER INTO DECIMAL");
        System.out.println("PRESS 3 TO ADD TWO HEXADECIMAL NUMBERS");
        System.out.println("PRESS 4 TO SUBTRACT TWO HEXADECIMAL NUMBERS");
        System.out.println("PRESS 5 TO MULTIPLY TWO HEXADECIMAL NUMBERS");
        System.out.println("PRESS 6 TO DIVIDE TWO HEXADECIMAL NUMBERS");
        System.out.println("PRESS 7 TO CHECK IF TWO HEXADECIMAL NUMBERS ARE EQUAL");
        System.out.println("PRESS 8 TO CHECK IF HEXADECIMAL NUMBER 1 IS BIGGER THAN 2");
        System.out.println("PRESS 9 TO CHECK IF HEXADECIMAL NUMBER 1 IS SMALLER THAN 2");
        Scanner sc =new Scanner(System.in);
        int choice =sc.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("Enter the No");
                int num = sc.nextInt();
                System.out.println(obj.convertIntoHexadecimal(num));
            }
            case 2 -> {
                System.out.println("Enter the No");
                String hexNum = sc.next();
                System.out.println(obj.convertIntoDecimal(hexNum));
            }
            case 3 -> {
                System.out.println("Enter number 1");
                String hexNum1 = sc.next();
                System.out.println("Enter number 2");
                String hexNum2 = sc.next();

                System.out.println(obj.addHex(hexNum1, hexNum2));
            }
            case 4 -> {
                System.out.println("Enter number 1");
                String hexNum1 = sc.next();
                System.out.println("Enter number 2");
                String hexNum2 = sc.next();
                System.out.println(obj.subtractHex(hexNum1, hexNum2));
            }
            case 5 -> {
                System.out.println("Enter number 1");
                String hexNum1 = sc.next();
                System.out.println("Enter number 2");
                String hexNum2 = sc.next();
                System.out.println(obj.multiplyHex(hexNum1, hexNum2));
            }
            case 6 -> {
                System.out.println("Enter number 1");
                String hexNum1 = sc.next();
                System.out.println("Enter number 2");
                String hexNum2 = sc.next();
                System.out.println(obj.divideHex(hexNum1, hexNum2));
            }
            case 7 -> {
                System.out.println("Enter number 1");
                String hexNum1 = sc.next();
                System.out.println("Enter number 2");
                String hexNum2 = sc.next();
                System.out.println(obj.isEqual(hexNum1, hexNum2));
            }
            case 8 -> {
                System.out.println("Enter number 1");
                String hexNum1 = sc.next();
                System.out.println("Enter number 2");
                String hexNum2 = sc.next();
                System.out.println(obj.isGreater(hexNum1, hexNum2));
            }
            case 9 -> {
                System.out.println("Enter number 1");
                String hexNum1 = sc.next();
                System.out.println("Enter number 2");
                String hexNum2 = sc.next();
                System.out.println(obj.isSmaller(hexNum1, hexNum2));
            }
            default -> {
                throw new IllegalArgumentException("Unexpected value: " + choice);
            }
        }
        System.out.println("Do you want to continue?1.Yes 2.No");
        exitCode=sc.nextInt();
    }while(exitCode==1);

    }
}
