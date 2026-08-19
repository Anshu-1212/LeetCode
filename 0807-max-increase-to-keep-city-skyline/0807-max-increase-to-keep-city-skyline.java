class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, mx;
        int[] hz = new int[n];
        int[] vt = new int[n];
        for (int i = 0; i < n; i++) {
            mx = -1;
            for (int j = 0; j < n; j++)
                mx = Math.max(mx, grid[i][j]);
            hz[i] = mx;
        }
        for (int j = 0; j < n; j++) {
            mx = -1;
            for (int i = 0; i < n; i++)
                mx = Math.max(mx, grid[i][j]);
            vt[j] = mx;
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                ans+=(Math.min(hz[i],vt[j])-grid[i][j]);
            }
        }
        return ans;
    }
}