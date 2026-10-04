// class Solution {
//     public int splitArray(int[] nums, int k) {
//         int n=nums.length;
//         int[][]dp=new int[n][k+1];
//         for(int[]a:dp) Arrays.fill(a,-1);
//         return helper(nums,0,k,dp);
//     }
//     public int helper(int[] nums,int i,int k,int[][]dp) {
//         int n=nums.length;
//         if(k==0 && i<n) return Integer.MAX_VALUE;
//         if(i>=n || k<=0) return 0;
//         if(dp[i][k]!=-1) return dp[i][k];
//         int sum=0;
//         int ans=Integer.MAX_VALUE;
//         for(int j=i;j<=n-k;j++){
//             sum+=nums[j];
//             int val=helper(nums,j+1,k-1,dp);
//             int s=Math.max(sum,val);
//             ans=Math.min(ans,s);
//         }
//         return dp[i][k]=ans;
//     }
// }
class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int mx=-1,sum=0;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            sum+=nums[i];
        }
        int l=mx,r=sum,ans=-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(isPos(nums,k,m)){
                ans=m;
                r=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
    public boolean isPos(int[] nums,int k,int sum) {
        int nos=1,s=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(s+nums[i]>sum){
                nos++;
                s=0;
            }
            s+=nums[i];
        }
        return nos<=k;
    }
}