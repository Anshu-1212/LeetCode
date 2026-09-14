// class Solution {
//     public int climbStairs(int n, int[] costs) {
//         return helper(n,costs);
//     }
//     public int helper(int n, int[] costs) {
//         if(n<=0) return 0;
//         int a=1+helper(n-1,costs);
//         int b=4+helper(n-2,costs);
//         int c=9+helper(n-3,costs);
//         return costs[n-1]+Math.min(a,Math.min(b,c));
//     }
// }
// class Solution {
//     public int climbStairs(int n, int[] costs) {
//         int[]dp=new int[n+1];
//         Arrays.fill(dp,-1);
//         return helper(n,costs,dp);
//     }
//     public int helper(int n, int[] costs,int[]dp) {
//         if(n<=0) return 0;
//         if(dp[n]!=-1) return dp[n];
//         int a=1+helper(n-1,costs,dp);
//         int b=4+helper(n-2,costs,dp);
//         int c=9+helper(n-3,costs,dp);
//         return dp[n]=costs[n-1]+Math.min(a,Math.min(b,c));
//     }
// }
class Solution {
    public int climbStairs(int n, int[] costs) {
        int[]dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int a=1+((i-1>=0)?dp[i-1]:0);
            int b=4+((i-2>=0)?dp[i-2]:0);
            int c=9+((i-3>=0)?dp[i-3]:0);
            dp[i]=costs[i-1]+Math.min(a,Math.min(b,c));
        }
        return dp[n];
    }
}