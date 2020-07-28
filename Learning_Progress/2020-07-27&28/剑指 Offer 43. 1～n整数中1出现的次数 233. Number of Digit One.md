# 剑指 Offer 43. 1～n整数中1出现的次数 233. Number of Digit One

brute force solution: `O(nlogn)` --> TLE

```java
class Solution {
    public int countDigitOne(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += numberOfOne(i);
        }
        return num;
    }

    private int numberOfOne(int n) {
        int num = 0;
        while (n > 0) {
            if (n % 10 == 1) {
                num++;
            }
            n /= 10;
        }
        return num;
    }
}
```

```java
class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
```

```java
class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0); // 1 and >=2 can easily be done in one expression
        return ones;
    }
}
```
