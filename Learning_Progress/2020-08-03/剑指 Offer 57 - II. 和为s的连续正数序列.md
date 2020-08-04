# 剑指 Offer 57 - II. 和为s的连续正数序列

Sliding Window.

Since it's all positive number, so we set `start` and `end` as `1`.
If `sum < target`, we move the end to right side.
If `sum > target`, we abandon the most left elements, move left side to right.

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        int start = 1, end = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (start <= target / 2) {
            if (sum < target) {
                sum += end;
                end++;
            } else if (sum > target) {
                sum -= start;
                start++;
            } else {
                int[] arr = new int[end - start];
                for (int k = start; k < end; k++) {
                    arr[k - start] = k;
                }
                res.add(arr);
                sum -= start;
                start++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
```
