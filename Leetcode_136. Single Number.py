'''
136. Single Number

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
'''


class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
#         First Approach

#         hashmap = {}
#         for num in nums:
#             if hashmap.get(num, None) != None:
#                 hashmap[num] = 0
#             else:
#                 hashmap[num] = num

#         return sum(hashmap.values())

#         Second Approach After taking help
        num = 0
        for i in nums:
            num ^= i
        return num

