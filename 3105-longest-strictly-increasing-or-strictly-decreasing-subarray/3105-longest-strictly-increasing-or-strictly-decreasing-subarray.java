class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        if(n==1) return n;
        int ans=0,li=1,ld=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                li++;
            }
            else{
                ans=Math.max(ans,li);
                li=1;
            }
            if(nums[i]<nums[i-1]){
                ld++;
            }
            else{
                ans=Math.max(ans,ld);
                ld=1;
            }
        }
        ans=Math.max(ans,Math.max(li,ld));
        return ans;
    }
}