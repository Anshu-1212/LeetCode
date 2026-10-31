class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int[][]dp=new int[n][1001];
        dp[1][nums[1]-nums[0]+500]=2;
        int ans=2;
        for(int i=2;i<n;i++){
            int lmx=0;
            for(int j=0;j<i;j++){
                int d=nums[i]-nums[j]+500;
                int a=dp[j][d];
                if(a==0) dp[i][d]=Math.max(dp[i][d],2);
                else dp[i][d]=Math.max(dp[i][d],1+dp[j][d]);
                ans=Math.max(ans,dp[i][d]);
            }
        }
        return ans;
    }
}