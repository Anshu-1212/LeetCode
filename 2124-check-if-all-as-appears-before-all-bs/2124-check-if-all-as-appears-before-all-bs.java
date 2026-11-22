class Solution {
    public boolean checkString(String s) {
        boolean bSeen=false;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!bSeen && ch=='b') bSeen=true;
            if(ch=='a' && bSeen) return false;
        }
        return true;
    }
}