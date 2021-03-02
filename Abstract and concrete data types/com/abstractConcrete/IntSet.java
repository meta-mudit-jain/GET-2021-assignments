package com.abstractConcrete;

/**
 * Implement the immutable class intSet using an array to represent a set of integers in the range 1-1000. It should support public methods like -
 * isMember(int x) - check whether x is a member of the set and return a boolean value
 * size() - return the size of the set
 * isSubSet(intSet s) - check whether s is a subset of the set
 * getComplement()  - return the complement set, you can assume that 1..1000 is the universal set
 * union(intSet s1, intSet s2) - return the union of s1 and s2
 * You may use private helper methods.
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
/**
 * Single Variable polynomial
 * Immutable Poly Class
 * A class is immutable when class is final all members are private final
 * Initialize all fields using constructor
 * Don't use setters only use getters
 * @author  Mudit Jain
 */
public final class IntSet {
    private static Scanner scan=new Scanner(System.in);

    /**
     * Function to return size of array
     * @param arr is of type array
     * @return length of array
     */
    private static int size(int[] arr){
        return arr.length;
    }

    /**
     * Function to check input set is subSet or not
     * @param uniSet
     * @return boolean value true if its a subset otherwise false
     */
    private static boolean isSubset(int[] uniSet){
        System.out.println("Enter the size of your set: ");
        int size=scan.nextInt();
        int set[]=new int[size];

        System.out.println("Enter elements of the set");

        for (int i = 0; i < set.length; i++) {
            set[i]=scan.nextInt();
        }

        for(int i=0;i<set.length;i++){
            for (int j = 0; j < uniSet.length; j++) {
                if(set[i]==uniSet[j]){
                    break;
                }
                if(j==uniSet.length-1) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Function to check a number is a member of uniSet or not
     * @param arr is of type array
     * @return boolan value true if it's a part else false
     */
    private static boolean isMember(int[] arr){
        System.out.println("Enter number you want to search in the set = ");
        int num=scan.nextInt();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                return true;
            }
        }
        return false;
    }

    /**
     * Function to find out union of two sets
     * @return union a array which is union of two sets
     */
    private static Integer[] union(){
        System.out.println("Enter length of set1: ");
        int n1=scan.nextInt();
        Integer[] set1= new Integer[n1];
        System.out.println("Enter length of set2: ");
        int n2=scan.nextInt();
        Integer[] set2=new Integer[n2];
        System.out.println("Enter elements of set1");
        for (int i = 0; i < n1; i++) {
            set1[i]=scan.nextInt();
        }
        System.out.println("Enter elements of set2");
        for (int i = 0; i < n2; i++) {
            set2[i]=scan.nextInt();
        }
        HashSet<Integer> union_set=new HashSet<>();
        union_set.addAll(Arrays.asList(set1));
        union_set.addAll(Arrays.asList(set2));
        Integer[] union={};
        union=union_set.toArray(union);
        return union;
    }

    /**
     * Function to find compliment set of a set
     * @param uniSet is of type array the set
     * @return compliment set
     */
    private static Integer[] getComplement(int[] uniSet){
        Integer[] us=new Integer[uniSet.length];
        for (int i = 0; i < uniSet.length; i++) {
            us[i]=Integer.valueOf(uniSet[i]);
        }
        System.out.println("Enter length of set");
        int n1=scan.nextInt();
        Integer[] set1= new Integer[n1];
        System.out.println("Enter elements of your set");
        for (int i = 0; i < n1; i++) {
            set1[i]=scan.nextInt();
        }
        HashSet<Integer> complement_set=new HashSet<>();
        complement_set.addAll(Arrays.asList(us));
        complement_set.removeAll(Arrays.asList(set1));
        Integer[] complement={};
        complement=complement_set.toArray(complement);
        return complement;
    }

    /**
     * Function which displays menu to user
     * @param uniSet
     */
    private static void operations(int[] uniSet){
        System.out.println("Enter Your choice");
        System.out.println("1 to find an element in array\n"
                            + " 2 to find the size of the universal set\n"
                            + " 3 to find subset of universal set\n"
                            + " 4 to get compliment of a set\n"
                            + " 5 to get union of 2 sets\n"
                            + " 6 to exit."
        );
        int input=scan.nextInt();
        switch (input) {
            case 1:
                boolean check=isMember(uniSet);
                if (check==true) {
                    System.out.println("Item found in set");
                }else {
                    System.out.println("Item not found in set");
                }
                break;
            case 2:
                int size_of_set=size(uniSet);
                System.out.println("The size of set is = "+size_of_set);
                break;
            case 3:
                boolean subset=isSubset(uniSet);
                if (subset==true) {
                    System.out.println("This is a subset");
                }else {
                    System.out.println("This is not a subset");
                }
                break;
            case 4:
                Integer[] complement_set=getComplement(uniSet);
                System.out.println("Complement of the set is = ");
                for (int i : complement_set) {
                    System.out.print(i+ " ");
                }
                System.out.println();
                break;
            case 5:
                Integer[] union_set=union();
                System.out.println("Union of the sets is = ");
                for (int i : union_set) {
                    System.out.print(i+" ");
                }
                System.out.println();
                break;
            case 6:
                System.out.println("Thanks to use set operations.");
                return;
            default:
                System.out.println("Wrong Input, Try again");
                break;
        }

    }

    /**
     * Main Method
     * @param args take command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter total no of elements in Universal set = ");
        int n=scan.nextInt();
        int uniSet[] = new int[n];
        for(int i=0;i<n;i++){
            uniSet[i]=i+1;
        }
        operations(uniSet);
        scan.close();
    }
}
