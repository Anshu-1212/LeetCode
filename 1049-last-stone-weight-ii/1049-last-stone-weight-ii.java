class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=stones[i];
        } 
        int cap=sum/2;
        boolean[][]dp=new boolean[n+1][cap+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=cap;j++){
                if(stones[i-1]>j) dp[i][j]=dp[i-1][j];
                else dp[i][j]=(dp[i-1][j]) || (dp[i-1][j-stones[i-1]]);
            }
        }
        int ans=-1;
        for(int j=cap;j>=0;j--){
            if(dp[n][j]){
                ans=j;
                break;
            }
        }
        return Math.abs(sum-2*ans);
    }
}