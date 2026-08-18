class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[51];
        int mx = -1, cmx = 0;
        for (int e : nums) {
            f[e]++;
            mx = Math.max(mx, e);
        }
        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (f[i] == 1)
                    return i;
            }
        }
        if (k == n)
            return mx;
        int ans = -1;
        if (f[nums[0]] == 1)
            ans = Math.max(ans, nums[0]);
        if (f[nums[n - 1]] == 1)
            ans = Math.max(ans, nums[n - 1]);
        return ans;
    }
}