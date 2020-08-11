# 剑指 Offer 63. 股票的最大利润

DP.
Find the state transfer function:
`dp[i]=max(dp[i−1],prices[i]−min(prices[0:i]))`

while `dp[i]` only relate with `dp[i−1]` , `prices[i]` , `cost`, we can use `profit` to decrease the space complexity:
`profit=max(profit,prices[i]−min(cost,prices[i])`

```java
class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price < cost) {
                cost = price;
            }
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
```
