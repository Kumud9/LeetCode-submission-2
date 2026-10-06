class Solution {
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O')dfs(board,i,0);

            if (board[i][m - 1] == 'O')
                dfs(board, i, m - 1);
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O')dfs(board,0,i);
             if (board[n-1][i] == 'O')
                dfs(board, n-1,i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='#')board[i][j]='O';
            }
        }
    }
    void dfs(char [][]  b, int r, int c){
        if(r<0 || c<0|| r>=b.length|| c>= b[0].length || b[r][c]!='O')return ;
        b[r][c]='#';
         dfs(b,r+1,c);
         dfs(b,r-1,c);
         dfs(b,r,c+1);
         dfs(b,r,c-1);
    }
}