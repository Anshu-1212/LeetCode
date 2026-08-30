class Solution {
    int mod=(int)1e9+7;
    public long pow(long a,long b){
        if(b==0) return 1;
        long sp=pow(a,b/2);
        if(b%2==0){
            return ((sp*sp)%mod);
        }
        else{
            return (((sp*sp)%mod)*(a%mod))%mod;
        }
    }
    
    public int sumDecoded(long[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int w=(int)(nums[i]%10);
            long d=nums[i]/10;
            int dig=0;
            long dn=d;
            while(dn>0){
                dig++;
                dn/=10;
            }
            int b=dig-w;
            int place=1;
            while(b-->0) place*=10;
            int x=(int)(d/place),y=(int)(d%place);
            ans+=(pow(x,y)%mod);
            ans%=mod;
        }
        return ans;
    }
}