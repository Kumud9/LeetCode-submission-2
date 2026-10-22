class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n= numCourses;
        boolean [][] mat= new boolean [n][n];
        for(int [] p: prerequisites){
            mat[p[0]][p[1]]= true;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]= mat[i][j] ||  (mat[i][k] && mat[k][j]);
                }
            }
        }
        List<Boolean> ans= new ArrayList<>();
             for(int i=0;i<queries.length;i++){
        ans.add(mat[queries[i][0]][queries[i][1]]);
      }
      return ans;
    }
}