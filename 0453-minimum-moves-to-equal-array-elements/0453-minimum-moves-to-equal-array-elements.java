class Solution {
    public int minMoves(int[] nums) {
        int mn=Integer.MAX_VALUE,n=nums.length;
        for(int i=0;i<n;i++) mn=Math.min(mn,nums[i]);
        int sans=0;
        for(int i=0;i<n;i++){
            sans+=(nums[i]-mn);
        }
        return sans;
    }
}