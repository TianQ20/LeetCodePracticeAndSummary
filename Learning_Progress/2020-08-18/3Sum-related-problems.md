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

## 18. 4Sum

generalize to k sum situation. Use recursion to get 2 sum.

```java
class Solution {
    int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private List<List<Integer>> kSum (int[] nums, int target, int k, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (index >= len) {
            return res;
        }
        if (k == 2) {
            int lo = index, hi = len - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    res.add(temp);
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi--;
                    }
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo++;
                    }
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] < target) {
                    lo++;
                } else hi--;
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                List<List<Integer>> tmpList = kSum(nums, target - nums[i], k - 1, i + 1);
                if (tmpList != null) {
                    for (List<Integer> t : tmpList) {
                        t.add(0, nums[i]); // add to the first place
                    }
                    res.addAll(tmpList);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) { // skip duplicates
                    i++;
                }
            }
        }
        return res;
    }
}
```
