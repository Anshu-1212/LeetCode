class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') sb.append(ch);
            else{
                if(i+1<n && s.charAt(i+1)==')'){
                    i++;
                    sb.append(ch);
                }
                else sb.append('*');
            }
        }
        int l=0,r=0,rr=0,ans=0;
        n=sb.length();
        for(int i=0;i<n;i++){
            char ch=sb.charAt(i);
            if(ch=='(') l++;
            else if(ch==')') r++;
            else rr++;
            if(r>l){
                ans++;
                r--;
            }
            if(rr>0 && (l>r)){
                ans++;
                rr--;
                l--;
            }
            else if(rr>0){
                ans+=2;
                rr--;
            }
        }
        return ans+(l-r)*2;
    }
}