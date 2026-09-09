class Solution {
    public long countCommas(long n) {
        long ans=0;
        long base=1000;
        while(n>=base){
            ans+=(n-base+1);
            base*=1000;
        }
        return ans;
    }
}