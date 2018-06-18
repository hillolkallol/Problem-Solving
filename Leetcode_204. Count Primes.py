'''
204. Count Primes

Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
'''

import math


class Solution:
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 2: return 0

        arrList = [True] * n
        arrList[0] = arrList[1] = 0

        i = 2
        while i * i < n:
            if arrList[i]:
                for j in range(i * i, n, i):
                    arrList[j] = False
            i += 1
        return sum(arrList)




        # arrList = [True]*n
        # arrList[0] = arrList[1] = False
        # for i in range(2, int(n**0.5)):
        #     if arrList[i]:
        #         for j in range(i*i, n, i):
        #             arrList[j] = False
        # return sum(arrList)



        #         allNums = []
        #         for x in range(2, n+1):
        #             if x==2 or x==3 or x==5 or x==7:
        #                 allNums.append(x)

        #             elif x%2 !=0 and x%3 !=0 and x%5 !=0 and x%7 != 0:
        #                 allNums.append(x)


        #         total = 0
        #         for i in allNums:
        #             count = 1
        #             for j in range(1, int(i**0.5)+1):
        #                 if i%j==0:
        #                     count += 1
        #             # print(i, count)
        #             if count == 2:
        #                 total += 1
        #         return total