class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        int ans=0;
        int i=0;
        while(i+k-1<n){
            int x=i;
            int y;
            y=i+k-1;
            boolean isPal=false;
            while(x<y){
                if(s.charAt(x)!=s.charAt(y)) break;
                x++;y--;
            }
            if(k%2==0) isPal=x>y;
            else isPal=x==y;
            if(isPal){
                ans++;
                i+=k;
                continue;
            }
            x=i;
            y=i+k;
            while(y<n && x<y){
                if(s.charAt(x)!=s.charAt(y)) break;
                x++;y--;
            }
            if((k+1)%2==0) isPal=x>y;
            else isPal=x==y;
            if(isPal){
                ans++;
                i+=(k+1);
                continue;
            }
            i++;
        }
        return ans;
    }
}