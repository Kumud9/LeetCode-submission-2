class DSU{
    int [] parent;
    int [] size;
    DSU(int n){
        parent= new int[n+1];
        size= new int[n+1];
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
        int pu= find(u);
        int pv= find(v);
        if(pu==pv)return ;
        if(size[pu]<size[pv]){
            parent[pu]=pv;
            size[pv]+=pu;
        }else{
            parent[pv]=pu;
            size[pu]+=pv;
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
     

        int n=accounts.size();
        DSU dsu= new DSU(n);
        Map<String,Integer> map= new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail= accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    dsu.union(i,map.get(mail));
                }else{
                    map.put(mail,i);
                }
            }
        }
      ArrayList<String> []merge= new ArrayList[n];
      for(int i=0;i<n;i++){
        merge[i]=new ArrayList<>();
      }
       for(Map.Entry<String,Integer> it: map.entrySet()){
        int node= dsu.find(it.getValue());
        merge[node].add(it.getKey());
       }

       List<List<String>> ans= new ArrayList<>();
       for(int i=0;i<n;i++){
        if(merge[i].isEmpty())continue;
        Collections.sort(merge[i]);
        List<String> temp=new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        temp.addAll(merge[i]);
        ans.add(temp);
       }
        
       return ans;
    }
}