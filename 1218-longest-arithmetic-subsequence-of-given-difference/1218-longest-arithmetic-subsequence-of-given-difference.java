class Solution {
    public int longestSubsequence(int[] nums, int d) {
        int n=nums.length;
        int mx=Integer.MIN_VALUE;
        int mn=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            mn=Math.min(mn,nums[i]);
        }
        int len=mx-mn+1;
        int[]dp=new int[len];
        HashSet<Integer>set=new HashSet<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(set.contains(nums[i]-d)){
                if(nums[i]-mn-d>=0 && nums[i]-mn-d<len)dp[nums[i]-mn]=1+dp[nums[i]-mn-d];
                ans=Math.max(ans,dp[nums[i]-mn]);
            }
            set.add(nums[i]);
        }
        return ans+1;
    }
}