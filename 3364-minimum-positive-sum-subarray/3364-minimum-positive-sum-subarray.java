class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int[]arr=new int[n];
        arr[0]=nums.get(0);
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]+nums.get(i);
        }
        int mn=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=l;j<=r;j++){
                if(i+j-1>=n) break;
                int a=i>0?arr[i-1]:0;
                int b=arr[i+j-1];
                int s=b-a;
                if(s>0)mn=Math.min(mn,s);
            }
        }
        return mn==Integer.MAX_VALUE?-1:mn;
    }
}