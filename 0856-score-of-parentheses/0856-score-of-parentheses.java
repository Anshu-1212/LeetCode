class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        int[]h=new int[n];
        int bal=0;
        int sans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') bal++;
            else bal--;
            h[i]=bal;
        }
        for(int i=0;i<n;i++){
            int l=i-1>=0?h[i-1]:0;
            int r=i+1<n?h[i+1]:0;
            int b=h[i];
            if(b>l && b>r) sans=sans+(1<<(b-1));
        }
        return sans;
    }
}