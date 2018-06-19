'''
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
'''

class Solution:
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""
        if len(strs) == 1:
            return strs[0]

        prefix = ""
        for s in range(len(strs[0])):
            for str in range(1, len(strs)):
                if len(strs[str]) < s+1:
                    return prefix

                if strs[str][s] != strs[0][s]:
                    return prefix

            prefix = prefix + strs[0][s]

        return prefix

s = Solution()
print(s.longestCommonPrefix(["aa", "aaa", "aaa"]))



