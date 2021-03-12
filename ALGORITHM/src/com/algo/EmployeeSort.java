package com.algo;

public class EmployeeSort {
    public static List head=null;
    public static List sorted=null;
    public static class List{
        String name;
        int age;
        double salary;
        List next;
        public List(String name,int age,double salary){
            this.name=name;
            this.age=age;
            this.salary=salary;
        }
    }

    public void push(String name,int age,double salary){
        List new_node=new List(name,age,salary);
        new_node.next=head;
        head=new_node;
    }
    public void print(){
        List temp=head;
        System.out.println("Name \t \t Age \t \t Salary");
        while(temp!=null){
            System.out.println(temp.name+"\t \t"+temp.age+"\t \t"+temp.salary);
            temp=temp.next;
        }
    }
    public void insertionSort(){
        sorted=null;
        List cur=head;
        while(cur!=null){
            List next=cur.next;
            sortedInsert(cur);
            cur=next;
        }
        head=sorted;
    }

    public void sortedInsert(List newnode){
        if(sorted==null || sorted.salary<newnode.salary){
            newnode.next=sorted;
            sorted=newnode;
        }
        else{
            List current=sorted;
            List pre=current;
            while(current.next!=null && current.next.salary>=newnode.salary){
                pre=current;
                current=current.next;
            }
            if(newnode.salary==current.salary){
                if(newnode.age<current.age){
                    newnode.next=current;
                    pre.next=newnode;
                }
                else{
                    newnode.next=current.next;
                    current.next=newnode;
                }
            }
            else{
                newnode.next=current.next;
                current.next=newnode;
            }
        }
    }

    public static void main(String args[]){

        EmployeeSort e=new EmployeeSort();
        e.push("Mudit", 20, 10000);
        e.push("Amit", 26, 50000);
        e.push("Manav", 27, 25000);
        e.push("Megha", 25, 60000);
        e.push("Shakti", 30, 80000);
        e.push("Raghav", 32, 90000);
        e.push("Ravi", 22, 25000);
        System.out.println("Before sorting");
        e.print();
        e.insertionSort();
        System.out.println("After sorting");
        e.print();
    }
}
