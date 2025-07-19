package KosarajuAlgo;

import java.util.ArrayList;
import java.util.Stack;

public class Ques {
    static class Edges{
        int src;
        int dest;
        int wt;
        Edges(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void creategraph(ArrayList<Edges> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edges(0, 2, 0));
        graph[0].add(new Edges(0, 3, 0));

        graph[1].add(new Edges(1, 0, 0));
        graph[2].add(new Edges(2, 1, 0));
        graph[3].add(new Edges(3, 4, 0));

    }

    public static void topsort(ArrayList<Edges> graph[],int curr,Stack<Integer> s,boolean vis[]){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){

            Edges e=graph[curr].get(i);
            if(!vis[e.dest]){
                topsort(graph, e.dest, s, vis);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edges> graph[],int curr,boolean vis[]){
        vis[curr]=true;
        System.out.println(curr);
        for(int i=0;i<graph[curr].size();i++){
            Edges e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static void Kosaraju(ArrayList<Edges> graph[],int v){
        //step1 -topology sorting
        Stack<Integer> s=new Stack<>();
        boolean vis[]=new boolean[v];
        //store topology sorting in Stack
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topsort(graph, i, s, vis);
            }
        }

        //step2- transepose the graph
         ArrayList<Edges> transpose[]=new ArrayList[v];
         for(int i=0;i<graph.length;i++){
            vis[i]=false;//reinitailized
            transpose[i]=new ArrayList<>();
         }       
         
         for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edges e=graph[i].get(j);//e.src->e.dest
                transpose[e.dest].add(new Edges(e.dest, e.src, 0));
            }
         }

         //step 3
         while(!s.isEmpty()){
            int curr=s.pop();
            if(!vis[curr]){
                System.out.println("Strongly connected graph ->");
                dfs(transpose,curr,vis);
                System.err.println();
            }
         }
    }
    public static void main(String args[]){
        int v=5;
        ArrayList<Edges> graph[]=new ArrayList[v];
        creategraph(graph);
        Kosaraju(graph,v);
    }
}