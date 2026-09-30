class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[]ans=new int[n];
        int cg=0;
        char prev=')';
        for(int i=0;i<n;i++){
            char ch=seq.charAt(i);
            if(ch==prev) cg=1-cg;
            ans[i]=cg;
            prev=ch;
        }
        return ans;
    }
}