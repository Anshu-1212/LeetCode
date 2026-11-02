class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length,sans=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            sans+=Math.abs(nums[n/2]-nums[i]);
        }
        return sans;
    }
}