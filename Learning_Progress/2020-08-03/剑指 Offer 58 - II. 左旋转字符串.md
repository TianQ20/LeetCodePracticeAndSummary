# 剑指 Offer 58 - II. 左旋转字符串

Using substring method.

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
```

Only use string. (simlilar as using StringBuilder)

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }
        return res;
    }
}
```
