class Solution {
   
    public int numIslands(char[][] grid) {
        int count=0;
        int m= grid.length;
        int n= grid[0].length;
        boolean [][] vis= new boolean[m][n];
        int[][] dir= {{1,0} ,{0,1} ,{0,-1},{-1,0} };
        Queue<int[]> que= new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'  && !vis[i][j]){
                    count++;
                    que.offer(new int[]{i,j});
                    vis[i][j]= true;
                    while(!que.isEmpty()){
                        int [] curr= que.poll();
                        int r= curr[0];
                        int c= curr[1];
                        for( int [] d: dir){
                            int nr= r+d[0];
                            int nc= c+ d[1];
                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1'&& !vis[nr][nc]){
                                vis[nr][nc]=true;
                                que.offer(new int[]{nr,nc});
                            }
                        }

                    }

                }
            }
        }  
        return count;
    }
  
}