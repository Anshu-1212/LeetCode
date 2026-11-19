class Solution {
    public int minimizeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        return Math.min(nums[n-2]-nums[1],Math.min(nums[n-3]-nums[0],nums[n-1]-nums[2]));
    }
}