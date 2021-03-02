package com.tp;

import java.util.Arrays;
import java.util.Scanner;

public class RecursionProb {
    static Scanner sc = new Scanner(System.in);
    public static int N;

    private static boolean isSafe(int mat[][], int r, int c) {
        // return false if two queens share the same column
        for (int i = 0; i < r; i++) {
            if (mat[i][c] == 1) {
                return false;
            }
        }

        // return false if two queens share the same `` diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 1) {
                return false;
            }
        }

        // return false if two queens share the same `/` diagonal
        for (int i = r, j = c; i >= 0 && j < N; i--, j++) {
            if (mat[i][j] ==1) {
                return false;
            }
        }

        return true;
    }

    private static void printSolution(int mat[][]) {
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();

        }
    }

    private static void nQueen(int mat[][], int r) {
        // if `N` queens are placed successfully, print the solution
        if (r == N) {
            printSolution(mat);
            System.out.println();
            return;
        }

        // place queen at every square in the current row `r`
        // and recur for each valid movement
        for (int i = 0; i < N; i++) {
            // if no two queens threaten each other
            if (isSafe(mat, r, i)) {
                // place queen on the current square
                mat[r][i] = 1;

                // recur for the next row
                nQueen(mat, r + 1);

                // backtrack and remove the queen from the current square
                mat[r][i] = 0;
            }
        }
    }
    private static void nQueenMatrixInitialiser(int mat[][],int n){
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                mat[i][j]=0;
            }
        }
        nQueen(mat,0);
    }

    /**
     * GCD which is basically hcf of two numbers
     * @param a is the first number
     * @param b is the second number
     * @return gcd or hcf of two numbers
     */
    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    /**
     * lcm function finds the least common factor of two numbers recursively
     * @param a is the first number
     * @param b is the second number
     * @return the lcm of two numbers
     */
    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    /**
     *Binary search works on divide and conquer algorithm
     * @param arr is the array in which search is to performed
     * @param l is the left index initially 0
     * @param r is the right index initially length -1
     * @param x is the number to be fond out
     * @return the index at which x is present or -1 if not found
     */
    private static int binarySearch(int arr[], int l, int r, int x) {
        //Restrict the boundary of right index
        // and the left index to prevent
        // overflow of indices.
        if (r >= l && l < arr.length - 1) {

            int mid = l + (r - l) / 2;

            // If the element is present
            // at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
    /**
     *Linear Search function compare each element with the number to be found out
     * @param arr is the array in which search is to performed
     * @param l is the left index initially 0
     * @param r is the right index initially length -1
     * @param x is the number to be fond out
     * @return the index at which x is present or -1 if not found
     */
    private static int linearSearch(int arr[], int l, int r, int x) {
        if (r < l)
            return -1;
        if (arr[l] == x)
            return l;
        if (arr[r] == x)
            return r;
        return linearSearch(arr, l + 1, r - 1, x);
    }

    /**
     * Helper function for Linear search and Binary Search
     * @param choice is to check which type of search need to be performed
     *
     */
    static void helperFunctionForSearch(int choice){
        int size,no,index;
        System.out.println("Enter the size of array");
        size=sc.nextInt();
        System.out.println("Enter the elements of array");
        int arr[]= new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter the number to be searched");
        no=sc.nextInt();
        if(choice ==1){
            index =linearSearch(arr,0,size-1,no);
        }
        else {
            index= binarySearch(arr,0,size-1,no);
        }
        if(index==-1)
            System.out.println("Not found");
        else
            System.out.println("Index is "+ index);
    }

    /**
     * Helper function for LCM and HCF
     * @param choice is to check what we need to find
     */
    static void helperFunctionForLCMAndHCF(int choice){
        int no1,no2,lcmResult,hcfResult=0;
        System.out.println("Enter No 1");
        no1 =sc.nextInt();
        System.out.println("Enter No 2");
        no2 =sc.nextInt();
        if(choice ==1){
            lcmResult=lcm(no1,no2);
            System.out.println("LCM result is"+lcmResult);
        }
        else
            hcfResult=gcd(no1,no2);
        System.out.println("HCF result is"+hcfResult);

    }

    public static void main(String[] args) {
        int choice;
        int exitCode=1;

        do {
            RecursionProb obj = new RecursionProb();
            System.out.println("enter your choice");
            System.out.println("1. Linear Search\n2. Binary Search\n3.LCM of two numbers\n4. HCF of two numbers\n5." +
                    "NqueenProblem\n6.Knights tour problem");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    helperFunctionForSearch(choice);
                    break;
                case 2:
                    helperFunctionForSearch(choice);
                    break;
                case 3:
                    helperFunctionForLCMAndHCF(choice);
                    break;
                case 4:
                    helperFunctionForLCMAndHCF(choice);
                    break;
                case 5: {
                    System.out.println("Enter the no size of board");
                    N = sc.nextInt();
                    int mat[][]=new int[N][N];
                    nQueenMatrixInitialiser(mat,N);
                    break;
                }
                default: System.out.println("Invalid choice entered");

            }
            System.out.println("Do you want to continue Press\n 1. yes \n 2. no");
            exitCode=sc.nextInt();
        }while(exitCode==1);

    }
}
