package TopologicalSorting;

import java.util.ArrayList;
import java.util.Stack;

public class Prob {
    static class  Edge {
   int src;
   int dest;
   int wt;
   public Edge(int s,int d,int w){
        this.src=s;
        this.dest=d;
        this.wt=w;
   }
    
   }

   //using dfs
   public static void dfs(ArrayList<Edge> graph[]){
    boolean vis[]=new boolean[graph.length];
    Stack<Integer> s=new Stack<>();
    // int stack[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfsutil(graph,i,vis,s);//topsort
            }
        }
        while (!s.isEmpty()) {
          System.err.println(s.pop());  
        }
   }

   public static void dfsutil(ArrayList<Edge> graph[],int curr,boolean vis[],Stack<Integer> s){
    vis[curr]=true;
    // s.push(curr);
    for(int i=0;i<graph[curr].size();i++){
        Edge e=graph[curr].get(i);
        if(!vis[e.dest]){
            dfsutil(graph, e.dest, vis, s);
        }
    }
    s.push(curr);
   }

   public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

    graph[2].add(new Edge(2, 3, 0));
    graph[3].add(new Edge(3, 0, 0));
    graph[4].add(new Edge(4, 1, 0));  // <-- FIXED
    graph[4].add(new Edge(4, 0, 0));
    graph[5].add(new Edge(5, 0, 0));
    graph[5].add(new Edge(5, 2, 0));

    //    graph[0].add(new Edge(0, 2, 0));
      //  graph[1].add(new Edge(1, 0, 0));
       // graph[1].add(new Edge(2, 3, 0));
       // graph[1].add(new Edge(2, 3, 0));
   }
  public static void main(String args[]){
    int V=6;
    ArrayList<Edge> graph[]=new ArrayList[V];
    creategraph(graph);
    dfs(graph);
  }  
}
