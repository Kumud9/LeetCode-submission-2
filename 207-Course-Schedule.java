class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
      List<List<Integer>> adj= new ArrayList<>();
      List<Integer> ans= new ArrayList<>();

          for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pr : prerequisites) {
            adj.get(pr[1]).add(pr[0]);    
        }
       boolean [] vis= new boolean[n];
       boolean [] path= new boolean[n];
  for(int i=0;i<n;i++){
    if(!vis[i] && dfs(i, adj, vis, path))return false;
  }
  return true;
 


    }
    public boolean dfs(int i, List<List<Integer>> adj, boolean[] vis, boolean[] path){
        vis[i]=path[i]= true;
        for(int next: adj.get(i)){
            if(!vis[next] && dfs(next,adj,vis,path))return true;
            else if(path[next])return true;
        }
        path[i]= false;
        return false;
    }
}