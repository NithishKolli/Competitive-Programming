# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices)==0:
            return 0
        left_min = prices[0]
        max_profit = 0
        for i in range(1,len(prices)):
            if prices[i]>left_min:
                max_profit = max(max_profit,prices[i]-left_min)
            else:
                left_min = prices[i]
        return max_profit