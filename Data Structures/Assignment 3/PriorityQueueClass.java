package com.dsa4;

public class PriorityQueueClass implements PriorityQueue{
    private final int size=100;
    private int queue[]=new int[size];
    private int count=0;
    public void enqueue(int x){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        int i=count-1;
        while(i>=0 && x<queue[i]){
            queue[i+1]=queue[i];
            i--;
        }
        queue[i+1]=x;
        count++;
    }
    public int dequeue(){
        if(isFull()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int x=queue[count-1];
        count--;
        return x;

    }
    public boolean isEmpty(){
        if(count==0)
            return true;
        return false;
    }
    public boolean isFull(){
        if(count==size-1)
            return true;
        return false;
    }
    public void print(){
        System.out.println("The priority queue is");
        for(int i=0;i<count;i++)
            System.out.print(queue[i]+" ");
        System.out.println();
    }
    public  static void main(String args[]){
        PriorityQueueClass p=new PriorityQueueClass();
        p.enqueue(5);
        p.enqueue(10);
        p.enqueue(6);
        p.enqueue(8);
        p.enqueue(10);
        p.print();
        p.dequeue();
        p.print();
    }

}
