class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n][n];
        for(int[]d:dp) Arrays.fill(d,-1);
        return helper(nums,0,n-1,dp);
    }
    public int helper(int[]nums,int i,int j,int[][]dp){
        int n=nums.length;
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mx=0;
        for(int k=i;k<=j;k++){
            // int val=(k-1>=i?nums[k-1]:1)*nums[k]*(k+1<=j?nums[k+1]:1);
            int val = (i > 0 ? nums[i-1] : 1)*nums[k]*(j < n-1 ? nums[j+1] : 1);
            int score=val+helper(nums,i,k-1,dp)+helper(nums,k+1,j,dp);
            mx=Math.max(mx,score);
        }
        return dp[i][j]=mx;
    }
}