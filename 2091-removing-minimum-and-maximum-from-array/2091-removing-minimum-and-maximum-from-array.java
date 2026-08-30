class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int mn=Integer.MAX_VALUE;
        int mx=Integer.MIN_VALUE;
        int mni=-1,mxi=-1;
        for(int i=0;i<n;i++){
            if(mx<nums[i]){
                mx=nums[i];
                mxi=i;
            }
            if(mn>nums[i]){
                mn=nums[i];
                mni=i;
            }
        }
        int high=mni>mxi?mni:mxi;
        int low=mni>mxi?mxi:mni;
        int l=high+1;
        int r=n-low;
        int c=low+1+n-high;
        return Math.min(c,Math.min(l,r));
    }
}