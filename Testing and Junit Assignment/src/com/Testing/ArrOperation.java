package com.Testing;

import java.util.Scanner;

public class ArrOperation {
    static Scanner scan = new Scanner(System.in);

    /**
     * Find the size of the largest mirror section in the input array.
     *
     * @param arr is an array on which operation is performed
     *            Throws assertion if empty
     * @return max size of largest mirror section
     */
    public static int maxMirrorSize(int[] arr) {
        int max = -1;
        try {
            if (arr.length == 0) {
                throw new AssertionError("Empty array");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    int k = i;
                    int count = 0;
                    for (int j = arr.length - 1; j >= i; j--) {
                        if (arr[j] == arr[k]) {
                            count++;
                            k++;
                            if (k >= arr.length) {
                                if (max < count) {
                                    max = count;
                                }
                                break;
                            }
                        } else if (count != 0) {
                            if (count > max) {
                                max = count;
                            }
                            count = 0;
                            k = i;
                        }
                    }
                    if (count > max) {
                        max = count;
                    }
                    if ((arr.length - i) < max) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return max;
    }

    /**
     * Find the number of clumps in the input array.
     *
     * @param nums, array to perform operation
     *              Throw AssertionError if array is empty
     * @return clumps that is number of clumps in the array
     */

    public static int countClumps(int[] nums) {
        int clumps = 0;
        try {
            if (nums.length == 0)
                throw new AssertionError("Empty Array");

            boolean isClump = false;

            for (int i = 0; i < nums.length - 1; i++) {
                if (isClump) {
                    if (nums[i] != nums[i + 1])
                        isClump = false;
                } else if (nums[i] == nums[i + 1]) {
                    isClump = true;
                    clumps++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clumps;
    }

    /**
     * Find the index where left and right elements sum is equal.
     *
     * @param nums, requires array to perform operation
     *              Throw AssertionError if array is empty
     * @return -1, if splitting is not possible
     */
    public static int splitArray(int[] nums) {
        int k = -1;
        try {
            int sum = 0;
            if (nums.length == 0) {
                throw new AssertionError("Empty array");
            } else {
                for (int i = 0; i < nums.length; i++) {
                    sum = sum + nums[i];
                    nums[i] = sum;
                }
                if (sum % 2 == 0) {
                    for (int i = 0; i < nums.length; i++) {
                        if (nums[i] == (sum / 2)) {
                            k = i + 1;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return k;
    }

    /**
     * Rearrange the array as x is followed by y.
     *
     * @param arr, array to perform operation
     * @param x,    x is such that each x should be followed by y can't be moved
     * @param y,    should be present after each x can be moved
     *              Throw AssertionError if array is empty
     * @return nums as rearranged array
     */
    public static int[] fixXY(int[] arr,int x,int y){
        try {
            if(arr.length==0){
                throw new AssertionError("Empty array");
            }else if (arr[arr.length-1]==x) {
                throw new AssertionError("X occurs at the last index of the array");
            }
            else{
                for (int i = 0; i < arr.length-1; i++) {
                    if(arr[i]==x && arr[i+1]==x){
                        throw new AssertionError("two adjacents X values are there");
                    }
                }
                int count_x=0,count_y=0;
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]==x){
                        count_x++;
                    }
                    if (arr[i]==y) {
                        count_y++;
                    }
                }
                if(count_x!=count_y){
                    throw new AssertionError("there are unequal numbers of X and Y");
                }
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i]==y){
                        for (int j = 0; j < arr.length; j++) {
                            if(arr[j]==x && arr[j+1]!=y && j!=arr.length-1){
                                int temp=arr[i];
                                arr[i]=arr[j+1];
                                arr[j+1]=temp;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }


    public static void main(String[] args) {
        int exitCode = 0;
        do {
            System.out.println("Enter 1 to find largest mirror section size\n"
                    + "Enter 2 to find number of clumps in array\n"
                    + "Enter 3 to rearrange array as XY\n"
                    + "Enter 4 to find index of split array where sum of left right is equal\n"
                    + "Enter 5 to exit");
            int input = scan.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter total no of elements in array");
                    int total_num = scan.nextInt();
                    int[] arr = new int[total_num];
                    System.out.println("Enter elements of array");
                    for (int i = 0; i < total_num; i++) {
                        arr[i] = scan.nextInt();
                    }
                    int max = maxMirrorSize(arr);
                    System.out.println(max);
                    break;
                case 2:
                    System.out.println("Enter total no of elements in array");
                    int total_num1 = scan.nextInt();
                    int[] arr1 = new int[total_num1];
                    System.out.println("Enter elements of array");
                    for (int i = 0; i < total_num1; i++) {
                        arr1[i] = scan.nextInt();
                    }
                    int clumps = countClumps(arr1);
                    System.out.println(clumps);
                    break;
                case 3:
                    System.out.println("Enter total no of elements in array");
                    int total_num2 = scan.nextInt();
                    int[] arr2 = new int[total_num2];
                    System.out.println("Enter elements of array");
                    for (int i = 0; i < total_num2; i++) {
                        arr2[i] = scan.nextInt();
                    }
                    System.out.println("Enter value of X");
                    int x = scan.nextInt();
                    System.out.println("Enter value of Y");
                    int y = scan.nextInt();
                    int[] fix_arr = fixXY(arr2, x, y);
                    for (int i = 0; i < fix_arr.length; i++) {
                        System.out.print(fix_arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Enter total no of elements in array");
                    int total_num3 = scan.nextInt();
                    int[] arr3 = new int[total_num3];
                    System.out.println("Enter elements of array");
                    for (int i = 0; i < total_num3; i++) {
                        arr3[i] = scan.nextInt();
                    }
                    int split_index = splitArray(arr3);
                    System.out.println(split_index);
                    break;
                case 5:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            System.out.println("Do You want to continue 1.Yes 2.No");
            exitCode=scan.nextInt();
        } while (exitCode == 1);
    }
}
