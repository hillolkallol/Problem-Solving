'''
38. Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
'''

class Solution:
    def countAndSay(self, n):
        prev = "1"
        for i in range(1, n):
            strin = ""
            first_element = prev[0]
            count = 1
            for j in range(1, len(prev)):
                if first_element == prev[j]:
                    count += 1
                else:
                    strin = strin + str(count) + first_element
                    first_element = prev[j]
                    count = 1
            strin = strin + str(count) + first_element

            prev = strin

        return prev

s = Solution()
print(s.countAndSay(8))
