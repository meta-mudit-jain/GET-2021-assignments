package com.Specifications;
/**
 * @author Mudit Jain
 */

import java.util.Scanner;

public class FCFS {
    int i, j;
    private int noOfProcess =0;
    private final int noOfTimes=2;
    private int[][] process;
    private int[] completionTime;
    private int[] turnAroundTime;
    private int[] waitingTime;
    Scanner sc = new Scanner(System.in);

    /**
     * Function to take input no of process and their arrival time and burst time
     */
    public void getInput(){
        System.out.print("Enter the number of Process: ");
        this.noOfProcess = sc.nextInt();
        process = new int[noOfProcess][noOfTimes];
        //input of jobs
        for(i=0; i < noOfProcess; i++){
            System.out.println("Enter arrival time and burst time of process " + (i+1));
            for( j = 0; j < noOfTimes ; j++){
                process[i][j] = sc.nextInt();
            }
        }
    }

    /**
     * To display arrival time and burst time
     */
    private void displayInput(){
        for(i=0;i<noOfProcess;i++){
            for(j=0;j<noOfTimes;j++){
                System.out.print(process[i][j]+"  ");
            }
            System.out.println("\n");
        }

    }

    private void getOutput(String s, int []arr){
        System.out.println();
        System.out.println(s+" Time of processes are:");
        for(i=0;i<noOfProcess;i++){
            System.out.println("P"+(i+1)+" = "+arr[i]);
        }
    }
    // calculate completion time of each process
    private void calcCompletionTime(){
        completionTime = new int[noOfProcess];

        completionTime[0] = process[0][1];
        for(i = 1 ; i < noOfProcess; i++){
            if ( process[i][0] > (process[i-1][0] +process[i-1][1])){
                completionTime[i] = process[i][0] + process[i][1];
            }
            else{
                completionTime[i] = completionTime[i-1]+process[i][1];
            }
        }

        this.getOutput("Completion", this.completionTime);

    }
    // calculate turnaround time of each process
    private void calcTurnAroundTime(){
        turnAroundTime = new int[noOfProcess];

        for(i = 0 ; i < noOfProcess; i++){
            turnAroundTime[i] = completionTime[i] - process[i][0];
        }

        this.getOutput("TurnAround", turnAroundTime);
    }
    // calculate waiting time of each process
    private void calcWaitingTime(){
        waitingTime = new int[noOfProcess];

        for(i = 0 ; i < noOfProcess; i++){
            waitingTime[i] = turnAroundTime[i] - process[i][1];
        }

        this.getOutput("Waiting", waitingTime);
    }

    static int sum(int[] arr)
    {
        int sum = 0; // initialize sum
        int i;

        // Iterate through all elements and add them to sum
        for (i = 0; i < arr.length; i++)
            sum +=  arr[i];

        return sum;
    }

    // calculate average waiting time
    private void calcAvgWaitingTime(){
        double totalWaitingTime = 0;
        double avgWaitingTime = 0;

        totalWaitingTime = sum(waitingTime);
        avgWaitingTime = totalWaitingTime/noOfProcess;
        System.out.println();
        System.out.println("Average Waiting Time : " +avgWaitingTime +" units");
    }

    // calculate maximum waiting time
    private void calcMaxWaitingTime(){
        int maxWaitingTime = waitingTime[0];
        int index =1;

        for( i=1; i < noOfProcess;i++){
            if(maxWaitingTime < waitingTime[i]){
                maxWaitingTime = waitingTime[i];
                index = i+1;
            }
        }
        System.out.println();
        System.out.println("Maximum Waiting Time : " +maxWaitingTime + " and the process is : P" +index);
    }
    
    public static void main(String[] args) {
        FCFS obj = new FCFS();

        obj.getInput();
        //display input for review
        obj.displayInput();

        obj.calcCompletionTime();
        obj.calcTurnAroundTime();
        obj.calcWaitingTime();
        obj.calcAvgWaitingTime();
        obj.calcMaxWaitingTime();
    }

}