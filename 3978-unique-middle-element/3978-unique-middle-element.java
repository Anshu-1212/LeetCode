class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n=nums.length;
        int mid=nums[n/2],i=0,j=n-1;
        while(i<j){
            if(nums[i]==mid || nums[j]==mid) return false;
            i++;j--;
        }
        return true;
    }
}