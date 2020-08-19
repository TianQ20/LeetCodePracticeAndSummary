# 3Sum related problems

## 15. 3Sum

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++; // skip duplicates
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--; // skip duplicates
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else hi--;
                }
            }
        }
        return res;
    }
}
```

## 16. 3Sum Closest

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum > target) {
                    hi--;
                } else {
                    lo++;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) { // update res
                    res = sum;
                }
            }
        }
        return res;
    }
}
```

## 259. 3Sum Smaller

```java
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        int len = nums.length;
        if (len < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int lo = i + 1, hi = len - 1;
            while (lo < hi) {
                int tmpSum = nums[i] + nums[lo] + nums[hi];
                if (tmpSum >= target) {
                    hi--;
                } else {
                    res += (hi - lo); // update count
                    lo++;
                }
            }
        }
        return res;
    }
}
```
