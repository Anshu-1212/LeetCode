// class Solution {
//     public int countIntersectingIntervals(int[][] intervals) {
//         int[]arr=new int[102];
//         for(int[]i:intervals){
//             arr[i[0]]++;
//             arr[i[1]+1]--;
//         }
//         for(int i=1;i<102;i++){
//             arr[i]+=arr[i-1];
//         }
//         Set<Integer>set=new HashSet<>();
//         for(int i=1;i<=100;i++){
//             if(arr[i]!=0)set.add(arr[i]);
//         } 
//         int ans=set.size();
//         return ans<=1?0:ans;
//     }
// }
class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n=intervals.length,ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Math.max(intervals[i][0],intervals[j][0])<=Math.min(intervals[i][1],intervals[j][1])) ans++;
            }
        }
        return ans;
    }
}