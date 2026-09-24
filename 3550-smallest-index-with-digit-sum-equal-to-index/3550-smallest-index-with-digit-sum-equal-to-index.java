class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int t=nums[i];
            int s=0;
            while(t>0){
                s+=(t%10);
                t/=10;
            }
            if(s==i) return i;
        }
        return -1;
    }
}