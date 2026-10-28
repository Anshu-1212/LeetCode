class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int[]zero=new int[len];
        int[]one=new int[len];
        for(int i=0;i<len;i++){
            String s=strs[i];
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)-'0'==0) zero[i]++;
                else one[i]++;
            }
        }
        int[][][]dp=new int[len+1][m+1][n+1];
        for(int i=1;i<=len;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    if(zero[i-1]>j || one[i-1]>k) dp[i][j][k]=dp[i-1][j][k];
                    else dp[i][j][k]=Math.max(dp[i-1][j][k],1+dp[i-1][j-zero[i-1]][k-one[i-1]]);
                }
            }
        }
        return dp[len][m][n];
    }
}