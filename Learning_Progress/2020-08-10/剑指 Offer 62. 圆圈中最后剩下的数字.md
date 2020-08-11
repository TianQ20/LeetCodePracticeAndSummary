# 剑指 Offer 62. 圆圈中最后剩下的数字

start from the end.

```java
class Solution {
    public int lastRemaining(int n, int m) {
        int pos = 0; // winner position must be 0 in the edn
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i; // rebuild the original sequence, update length(i) the same time
        }
        return pos;
    }
}
```
