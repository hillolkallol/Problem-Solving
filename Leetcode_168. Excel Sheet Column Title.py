'''
168. Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
'''


class Solution:
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """

        string = ''
        while n:
            n, rem = divmod(n - 1, 26)
            string = chr(65 + rem) + string

        return string

        #         rem = n % 26
        #         div = int(n/26)

        #         string = ''

        #         while div > 26:
        #             if rem != 0:
        #                 string = chr(64+rem) + string
        #             rem = div % 26
        #             div = int(div/26)

        #         if rem != 0: string = chr(64+rem) + string

        #         if div != 0: string = chr(64+div) + string

        #         if div > 1 and rem == 0: string = chr(64+div-1) + chr(64+26)

        #         if div == 1 and rem == 0: string = chr(64+26)


        #         return string