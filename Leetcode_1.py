'''
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
'''

# brute force
# class Solution:
#     def twoSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]
#         """
#
#         for i in range(len(nums)):
#             for j in range(i+1, len(nums)):
#                 if nums[i] + nums[j] == target:
#                     return [i, j]
#
#         return None

#hash table
# class Solution:
#     def twoSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]
#         """
#         numbers_hash ={}
#         for i in range(len(nums)):
#             numbers_hash[i] = nums[i]
#
#         for j in range(len(nums)):
#                 complement = target - nums[j]
#                 if complement in numbers_hash.values() and complement != nums[j]:
#                     return [j, list(numbers_hash.keys())[list(numbers_hash.values()).index(complement)]]
#
#         return None

#hash table- One pass
# class Solution:
#     def twoSum(self, nums, target):
#         """
#         :type nums: List[int]
#         :type target: int
#         :rtype: List[int]
#         """
#         numbers_hash ={}
#         for i in range(len(nums)):
#             complement = target - nums[i]
#             if complement in numbers_hash.values() and list(numbers_hash.values()).index(complement) != i:
#                     return [list(numbers_hash.values()).index(complement), i]
#             numbers_hash[i] = nums[i]
#         return None

# the best one
class Solution:
    def twoSum(self, nums, target):
        numbers_hash = {}
        for i in range(len(nums)):
            if target - nums[i] in numbers_hash:
                return [numbers_hash[target - nums[i]], i]
            else:
                numbers_hash[nums[i]] = i
        return None

s = Solution()
print(s.twoSum([3, 3], 6))
