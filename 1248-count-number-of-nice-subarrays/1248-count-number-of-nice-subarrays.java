class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        if (nums[0] % 2 == 0)
            nums[0] = 0;
        else
            nums[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
            nums[i] += nums[i - 1];
        }
        int cnt = 0, j = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < k)
                continue;
            if (i > 0 && nums[i] == nums[i - 1]) {
                ans += cnt;
            } else {
                cnt = 0;
                int val = nums[i] - k;
                while (nums[j] <= val) {
                    if (nums[j] == val)
                        cnt++;
                    j++;
                }
                j++;
                cnt++;
                ans += cnt;
            }
        }
        return ans;
    }
}