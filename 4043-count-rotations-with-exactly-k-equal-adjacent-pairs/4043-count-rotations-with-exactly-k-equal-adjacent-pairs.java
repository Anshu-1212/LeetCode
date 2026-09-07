class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int c = s.charAt(0) == s.charAt(n - 1) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            char ch1 = s.charAt(i - 1);
            char ch2 = s.charAt(i);
            if (ch1 == ch2)
                c++;
        }
        if (c != k && c - 1 != k)
            return 0;
        int sans = 0;
        int i = 0, j = n - 1;
        s += s;
        boolean f = k == c;
        if (f) {
            while (i < n) {
                if (s.charAt(i) != s.charAt(j)) {
                    sans++;
                }
                i++;j++;
            }
        }
        else {
            while (i < n) {
                if (s.charAt(i) == s.charAt(j)) {
                    sans++;
                }
                i++;j++;
            }
        }
        return sans;
    }
}