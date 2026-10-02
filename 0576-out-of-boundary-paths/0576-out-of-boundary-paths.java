// class Solution {
//     int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
//     public int findPaths(int m, int n, int mx, int r, int c) {
//         return helper(m,n,r,c,mx);
//     }
//     public int helper(int m,int n,int i,int j,int move){
//         if(i<0 || j<0 || i>=m || j>=n) return 1;
//         if(move<=0) return 0;
//         int ans=0;
//         for(int[]d:dir){
//             ans+=helper(m,n,i+d[0],j+d[1],move-1);
//         }
//         return ans;
//     }
// }
class Solution {
    int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int mx, int r, int c) {
        int[][][]dp=new int[m][n][mx+1];
        for(var a:dp){
            for(var b:a) Arrays.fill(b,-1);
        }
        return helper(m,n,r,c,mx,dp);
    }
    public int helper(int m,int n,int i,int j,int move,int[][][]dp){
        if(i<0 || j<0 || i>=m || j>=n) return 1;
        if(move<=0) return 0;
        if(dp[i][j][move]!=-1) return dp[i][j][move];
        int ans=0;
        for(int[]d:dir){
            ans=(ans+helper(m,n,i+d[0],j+d[1],move-1,dp))%mod;
        }
        return dp[i][j][move]=ans;
    }
}