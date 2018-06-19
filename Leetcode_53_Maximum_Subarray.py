'''
53. Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
'''

class Solution:
    def maxSubArray(self, nums):
        for i in range(1, len(nums)):
            nums[i] = max(nums[i], nums[i] + nums[i-1])
        return max(nums)

# #
# class Solution:
#     def maxSubArray(self, nums):
#         if len(nums) == 1: return nums[0]
#
#         half = len(nums)//2
#         first_sum = self.maxSubArray(nums[:half])
#         second_sum = self.maxSubArray(nums[half:])
#
#         a = max(first_sum, second_sum, first_sum+second_sum)
#         # b = max(second_sum, first_sum+second_sum)
#         # c = max(a, b)
#
#         return a
#
s = Solution()
print(s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))