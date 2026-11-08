class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int[]r=new int[n];
        int[]c=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int sans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && (r[i]>1 || c[j]>1)){
                    sans++;
                }
            }
        }
        return sans;
    }
}