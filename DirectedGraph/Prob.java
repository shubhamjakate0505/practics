package DirectedGraph;
import java.util.*;
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

   public static void creategraph(ArrayList<Edge> graph[]){//false No cycle
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

    graph[0].add(new Edge(0, 2, 0));
    graph[1].add(new Edge(1, 0, 0));
    graph[2].add(new Edge(2, 3, 0));  // <-- FIXED
    graph[3].add(new Edge(3, 0, 0));

    //    graph[0].add(new Edge(0, 2, 0));
      //  graph[1].add(new Edge(1, 0, 0));
       // graph[1].add(new Edge(2, 3, 0));
       // graph[1].add(new Edge(2, 3, 0));
   }
   public static boolean dfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(iscycleutil(graph,i,vis,stack)){
                    return true;
                }

            }
        }
        return false;
   }

   public static boolean iscycleutil(ArrayList<Edge> graph[],int curr, boolean vis[],boolean stack[]){
            vis[curr]=true;
            stack[curr]=true;
           for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(stack[e.dest]){//cycle
                    return true;
                }
                if(!vis[e.dest]){
                    if(iscycleutil(graph, e.dest, vis, stack)){
                        return true;
                    }
                }
           }
           stack[curr]=false;
           return false;
   }
    public static void main(String args[]){
        int V=4;
        ArrayList<Edge> graph[]=new ArrayList[V];
        creategraph(graph);
        System.out.println(dfs(graph));
    }
}
