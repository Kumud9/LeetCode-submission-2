class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> list= new ArrayList<>();
        list.add(0);
        dfs(0,graph,ans,list,graph.length-1);
        return ans;
    }
    public void dfs(int src, int[][]graph,List<List<Integer>> ans,List<Integer> list,int dest){
        if(src==dest){
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int n: graph[src]){
           list.add(n);
           dfs(n,graph,ans,list,dest);
           list.remove(list.size()-1); 
        }
    }
}