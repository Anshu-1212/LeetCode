// class Solution {
//     int[][]dir={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
//     public double knightProbability(int n, int k, int r, int c) {
//         return (double)helper(n,k,r,c)/(1<<(3*k));
//     }
//     public int helper(int n,int k,int i,int j){
//         if(i<0 || j<0 || i>=n || j>=n) return 0;
//         if(k==0){
//             return 1;
//         }
//         int ans=0;
//         for(int[]d:dir){
//             ans+=helper(n,k-1,i+d[0],j+d[1]);
//         }
//         return ans;
//     }
// }
class Solution {
    int[][]dir={{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public double knightProbability(int n, int k, int r, int c) {
        double[][][]dp=new double[n][n][k+1];
        for(var a:dp){
            for(var b:a){
                Arrays.fill(b,-1);
            }
        }
        return helper(n,k,r,c,dp);
    }
    public double helper(int n,int k,int i,int j,double[][][]dp){
        if(i<0 || j<0 || i>=n || j>=n) return 0;
        if(k==0){
            return 1;
        }
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        double ans=0;
        for(int[]d:dir){
            ans=ans+(helper(n,k-1,i+d[0],j+d[1],dp)/8);
        }
        return dp[i][j][k]=ans;
    }
}