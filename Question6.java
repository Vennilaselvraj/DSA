import java.util.*;
class Edge{
    int src,dest,w,pri;
    Edge(int src,int dest,int w,int pri){
        this.src=src;
        this.dest=dest;
        this.w=w;
        this.pri=pri;
    }
}
class DisjointSet{
    int parent[];
    DisjointSet(int n){
        parent=new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i] = i;
        }
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    boolean union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB) return false;
        parent[rootA]=rootB;
        return true;
    }
}
class Graphj{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        List<Edge> l=new ArrayList<>();
        int E=sc.nextInt();
        for(int i=0;i<E;i++){
            System.out.println("Enter the edges:");
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            int pri=sc.nextInt();
            l.add(new Edge(u,v,w,pri));
        }
        l.sort((e1,e2)->{
            if(e1.w!=e2.w){
                return Integer.compare(e1.w,e2.w);
            }
            else{
                return Integer.compare(e2.pri,e1.pri);
            }
        });
        DisjointSet ds=new DisjointSet(V);
        int sum=0,edgesused=0;
        List<Edge> mst=new ArrayList<>();
        for(Edge b:l){
            if(ds.union(b.src,b.dest)){
                mst.add(b);
                sum+=b.w;
                edgesused++;
                if(V-1==edgesused) break;
            }
        }
        System.out.println("Edges in MST:");
        for(Edge s:mst){
            System.out.println(s.src+" "+s.dest+" "+s.w+" "+s.pri);
        }
        System.out.println("Minimum cost : "+sum);
    }
}
