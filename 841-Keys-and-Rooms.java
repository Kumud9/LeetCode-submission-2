class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] visited= new boolean[rooms.size()];
        dfs(rooms.get(0),0,rooms,visited);
        for(int i=0;i<visited.length;i++){
            if(!visited[i])return false;
        }
        return true;
    }
    public void dfs(List<Integer>list, int room, List<List<Integer>> rooms,boolean [] vis){
        vis[room]=true;
        for(Integer i: list){
            if(!vis[i]){
                dfs(rooms.get(i),i,rooms,vis);
            }
        }
    }
}