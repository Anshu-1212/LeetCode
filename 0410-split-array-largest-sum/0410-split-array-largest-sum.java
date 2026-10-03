class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int[][]dp=new int[n][k+1];
        for(int[]a:dp) Arrays.fill(a,-1);
        return helper(nums,0,k,dp);
    }
    public int helper(int[] nums,int i,int k,int[][]dp) {
        int n=nums.length;
        if(k==0 && i<n) return Integer.MAX_VALUE;
        if(i>=n || k<=0) return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        int sum=0;
        int ans=Integer.MAX_VALUE;
        for(int j=i;j<=n-k;j++){
            sum+=nums[j];
            int val=helper(nums,j+1,k-1,dp);
            int s=Math.max(sum,val);
            ans=Math.min(ans,s);
        }
        return dp[i][k]=ans;
    }
}