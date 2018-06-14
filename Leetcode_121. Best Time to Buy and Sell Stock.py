'''
121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
'''

import sys


class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        buy = sys.maxsize
        profit = 0

        for i in range(len(prices)):
            if prices[i] < buy:
                buy = prices[i]
            elif prices[i] - buy > profit:
                profit = prices[i] - buy

        return profit

# if not prices: return 0

#         buy = min(prices)
#         minIndex = prices.index(buy)

#         if minIndex + 1 == len(prices): return 0

#         sell = max(prices[minIndex+1:])

#         if sell > buy: return sell - buy

#         return 0

#         if not prices: return 0

#         arr = [0]
#         count = 1
#         buy = prices.index(min(prices))
#         while count < len(prices):
#             if buy + 1 != len(prices):
#                 sell = max(prices[buy+1:])
#             else:
#                 buy = prices.index(min(prices[:buy]))
#                 count += 1
#                 continue

#             if sell > prices[buy]: arr.append(sell - prices[buy])
#             else: arr.append(0)

#             buy = prices.index(min(prices[:buy] + prices[buy+1:]))
#             count += 1

#         return max(arr)


