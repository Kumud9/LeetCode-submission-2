class Solution {
    public boolean isMatch(String s, String p) {
      return abc(0,s,0,p,new Boolean [s.length()+1][p.length()+1]);
    }
    public boolean abc(int i, String s, int j,String p, Boolean[][] memo){
        if (memo[i][j] != null) return memo[i][j];
        if(j==p.length())
        return memo[i][j]=( i==s.length());
        
       boolean firstmatch = (i < s.length()) &&
                             (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans;
        if(j+1<p.length() && p.charAt(j+1)=='*'){
             ans= abc(i,s,j+2,p,memo) ||
                  (firstmatch && abc(i+1,s,j,p,memo));
        }else{
             ans= firstmatch && abc(i+1,s,j+1,p,memo);
        }
        return memo[i][j]=ans;
    }
}