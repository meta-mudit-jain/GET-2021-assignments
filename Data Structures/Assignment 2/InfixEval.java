package com.Dsa2;

/**
 * Java program to evaluate a
 * given expression where tokens
 * are separated by space.
 */

import java.util.Scanner;

public class InfixEval implements Stack {
    private int top;
    private final int size=100;
    private String arr[];

    /**
     * Constructor of class InfixEval
     */
    InfixEval(){
        top=-1;
        arr=new String[size];
    }

    /**
     * Method to push an element in stack
     * @param x the string to be pushed in stack
     */
    public void push(String x){
        if(this.top>=size-1){
            System.out.println("Stack is full");
            return;
        }
        this.top++;
        this.arr[this.top]=x;
    }

    /**
     * Method to check is stack is empty
     * @return boolean value true if empty else false
     */
    public  boolean empty(){
        if(this.top==-1)
            return true;
        return false;
    }

    /**
     * Method to return the top element in stack
     * @return -1 is stack is empty else top element
     */
    public  String peek(){
        if(this.top==-1){
            System.out.println("Stack is empty");
            return "-1";
        }
        return this.arr[this.top];
    }

    /**
     * Method to pop out a element from the stack
     * @return the top element else -1
     */
    public String pop(){
        if(this.top==-1){
            System.out.println("Stack is empty");
            return "#";
        }
        String x=arr[this.top];
        this.top--;
        return x;
    }

    /**
     *
     * @param exp
     * @return
     */
    public String evaluate(String exp){
        InfixEval values=new InfixEval();
        InfixEval ops=new InfixEval();
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i)==' ')
                continue;
            if(exp.charAt(i)>='0' && exp.charAt(i)<='9'){
                String temp="";
                while(i<exp.length() && exp.charAt(i)>='0' && exp.charAt(i)<='9'){
                    temp=temp+exp.charAt(i);
                    i++;
                }
                values.push(temp);
                i--;
            }
            else if(exp.charAt(i)=='(')
                ops.push("(");
            else if(exp.charAt(i)==')'){
                while(ops.peek()!="(")
                    values.push(evalOp(ops.pop(),Integer.parseInt(values.pop()),Integer.parseInt(values.pop())));
                ops.pop();

            }
            else if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*'
                    || exp.charAt(i)=='/' || (exp.charAt(i)=='>'&& exp.charAt(i+1)!='=' )|| (exp.charAt(i)=='<' && exp.charAt(i+1)!='=' )){
                while(!ops.empty() && (precedence(Character.toString(exp.charAt(i)))>=precedence(ops.peek())))
                    values.push(evalOp(ops.pop(),Integer.parseInt(values.pop()),Integer.parseInt(values.pop())));
                ops.push(Character.toString(exp.charAt(i)));
            }



            else if(exp.charAt(i)=='=' || exp.charAt(i)=='!' || exp.charAt(i)=='&'
                    || exp.charAt(i)=='|' || (exp.charAt(i)=='>'&& exp.charAt(i+1)=='=' )|| (exp.charAt(i)=='<' && exp.charAt(i+1)=='=' )){
                String temp="";
                temp=temp+exp.charAt(i);
                temp=temp+exp.charAt(i+1);
                i=i+1;
                while(!ops.empty() && (precedence(temp)>=precedence(ops.peek())))
                    values.push(evalOp(ops.pop(),Integer.parseInt(values.pop()),Integer.parseInt(values.pop())));
                ops.push(temp);
            }
        }
        while(!ops.empty())
            values.push(evalOp(ops.pop(),Integer.parseInt(values.pop()),Integer.parseInt(values.pop())));
        return values.pop();

    }

    public static  int precedence(String op1){
        if(op1=="(" || op1==")")
            return 7;
        if(op1=="*" || op1=="/")
            return 6;
        if(op1=="+" || op1=="-")
            return 5;
        if(op1=="<" || op1==">" || op1=="<=" || op1==">=")
            return 4;
        if(op1=="==" || op1=="!=")
            return 3;
        if(op1=="&&")
            return 2;
        if(op1=="||")
            return 1;
        else
            return -1;
    }
    public static String evalOp(String op,int b,int a){
        switch(op){
            case "+": int c=a+b;
                return Integer.toString(c);

            case "-": int d=a-b;
                return Integer.toString(d);

            case "*": int e=a*b;
                return Integer.toString(e);
            case "/":
                if(b==0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                int f=a/b;
                return Integer.toString(f);


            case "==" : return Boolean.toString(a==b);
            case ">" : return Boolean.toString(a>b);
            case ">=" : return Boolean.toString(a>=b);
            case "<=" : return Boolean.toString(a<=b);
            case "<" : return Boolean.toString(a<b);
            case "!=" : return Boolean.toString(a!=b);
            case "&&" : return Boolean.toString(intToBool(a)&&intToBool(b));
            case "||" : return Boolean.toString(intToBool(a)||intToBool(b));
        }
        return "#";
    }
    public static boolean intToBool(int x){
        if(x>0)
            return true;
        return false;
    }
    public static void main(String args[]){
        InfixEval obj=new InfixEval();
        String str;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the infix string to be evaluated");
        str= sc.nextLine();
        System.out.println(obj.evaluate(str));

    }
}