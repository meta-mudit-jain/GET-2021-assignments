package com.Recursionpack;

import java.util.Scanner;
// Java class LcmHcf
public class LcmHcf {
    static int lcm=1;
    /**
     * Find the lcm of two positive integers.
     * @param num1,num2 , requires 2 numbers for find lcm
     * @return lcm of integers
     */
    public static int find_lcm(int num1,int num2){
        if(lcm%num1==0 && lcm%num2==0){
            return lcm;
        }
        else{
            lcm++;
            find_lcm(num1, num2);
            return lcm;
        }
    }
    /**
     * Find the Hcf of two positive integers.
     * @param num1,num2 , requires 2 numbers for find Hcf
     * @return Hcf of integers
     */
    public static int find_hcf(int num1,int num2){
        if(num2==0){
            return num1;
        }
        else{
            return find_hcf(num2, num1%num2);
        }
    }
    // main method
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter 2 numbers to find LCM and HCF");
        int num1=scan.nextInt();
        int num2=scan.nextInt();
        int lcm=find_lcm(num1,num2);
        System.out.println("LCM is = "+lcm);
        int hcf=find_hcf(num1,num2);
        System.out.println("HCF is = "+hcf);
        scan.close();
    }
}