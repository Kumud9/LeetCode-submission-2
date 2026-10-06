class Solution {
    public int orangesRotting(int[][] grid) {

        int rows= grid.length;
        int col= grid[0].length;

        Queue<int []> q= new LinkedList<>();
        int fresh =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2)q.add(new int []{i,j});
                else if(grid[i][j]==1)fresh++;
            }
        } 
        if(fresh==0)return 0;
        int min=-1;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int size= q.size();
            min++;
            while(size-- > 0){
                int [] curr= q.poll();

                for(int []d: dir){
                    int x= curr[0]+d[0];  //new row
                    int y= curr[1]+d[1];  // new col

                    if(x<0|| y<0|| x>=rows|| y>= col|| grid[x][y]!=1)continue;

                    grid[x][y]=2; // oranges are now rotten
                    fresh--;
                    q.add(new int[]{x,y});
                }
            }
        }
        if(fresh==0)return min;
        else return -1;
    }
}