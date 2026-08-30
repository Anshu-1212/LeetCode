class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n=nums.length;
        int[][]idx=new int[2][101];
        int[]f=new int[101];
        Arrays.fill(idx[0],-1);
        for(int i=0;i<n;i++){
            if(idx[0][nums[i]]==-1) idx[0][nums[i]]=i;
            idx[1][nums[i]]=i;
            f[nums[i]]++;
        }
        int ans=0;
        for(int i=0;i<=100;i++){
            if(f[i]==idx[1][i]-idx[0][i]+1) ans++;
        }
        return ans;
    }
}