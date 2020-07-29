# 剑指 Offer 45. 把数组排成最小的数 && 179. Largest Number

```java
class Solution {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] cache = new String[len];
        String res = "";
        for (int i = 0; i < len; i++) {
            cache[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(cache, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        for (int i = len - 1; i >= 0; i--) {
            res += cache[i];
        }
        return res;
    }
}
```

179.Largest Number

be careful with leading zero.

```java
class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] cache = new String[len];
        String res = "";
        for (int i = 0; i < len; i++) {
            cache[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(cache, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        if (cache[len - 1].equals("0")) return "0";
        for (int i = len - 1; i >= 0; i--) {
            res += cache[i];
        }
        return res;
    }
}
```
