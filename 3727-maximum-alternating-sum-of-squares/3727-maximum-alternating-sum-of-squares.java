class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0) nums[i]=-nums[i];
        }
        Arrays.sort(nums);
        long sans=0;
        // int s=n%2==0?n/2-1:n/2;
        int s=n/2-1,i=0;
        for(;i<=s;i++){
            sans-=(nums[i]*nums[i]);
        }
        for(;i<n;i++){
            sans+=(nums[i]*nums[i]);
        }
        return sans;
    }
}