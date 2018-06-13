'''

118. Pascal's Triangle

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
'''


class Solution:
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        arrList = []
        for i in range(numRows):
            if i == 0:
                arrList.append([1])
            elif i == 1:
                arrList.append([1, 1])
            else:
                temp = [1]
                for j in range(1, i):
                    prev = arrList[i - 1]
                    temp.append(prev[j - 1] + prev[j])
                temp.append(1)
                arrList.append(temp)
        return arrList
