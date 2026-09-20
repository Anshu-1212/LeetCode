class Solution {
    public int reverseDegree(String s) {
        int n=s.length(),sans=0;
        for(int i=0;i<n;i++){
            sans=sans+((i+1)*(26-(s.charAt(i)-'a')));
        }
        return sans;
    }
}