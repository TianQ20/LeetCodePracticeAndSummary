package Top50LeetCode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    // 按位取异或
    /*
    first , we have to know the bitwise XOR in java
    0 ^ N = N
    N ^ N = 0
    So if N is the single number
    N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
    = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
    = 0 ^ 0 ^ ..........^ 0 ^ N
    = N
     */

    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i != nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    // 数学方法 sum(set) * 2 - sum1 = single number

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int sum = 0;
        for (Integer num : set) {
            sum += num;
        }

        int sum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
        }
        return 2 * sum - sum1;
    }
}


