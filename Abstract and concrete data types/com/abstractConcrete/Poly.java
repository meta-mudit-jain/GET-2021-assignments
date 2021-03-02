package com.abstractConcrete;

import java.util.Scanner;
/**
 *Implement the immutable class Poly using an array to represent single variable polynomial. Note that you should be storing only those terms of polynomial that have non zero coefficient. You can assume that the coefficients are integers
 * It should support methods like -
 * evaluate(float) - return the value of the polynomial for the given value of the variable
 * degree() - return the degree of the polynomial
 * addPoly(Poly p1, Poly p2) - return the sum of the polynomials p1 and p2
 * multiplyPoly(Poly p1, Poly p2) - return the product of polynomials p1 and p2
 * You may use private helper methods. addPoly() and multiplyPoly() can make assumptions about size of the resulting polynomial to decide about the size of the array to be created.
 *
 */

/**
 * Single Variable polynomial
 * Immutable Poly Class
 * A class is immutable when class is final all members are private final
 * Initialize all fields using constructor
 * Don't use setters only use getters
 * @author  Mudit Jain
 */
public final class Poly {
    static Scanner scan=new Scanner(System.in);

    /**
     * Function to add two polynomials
     * @param poly1 is of type array that contains coefficient of polynomial
     * @param poly2 is of type array that contains coefficient of polynomial
     * @return sum the sum of two polynomial
     */
    private static int[] addPoly(int[] poly1,int[] poly2){
        System.out.println("First Polynomial is:");
        printPoly(poly1, poly1.length);
        System.out.println("Second Polynomial is:");
        printPoly(poly2, poly2.length);
        int size=max(poly1.length, poly2.length);
        int sum[]=new int[size];
        for (int i = 0; i < poly1.length; i++) {
            sum[i]=poly1[i];
        }
        for (int i = 0; i < poly2.length; i++) {
            sum[i]+=poly2[i];
        }
        return sum;
    }

    /**
     * Function to multiply two polynomial expression
     * @param poly1 is of type array that contains coefficient of polynomial 1
     * @param poly2 is of type array that contains coefficient of polynomial 2
     * @return mul multiplication of two arrays
     */
    private static int[] multiplyPoly(int[] poly1,int[] poly2){
        System.out.println("First polynomial expression is =");
        printPoly(poly1, poly1.length);
        System.out.println("Second polynomial expression is =");
        printPoly(poly2, poly2.length);
        int[] mul=new int[poly1.length+poly2.length-1];
        for (int i = 0; i < poly1.length+poly2.length-1; i++) {
            mul[i]=0;
        }
        for (int i = 0; i < poly1.length; i++) {
            for (int j = 0; j < poly2.length; j++) {
                mul[i+j]+=poly1[i]*poly2[j];
            }
        }
        return mul;
    }

    /**
     * Function to find maximum of two numbers
     * @param x a integer
     * @param y second integer
     * @return x if x>y else y
     */
    private static int max(int x, int y){
        return (x>y)? x :y ;
    }

    /**
     *Function to display a polynomial
     * @param arrPoly is of type array that contains coefficient of polynomial
     * @param n is the degree of polynomial+1 or size of array
     */
    private static void printPoly(int arrPoly[],int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arrPoly[i]);
            if (i!=0) {
                System.out.print("x^"+i);
            }
            if(i!=n-1){
                System.out.print(" + ");
            }
        }
        System.out.println();
    }

    /**
     * Function to find degree of polynomial
     * @param arr is of type array that contains coefficient of polynomial
     * @return degree of polynomial
     */

    private static int find_degree(int[] arr){
        printPoly(arr, arr.length);
        return (arr.length-1);
    }

    /**
     * Function to evaluate Polynomial through a user input
     * @param poly is of type array that contains coefficient of polynomial
     * @param num is the user input
     * @return result the evaluation
     */
    private static float evaluate(int[] poly,float num){
        float result=0;
        for (int i = 0; i < poly.length; i++) {
            result+=(poly[i])*(Math.pow(num, i));
        }
        return result;
    }

    /**
     * Function which displays menu and perform input operations
     * @param arr s of type array that contains coefficient of polynomial
     */
    private static void menuPoly(int[] arr){
        System.out.println("Enter 1 to evaluate the value of Polynomial expression\n"
                + "Enter 2 to find degree of polynomial expression\n"
                + "Enter 3 to add two polynomial expressions\n"
                + "Enter 4 to multiply 2 polynomial expressions\n"
                + "Enter 5 to exit");
        int input=scan.nextInt();
        switch (input) {
            case 1:
                System.out.println("Enter the number, which you want to put in polynomial expression = ");
                float num=scan.nextFloat();
                float result = evaluate(arr,num);
                printPoly(arr, arr.length);
                System.out.println("The value of polynomial is = "+result);
                break;
            case 2:
                int degree = find_degree(arr);
                System.out.println("Degree of the polynomial is = "+degree);
                break;
            case 3:
                System.out.println("Enter total number of integers in 1st polynomial = ");
                int n1=scan.nextInt();
                int[] poly1=new int[n1];
                System.out.println("Enter integers = ");
                for (int i = 0; i < n1; i++) {
                    poly1[i]=scan.nextInt();
                }
                System.out.println("Enter total number of integers in 2nd polynomial = ");
                int n2=scan.nextInt();
                int[] poly2=new int[n2];
                System.out.println("Enter integers = ");
                for (int i = 0; i < n2; i++) {
                    poly2[i]=scan.nextInt();
                }
                int[] sum=addPoly(poly1,poly2);
                System.out.println("Sum of polynomials is =");
                printPoly(sum, sum.length);
                break;
            case 4:
                System.out.println("Enter total number of integers in 1st polynomial = ");
                int x=scan.nextInt();
                int[] exp1=new int[x];
                System.out.println("Enter integers = ");
                for (int i = 0; i < x; i++) {
                    exp1[i]=scan.nextInt();
                }
                System.out.println("Enter total number of integers in 2nd polynomial = ");
                int y=scan.nextInt();
                int[] exp2=new int[y];
                System.out.println("Enter integers = ");
                for (int i = 0; i < y; i++) {
                    exp2[i]=scan.nextInt();
                }
                int[] multiplication = multiplyPoly(exp1,exp2);
                System.out.println("Multiplication of polynomials is = ");
                printPoly(multiplication, multiplication.length);
                break;
            case 5:
                System.out.println("Thanks to use polynomial operations.");
                return;
            default:
                System.out.println("Wrong input, try again.");
                break;
        }

    }

    /**
     * Main method
     * @param args take command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter number of integers in polynomial = ");
        int n=scan.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter integers = ");
        for (int i = 0; i < n; i++) {
            arr[i]=scan.nextInt();
        }
        menuPoly(arr);
        scan.close();
    }
}
