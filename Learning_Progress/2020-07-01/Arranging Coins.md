# Arranging Coins

## Intuition

1. simple math solution.

    ```java
    class Solution {
        public int arrangeCoins(int n) {
            return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
        }
    }
    ```

2. check every line requirement.

    ```java
    class Solution {
        public int arrangeCoins(int n) {
            int count = 0;
            while (n - count > count) {
                n -= count;
                count++;
            }
            return count;
        }
    }
    ```
