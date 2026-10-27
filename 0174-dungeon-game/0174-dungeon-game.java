// class Solution {
//     static int MIN=-2000;
//     public int calculateMinimumHP(int[][] dungeon) {
//         int n=dungeon.length;
//         int m=dungeon[0].length;
//         int st=1,end=Integer.MAX_VALUE,ans=0;
//         while(st<=end){
//             int mid=st+(end-st)/2;
//             if(isPos(dungeon,mid)){
//                 ans=mid;
//                 end=mid-1;
//             }
//             else st=mid+1;
//         }
//         return ans;
//     }
//     public boolean isPos(int[][]nums,int h){
//         int n=nums.length,m=nums[0].length;
//         int[][]dp=new int[n][m];
//         dp[0][0]=nums[0][0]+h;
//         if(dp[0][0]<=0) dp[0][0]=MIN;
//         for(int i=1;i<n;i++){
//             if(dp[i-1][0]<0)dp[i][0]=MIN;
//             else dp[i][0]=dp[i-1][0]+nums[i][0];
//             if(dp[i][0]<=0) dp[i][0]=MIN;
//         }
//         for(int j=1;j<m;j++){
//             if(dp[0][j-1]<0)dp[0][j]=MIN;
//             else dp[0][j]=dp[0][j-1]+nums[0][j];
//             if(dp[0][j]<=0) dp[0][j]=MIN;
//         }
//         for(int i=1;i<n;i++){
//             for(int j=1;j<m;j++){
//                 if(Math.max(dp[i-1][j],dp[i][j-1])<0) dp[i][j]=MIN;
//                 else dp[i][j]=nums[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
//                 if(dp[i][j]<=0) dp[i][j]=MIN;
//             }
//         }
//         return dp[n-1][m-1]>0;
//     }
// }
class Solution {
    static int MAX=+2000;
    // public int calculateMinimumHP(int[][] dungeon) {
    //     int n=dungeon.length;
    //     int m=dungeon[0].length;
    //     return helper(dungeon,0,0);
    // }
    // public int helper(int[][]nums,int i,int j){
    //     int n=nums.length,m=nums[0].length;
    //     if(i==n-1 && j==m-1) return Math.max(1,1-nums[i][j]);
    //     if(i>=n || j>=m) return MAX;
    //     int a=helper(nums,i+1,j); 
    //     int b=helper(nums,i,j+1);
    //     return Math.max(1,Math.min(a,b)-nums[i][j]); 
    // }
    public int calculateMinimumHP(int[][] d) {
        int n=d.length;
        int m=d[0].length;
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++)dp[i][m]=MAX;
        for(int i=0;i<=m;i++)dp[n][i]=MAX;
        dp[n-1][m-1]=Math.max(1,1-d[n-1][m-1]);
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1) continue;
                dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-d[i][j]);
            }
        }
        return dp[0][0];
    }
}