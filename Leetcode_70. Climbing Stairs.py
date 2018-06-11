'''
70. Climbing Stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
'''

# class Solution:
#     def climbStairs(self, n):
#         if n == 0: return 1
#         if n == 1: return 1
#         count = 0
#         count += self.climbStairs(n-1)
#         count += self.climbStairs(n-2)

#         return count

# import math
# class Solution:
#     def climbStairs(self, n):
#         count = 1
#         for i in range(2, n, 2):
#             down1 = (n-i)
#             down2 = (i/2)

#             count += math.factorial(down1+down2) / (math.factorial(down1) * math.factorial(down2))

#         return int(count)

import math


class Solution:
    def climbStairs(self, n):
        dp = []
        dp.append(0)
        dp.append(1)
        dp.append(2)

        for i in range(3, n + 1):
            dp.append(dp[i - 1] + dp[i - 2])

        return dp[n]
