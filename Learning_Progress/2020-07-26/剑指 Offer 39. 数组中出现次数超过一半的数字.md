# 剑指 Offer 39. 数组中出现次数超过一半的数字

Sort: time `O(nlogn)`, space `O(1)`.

```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2]; // index start from 0
    }
}
```

Hash table: time `O(n)`, space `O(n)`.

```java
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
```

time `O(n)`, space `O(1)`.

```java
class Solution {
    public int majorityElement(int[] nums) {
        int major = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (nums[i] == major) {
                count++;
            } else count--;
        }
        return major;
    }
}
```
