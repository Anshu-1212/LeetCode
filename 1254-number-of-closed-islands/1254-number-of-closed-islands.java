class Solution {
    int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int closedIsland(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        Queue<int[]>q=new ArrayDeque<>();
        boolean[][]vis=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] || grid[i][j]==1) continue;
                boolean f=false;
                vis[i][j]=true;
                q.add(new int[]{i,j});
                while(!q.isEmpty()){
                    int[]t=q.poll();
                    int x=t[0],y=t[1];
                    for(int[]d:dir){
                        int nx=x+d[0];
                        int ny=y+d[1];
                        if(nx<0 || ny<0 || nx>=n || ny>=m){
                            f=true;
                            continue;
                        } 
                        if(grid[nx][ny]==1 || vis[nx][ny]) continue;
                        vis[nx][ny]=true;
                        q.add(new int[]{nx,ny});
                    }
                }
                if(!f) ans++;
            }
        }
        return ans;
    }
}