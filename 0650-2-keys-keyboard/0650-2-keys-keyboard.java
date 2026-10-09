// class Solution {
//     int s=(int)1e8;
//     public int minSteps(int n) {
//         if(n==1) return 0;
//         return helper(n,1,1,true)+1;
//     }
//     public int helper(int n,int clip,int copy,boolean f){
//         if(clip>n) return (int)1e8;
//         if(clip==n) return 0;
//         int c=s;
//         if(f) c=helper(n,clip,clip,false);
//         int p=helper(n,clip+copy,copy,true);
//         int val=Math.min(c,p);
//         return 1+val;
//     }
// }
class Solution {
    int s=(int)1e8;
    public int minSteps(int n) {
        if(n==1) return 0;
        int[][][]dp=new int[n+1][n+1][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<2;k++) dp[i][j][k]=-1;
            }
        }
        return helper(n,1,1,true,dp)+1;
    }
    public int helper(int n,int clip,int copy,boolean f,int[][][]dp){
        if(clip>n) return (int)1e8;
        if(clip==n) return 0;
        if(dp[clip][copy][f?1:0]!=-1) return dp[clip][copy][f?1:0];
        int c=s;
        if(f) c=helper(n,clip,clip,false,dp);
        int p=helper(n,clip+copy,copy,true,dp);
        int val=Math.min(c,p);
        return dp[clip][copy][f?1:0]=1+val;
    }
}