class Solution {
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0], nums[1]);
 
        int [] a1= new int [n-1];
        int [] a2= new int [n-1];
       for(int i=0;i<n-1;i++){
        a1[i]=nums[i];
       }
         for(int i=1;i<n;i++){
        a2[i-1]=nums[i];
       }
       return Math.max(circle(a1),circle(a2));

    }
    public  int circle(int [] nums){
        int n= nums.length;
        int [] dp= new int [n];
        if(n==1)return nums[0];
        if(n==1)return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]= Math.max(dp[i-1],dp[i-2]+nums[i]);
                    }

                    return dp[n-1];
    }

}