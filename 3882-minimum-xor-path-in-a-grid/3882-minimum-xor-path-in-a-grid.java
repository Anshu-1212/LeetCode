// class Solution {
//     int mn = Integer.MAX_VALUE;

//     public int minCost(int[][] grid) {
//         helper(grid, 0, 0, 0);
//         return mn;
//     }

//     public void helper(int[][] grid, int i, int j, int s) {
//         if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
//             return;
//         s ^= grid[i][j];
//         if (i == grid.length - 1 && j == grid[0].length - 1) {
//             mn = mn < s ? mn : s;
//             return;
//         }
//         helper(grid, i + 1, j, s);
//         helper(grid, i, j + 1, s);
//     }
// }
class Solution {
    public int minCost(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        boolean[][][]dp=new boolean[n+1][m+1][1024];
        dp[1][1][grid[0][0]]=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1) continue;
                for(int x=0;x<1024;x++){
                    dp[i][j][x] = dp[i-1][j][x^grid[i-1][j-1]] || dp[i][j-1][x^grid[i-1][j-1]];
                }
            }
        }
        int mn=-1;
        for(int x=0;x<1024;x++){
            if(dp[n][m][x]){
                mn=x;
                break;
            }
        }
        return mn;
    }
}
