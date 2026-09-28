class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int ans=0,sans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') ans++;
            else if(ch==')') ans--;
            sans=Math.max(sans,ans);
        }
        return sans;
    }
}