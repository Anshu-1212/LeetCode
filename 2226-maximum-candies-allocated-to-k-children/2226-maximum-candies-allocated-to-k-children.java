class Solution {
    boolean isPossible(int[] candies,int mid,long k){
        if(mid==0) return true;
        long noc=0;
        for(int i=0;i<candies.length;i++){
            noc+=(candies[i]/mid);
            if(noc>=k) return true; 
        }
        return noc>=k;
    }
    public int maximumCandies(int[] candies, long k) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            max=Math.max(max,candies[i]);
        }
        int st=0;
        int end=max;
        int ans=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isPossible(candies,mid,k)){
                ans=mid;
                st=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
}