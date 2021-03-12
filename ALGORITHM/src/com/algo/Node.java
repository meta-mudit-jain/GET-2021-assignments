package com.algo;

public class Node{
    String key;
    String value;
    Node left,right;
    public Node(String key,String value){
        this.key=key;
        this.value=value;
        left=right=null;
    }
    public String getKey(){
        return this.key;

    }
    public String getValue(){
        return this.value;

    }
}
