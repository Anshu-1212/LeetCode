// class Solution{
//     public boolean hasValidPath(char[][] grid) {
//         int n=grid.length,m=grid[0].length;
//         int[][]dp=new int[n][m];
//         boolean[][]dpf=new boolean[n][m];
//         dp[0][0]=grid[0][0]=='('?1:-1;
//         dpf[0][0]=dp[0][0]>=0?true:false;
//         for(int j=1;j<m;j++){
//             if(dpf[0][j-1]){
//                 dp[0][j]=dp[0][j-1]+(grid[0][j]=='('?1:-1);
//                 dpf[0][j]=dp[0][j]>=0?true:false;
//             }
//         }
//         for(int i=1;i<n;i++){
//             if(dpf[i-1][0]){
//                 dp[i][0]=dp[i-1][0]+(grid[i][0]=='('?1:-1);
//                 dpf[i][0]=dp[i][0]>=0?true:false;
//             }
//         }
//         for(int i=1;i<n;i++){
//             for(int j=1;j<m;j++){
//                 if(dpf[i-1][j] && dpf[i][j-1]){
//                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+(grid[i][j]=='('?1:-1);
//                     dpf[i][j]=dp[i][j]>=0?true:false;
//                 }
//                 if(dpf[i-1][j]){
//                     dp[i][j]=dp[i-1][j]+(grid[i][j]=='('?1:-1);
//                     dpf[i][j]=dp[i][j]>=0?true:false;
//                 }
//                 if(dpf[i][j-1]){
//                     dp[i][j]=dp[i][j-1]+(grid[i][j]=='('?1:-1);
//                     dpf[i][j]=dp[i][j]>=0?true:false;
//                 }
//             }
//         }
//         return dpf[n-1][m-1];
//     }
// }
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        Set<Integer>[][] dp = new HashSet[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        int x = grid[0][0] == '(' ? 1 : -1;
        if (x >= 0)
            dp[0][0].add(x);
        for (int j = 1; j < m; j++) {
            for (int a : dp[0][j - 1]) {
                int b = a + (grid[0][j] == '(' ? 1 : -1);
                if (b >= 0)
                    dp[0][j].add(b);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int a : dp[i - 1][0]) {
                int b = a + (grid[i][0] == '(' ? 1 : -1);
                if (b >= 0)
                    dp[i][0].add(b);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int a : dp[i][j - 1]) {
                    int b = a + (grid[i][j] == '(' ? 1 : -1);
                    if (b >= 0)
                        dp[i][j].add(b);
                }
                for (int a : dp[i - 1][j]) {
                    int b = a + (grid[i][j] == '(' ? 1 : -1);
                    if (b >= 0)
                        dp[i][j].add(b);
                }
            }
        }
        return dp[n - 1][m - 1].contains(0);
    }
}