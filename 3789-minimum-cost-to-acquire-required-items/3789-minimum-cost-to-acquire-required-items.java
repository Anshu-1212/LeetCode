class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long ans=0;
        long mn=Math.min(need1,need2);
        ans=ans+mn*Math.min(costBoth,cost1+cost2);
        if(mn<need1) ans=ans+(need1-mn)*Math.min(costBoth,cost1);
        if(mn<need2) ans=ans+(need2-mn)*Math.min(costBoth,cost2);
        return ans;
    }
}