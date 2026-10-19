class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean [][] vis= new boolean [n][n];
        PriorityQueue<int []> pq= new PriorityQueue<>(
            (a,b)->a[0]-b[0]
        );
        pq.add(new int [] {grid[0][0],0,0});
        int [][] dir= {
            {1,0},{0,1},{0,-1},{-1,0}
        };
        while(!pq.isEmpty()){
          int [] cur= pq.poll();
          int time= cur[0];
          int r=cur[1];
          int c= cur[2];

         if(vis[r][c])continue;
         vis[r][c]= true;
         if(r==n-1 && c==n-1)return time;

         for(int [] d: dir){
           int nr= r+d[0];
           int nc= c+d[1];
            if(nr<0 || nc <0 || nr>=n || nc>=n)continue;
            
            pq.add(new int [] {Math.max(time,grid[nr][nc]),nr,nc});
         }
        }
        return -1;
    }
}