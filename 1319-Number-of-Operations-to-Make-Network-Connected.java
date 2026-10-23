class DSU{
    int [] parent;
    int [] size;
    DSU(int n){
        parent= new int [n+1];
        size= new int [n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }

    void union(int u, int v){
        int pu= find(u);
        int pv= find(v);

        if(pu==pv)return ;
        if(size[pu]<size[pv]){
            parent[pu]= pv;
            size[pv]+=size[pu];
        }
        else{
            parent[pv]= pu;
            size[pu]+=size[pv];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
       
        int s= connections.length;
         if (connections.length < n - 1) return -1;
        DSU dsu= new DSU(n);

        for(int [] c: connections){
            dsu.union(c[0],c[1]);
        }
        int comp=0;
        for(int i=0;i<n;i++){
            if(dsu.find(i)==i)comp++;
        }
        return comp-1;

    }
}