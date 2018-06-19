'''
66. Plus One

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
'''

class Solution:
    def plusOne(self, digits):
        i = 1
        while digits[-i] == 9 and i<len(digits):
            digits[-i] = 0
            i += 1
        if i==len(digits) and digits[0] == 9:
            digits = [1,0] + digits[1:]
        else:
            digits[-i] += 1
        return digits