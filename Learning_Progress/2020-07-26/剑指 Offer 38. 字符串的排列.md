# 剑指 Offer 38. 字符串的排列

use template from <https://leetcode.com/problems/permutations-ii/>

change string s to a sorted char array.

```java
class Solution {
    public String[] permutation(String s) {
        char[] ch = s.toCharArray();
        List<List<Character>> res = permuteUnique(ch);
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : res.get(i)) {
                sb.append(c);
            }
            String tmp = sb.toString();
            ans[i] = tmp;
        }
        return ans;
    }

    private List<List<Character>> permuteUnique(char[] nums) {
        List<List<Character>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(res, new ArrayList<Character>(), nums, used);
        return res;
    }

    private void backtrack(List<List<Character>> res, List<Character> tempList, char[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue; // always choose the first one of same elements
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(res, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
```

another backtracking solution, use hash set to avoid duplicates.
swap the character in two indexs, continue until reach to the end, then recover the swap.

```java
class Solution {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int start) {
        if (start == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, start);
            dfs(start + 1);
            swap(start, i); // recover
        }
    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
```
