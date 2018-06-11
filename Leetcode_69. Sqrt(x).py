'''
69. Sqrt(x)

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
'''
class Solution:
    def mySqrt(self, x):
        left = 0
        right = x
        while left <= right:
            mid = (left + right) // 2

            if mid ** 2 == x:
                return mid
            elif mid ** 2 > x:
                if (mid - 1) ** 2 <= x:
                    return mid - 1
                right = mid - 1
            elif mid ** 2 <= x:
                if (mid + 1) ** 2 > x:
                    return mid
                left = mid + 1

# class Solution:
#     def mySqrt(self, x):
#         if x == 0 or x == 1:
#             return x
#         return self.mySqrtAns(0, x, x)
#
#     def mySqrtAns(self, left, right, x):
#         if left > right: return 0
#
#         mid = (left + (right - left)) // 2
#
#         if mid ** 2 == x:
#             return mid
#         elif mid ** 2 > x:
#             if (mid - 1) ** 2 <= x:
#                 return mid - 1
#             self.mySqrtAns(left, mid - 1, x)
#         elif mid ** 2 <= x:
#             if (mid + 1) ** 2 > x:
#                 return mid
#             self.mySqrtAns(mid + 1, right, x)

# class Solution:
#     def mySqrt(self, x):
#         if x<4: return 0 if x==0 else 1
#         i = 2
#         while i**2 < x:
#             i = i - (i**2 - x)/ (2 * i)
#         return int(i)


s = Solution()
print(s.mySqrt(16))

import math
print(math.sqrt(4546656575))