class Solution {
    public int minMoves(int[] nums) {
        int mx=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++) mx=Math.max(mx,nums[i]);
        int ans=0;
        for(int i=0;i<n;i++) ans+=(mx-nums[i]);
        return ans;
    }
}