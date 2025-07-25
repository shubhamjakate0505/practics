package Allpath;

// import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

public class Prob {
    static class  Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }

    }

    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3, 0));
        graph[2].add(new Edge(2, 3, 0));
        graph[3].add(new Edge(3, 1, 0));
        graph[4].add(new Edge(4, 1, 0));  
        graph[4].add(new Edge(4, 0, 0));
        graph[5].add(new Edge(5, 0, 0));
        graph[5].add(new Edge(5, 2, 0));



    }

    public static void allpath(ArrayList<Edge> graph[],int src,int dest,String path){
        if(src==dest){
            System.out.println(path+dest+" ");
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            allpath(graph, e.dest, dest, path+src);
        }

    }
    public static void main(String args[]){
        int V=6;
      
        ArrayList<Edge> graph[]=new ArrayList[V];
        creategraph(graph);
          int src=5;
        int dest=1;
        allpath(graph, src, dest, "");
    }
}
