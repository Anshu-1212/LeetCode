// class Solution {
//     public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
//         int n=nums1.length;
//         int k=k1+k2;
//         PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
//         for(int i=0;i<n;i++) pq.add(Math.abs(nums1[i]-nums2[i]));
//         while(k>0 && pq.peek()>0){
//             pq.add(pq.poll()-1);
//             k--;
//         }
//         long ans=0;
//         while(!pq.isEmpty()){
//             int a=pq.poll();
//             ans+=(a*a);
//         }
//         return ans;
//     }
// }
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int k = k1 + k2;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Math.abs(nums1[i] - nums2[i]);
        Arrays.sort(arr);
        int st = 0, end = arr[n - 1], ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (ok(arr, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else
                st = mid + 1;
        }
        long used = 0;
        long sans = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > ans) {
                used += (arr[i] - ans);
                arr[i] = ans;
            }
        }

        long rem = k - used;
        for (int i = n - 1; i >= 0 && rem > 0; i--) {
            if (arr[i] == ans && arr[i]>0) {
                arr[i]--;
                rem--;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            sans += ((long) arr[i] * arr[i]);
        }

        return sans;
    }

    public boolean ok(int[] arr, int k, int mid) {
        int n = arr.length;
        long kk = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= mid)
                break;
            kk += (arr[i] - mid);
            if (kk > k)
                return false;
        }
        return kk <= k;
    }
}