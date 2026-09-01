class Solution {
    public void gameOfLife(int[][] board) {
        int[][]dir={{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int n=board.length,m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean f=board[i][j]==1?true:false;
                int s=0;
                for(int[]d:dir){
                    int nx=i+d[0],ny=j+d[1];
                    if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
                    if(board[nx][ny]>0) s++;
                }
                board[i][j]=f?s+1:-s-1;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==3 || board[i][j]==4 || board[i][j]==-4){
                    board[i][j]=1;
                }
                else board[i][j]=0;
            }
        }
    }
}