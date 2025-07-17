// public package Bellaman;
import java.util.*;
class Prob {
static class Edges {
    int src;
    int dest;
    int wt;
    Edges(int s,int d,int wt){
        this.src=s;
        this.dest=d;
        this.wt=wt;
    }
    
}

public static void create(ArrayList<Edges> graph[]){
    for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
    }

    graph[0].add(new Edges(0, 1, 2));
    graph[0].add(new Edges(0, 2, 4));
    graph[1].add(new Edges(1, 2, -4));
    graph[2].add(new Edges(2, 3, 2));
    graph[3].add(new Edges(3, 4, 4));
    graph[4].add(new Edges(4, 1, -1));



}
public static void BellamanFord(ArrayList<Edges> graph[],int src){
    int dist[]=new int[graph.length];
    for(int i=0;i<dist.length;i++){
        if(i!=src){
            dist[i]=Integer.MAX_VALUE;
        }   
    }
    int v=graph.length;
    for(int i=0;i<v-1;i++){
        for(int j=0;j<graph.length;j++){
            for(int k=0;k<graph[j].size();k++){
                Edges e=graph[j].get(k);

                int u=e.src;
                int V=e.dest;
                int wt=e.wt;

                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt<dist[V]){
                    dist[V]=dist[u]+wt;
                }

            }
        }
    }
    //print
    for(int i=0;i<dist.length;i++){
        System.out.print(dist[i]+" ");
    }
    System.out.println();
}

//
/* public static void Printall(ArrayList<Edges> graph[]){
    for(int i=0;i<graph.length;i++){

    
    System.out.print(graph[i]+" ");
    }
} */
public static void main(String args[]){
    int v=5;
ArrayList<Edges> graph[]=new ArrayList[v];
create(graph);
BellamanFord(graph, 0);
// Printall(graph);
}
    
}