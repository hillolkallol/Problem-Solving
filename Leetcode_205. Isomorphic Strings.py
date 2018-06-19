'''
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
'''


class Solution:
    def isIsomorphic(self, s, t):
        # #         THE BEST SOLUTION FROM DISCUSSION
        #         return len(set(zip(t, s))) == len(set(s)) == len(set(t))

        hashs = {}
        hasht = {}
        for i in range(len(s)):
            if s[i] in hashs and t[i] in hasht:
                if hashs[s[i]] != t[i] or hasht[t[i]] != s[i]:
                    return False

            elif s[i] in hashs or t[i] in hasht:
                return False
            else:
                hashs[s[i]] = t[i]
                hasht[t[i]] = s[i]

        return True


        # class Solution:
        #     def isIsomorphic(self, s, t):
        #         hashs = {}
        #         hasht = {}

        #         for string1 in s:
        #             if string1 in hashs:
        #                 hashs[string1] += 1
        #             else:
        #                 hashs[string1] = 1

        #         for string2 in t:
        #             if string2 in hasht:
        #                 hasht[string2] += 1
        #             else:
        #                 hasht[string2] = 1

        #         l1 = hashs.values()
        #         l2 = hasht.values()
        #         print(l1, l2)
        #         return l1 == l2