class Solution {
    public int minOperations(String s) {
        boolean isS = true;
        int n = s.length();
        int mn = s.charAt(0);
        int cmn = 1;
        int cmx = 1;
        int mx = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                isS = false;
            }
            if (mn > s.charAt(i)) {
                cmn = 1;
                mn = s.charAt(i);
            } else if (mn == s.charAt(i))
                cmn++;
            if (mx < s.charAt(i)) {
                cmx = 1;
                mx = s.charAt(i);
            } else if (mx == s.charAt(i))
                cmx++;
        }
        if (isS)
            return 0;
        if (!isS && n == 2)
            return -1;
        if (mx == s.charAt(0) && mn == s.charAt(n - 1) && (cmn == 1 && cmx == 1))
            return 3;
        if (mn == s.charAt(0) || mx == s.charAt(n - 1))
            return 1;
        return 2;
    }
}