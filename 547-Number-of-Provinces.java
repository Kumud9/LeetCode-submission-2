 class  DSU{
    int [] parent ,size;
          DSU(int n){
            parent= new int [n+1];
            size= new int [n+1];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
          }
               int findParent(int x){
            if(parent[x]==x)return x;
            return parent[x]=findParent(parent[x]);

        }
        
          void union(int u, int v){
            int pu=findParent(u);
            int pv=findParent(v);

            if(pu==pv)return;
            if(size[pu]<size[pv]){
                parent[pu]=pv;
                size[pv]+=size[pu];
            }else{
                   parent[pv]=pu;
                size[pu]+=size[pv];
            }
        }

 }     
class Solution {

    public int findCircleNum(int[][] isConnected) {
        
       int n= isConnected.length;
       DSU dsu= new DSU(n);
       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(isConnected[i][j]==1){
                dsu.union(i,j);
            }
        }
       }
       int p=0;
       for(int i=0;i<n;i++){
        if(dsu.findParent(i)==i)p++;
       }
       return p;

    }
}