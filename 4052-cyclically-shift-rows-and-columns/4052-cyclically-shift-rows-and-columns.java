class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][]ans=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int c=(j-rowShift[i]+n)%n;
                ans[(i-colShift[c]+n)%n][c]=grid[i][j];
            }
        }
        return ans;
    }
}