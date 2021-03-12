package com.algo2;

/**
 * @author  Mudit Jain
 */
public class Edge{
    public int node;
    public int weight;
    public Edge(int n,int w){
        node=n;
        weight=w;
    }
    public int getNode(){
        return node;
    }
    public int getWeight(){
        return weight;
    }
}
