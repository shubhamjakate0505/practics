//import java.lang.reflect.Array;
import java.util.*;
public class Prob{
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    //make the col[] and initialy give -1 color to everyone
   public static boolean isBipertite(ArrayList<Edge> graph[]){
    int col[]=new int[graph.length];
    for(int i=0;i<col.length;i++){
        col[i]=-1;//no color
    }
    Queue<Integer> q=new LinkedList<>();

    for(int i=0;i<graph.length;i++){
        if(col[i]==-1){
            q.add(i);
            col[i]=0;//give color yellow
            while (!q.isEmpty()) {
                int curr=q.remove();
                for(int j=0;j<graph[curr].size();j++){
                    Edge e=graph[curr].get(j);//neigh=e.dest
                    if(col[e.dest]==-1){
                        //if the curr[curr]==0 than make 1 otherwise 0;
                        int nextcol=col[curr]==0?1:0;
                        col[e.dest]=nextcol;
                        q.add(e.dest);
                    }else if(col[e.dest]==col[curr]){
                        return false;
                    }
                }
            }
        }
    }
    return true;
   }     
    public static void creategraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        //0
        graph[0].add(new Edge(0, 2, 0));
        graph[0].add(new Edge(0, 1, 0));
        //1
        graph[1].add(new Edge(1, 3, 0));
        graph[1].add(new Edge(1, 0, 0));
        //2
        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 4, 0));
        //3
        graph[3].add(new Edge(3, 1, 0));
       // graph[3].add(new Edge(3, 4, 0));
        //4
        graph[4].add(new Edge(4, 2, 0));
       // graph[4].add(new Edge(4, 3, 0));
    }




    public static void main(String args[]){
    int V=5;
    ArrayList<Edge> graph[]=new ArrayList[V];
    creategraph(graph);
    System.out.println(isBipertite(graph));    
    }
    
}