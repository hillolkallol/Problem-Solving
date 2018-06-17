'''
169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
'''


# class Solution:
#     def majorityElement(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         if len(nums) == 1:
#             return nums[0]

#         nums.sort()

#         f_num = nums[0]
#         count = 1
#         for i in range(1, len(nums)):
#             if count >= len(nums)/2:
#                 return nums[i-1]

#             if f_num == nums[i]:
#                 count += 1
#             else:
#                 f_num = nums[i]
#                 count = 1

#         if count >= len(nums)/2:
#             return nums[i-1]
#         return None

# # simple nlogn implementation
# class Solution:
#     def majorityElement(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """

#         nums.sort()
#         return nums[len(nums)//2]

# boyer moore algorithm
class Solution:
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        count = 0
        num = None

        for i in nums:
            if count == 0: num = i
            if num == i:
                count += 1
            else:
                count -= 1

        return num
