class DSU{
    int [] parent;
    int size[];
    DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=1;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);


    }
    void union (int x,int y){
        int rootA= find(x);
        int rootB=find(y);
        if(rootA==rootB)return;

        if(size[rootA]<size[rootB]){
            int temp=rootA;
            rootA= rootB;
            rootB= temp;

        
        }
        parent[rootB]=rootA;
      size[rootA] += size[rootB];

    }
    boolean connected(int x, int y){
        return find(x)==find(y);
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        DSU dsu= new DSU(n);
        for(int [] e: edges){
            int u= e[0];
            int v= e[1];

            if(dsu.connected(u,v))return e;

            dsu.union(u,v);
        }

        return new int [0];

    }
}