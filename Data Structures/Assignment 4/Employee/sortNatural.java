package com.dsa4;

import java.util.Comparator;
public class sortNatural implements Comparator<Employee>{
    public int compare(Employee a, Employee b){
        return a.getId()-b.getId();
    }

}
