# 剑指 Offer 61. 扑克牌中的顺子

`O(n)` time, `O(n)` space.

```java
class Solution {
    public boolean isStraight(int[] nums) {
        int min = 14, max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if (set.contains(nums[i])) {
                return false;
            }
            set.add(nums[i]);
        }
        return max - min < 5;
    }
}
```

`O(nlogn)` time, `O(1)` space.

```java
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int jokers = 0, max = nums[4];
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] == 0) {
                jokers++;
            } else if (nums[i] == nums[i + 1]) return false;
        }
        return max - nums[jokers] < 5;
    }
}
```
