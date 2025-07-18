package Disjoint;
public class Ques{
    static int n=7;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static void init(){
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    //for the find
    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    //for the union
    public static void union(int a,int b){
        int parA=find(a);//Find the par of A and store it into parA
        int parb=find(b);//find the par of B and store it into par b
        if(rank[parA]==rank[parb]){//if the rank of a and b are eqaul than we can make any one par 
            par[parb]=parA;//in this case we had make parent of b is a 
            rank[parA]++;//increse the rank of A
        }else if(rank[parA]<rank[parb]){
            par[parA]=parb;
        }else{
            par[parb]=parA;
        }
    }
    public static void main(String args[]){
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
    }
}