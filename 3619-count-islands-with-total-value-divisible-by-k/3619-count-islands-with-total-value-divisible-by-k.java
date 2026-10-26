class Solution {
    int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int countIslands(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        Queue<int[]>q=new ArrayDeque<>();
        boolean[][]vis=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] || grid[i][j]==0) continue;
                long s=grid[i][j];
                vis[i][j]=true;
                q.add(new int[]{i,j});
                while(!q.isEmpty()){
                    int[]t=q.poll();
                    int x=t[0],y=t[1];
                    for(int[]d:dir){
                        int nx=x+d[0];
                        int ny=y+d[1];
                        if(nx<0 || ny<0 || nx>=n || ny>=m || grid[nx][ny]==0 || vis[nx][ny]) continue;
                        s+=grid[nx][ny];
                        vis[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                    }
                }
                if(s%k==0) ans++;
            }
        }
        return ans;
    }
}