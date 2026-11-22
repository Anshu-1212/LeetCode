class Solution {
    public int countDominantElements(int[] nums) {
        int n=nums.length,c=0;
        if(n<2) return 1;
        if(nums[1]<=nums[0]) c++;
        if(nums[n-2]<=nums[n-1]) c++;
        for(int i=1;i<n-1;i++){
            if((double)(nums[i+1]+nums[i-1])/2<=nums[i]) c++;
        }
        return c;
    }
}