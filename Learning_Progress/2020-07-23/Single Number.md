# Single Number

260.Single Number III

**Brute force HashMap**
`O(n)` time, `O(n)` space.

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[2];
        for (int i : nums) {
            if (map.get(i) == 1) {
                res[0] = i;
                map.put(i, 0);
                break;
            }
        }

        for (int i : nums) {
            if (map.get(i) == 1) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
```

**bit XOR**
`O(n)` time, `O(1)` space.

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }
        // If bit_i in (a xor b) is 1, bit_i at a and b are different.
        // Find bit_i using the low bit formula m & -m
        diff &= -diff;
        int[] res = new int[2];
        for (int i : nums) {
            if ((i & diff) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
```
