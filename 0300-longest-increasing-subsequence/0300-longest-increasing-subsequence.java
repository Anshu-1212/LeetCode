// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         int ans=0;
//         for (int i = 0; i < n; i++) {
//             int mx = 0;
//             for (int j = 0; j < i; j++) {
//                 if (nums[i] > nums[j]) mx = Math.max(mx, dp[j]);
//             }
//             dp[i] = 1 + mx;
//             ans=Math.max(ans,dp[i]);
//         }
//         return ans;
//     }
// }
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        helper(nums,0,dp);
        int ans=0;
        for(int i=0;i<n;i++) ans=Math.max(ans,dp[i]);
        return ans;
    }
    public int helper(int[]nums,int i,int[]dp){
        int n=nums.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int mx=0;
        for(int j=0;j<i;j++){
            if(nums[i]>nums[j]) mx=Math.max(mx,helper(nums,j,dp));
        }
        dp[i]=1+mx;
        helper(nums,i+1,dp);
        return dp[i];
    }
}
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][]dp=new int[n+1][n+1];
//         for(int i=1;i<=n;i++) dp[i][0]=1;
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n;j++){
//                 int skip=dp[i-1][j];
//                 int take=0;
//                 if(nums[i-1]>nums[j-1]) take=1+dp[i-1][i];
//                 dp[i][j]=Math.max(take,skip);
//             }
//         }
//         int mx=0;
//         for(int j=0;j<=n;j++) mx=Math.max(mx,dp[n][j]);
//         return mx;
//     }
//     // public int helper(int[]nums,int i,int pi){       //call helper(nums,0,-1);
//     //     int n = nums.length;
//     //     if(i>=n) return 0;
//     //     int skip=helper(nums,i+1,pi);
//     //     int take=0;
//     //     if(pi!=-1 || nums[i]>nums[pi]) take=1+helper(nums,i+1,i);
//     //     return Math.max(skip,take);
//     // }
//     // public int helper(int[]nums,int i,int pi){       //call helper(nums,n-1,n);
//     //     int n = nums.length;
//     //     if(i<0) return 0;
//     //     int skip=helper(nums,i-1,pi);
//     //     int take=0;
//     //     if(pi!=n || nums[i]>nums[pi]) take=1+helper(nums,i-1,i);
//     //     return Math.max(skip,take);
//     // }
// }