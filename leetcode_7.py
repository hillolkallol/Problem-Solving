'''
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the
32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
assume that your function returns 0 when the reversed integer overflows.
1534236469
0

1463847412
2147483641
'''

class Solution:
    def reverse(self, x):
        reverse = 0
        flag = Solution.checkPositive(self, x)

        x = abs(x)
        while x >= 1:
            reverse = (reverse * 10) + (x % 10)
            x = int(x/10)

        if flag == False:
            reverse = -reverse
        if reverse <= -2**31 or reverse >= 2**31 - 1:
            return 0
        else:
            return reverse

    def checkPositive(self, x):
        if x < 0:
            return False
        return True


# The best
# class Solution:
#     def reverse(self, x):
#         """
#         :type x: int
#         :rtype: int
#         """
#         if x < 0:
#             y = -1 * int(str(-x)[::-1])
#         else:
#             y = int(str(x)[::-1])
#
#         if y > 2 ** 31 or y < -2 ** 31:
#             y = 0
#         return y



s = Solution()
print(s.reverse(1463847412))


# a = 113
# print(str(a)[::-1])