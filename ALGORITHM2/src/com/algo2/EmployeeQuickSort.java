package com.algo2;

/**
 * @author Mudit Jain
 */
public class EmployeeQuickSort {
    public static List head=null;
    public static List end=null;

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
    public List paritionLast(List start,List end){
        if(start==end || start==null || end==null)
            return start;
        List pivot_pre=start;
        List cur=start;
        double pivot=end.salary;
        int pivot_age=end.age;
        String pivot_name=end.name;
        while(start!=end){
            if(start.salary<=pivot){
                if(start.salary==pivot){
                    if(start.age>pivot_age) {
                        pivot_pre=cur;
                        String name=cur.name;
                        int age=cur.age;
                        double temp=cur.salary;
                        cur.salary=start.salary;
                        cur.name=start.name;
                        cur.age=start.age;
                        start.salary=temp;
                        start.age=age;
                        start.name=name;
                        cur=cur.next;
                    }
                }
                else{
                    pivot_pre=cur;
                    String name=cur.name;
                    int age=cur.age;
                    double temp=cur.salary;
                    cur.salary=start.salary;
                    cur.name=start.name;
                    cur.age=start.age;
                    start.salary=temp;
                    start.age=age;
                    start.name=name;
                    cur=cur.next;
                }
            }
            start=start.next;
        }
        double temp=cur.salary;
        int age=cur.age;
        String name=cur.name;
        cur.salary=pivot;
        cur.age=pivot_age;
        cur.name=pivot_name;
        end.salary=temp;
        end.age=age;
        end.name=name;
        return pivot_pre;
    }

    public void sort(List start,List end){
        if(start==end)
            return;
        List pivot_pre=paritionLast(start,end);
        sort(start,pivot_pre);
        if(pivot_pre!=null && pivot_pre==start)
            sort(pivot_pre.next,end);
        else if(pivot_pre!=null && pivot_pre.next.next!=null)
            sort(pivot_pre.next.next,end);

    }
    public void descending(){
        List pre=null;
        List cur=head;
        List next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        head=pre;
    }
    public static void main(String args[]){

        EmployeeQuickSort e=new EmployeeQuickSort();
        e.push("Aman", 25, 25000);
        e.push("Amit", 26, 50000);
        e.push("Manav", 27, 25000);
        e.push("Megha", 25, 60000);
        e.push("Shakti", 30, 80000);
        e.push("Raghav", 32, 90000);
        e.push("Ravi", 22, 25000);
        end=head;
        while(end.next!=null)
            end=end.next;
        System.out.println("Before sorting");
        e.print();
        e.sort(head,end);
        e.descending();
        System.out.println("After sorting");
        e.print();
    }

}