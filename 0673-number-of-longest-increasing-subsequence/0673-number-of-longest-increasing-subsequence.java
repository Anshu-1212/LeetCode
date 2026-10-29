class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        int[]da=new int[n];
        da[0]=1;
        int ans=0;
        for(int i=0;i<n;i++){
            int mx=0;
            int a=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(mx<dp[j]){
                        mx=dp[j];
                        a=da[j];
                    }
                    else if(mx==dp[j]) a+=da[j];
                }
            }
            dp[i]=1+mx;
            if(a!=0)da[i]=a;
            else da[i]=1;
            ans=Math.max(ans,dp[i]);
        }
        int sans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==ans) sans+=da[i];
        }
        return sans;
    }
}