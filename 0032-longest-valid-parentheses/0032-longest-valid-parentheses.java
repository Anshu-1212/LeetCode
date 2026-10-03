class Solution {
    public int longestValidParentheses(String s) {
        int l=0,r=0,mx=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') l++;
            else r++;
            if(l==r) mx=Math.max(mx,l+r);
            if(r>l){
                l=0;
                r=0;
            }
        }
        l=0;
        r=0;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='(') l++;
            else r++;
            if(l==r) mx=Math.max(mx,l+r);
            if(l>r){
                l=0;
                r=0;
            }
        }
        return mx;
    }
}