package com.dsa4;

import java.util.*;
public class Employee {
    public int empId;
    public String empName;
    public String empAddr;
    public Employee(int id,String name,String addr){
        empId=id;
        empName=name;
        empAddr=addr;
    }
    public String getName(){
        return this.empName;
    }
    public int getId(){
        return this.empId;
    }
    public String getAddr(){
        return this.empAddr;
    }

    public static HashMap<Integer,Employee> emp=new HashMap<>();
    public static List<Employee> employee=new ArrayList<>();
    public static void printMap(){
        if(emp.isEmpty())
            System.out.println("No Employee is present in list");
        else{
            Iterator<Map.Entry<Integer,Employee>> itr =emp.entrySet().iterator();
            System.out.println("The employee map is");
            System.out.println("EmpId \t      EmpName \t    EmpAddress");
            while(itr.hasNext()){
                Map.Entry<Integer, Employee> entry = itr.next();
                System.out.println(entry.getKey()+"\t \t"+entry.getValue().empName+"\t \t"+entry.getValue().empAddr);
            }
        }
    }
    public static void printList(){
        if(emp.isEmpty())
            System.out.println("No Employee is present in list");
        else{
            System.out.println("EmpId \t      EmpName \t   EmpAddress");
            for(Employee i : employee){
                System.out.println(i.getId()+"\t \t"+i.getName()+"\t \t"+i.getAddr());
            }
        }
    }

    public static void main(String arg[]){
        Employee e1=new Employee(1,"Aman","Jaipur");
        Employee e2=new Employee(2,"Abhi","Ajmer");
        Employee e3=new Employee(3,"Avi","Jaipur");
        Employee e4=new Employee(4,"Payal","Kota");
        Employee e5=new Employee(5,"Jaya","Delhi");
        Employee e6=new Employee(5,"Jaya","Delhi");
        emp.put(e1.empId, e1);
        emp.put(e2.empId, e2);
        emp.put(e4.empId, e4);
        emp.put(e3.empId, e3);
        emp.put(e6.empId, e6);
        emp.put(e5.empId, e5);
        employee.add(e1);
        employee.add(e2);
        employee.add(e5);
        employee.add(e3);
        employee.add(e4);
        employee.add(e6);
        printList();
        System.out.println("Employee Sorted by Natural order ");
        Collections.sort(employee, new sortNatural());
        printList();
        System.out.println("Employee Sorted by Name order ");
        Collections.sort(employee, new sortByName());
        printList();
        printMap();

    }

}