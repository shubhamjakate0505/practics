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
   public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

    graph[2].add(new Edge(2, 3, 0));
    graph[3].add(new Edge(3, 0, 0));
    graph[4].add(new Edge(4, 1, 0));  
    graph[4].add(new Edge(4, 0, 0));
    graph[5].add(new Edge(5, 0, 0));
    graph[5].add(new Edge(5, 2, 0));

   
   }
   public static void calculatein(ArrayList<Edge> graph[],int indeg[]){
    for(int i=0;i<graph.length;i++){
        //vertax
        int v=i;

        for(int j=0;j<graph[v].size();j++){//Edges
            Edge e=graph[v].get(j);
            indeg[e.dest]++;
        }
    }}

   public static void topsort(ArrayList<Edge> graph[]){
    int indeg[]=new int[graph.length];
    calculatein(graph, indeg);
    Queue<Integer> q=new LinkedList<>();
    for(int i=0;i<indeg.length;i++){
        if(indeg[i]==0){
            q.add(i);
        }
    }
        //BFs
        while (!q.isEmpty()) {
            int curr=q.remove();
            System.out.print(curr);
            
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
   }
    public static void main(String args[]){
         int V=6;
        ArrayList<Edge> graph[]=new ArrayList[V];
        creategraph(graph);
        topsort(graph);
    }
}
