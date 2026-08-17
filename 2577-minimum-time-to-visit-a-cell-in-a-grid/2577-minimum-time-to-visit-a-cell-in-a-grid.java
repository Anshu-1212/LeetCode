// class Solution {
//     public int minimumTime(int[][] grid) {
//         int n=grid.length,m=grid[0].length;
//         int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
//         PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
//         int[][]ans=new int[n][m];
//         for(int[]a:ans) Arrays.fill(a,Integer.MAX_VALUE);
//         ans[0][0]=0;
//         pq.add(new int[]{0,0,0});
//         while(!pq.isEmpty()){
//             int[]t=pq.poll();
//             int x=t[0],y=t[1],wt=t[2];
//             if(x==n-1 && y==m-1) return ans[n-1][m-1];
//             if(wt>ans[x][y]) continue;
//             for(int[]d:dir){
//                 int nx=x+d[0],ny=y+d[1];
//                 if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
//                 int twt=wt+1;
//                 if(twt<grid[nx][ny]) continue;
//                 if(twt>=ans[nx][ny]) continue;
//                 ans[nx][ny]=twt;
//                 pq.add(new int[]{nx,ny,twt});
//             }
//         }
//         return ans[n-1][m-1]==Integer.MAX_VALUE?-1:ans[n-1][m-1];
//     }
// }
class Solution {
    public int minimumTime(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        if(grid[0][1]>1 && grid[1][0]>1) return -1;
        int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int[][]ans=new int[n][m];
        for(int[]a:ans) Arrays.fill(a,Integer.MAX_VALUE);
        ans[0][0]=0;
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[]t=pq.poll();
            int x=t[0],y=t[1],wt=t[2];
            if(x==n-1 && y==m-1) return ans[n-1][m-1];
            if(wt>ans[x][y]) continue;
            for(int[]d:dir){
                int nx=x+d[0],ny=y+d[1];
                if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                int twt=wt+1;
                if(twt>=grid[nx][ny]){
                    if(twt>=ans[nx][ny]) continue;
                    ans[nx][ny]=twt;
                    pq.add(new int[]{nx,ny,twt});
                }
                else{
                    int diff=grid[nx][ny]-twt;
                    if(diff%2==0) twt=grid[nx][ny];
                    else twt=grid[nx][ny]+1;
                    if(twt>=ans[nx][ny]) continue;
                    ans[nx][ny]=twt;
                    pq.add(new int[]{nx,ny,twt});
                }
            }
        }
        return ans[n-1][m-1]==Integer.MAX_VALUE?-1:ans[n-1][m-1];
    }
}