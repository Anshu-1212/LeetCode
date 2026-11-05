class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr1.length;
        Arrays.sort(arr2);
        int ans=0;
        for(int i=0;i<n;i++){
            if(!helper(arr2,arr1[i],d)) ans++;
        }
        return ans;
    }
    public boolean helper(int[]arr,int v,int d){
        int n=arr.length;
        int st=0,end=n-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(Math.abs(arr[mid]-v)<=d) return true;
            if(arr[mid]>=v) end=mid-1;
            else st=mid+1;
        }
        return false;
    }
}