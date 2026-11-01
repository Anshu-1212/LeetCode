// class Solution {
//     public int minInsertions(String s) {
//         int n=s.length();
//         int x=lgPalSubSeq(s);
//         return n-x;
//     }
//     public int lgPalSubSeq(String s) {
//         int n=s.length();
//         if(n==1) return 1;
//         int[][]dp=new int[n][n];
//         for(int[]a:dp) Arrays.fill(a,-1);
//         return helper(s,0,s.length()-1,dp);
//     }
//     public int helper(String s,int i,int j,int[][]dp){
//         if(i>j) return 0;
//         if(i==j) return 1;
//         if(dp[i][j]!=-1) return dp[i][j];
//         if(s.charAt(i)==s.charAt(j)) return dp[i][j]=2+helper(s,i+1,j-1,dp);
//         else return dp[i][j]=Math.max(helper(s,i+1,j,dp),helper(s,i,j-1,dp));
//     }
// }
class Solution {
    public int minInsertions(String s) {
        StringBuilder s1=new StringBuilder(s);
        StringBuilder s2=new StringBuilder(s).reverse();
        int n=s.length();
        int[][]dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int x=dp[n][n];
        return n-x;
    }
}