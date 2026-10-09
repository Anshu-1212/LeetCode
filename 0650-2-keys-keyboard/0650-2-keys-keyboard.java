class Solution {
    int s=(int)1e8;
    public int minSteps(int n) {
        if(n==1) return 0;
        // return helper(n-1,1,1,true)+1;
        return helper(n,1,1,true)+1;
        // return helper(n,1,0,true);
    }
    public int helper(int n,int clip,int copy,boolean f){
        if(clip>n) return (int)1e8;
        // if(n<0) return s;
        if(clip==n) return 0;
        // if(n==0) return 0;
        int c=s;
        if(f) c=helper(n,clip,clip,false);
        int p=helper(n,clip+copy,copy,true);
        int val=Math.min(c,p);
        return 1+val;
    }
}