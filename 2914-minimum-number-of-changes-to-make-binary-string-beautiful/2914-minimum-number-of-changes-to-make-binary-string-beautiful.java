class Solution {
    public int minChanges(String s) {
        int n=s.length(),sans=0;
        for(int i=0;i<n;i+=2){
            int a=s.charAt(i)-'0';
            int b=s.charAt(i+1)-'0';
            if(a!=b) sans++;
        }
        return sans;
    }
}