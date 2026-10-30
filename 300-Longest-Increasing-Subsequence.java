class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][] dp= new int [nums.length][nums.length+1];
        for(int [] rows : dp){
            Arrays.fill(rows,-1);
        }
        return solve(0,-1,nums,dp);
    }
    public int solve(int idx, int prev, int [] nums, int [][] dp){
        if(idx==nums.length)return 0;
         if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
        // take
        int ntake= solve(idx+1,prev,nums,dp);
             
        int take=0;
        if(prev==-1 || nums[idx]> nums[prev]){
            take= solve(idx+1,idx, nums,dp)+1;
        }
        return dp[idx][prev+1]=Math.max(take,ntake);

    }
}