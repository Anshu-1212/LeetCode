// class Solution {
//     int ans = 0;

//     public int findTargetSumWays(int[] nums, int target) {
//         helper(nums, target, 0);
//         return ans;
//     }

//     public void helper(int[] nums, int target, int i) {
//         if (i == nums.length) {
//             if (target == 0)
//                 ans++;
//             return;
//         }
//         helper(nums, target + nums[i], i + 1);
//         helper(nums, target - nums[i], i + 1);
//     }
// }

// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         return helper(nums, target, 0);
//     }

//     public int helper(int[] nums, int target, int i) {
//         if (i == nums.length) {
//             if (target == 0)
//                 return 1;
//             else
//                 return 0;
//         }
//         int c = 0;
//         c += helper(nums, target + nums[i], i + 1);
//         c += helper(nums, target - nums[i], i + 1);
//         return c;
//     }
// }

// class Solution {
//     // int sum;
//     int tarSubSum;
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length,sum=0;
//         for(int ele: nums)sum+=ele;
//         tarSubSum=target-sum;
//         int[][] dp = new int[n][2*sum+1];
//         for (int[] a : dp)
//             Arrays.fill(a, -1);
//         return helper(nums, target, 0, dp);
//     }

//     public int helper(int[] nums, int target, int i, int[][] dp) {
//         if (i == nums.length) {
//             if (target == 0) return 1;
//             else return 0;
//         }
//         if (dp[i][target-tarSubSum] != -1) return dp[i][target-tarSubSum];
//         int add= helper(nums, target + nums[i], i + 1, dp);
//         int sub= helper(nums, target - nums[i], i + 1, dp);
//         return dp[i][target-tarSubSum] = add+sub;
//     }
// }
class Solution {
    // int sum;
    int tarSubSum;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length,sum=0;
        for(int ele: nums)sum+=ele;
        if(Math.abs(target)>sum) return 0;
        // tarSubSum=target-sum;
        int[][] dp = new int[n+1][2*sum+1];
        // Arrays.fill(dp[0],Integer.MAX_VALUE/2);
        dp[0][sum]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=2*sum;j++){
                if(j-nums[i-1]>=0) dp[i][j]+=dp[i-1][j-nums[i-1]];
                if(j+nums[i-1]<=2*sum) dp[i][j]+=dp[i-1][j+nums[i-1]];
            }
        }
        return dp[n][target+sum];
    }
}