// class Solution {
//     public int sortableIntegers(int[] nums) {
//         int n = nums.length, ans = 0, mn, mx, pmx, i, j, c;
//         a: for (int k = 1; k <= n; k++) {
//             if (n % k != 0)
//                 continue;
//             pmx = -1;
//             for (i = 0; i < n; i += k) {
//                 mn = 1000000;
//                 mx = -1;
//                 c = 0;
//                 for (j = i; j < i + k; j++) {
//                     mn = Math.min(mn, nums[j]);
//                     mx = Math.max(mx, nums[j]);
//                     if (j + 1 < i + k && nums[j] > nums[j + 1])
//                         c++;
//                     if (j == i + k - 1)
//                         c += (nums[j] > nums[i] ? 1 : 0);
//                     if (c > 1)
//                         continue a;
//                 }
//                 if (pmx > mn)
//                     continue a;
//                 pmx = mx;
//             }
//             ans += k;
//         }
//         return ans;
//     }
// }

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length, ans = 0, mn, mx, pmx, i, j, c;
        List<Integer> div = new ArrayList<>();
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                div.add(d);
                if (d != n / d)
                    div.add(n / d);
            }
        }
        Collections.sort(div);
        a: for (int k : div) {
            pmx = -1;
            for (i = 0; i < n; i += k) {
                mn = 1000000;
                mx = -1;
                c = 0;
                for (j = i; j < i + k; j++) {
                    mn = Math.min(mn, nums[j]);
                    mx = Math.max(mx, nums[j]);
                    if (j + 1 < i + k && nums[j] > nums[j + 1])
                        c++;
                    if (j == i + k - 1)
                        c += (nums[j] > nums[i] ? 1 : 0);
                    if (c > 1)
                        continue a;
                }
                if (pmx > mn)
                    continue a;
                pmx = mx;
            }
            ans += k;
        }
        return ans;
    }
}