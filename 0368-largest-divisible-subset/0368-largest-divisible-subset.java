class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<Integer>[][]dp=new ArrayList[n][n+1];
        return helper(nums,0,-1,dp);
    }
    public List<Integer> helper(int[]nums,int i,int lst,List<Integer>[][]dp){
        if(i>=nums.length) return new ArrayList<>();
        if(dp[i][lst+1]!=null) return dp[i][lst+1];
        List<Integer>skip=new ArrayList<>();
        List<Integer>take=new ArrayList<>();
        if(lst==-1 || nums[i]%nums[lst]==0){
            take.add(nums[i]);
            take.addAll(helper(nums,i+1,i,dp));
        }
        skip.addAll(helper(nums,i+1,lst,dp));
        return dp[i][lst+1]=(skip.size()>take.size()?skip:take);
    }
}
// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         int n=nums.length;
//         List<Integer>[][]dp=new ArrayList[n][n+1];
//         // for(int i=0;i<n;i++){
//         //     for(int j=0;j<n;j++) dp[i][j]=new ArrayList<>();
//         // }
//         return helper(nums,0,-1,dp);
//     }
//     public List<Integer> helper(int[]nums,int i,int lst,List<Integer>[][]dp){
//         List<Integer>l=new ArrayList<>();
//         if(i>=nums.length) return l;
//         if(lst!=-1 && dp[i][lst]!=null) return dp[i][lst];
//         if(lst==-1 || nums[i]%nums[lst]==0){
//             l.add(nums[i]);
//             l.addAll(helper(nums,i+1,i,dp));
//             return (lst!=-1)?dp[i][lst]=l:l;
//         }
//         l.addAll(helper(nums,i+1,lst,dp));
//         return (lst!=-1)?dp[i][lst]=l:l;
//     }
// }