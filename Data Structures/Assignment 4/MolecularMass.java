package com.dsa4;

import java.util.*;
public class MolecularMass {
    public static HashMap<Character,Integer> mass=new HashMap<Character,Integer>();

    public static int getMass(String str){
        int sum=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                int a=0;
                i++;
                while(str.charAt(i)!=')'){
                    if(str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && (i+1)<str.length()){
                        int c=0;
                        c=mass.get(str.charAt(i));
                        i++;
                        c=c*Integer.parseInt(String.valueOf(str.charAt(i)));
                        a=a+c;
                    }
                    else{
                        a=a+mass.get(str.charAt(i));
                    }
                    i++;

                }
                if((i+1)<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9'){
                    i++;
                    a=a*Integer.parseInt(String.valueOf(str.charAt(i)));
                }
                sum=sum+a;
            }
            else {
                if((i+1)<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9'){
                    int b=0;
                    b=mass.get(str.charAt(i));
                    i++;
                    b=b*Integer.parseInt(String.valueOf(str.charAt(i)));
                    sum=sum+b;
                }
                else
                    sum=sum+mass.get(str.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String agr[]){
        mass.put('H', 1);
        mass.put('C', 12);
        mass.put('O', 16);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        String str=sc.nextLine();
        System.out.println(getMass(str));
    }
}