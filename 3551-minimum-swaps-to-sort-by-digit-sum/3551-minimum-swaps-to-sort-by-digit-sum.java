// class Solution {
//     private void swap(int[]arr,int i,int j){
//         int temp=arr[i];
//         arr[i]=arr[j];
//         arr[j]=temp;
//     }
//     public int minSwaps(int[] nums) {
//         int n=nums.length;
//         int[]sum=new int[n];
//         for(int i=0;i<n;i++){
//             int a=nums[i],s=0;
//             while(a>0){
//                 s+=(a%10);
//                 a/=10;
//             }
//             sum[i]=s;
//         }
//         int sans=0,idx;
//         for(int i=0;i<n-1;i++){
//             idx=i;
//             for(int j=i+1;j<n;j++){
//                 if(sum[j]<sum[idx]) idx=j;
//                 else if(sum[j]==sum[idx] && nums[j]<nums[idx]) idx=j;
//             }
//             if(idx==i) continue;
//             swap(nums,idx,i);
//             swap(sum,idx,i);
//             sans++;
//         }
//         return sans;
//     }
// }
class Solution {
    class Pair implements Comparable<Pair> {
        int i;
        int val;
        int sum;

        Pair(int i, int val, int sum) {
            this.i = i;
            this.val = val;
            this.sum = sum;
        }

        public int compareTo(Pair p) {
            if (this.sum == p.sum)
                return Integer.compare(this.val, p.val);
            return Integer.compare(this.sum, p.sum);
        }
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            int a = nums[i], s = 0;
            while (a > 0) {
                s += (a % 10);
                a /= 10;
            }
            arr[i] = new Pair(i, nums[i], s);
        }
        Arrays.sort(arr);
        int swaps = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i].i == i) {
                continue;
            }

            int j = i;
            int cycleLength = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = arr[j].i;
                cycleLength++;
            }

            swaps += cycleLength - 1;
        }

        return swaps;
    }
}