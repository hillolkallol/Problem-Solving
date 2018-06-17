'''
171. Excel Sheet Column Number

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
'''


class Solution:
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s) == 1:
            return ord(s) - 64

        total = 0

        for i in range(len(s) - 1, -1, -1):
            total += (ord(s[i]) - 64) * 26 ** (len(s) - 1 - i)

        return total
