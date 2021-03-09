package com.dsa4;

import java.util.Comparator;
public class sortByName implements Comparator<Employee>{
    public int compare(Employee a, Employee b){
        return (a.getName().compareTo(b.getName()));
    }

}
