// class Solution {
//     public boolean checkValidString(String s) {
//         int n=s.length();
//         int l=0,r=0,c=0;
//         for(int i=0;i<n;i++){
//             char ch=s.charAt(i);
//             if(ch=='(') l++;
//             else if(ch==')') r++;
//             else c++;
//             if(l+c<r) return false;
//         }
//         return Math.abs(l-r)<=c;
//     }
// }
// class Solution {
//     public boolean checkValidString(String s) {
//         int n=s.length();
//         int bal=0,c=0;
//         for(int i=0;i<n;i++){
//             char ch=s.charAt(i);
//             if(ch=='(') bal++;
//             else if(ch==')') bal--;
//             else c++;
//             if(bal+c<0) return false;
//         }
//         return Math.abs(bal)<=c;
//     }
// }
class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int[][]dp=new int[n+1][n+1];
        for(var a:dp) Arrays.fill(a,-1);
        return helper(new StringBuilder(s),0,0,dp);
    }
    public boolean helper(StringBuilder s,int i,int bal,int[][]dp){
        int n=s.length();
        if(bal<0) return false;
        if(i>=n) return bal==0;
        if(dp[i][bal]!=-1) return dp[i][bal]==1;
        char ch=s.charAt(i);
        boolean x=false,y=false,z=false;
        if(ch=='(') x=helper(s,i+1,bal+1,dp);
        else if(ch==')') y=helper(s,i+1,bal-1,dp);
        else z=helper(s,i+1,bal,dp) || helper(s,i+1,bal+1,dp) || helper(s,i+1,bal-1,dp);
        boolean ans=x||y||z;
        dp[i][bal]=ans?1:0;
        return ans;
    }
}