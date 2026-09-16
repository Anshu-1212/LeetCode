class Solution {
    static final long MOD = 1_000_000_007L;
    long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % MOD;

            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    long nCr(int n, int r) {
        if (r > n - r)
            r = n - r;
        long num = 1;
        long den = 1;
        for (int i = 1; i <= r; i++) {
            num = num * (n - i + 1) % MOD;
            den = den * i % MOD;
        }
        return num * modPow(den, MOD - 2) % MOD;
    }

    public int numberOfSets(int n, int k) {
        return (int) nCr(n + k - 1, 2 * k);
    }
}