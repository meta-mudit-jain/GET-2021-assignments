package com.Specifications;

import java.util.Scanner;

/**
 * A class Marksheet, which reads in grades of n no of students.
 * Assume n as a positive integer and grades will be between 0 and 100 both inclusive
 * @author Mudit Jain
 */


public class MarkSheet {
    static float grades[]=new float[100];
    static int n;

    /**
     * Find average of grades .
     * @return avg which is average grade in float
     */
    public static float averageGrade(){
        float sum,avg;
        sum = 0.0f;
        for(int i=0;i<n;i++){
            sum=sum+grades[i];
        }
        avg=sum/n;
        return avg;
    }

    /**
     * Find maximum grade in the array.
     * @return max which is maximum grade
     */
    public static float maximumGrade(){
        float max;
        max = 0.00f;
        for(int i=0;i<n;i++){
            if(grades[i]>max)
                max=grades[i];
        }
        return max;
    }

    /**
     * Find minimum grade in the array.
     * @return min which is minimum grade in float
     */
    public static float minimumGrade(){
        float min=grades[0];
        for(int i=1;i<n;i++){
            if(grades[i]<min)
                min=grades[i];
        }
        return min;
    }

    /**
     * Find percentage of passed students.
     * @return percent which is percentage of passed students in float
     */
    public static float passStudPercent(){
        int pass=0;
        for(int i=0;i<n;i++){
            if(grades[i]>=40)
                pass++;
        }
        float percent=((float)pass/n)*100;
        return percent;
    }
    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter number of students");
        n=scan.nextInt();
        System.out.println("Enter grades of students");
        for(int i=0;i<n;i++) {
            grades[i] = scan.nextFloat();
            if (grades[i] > 100 || grades[i] < 0) {
                System.out.println("Invalid grade entered grade should be 0<=grade<=100");
                System.exit(0);
            }
        }
        System.out.println("Max grade is"+" "+maximumGrade());
        System.out.println("Min grade is"+" "+minimumGrade());
        System.out.println("Avg grade is"+" "+averageGrade());
        System.out.println("Percentage of students passed is"+" "+passStudPercent()+"%");
    }


}
