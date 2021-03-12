package com.algo2;
/**
 * @author  Mudit Jain
 */

import java.util.*;
import java.util.Queue;


public class GraphImplements implements Graph{
    //public Queue pq=new LinkedList<Edge>();
    public int vertices;
    public Vector<Edge> adjacencyList[];
    //public int dist[];
    //public Set<Integer> settled;

    public GraphImplements(int x){
        vertices=x;
        //dist=new int[vertices];
        //settled=new HashSet<Integer>();
        adjacencyList=new Vector[vertices];
        for(int i=0;i<vertices;i++)
            adjacencyList[i]=new Vector<>();
    }

    public void addEdge(int source,int dest,int w){
        boolean anss=true;
        for(int i=0;i<adjacencyList[source].size();i++){
            if(adjacencyList[source].get(i).node==dest){
                anss=false;
                break;
            }
        }
        if(anss)
            adjacencyList[source].add(new Edge(dest,w));

        boolean ansd=true;
        for(int i=0;i<adjacencyList[dest].size();i++){
            if(adjacencyList[dest].get(i).node==source){
                ansd=false;
                break;
            }
        }
        if(ansd)
            adjacencyList[dest].add(new Edge(source,w));

    }

    public void isConnected(){
        boolean[] visited=new boolean[vertices];
        DFS(0,visited);
        boolean connected =true;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                connected=false;
                break;
            }
        }
        if(connected){
            System.out.println("Graph is connected");
        }
        else
            System.out.println("Graph is not connected");
    }

    public void DFS(int source,boolean[] visited){
        visited[source]=true;
        for(int i=0;i<adjacencyList[source].size();i++){
            int neighbour=adjacencyList[source].get(i).node;
            if(visited[neighbour]==false)
                DFS(neighbour,visited);
        }
    }
    public void reachable(int a){
        System.out.println("Nodes reachable from node "+a+" are");
        boolean visited[]=new boolean[vertices];
        LinkedList<Integer> queue=new LinkedList<Integer>();
        visited[a]=true;
        queue.add(a);
        while(queue.size()!=0){
            a=queue.poll();
            System.out.print(a+" ");
            Iterator<Edge> i=adjacencyList[a].listIterator();
            while(i.hasNext()){
                int n=i.next().node;
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }

    }

    public int minKey(int key[],boolean mstSet[]){
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for(int v=0;v<vertices;v++){
            if(mstSet[v]==false && key[v]<min){
                min=key[v];
                min_index=v;
            }
        }
        return min_index;
    }

    public void printMST(int parent[]){
        System.out.println("The minimum spanning tree is");
        System.out.println("Edge \t Weight");
        for(int i=1;i<vertices;i++){
            int w=0;
            for(int j=0;j<adjacencyList[i].size();j++){
                if(adjacencyList[i].get(j).node==parent[i])
                    w=adjacencyList[i].get(j).weight;
            }
            System.out.println(parent[i]+" - "+i+"\t"+w);
        }
    }
    public void primMST(){
        int parent[]=new int[vertices];
        int key[]=new int[vertices];
        boolean mstSet[]=new boolean[vertices];
        for(int i=0;i<vertices;i++){
            key[i]=Integer.MAX_VALUE;
            mstSet[i]=false;
        }
        key[0]=0;
        parent[0]=-1;
        for(int i=0;i<vertices-1;i++){
            int u=minKey(key,mstSet);
            mstSet[u]=true;
            for(int v=0;v<vertices;v++){
                boolean ans=false;
                int w=0;
                for(int j=0;j<adjacencyList[u].size();j++){
                    if(adjacencyList[u].get(j).node==v){
                        ans=true;
                        w=adjacencyList[u].get(j).weight;
                    }
                }
                if(ans && mstSet[v]==false && w<key[v]){
                    parent[v]=u;
                    key[v]=w;
                }
            }
        }
        printMST(parent);
    }
    public void print(){
        System.out.println("The graph is");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<adjacencyList[i].size();j++)
                System.out.print(adjacencyList[i].get(j).node +" "+adjacencyList[i].get(j).weight+"  ");
            System.out.println();
        }

    }
    public void shortestPath(int source,int dest){
        int shortestDistances[]=new int[vertices];
        boolean added[]=new boolean[vertices];
        for(int i=0;i<vertices;i++){
            shortestDistances[i]=Integer.MAX_VALUE;
            added[i]=false;
        }
        shortestDistances[source]=0;
        int parents[]=new int[vertices];
        parents[source]=-1;
        for(int i=1;i<vertices;i++){
            int nearestVertex=-1;
            int shortestDistance=Integer.MAX_VALUE;
            for(int j=0;j<vertices;j++){
                if(!added[j] && shortestDistances[j]<shortestDistance){
                    nearestVertex=j;
                    shortestDistance=shortestDistances[j];
                }
            }
            added[nearestVertex]=true;
            for(int k=0;k<vertices;k++){
                int edgeDistance=0;
                for(int l=0;l<adjacencyList[nearestVertex].size();l++){
                    if(adjacencyList[nearestVertex].get(l).node==k)
                        edgeDistance=adjacencyList[nearestVertex].get(l).weight;
                }
                if(edgeDistance>0 && ((shortestDistance+edgeDistance)<shortestDistances[k])){
                    parents[k]=nearestVertex;
                    shortestDistances[k]=shortestDistance+edgeDistance;
                }
            }
        }
        printSol(source,shortestDistances,parents,dest);
    }
    public void printSol(int source,int[] shortestDistances,int[] parents,int dest){
        System.out.println("Vertex\t Distance\t Path");
        if(source!=dest){
            System.out.print(source+" ->"+dest+" \t  "+shortestDistances[dest]+"\t\t");
            printPath(dest,parents);
        }
        System.out.println();
    }
    public void printPath(int dest,int[] parents){
        if(dest==-1)
            return;
        printPath(parents[dest],parents);
        System.out.print(dest+" ");
    }

    public static void main(String args[]){
        GraphImplements g=new GraphImplements(5);
        g.addEdge(0,1,2);
        g.addEdge(0,3,6);
        g.addEdge(1,2,3);
        g.addEdge(1,3,8);
        g.addEdge(1,4,5);
        g.addEdge(2,4,7);
        g.addEdge(3,4,9);
        g.isConnected();
        g.primMST();
        g.shortestPath(2,3);
        g.reachable(2);
    }
}
