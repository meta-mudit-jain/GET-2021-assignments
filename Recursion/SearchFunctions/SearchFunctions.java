package com.Recursionpack;

import java.util.Scanner;
// Java class Search
public class SearchFunctions {
    /**
     * Search an element in array using linear search.
     * @param arr, requires array in which we searching element
     * @param num, requires number which we want to search
     * @param low index, requires lower index of array
     * @param high index, requires higher index of array
     * @return index of element if found
     * @return -1 if element not found
     */
    public static int linearSearch(int[] arr,int num,int low,int high){
        if(high<low){
            return -1;
        }else if (arr[low]==num) {
            return low;
        }else{
            return linearSearch(arr, num, low+1, high);
        }
    }
    /**
     * Search an element in array using binary search.
     * @param arr, requires array in which we searching element
     * @param num, requires number which we want to search
     * @param low index, requires lower index of array
     * @param high is length - 1 of array
     * @return index of element if found
     * @return -1 if element not found
     */
    public static int binarySearch(int[] arr,int num,int low,int high){
        if(high>=low){
            int mid=low+(high-low)/2;
            if(arr[mid]==num){
                return mid;
            }
            if(arr[mid]>num){
                return binarySearch(arr, num, low, mid-1);
            }
            return binarySearch(arr, num, mid+1, high);
        }
        return -1;
    }
    // main method
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter total no of elements of array");
        int n=scan.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter elements of array");
        for (int i = 0; i < n; i++) {
            arr[i]=scan.nextInt();
        }
        System.out.println("Enter which element you want to search");
        int num=scan.nextInt();
        System.out.println("Using Linear Search");
        int index_of_element=linearSearch(arr,num,0,n-1);
        if(index_of_element==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index "+index_of_element);
        }
        System.out.println("Using Binary Search");
        int index_of_elem=binarySearch(arr,num,0,n-1);
        if(index_of_elem==-1){
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index "+index_of_elem);
        }
        scan.close();
    }
}
