# 剑指 Offer 56 - I. 数组中数字出现的次数 && 260. Single Number III

```java
(1) The process is XOR all elements in nums to get the result of res[0] ^ res[1].

(2) Then we tru to find the difference of two groups of elements, find a differ lower bit, one group is 1, another group is 0.

(3) Then we just XOR two groups elements seperatly, we can get res[0] and res[1].
```

there is a little trick here to get a bit equal 1 from the result XOR.

```java
see if we get XOR = aaaa1000(a = 1 or 0), we could get the first(from low to high) bit equals 1 as follow:

first: ~XOR = bbbb0111 (b = ~a)

then add 1, with carrying bits ~XOR + 1 = bbbb1000

then, XOR & (~XOR + 1) = 00001000

so we can write as XOR & (-XOR) also.
```

```java
class Solution {
    public int[] singleNumbers(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }
        diff &= -diff; // diff & (-diff)本身的作用是得到最低位的1
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
