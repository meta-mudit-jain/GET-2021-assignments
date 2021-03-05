package com.SparseMatrix;

import java.util.Scanner;
// sparse matrix java class
public final class SparseMtrx {
    private final int max = 100;
    private final int arr[][] = new int[max][3];
    private finalint row, col;
    private int length;
    static Scanner scan = new Scanner(System.in);

    /**
     * Main Function
     * @param args takes command line arguments
     */
    public static void main(String args[]) {
        SparseMtrx s1 = inputSparseMtrx();
        operations(s1);
        scan.close();
    }
    /**
     * sparse matrix constructor
     * @param c is col
     * @param r is row
     */
    private SparseMtrx(int r, int c) {
        row = r;
        col = c;
        length = 0;
    }

    /**
     * Insert Elements in sparse matrix space efficiently
     * @param r is row no
     * @param c is column no
     * @param val is the value to be inserted at r,c
     */
    private void insert(int r, int c, int val) {
        arr[length][0] = r;
        arr[length][1] = c;
        arr[length][2] = val;
        length++;
    }

    /**
     * Function to print the the spare matrix
     * format row col value
     */
    private void print() {
        System.out.println("Sparse Matrix: "+row+"x"+col+"\nRow Col Value");
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i][0] + "  " + arr[i][1] + "  " + arr[i][2]);
        }
    }

    /**
     * Function to check if sparse matrix is Symmetric
     * We wil find transpose of matrix and compare each value
     * @param s1 is object of matrix
     * @return boolean value true if symmetric else false
     */
    private static boolean isSymmetric(SparseMtrx s1){
        if(s1.row!=s1.col){
            return false;
        }
        else{
            SparseMtrx transpose = s1.transpose();
            int i = 0;
            while(i<s1.length){
                if(s1.arr[i][0]==transpose.arr[i][0]
                        && s1.arr[i][1]==transpose.arr[i][1]
                        && s1.arr[i][2]==transpose.arr[i][2]){
                    if(i==s1.length-1){
                        return true;
                    }
                    i++;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Function to add two sparse matrices
     * @param obj is the object of SparseMatrix
     */
    private void addSparse(SparseMtrx obj) {
        int i = 0, j = 0,sum;
        if (row != obj.row || col != obj.col) {
                System.out.println("Matrices can't be added");
        }
        else {
            SparseMtrx output = new SparseMtrx(row, col);
            while (i < length && j < obj.length) {
                if ((arr[i][0] > obj.arr[j][0])
                        || (arr[i][0] == obj.arr[j][0] && arr[i][1] > obj.arr[j][1])) {
                    output.insert(obj.arr[j][0], obj.arr[j][1], obj.arr[j][2]);
                    j++;
                }
                else if (arr[i][0] < obj.arr[j][0]
                        || (arr[i][0] == obj.arr[j][0] && arr[i][1] < obj.arr[j][1])) {
                    output.insert(arr[i][0], arr[i][1], arr[i][2]);
                    i++;
                }
                else {
                    sum = arr[i][2] + obj.arr[j][2];
                    if (sum != 0)
                        output.insert(arr[i][0], arr[i][1], sum);
                    i++;
                    j++;
                }
            }
            while (i < length)
                output.insert(arr[i][0], arr[i][1], arr[i++][2]);
            while (j < obj.length)
                output.insert(obj.arr[j][0], obj.arr[j][1], obj.arr[j++][2]);
            output.print();
        }
    }

    /**
     * Function to find transpose of sparse matrix
     * @return transObj which is transposed matrix object
     */

    private SparseMtrx transpose() {
        SparseMtrx transObj = new SparseMtrx(col, row);
        transObj.length = length;
        int count[] = new int[col + 1];

        for (int i = 1; i <= col; i++)
            count[i] = 0;

        for (int i = 0; i < length; i++)
            count[arr[i][1]]++;

        int[] index = new int[col + 1];

        index[1] = 0;

        for (int i = 2; i <= col; i++)
            index[i] = index[i - 1] + count[i - 1];

        for (int i = 0; i < length; i++) {
            int pos = index[arr[i][1]]++;
            transObj.arr[pos][0] = arr[i][1];
            transObj.arr[pos][1] = arr[i][0];
            transObj.arr[pos][2] = arr[i][2];
        }
        return transObj;
    }

    /**
     * Function to multiply two sparse matrix
     * @param obj
     */
    private void multiplySparse(SparseMtrx obj) {
        if (col != obj.row) {
            System.out.println("Invalid dimension Can't perform multiplication ");
            return;
        }
        obj = obj.transpose();
        int i, j;

        SparseMtrx result = new SparseMtrx(row, obj.row);

        for (i = 0; i < length;) {
            int r = arr[i][0];
            for (j = 0; j < obj.length;) {
                int c = obj.arr[j][0];
                int temp_s1 = i;
                int temp_obj = j;
                int sum = 0;
                while (temp_s1 < length && arr[temp_s1][0] == r && temp_obj < obj.length && obj.arr[temp_obj][0] == c) {
                    if (arr[temp_s1][1] < obj.arr[temp_obj][1])
                        temp_s1++;
                    else if (arr[temp_s1][1] > obj.arr[temp_obj][1])
                        temp_obj++;
                    else
                        sum += arr[temp_s1++][2] * obj.arr[temp_obj++][2];
                }
                if (sum != 0)
                    result.insert(r, c, sum);
                while (j < obj.length && obj.arr[j][0] == c)
                    j++;
            }
            while (i < length && arr[i][0] == r)
                i++;
        }
        result.print();
    }

    /**
     * Function which displays menu and perform operations
     * @param s1 is the object os sparsematrix
     */
    private static void operations(SparseMtrx s1) {
        System.out.println(
                "Enter 1 to transpose\nEnter 2 to check symmetrical or not\nEnter 3 to add two matrices\nEnter 4 to multiply two matrices\nEnter 5 to exit.");
        int input = scan.nextInt();
        switch (input) {
            case 1:
                SparseMtrx transpose = s1.transpose();
                transpose.print();
                break;
            case 2:
                boolean output=isSymmetric(s1);
                if(output==true){
                    System.out.println("Matrix is Symmetric");
                }
                else{
                    System.out.println("Matrix is not Symmetric");
                }
                break;
            case 3:
                SparseMtrx s3 = inputSparseMtrx();
                System.out.println("Addition: ");
                s1.addSparse(s3);
                break;
            case 4:
                SparseMtrx s2 = inputSparseMtrx();
                System.out.println("\nMultiplication: ");
                s1.multiplySparse(s2);
                break;
            case 5:
                System.out.println("Good Bye ...");
                return;
            default:
                System.out.println("Wrong Input, Try again.");
                break;
        }
        operations(s1);
    }
    // method to take input of a sparse matrix
    private static SparseMtrx inputSparseMtrx() {
        System.out.println("Enter rows of matrix");
        int row = scan.nextInt();
        if (row < 1) {
            System.out.println("Wrong input, try again");
            inputSparseMtrx();
        }
        System.out.println("Enter columns of matrix");
        int col = scan.nextInt();
        if (col < 1) {
            System.out.println("Wrong input, try again");
            inputSparseMtrx();
        }
        SparseMtrx s1 = new SparseMtrx(row, col);
        System.out.println("How much non zero elements you want to insert.");
        int y = scan.nextInt();
        if (y < 1 || y > row * col) {
            System.out.println(y + " elements can't be inserted, try again.");
            inputSparseMtrx();
        } else {
            for (int i = 0; i < y; i++) {
                System.out.println("Enter row index");
                int r = scan.nextInt();
                if (r < 1 || r > row) {
                    System.out.println("Row not present.");
                    inputSparseMtrx();
                } else {
                    System.out.println("Enter col index");
                    int c = scan.nextInt();
                    if (c < 1 || c > col) {
                        System.out.println("Column not present.");
                        inputSparseMtrx();
                    } else {
                        System.out.println("Enter value");
                        int v = scan.nextInt();
                        s1.insert(r, c, v);
                        s1.print();
                    }
                }
            }
        }
        return s1;
    }

}