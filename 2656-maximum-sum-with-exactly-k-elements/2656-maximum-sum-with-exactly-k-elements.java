class Solution {
    public int maximizeSum(int[] nums, int k) {
        int mx=Integer.MIN_VALUE;
        for(int a:nums) mx=Math.max(mx,a);
        int sum=0;
        for(int i=0;i<k;i++) sum+=(mx+i);
        return sum;
    }
}