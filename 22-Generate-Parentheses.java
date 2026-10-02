class Solution {
    public List<String> generateParenthesis(int n) {
       List<String > ans= new ArrayList<>();
       back(ans,n,"",0,0);
       return ans; 
    }
    public void back(List<String> ans, int n,String s,int op, int cl){
        if(s.length()==n*2){
            ans.add(s);
            return;
        }
        if(op<n){
         back(ans, n, s+"(",op+1,cl);

        }
        if(cl<op){
            back(ans,n,s+")",op,cl+1);
        }
    }
}