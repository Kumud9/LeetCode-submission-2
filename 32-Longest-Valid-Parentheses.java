class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st= new Stack<>();
       int max=0;
        int [] arr= new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
              st.push(i);
         
            }
            else{
                 if(!st.isEmpty()){
                    int x= st.pop();
                    arr[x]=1;
                    arr[i]=1;
                 }
            }

        }
        int count=0;
        for(int i=0;i<arr.length;i++){
        if(arr[i]==1){
            count++;

            max=Math.max(count, max);
        }else count=0;
        }
    return max;
    }
}