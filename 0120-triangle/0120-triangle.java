class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size(),i,j,m;
        int[][]dp=new int[n][n];
        dp[0][0]=triangle.get(0).get(0);
        for(i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
        }
        for(i=1;i<n;i++){
            m=triangle.get(i).size();
            for(j=1;j<m-1;j++){
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i-1][j],dp[i-1][j-1]);
            }
            dp[i][j]=triangle.get(i).get(j)+dp[i-1][j-1];
        }
        int mn=Integer.MAX_VALUE;
        for(j=0;j<n;j++){
            mn=Math.min(mn,dp[n-1][j]);
        }
        return mn;
    }
}