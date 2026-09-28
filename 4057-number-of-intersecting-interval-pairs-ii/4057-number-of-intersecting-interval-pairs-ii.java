
// class Solution {
//     public long countIntersectingIntervals(int[][] intervals) {
//         Map<Integer,Integer>st=new HashMap<>();
//         Map<Integer,Integer>end=new HashMap<>();
//         int mn=Integer.MAX_VALUE,mx=Integer.MIN_VALUE;
//         for(int[]i:intervals){
//             mn=Math.min(mn,i[0]);
//             mx=Math.max(mx,i[1]);
//             st.put(i[0],st.getOrDefault(i[0],0)+1);
//             end.put(i[1],end.getOrDefault(i[1],0)+1);
//         }
//         long active=0,ans=0;
//         for(int i=mn;i<=mx;i++){
//             if(st.containsKey(i)){
//                 int k=st.get(i);
//                 ans+=(active*k);
//                 ans+=((long)k*(k-1)/2);
//                 active+=k;
//             } 
//             if(end.containsKey(i)){
//                 int k=end.get(i);
//                 active-=k;
//                 // ans+=(active*k);
//                 // ans+=((long)k*(k-1)/2);
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans = 0;
        for (int[] interval : intervals) {
            int st = interval[0];
            int end = interval[1];
            while (!pq.isEmpty() && pq.peek() < st) {
                pq.poll();
            }
            ans += pq.size();
            pq.offer(end);
        }
        return ans;
    }
}