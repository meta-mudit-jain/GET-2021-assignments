package com.Dsa2;

public class QueueImplements implements Queue {

    private int arr[];
    private int rear;
    private int front;
    private final int size=100;
    public QueueImplements(){
        arr=new int[size];
        rear=-1;
        front=-1;
    }
    public void insert(int x){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(front==-1){
            front=0;
            rear=0;
        }
        else if(rear==size-1 && front!=0){
            rear=0;
        }
        else{
            rear=rear+1;
        }
        arr[rear]=x;
    }
    public int delete(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int temp=arr[front];
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else if(front==size-1)
            front=0;
        else
            front=front +1;
        return temp;
    }
    public boolean isFull(){
        if((front==0 && rear==size-1 )|| (rear==(front-1)%(size-1)))
            return true;
        else
            return false;
    }
    public boolean isEmpty(){
        if(front==-1)
            return true;
        return false;

    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("The circular queue is");
        if(rear>=front){
            for(int i=front;i<=rear;i++)
                System.out.print(arr[i]+" ");
        }
        else{
            for(int i=front;i<size-1;i++)
                System.out.print(arr[i]+" ");
            for(int i=0;i<=rear;i++)
                System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        QueueImplements q=new QueueImplements();
        System.out.println("Is queue empty "+q.isEmpty());
        q.insert(5);
        q.insert(8);
        q.insert(10);
        q.insert(15);
        q.insert(18);
        System.out.println("Is queue full "+q.isFull());
        q.display();
        System.out.println(q.delete()+" is deleted from queue");
        q.display();
    }
}
