# DP

## 121. Best Time to Buy and Sell Stock

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0, sofarMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > sofarMin) {
                max = Math.max(max, prices[i] - sofarMin);
            } else {
                sofarMin = prices[i];
            }
        }
        return max;
    }
}
```

## 122. Best Time to Buy and Sell Stock II

"u buy it on first day, sell it on second day, then buy it on second, sell it on third day" equals "buy it on first and sell it on third day", the answer is equal.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
```

## 123. Best Time to Buy and Sell Stock III
