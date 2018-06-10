'''
67. Add Binary

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
'''


class Solution:
    def addBinary(self, a, b):
        difference = abs(len(a) - len(b))
        if len(a) > len(b):
            b = ("0" * difference) + b
        else:
            a = ("0" * difference) + a

        i = 1
        string = ""
        remaining = 0
        while i < len(a):
            if int(a[-i]) + int(b[-i]) + remaining == 0:
                string = "0" + string
                remaining = 0
            elif int(a[-i]) + int(b[-i]) + remaining == 1:
                string = "1" + string
                remaining = 0
            elif int(a[-i]) + int(b[-i]) + remaining == 2:
                string = "0" + string
                remaining = 1
            elif int(a[-i]) + int(b[-i]) + remaining == 3:
                string = "1" + string
                remaining = 1
            i += 1

        if int(a[0]) + int(b[0]) + remaining == 1:
            string = "1" + string
        elif int(a[0]) + int(b[0]) + remaining == 2:
            string = "10" + string
        elif int(a[0]) + int(b[0]) + remaining == 3:
            string = "11" + string
        else:
            string = "0" + string

        return string


# class Solution:
#     def addBinary(self, a, b):
#         return self.addBinaryString(a, b, 0)

#     def addBinaryString(self, a, b, remaining):
#         string = ""
#         newString = ""


#         if len(a) == 1 and len(b) == 1:
#             if int(a[0]) + int(b[0]) + remaining == 1: return "1"
#             elif int(a[0]) + int(b[0]) + remaining == 2: return "10"
#             elif int(a[0]) + int(b[0]) + remaining == 3: return "11"
#             return "0"

#         if len(a) == 1:
#             if int(a[0]) + remaining == 1: return "1"
#             elif int(a[0]) + remaining == 2: return "10"
#             elif int(a[0]) + remaining == 3: return "11"
#             return "0"

#         if len(b) == 1:
#             if int(b[0]) + remaining == 1: return "1"
#             elif int(b[0]) + remaining == 2: return "10"
#             elif int(b[0]) + remaining == 3: return "11"
#             return "0"

#         newString += self.addBinaryString(a[:len(a)-1], b[:len(b)-1], remaining) + string
#         return newString





# class Solution:
#     def addBinary(self, a, b):

#         print(chr(65))
#         carry = 0
#         diff = abs(len(a) - len(b))
#         if(len(a) > len(b)):
#             stuff = "0" * diff
#             b = stuff + b
#         else:
#             stuff = "0"*diff
#             a = stuff + a

#         strss = ""
#         for i in range(len(a) - 1, -1, -1):
#             p = (int(a[i]) - 0) + (int(b[i]) - 0) + carry
#             strss = str(p % 2) + strss
#             carry = p // 2

#         if( carry == 1):
#             return str(carry) + strss
#         return strss


s = Solution()
print(s.addBinary("1100010010101", "100010100"))
