class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length,p=1,r=0,l=0,ans=0;
        for(;r<n;){
            if(gcd(p,nums[r])==1){
                p*=nums[r];
                r++;
            }
            else{
                while(gcd(p,nums[r])!=1){
                    p/=nums[l];
                    l++;
                }
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans-1<2?2:ans-1;
    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}