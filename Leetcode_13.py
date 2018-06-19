'''
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: C = 100, L = 50, XXX = 30 and III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
'''

class Solution:
    def romanToInt(self, s):
        # romanDict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M':1000}

        s = s[::-1]
        total = 0
        iFlag = False
        xFlag = False
        cFlag = False
        for char in s:
            if char == 'I':
                if iFlag == True:
                    total -= 1
                    iFlag = False
                else:
                    total += 1
            if char == 'V':
                iFlag = True
                total += 5
            if char == 'X':
                if xFlag == True:
                    total -= 10
                    xFlag = False
                else:
                    iFlag = True
                    total += 10
            if char == 'L':
                xFlag = True
                total += 50
            if char == 'C':
                if cFlag == True:
                    total -= 100
                    cFlag = False
                else:
                    xFlag = True
                    total += 100
            if char == 'D':
                cFlag = True
                total += 500
            if char == 'M':
                cFlag = True
                total += 1000

        return total

s = Solution()
print(s.romanToInt('MCMXCIV'))