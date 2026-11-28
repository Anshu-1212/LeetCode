class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length,mx=Integer.MIN_VALUE;
        Arrays.sort(items,(a,b)->Integer.compare(a[1],b[1]));
        int[]free=new int[n];
        int[]freq=new int[(int)1e5+1];
        for(int[]i:items){
            freq[i[0]]++;
            mx=Math.max(mx,i[0]);
        }
        for(int i=0;i<n;i++){
            int a=items[i][0],b=items[i][0],f=0;
            while(a<=mx){
                f+=freq[a];
                a+=b;
            }
            free[i]=f-1;
        }
        int ans=0;
        int i=0;
        while(i<n && items[i][1]<=2*items[0][1]){
            int q=Math.min(budget/items[i][1],free[i]);
            ans+=(q*2);
            budget-=(items[i][1]*q);
            i++;
        }
        ans+=(budget/items[0][1]);
        return ans;
    }
}