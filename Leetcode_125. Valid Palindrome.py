'''
125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
'''


class Solution:
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if not s: return True

        s, i, j = s.lower(), 0, len(s) - 1
        while i < j:
            if not s[i].isalnum():
                i += 1
                continue
            if not s[j].isalnum():
                j -= 1
                continue

            if s[i] != s[j]: return False
            i += 1
            j -= 1

        return True

# class Solution:
#     def isPalindrome(self, s):
#         """
#         :type s: str
#         :rtype: bool
#         """
#         if not s: return True
#
#         i, j = 0, len(s) - 1
#         while i < j:
#             if not s[i].isalpha() and not s[i].isdigit():
#                 i += 1
#                 continue
#             if not s[j].isalpha() and not s[j].isdigit():
#                 j -= 1
#                 continue
#
#             if s[i].lower() != s[j].lower():
#                 return False
#             i += 1
#             j -= 1
#
#         return True
