// import java.util.*;
package Prims;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Ques {
    //Edge class
    static class Edges{
        int src;
        int dest;
        int wt;
        Edges(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;

        }}
// graph creation
    public static void creategraph(ArrayList<Edges> graph[]){
          for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
    }

    graph[0].add(new Edges(0, 1, 10));
    graph[0].add(new Edges(0, 2, 15));
    graph[0].add(new Edges(0, 3, 30));
    graph[1].add(new Edges(1, 0, 10));
    graph[1].add(new Edges(1, 3, 40));
    graph[2].add(new Edges(2, 1, 15));
    graph[2].add(new Edges(2, 2, 50));
    graph[3].add(new Edges(3, 1, 40));
    graph[3].add(new Edges(3, 2, 50));

        
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        Pair(int v,int c){
            this.v=v;
            this.cost=c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;//asending
        }
    }
    public static void PrimsAlgo(ArrayList<Edges> graph[]){
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalcost=0;//total min weight
        while (!pq.isEmpty()) {
            Pair curr=pq.remove();
            if(!vis[curr.v]){
                vis[curr.v]=true;
                finalcost+=curr.cost;

                //now add neighbhor
                for(int i=0;i<graph[curr.v].size();i++){
                    Edges e=graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println(finalcost);
    }
    public static void main(String args[]){
        int V=4;
        ArrayList<Edges> graph[]=new ArrayList[V];
        creategraph(graph);
        PrimsAlgo(graph);
    }
}