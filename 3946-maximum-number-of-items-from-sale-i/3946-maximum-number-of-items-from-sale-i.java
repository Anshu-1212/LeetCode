// class Solution {
//     public int maximumSaleItems(int[][] items, int budget) {
//         int n=items.length;
//         int[]free=new int[n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i!=j && items[j][0]%items[i][0]==0) free[i]++;
//             }
//         }
//         int[][]dp=new int[n][budget+1];
//         for(int[]a:dp) Arrays.fill(a,-1);
//         return helper(items,free,budget,0,dp);
//     }
//     public int helper(int[][]items,int[]free,int budget,int i,int[][]dp){
//         int n=items.length;
//         if(i>=n) return 0;
//         if(dp[i][budget]!=-1) return dp[i][budget];
//         int take=0,skip=0;
//         skip=helper(items,free,budget,i+1,dp);
//         for(int x=1;budget-items[i][1]*x>=0;x++){
//             take=Math.max(take,x+free[i]+helper(items,free,budget-items[i][1]*x,i+1,dp));
//         }
//         return dp[i][budget]=Math.max(skip,take);
//     }
// }

// class Solution {
//     public int maximumSaleItems(int[][] items, int budget) {
//         int n=items.length;
//         int[]free=new int[n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i!=j && items[j][0]%items[i][0]==0) free[i]++;
//             }
//         }
//         int[][]dp=new int[n+1][budget+1];
//         for(int i=1;i<=n;i++){
//             for(int b=0;b<=budget;b++){
//                 int take=0,skip=0;
//                 skip=dp[i-1][b];
//                 for(int x=1;b-items[i-1][1]*x>=0;x++) take=Math.max(take,x+free[i-1]+dp[i-1][b-items[i-1][1]*x]);
//                 dp[i][b]=Math.max(skip,take);
//             }
//         }
//         return dp[n][budget];
//     }
// }

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;
        int[]free=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && items[j][0]%items[i][0]==0) free[i]++;
            }
        }
        int[][]dp=new int[n+1][budget+1];
        for(int i=1;i<=n;i++){
            int price=items[i-1][1];
            int bonus=free[i-1];
            for(int b=0;b<=budget;b++){
                int take1=0,taken=0,skip=0;
                skip=dp[i-1][b];
                if(b>=price) take1=bonus+1+dp[i-1][b-price];
                if(b>=price) taken=1+dp[i][b-price];
                dp[i][b]=Math.max(skip,Math.max(take1,taken));
            }
        }
        return dp[n][budget];
    }
}