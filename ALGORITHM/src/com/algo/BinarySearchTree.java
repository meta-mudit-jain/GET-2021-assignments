package com.algo;

import java.util.*;
public class BinarySearchTree implements Dictionary{

    public static Node root=null;

    public BinarySearchTree(){

    }

    public void addKey(String key,String value){
        root=insertRec(root,key,value);
    }
    public Node insertRec(Node root,String key,String value){
        if(root==null){
            root=new Node(key,value);
            return root;
        }
        int n=key.compareTo(root.key);
        if(n<0)
            root.left=insertRec(root.left,key,value);
        else if(n>0)
            root.right=insertRec(root.right,key,value);
        return root;
    }
    public List<Node> sortedPrint(){
        List<Node>l=new ArrayList<>();
        if(root==null)
            return null;
        Stack<Node> s=new Stack<Node>();
        Node cur=root;
        while(cur!=null || s.size()>0){
            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }
            cur=s.pop();
            l.add(cur);
            cur=cur.right;
        }
        return l;
    }

    public List<Node> sortedPrintBetweenValues(String k1,String k2){
        List<Node>l=new ArrayList<>();
        if(root==null)
            return null;
        Stack<Node> s=new Stack<Node>();
        Node cur=root;
        while(cur!=null || s.size()>0){
            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }
            cur=s.pop();
            int n=cur.key.compareTo(k1);
            int m=cur.key.compareTo(k2);
            if(n>=0 && m<=0)
                l.add(cur);
            cur=cur.right;
        }
        return l;
    }
    public void deleteKey(String key){
        root=deleteRec(root,key);
    }
    public Node deleteRec(Node root,String key){
        if(root==null)
            return root;

        int n=key.compareTo(root.key);
        if(n<0)
            root.left=deleteRec(root.left,key);
        else if(n>0)
            root.right=deleteRec(root.right,key);
        else{
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            root.key=minValue(root.right);
            root.right=deleteRec(root.right,root.key);
        }
        return root;
    }
    public String minValue(Node root){
        String min=root.key;
        while(root.left!=null){
            min=root.left.key;
            root=root.left;
        }
        return min;
    }
    public String getValue(String key){
        Node a=getValueRec(root,key);
        if(a!=null)
            return a.value;
        else
            return "Key is not present";

    }
    public void printList(List<Node> a){
        if(a.isEmpty())
            System.out.println("No element in dictionary");
        else{
            System.out.println("The dictionary is");
            System.out.println("Key \t        Value");
            for(Node i : a){
                System.out.println(i.getKey()+"\t \t"+i.getValue());
            }
        }
    }
    public Node getValueRec(Node root,String key){

        if(root==null || root.key.equals(key))
            return root;
        int n=key.compareTo(root.key);
        if(n<0)
            return getValueRec(root.left,key);
        else
            return getValueRec(root.right,key);

    }
    public static void main(String args[]){
        BinarySearchTree b=new BinarySearchTree();
        b.addKey("Banana","It is a fruit");
        b.addKey("Apple","It is a fruit");
        b.addKey("Cabbage","It is a vegetable");
        b.addKey("Orange","It is a fruit");
        b.addKey("Again","To repeat");
        System.out.println(b.getValue("cabbage"));
        List<Node> li=b.sortedPrint();
        b.printList(li);
        b.deleteKey("Cabbage");
        List<Node> li1=b.sortedPrint();
        b.printList(li1);
        List<Node> li2=b.sortedPrintBetweenValues("A", "Cabbage");
        b.printList(li2);
    }
}