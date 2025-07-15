package Dijkstr;
import java.util.*;
public class Algo {
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

    
    static class  pair implements Comparable<pair> {
        int n;
        int path;
        pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int  compareTo(pair p) {
        return this.path-p.path;//path based sorting for my pair
            
        }
        
    }
    public static void AlgoDijkstr(ArrayList<Edge> graph[],int src){
        //initialized dist at starting infinity
        int dist[]=new int[graph.length];//dest[i] means dest from src to i
        for(int i=0;i<graph.length;i++){
        if(i!=src){
            dist[i]=Integer.MAX_VALUE;//+infinity
        }

        }

        //create PQ
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        //src to src distant is 0;
        pq.add(new pair(src, 0));

        while (!pq.isEmpty()) {
            pair curr=pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                //now explore it neighbhor
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int w=e.wt;

                    if(dist[u]+w <dist[v]){
                        dist[v]=dist[u]+w;
                        pq.add(new pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.println(dist[i]+" ");
        }
        System.out.println();
    }



    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        //0
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 3));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));
         graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 5));  
        graph[4].add(new Edge(4, 3, 2));

       
        // graph[5].add(new Edge(5, 2, 0));



    }
    public static void main(String args[]){
        int V=6;

        ArrayList<Edge> graph[]=new ArrayList[V];
        creategraph(graph);
        int src=0;
        AlgoDijkstr(graph,src);
        }
}
