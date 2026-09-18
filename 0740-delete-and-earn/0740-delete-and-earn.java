class Solution {
    public int deleteAndEarn(int[] arr) {
        int mx=Integer.MIN_VALUE;
        for (int x:arr) {
            mx=Math.max(mx,x);
            
        }
        int[]dp=new int[mx+1];
        int[]f=new int[mx+1];
        for(int e:arr) f[e]++;
        Arrays.fill(dp,-1);
        return helper(f,0,dp);
    }
    public int helper(int[]arr,int i,int[]dp){
        int n=arr.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int skip=helper(arr,i+1,dp);
        int take=arr[i]*i+helper(arr,i+2,dp);
        return dp[i]=Math.max(take,skip);
    }
}