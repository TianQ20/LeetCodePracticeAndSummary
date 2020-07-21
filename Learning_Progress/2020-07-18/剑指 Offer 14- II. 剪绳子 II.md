# 剑指 Offer 14- II. 剪绳子 II

Can not use naive DP since there is a MOD.

## Greedy Solution

same as p.13 `O(n)`, just add a mod.

```java
class Solution {
    public int cuttingRope(int n) {
        int MOD = (int)1e9 + 7;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int res = 1;
        while (n >= 4) {
            res = (res * 3) % MOD;
            n -= 3;
        }
        res = (res * n) % MOD;
        return res;
    }
}
```

## Math Solution

quick mod (binary search) in `log(n)`.

```java
class Solution {
    int MOD = (int)1e9 + 7;
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if (b == 2) {
            return (int)(quickMOD(3, a) * b % MOD);
        } else {
            return (int)(quickMOD(3, a - 1) * (b + 3) % MOD); // b = 1 or 0, can not just time with b, since 4 = 2 + 2 = 1 + 3 and 2 * 2 > 1 * 3
        }
    }

    private long quickMOD(int x, int n) {
        long ans = 1;
        long t = x;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = (ans * t) % MOD;
            }
            n /= 2;
            t = (t * t) % MOD;
        }
        return ans;
    }
}
```
