class DSU{
    int [] parent;
    int [] size;
    DSU(int n){
        parent= new int [n+1];
        size= new int [n+1];
        for(int i=1;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    void union(int u, int v){
        int pu = find(u);
        int pv= find(v);

        if(pu==pv)return ;
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
    public boolean equationsPossible(String[] equations) {
        DSU dsu= new DSU(26);
        for(String e: equations){
            if(e.charAt(1)=='='){
                int u= e.charAt(0)-'a';
                int v= e.charAt(3)-'a';

                dsu.union(u,v);
            }
        }
        for(String e: equations){
            if(e.charAt(1)=='!'){
                int u= e.charAt(0)-'a';
                int v= e.charAt(3)-'a';

               if(dsu.find(u)==dsu.find(v))return false;
            }
        }
       return true;
    }
}